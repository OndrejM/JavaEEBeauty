package javaeebeauty.core.boundary;

import java.util.logging.*;

public class Logging {
    public static Logger getLogger(Class<?> cls) {
        return LogManager.getLogManager().getLogger(cls.getName());
    }

    public static Logger getLogger(Object obj) {
        return LogManager.getLogManager().getLogger(obj.getClass().getName());
    }

    public static Logger getRootLogger() {
        return LogManager.getLogManager().getLogger(Logger.GLOBAL_LOGGER_NAME);
    }
    
}
