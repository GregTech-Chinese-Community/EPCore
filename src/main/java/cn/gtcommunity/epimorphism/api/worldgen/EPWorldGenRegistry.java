package cn.gtcommunity.epimorphism.api.worldgen;

import cn.gtcommunity.epimorphism.api.utils.EPLog;
import gregtech.api.GTValues;
import gregtech.api.util.FileUtility;
import gregtech.api.util.GTLog;
import gregtech.api.worldgen.config.OreDepositDefinition;
import gregtech.api.worldgen.config.WorldGenRegistry;
import net.minecraftforge.fml.common.Loader;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.Level;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EPWorldGenRegistry {
    public static Path configPath = Loader.instance().getConfigDir().toPath().resolve(GTValues.MODID);
    public static List<String> overrideList = new ArrayList<>();

    public static void init() {
        // The path of the worldgen folder in the config folder
        Path worldgenRootPath = configPath.resolve("worldgen");
        // The folder where all physical veins are stored
        Path veinPath = worldgenRootPath.resolve("vein");

        try {
            if (!Files.exists(veinPath))
                Files.createDirectories(veinPath);
            extractJarVeinDefinitions(configPath, veinPath);
        } catch (IOException | RuntimeException exception) {
            EPLog.logger.fatal("Failed to generate worldgen config file", exception);
        }

        //  Add WorldGen
        WorldGenRegistry.INSTANCE.addVeinDefinitions(new OreDepositDefinition("vein/overworld/prasiolite_vein.json"));
        WorldGenRegistry.INSTANCE.addVeinDefinitions(new OreDepositDefinition("vein/overworld/magnetite.json"));
        WorldGenRegistry.INSTANCE.addVeinDefinitions(new OreDepositDefinition("vein/nether/banded_iron.json"));
        WorldGenRegistry.INSTANCE.addVeinDefinitions(new OreDepositDefinition("vein/end/magnetite.json"));
        WorldGenRegistry.INSTANCE.addVeinDefinitions(new OreDepositDefinition("vein/end/draconium_vein.json"));

        //  Remove WorldGen
        overrideList.add("overworld/magnetite_vein.json");
        overrideList.add("nether/banded_iron_vein");
        overrideList.add("end/magnetite_vein.json");
    }

    public static void override() {
        List<OreDepositDefinition> list = WorldGenRegistry.getOreDeposits().stream()
                .filter(Objects::nonNull)
                .filter(o -> overrideList.contains(FileUtility.nativeSepToSlash(o.getDepositName())))
                .collect(Collectors.toList());
        list.forEach(WorldGenRegistry.INSTANCE::removeVeinDefinitions);
    }
    private static void extractJarVeinDefinitions(Path configPath, Path targetPath) throws IOException {
        // The path of the worldgen folder in the config folder
        Path worldgenRootPath = configPath.resolve("worldgen");
        // The path of the physical vein folder in the config folder
        Path oreVeinRootPath = worldgenRootPath.resolve("vein");
        // The path of the bedrock fluid vein folder in the config folder
        Path bedrockFluidVeinRootPath = worldgenRootPath.resolve("fluid");
        // The path of the named dimensions file in the config folder
        Path dimensionsRootPath = configPath.resolve("dimensions.json");
        // THe path of the lock file in the config folder
        Path extractLockPath = configPath.resolve("worldgen_extracted.json");
        FileSystem zipFileSystem = null;
        try {
            URL sampleUrl = WorldGenRegistry.class.getResource("/assets/gregtech/.epassetsroot");
            if (sampleUrl == null) throw new FileNotFoundException("Could not find .epassetsroot");
            URI sampleUri = sampleUrl.toURI();
            // The Path for representing the worldgen folder in the assets folder in the Gregtech resources folder in the jar
            Path worldgenJarRootPath;
            // The Path for representing the vein folder in the vein folder in the assets folder in the Gregtech resources folder in the jar
            Path oreVeinJarRootPath;
            // The Path for representing the fluid folder in the vein folder in the assets folder in the Gregtech resources folder in the jar
            Path bedrockFluidJarRootPath;
            if (sampleUri.getScheme().equals("jar") || sampleUri.getScheme().equals("zip")) {
                zipFileSystem = FileSystems.newFileSystem(sampleUri, Collections.emptyMap());
                worldgenJarRootPath = zipFileSystem.getPath("/assets/gregtech/worldgen");
                oreVeinJarRootPath = zipFileSystem.getPath("/assets/gregtech/worldgen/vein");
                bedrockFluidJarRootPath = zipFileSystem.getPath("/assets/gregtech/worldgen/fluid");
            } else if (sampleUri.getScheme().equals("file")) {
                URL url = WorldGenRegistry.class.getResource("/assets/gregtech/worldgen");
                if (url == null) throw new FileNotFoundException("Could not find /assets/gregtech/worldgen");
                worldgenJarRootPath = Paths.get(url.toURI());

                url = WorldGenRegistry.class.getResource("/assets/gregtech/worldgen/vein");
                if (url == null) throw new FileNotFoundException("Could not find /assets/gregtech/worldgen/vein");
                oreVeinJarRootPath = Paths.get(url.toURI());

                url = WorldGenRegistry.class.getResource("/assets/gregtech/worldgen/fluid");
                if (url == null) throw new FileNotFoundException("Could not find /assets/gregtech/worldgen/fluid");
                bedrockFluidJarRootPath = Paths.get(url.toURI());
            } else {
                throw new IllegalStateException("Unable to locate absolute path to worldgen root directory: " + sampleUri);
            }

            // Attempts to extract the worldgen definition jsons
            if (targetPath.compareTo(oreVeinRootPath) == 0) {
                GTLog.logger.info("Attempting extraction of standard worldgen definitions from {} to {}",
                        oreVeinJarRootPath, oreVeinRootPath);
                // Find all the default worldgen files in the assets folder
                List<Path> jarFiles;
                try (Stream<Path> stream = Files.walk(oreVeinJarRootPath)) {
                    jarFiles = stream.filter(Files::isRegularFile).collect(Collectors.toList());
                }

                // Replaces or creates the default worldgen files
                for (Path jarFile : jarFiles) {
                    Path worldgenPath = oreVeinRootPath.resolve(oreVeinJarRootPath.relativize(jarFile).toString());
                    Files.createDirectories(worldgenPath.getParent());
                    Files.copy(jarFile, worldgenPath, StandardCopyOption.REPLACE_EXISTING);
                }
                GTLog.logger.info("Extracted {} builtin worldgen vein definitions into vein folder", jarFiles.size());
            } else if (targetPath.compareTo(bedrockFluidVeinRootPath) == 0) {
                GTLog.logger.info("Attempting extraction of standard worldgen definitions from {} to {}",
                        bedrockFluidJarRootPath, bedrockFluidVeinRootPath);
                // Find all the default worldgen files in the assets folder
                List<Path> jarFiles;
                try (Stream<Path> stream = Files.walk(bedrockFluidJarRootPath)) {
                    jarFiles = stream.filter(Files::isRegularFile).collect(Collectors.toList());
                }

                // Replaces or creates the default worldgen files
                for (Path jarFile : jarFiles) {
                    Path worldgenPath = bedrockFluidVeinRootPath.resolve(bedrockFluidJarRootPath.relativize(jarFile).toString());
                    Files.createDirectories(worldgenPath.getParent());
                    Files.copy(jarFile, worldgenPath, StandardCopyOption.REPLACE_EXISTING);
                }
                GTLog.logger.info("Extracted {} builtin worldgen bedrock fluid definitions into fluid folder", jarFiles.size());
            }
            // Attempts to extract the named dimensions json folder
            else if (targetPath.compareTo(dimensionsRootPath) == 0) {
                GTLog.logger.info("Attempting extraction of standard dimension definitions from {} to {}",
                        worldgenJarRootPath, dimensionsRootPath);

                Path dimensionFile = worldgenJarRootPath.resolve("dimensions.json");

                Path worldgenPath = dimensionsRootPath.resolve(worldgenJarRootPath.relativize(worldgenJarRootPath).toString());
                Files.copy(dimensionFile, worldgenPath, StandardCopyOption.REPLACE_EXISTING);

                GTLog.logger.info("Extracted builtin dimension definitions into worldgen folder");
            }
            // Attempts to extract lock txt file
            else if (targetPath.compareTo(extractLockPath) == 0) {
                Path extractLockFile = worldgenJarRootPath.resolve("worldgen_extracted.json");

                Path worldgenPath = extractLockPath.resolve(worldgenJarRootPath.relativize(worldgenJarRootPath).toString());
                Files.copy(extractLockFile, worldgenPath, StandardCopyOption.REPLACE_EXISTING);

                GTLog.logger.info("Extracted jar lock file into worldgen folder");
            }

        } catch (URISyntaxException impossible) {
            //this is impossible, since getResource always returns valid URI
            throw new RuntimeException(impossible);
        } finally {
            if (zipFileSystem != null) {
                //close zip file system to avoid issues
                IOUtils.closeQuietly(zipFileSystem);
            }
        }
    }
}
