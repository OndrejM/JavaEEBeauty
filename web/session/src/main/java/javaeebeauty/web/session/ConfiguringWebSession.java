package javaeebeauty.web.session;

/**
 * Configuration CDI beans marked by @ApplicationConfiguration can implement 
 * this interface to define Http Session configuration programmatically.
 * @author ondrejm
 */
public interface ConfiguringWebSession {

    /**
     * This method will be called to modify the configuration of HTTP session 
     * (session-config in web.xml). The method should modify the config parameter to adjust the configuration.
     * @param config
     */
    void configureWebSession(WebSessionConfig config);

}
