package javaeebeauty.core.boundary;

import java.util.logging.*;

public class Logging {
    public static Logger getLogger(Class<?> cls) {
        return Logger.getLogger(cls.getName());
    }

    public static Logger getLogger(Object obj) {
        return Logger.getLogger(obj.getClass().getName());
    }

    public static Logger getRootLogger() {
        return Logger.getGlobal();
    }
    
}
