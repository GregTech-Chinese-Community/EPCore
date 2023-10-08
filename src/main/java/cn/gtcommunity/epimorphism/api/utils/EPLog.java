package cn.gtcommunity.epimorphism.api.utils;

import org.apache.logging.log4j.Logger;

public class EPLog {

    public static Logger logger;

    public EPLog() {
    }

    public static void init(Logger modLogger) {
        logger = modLogger;
    }

}
