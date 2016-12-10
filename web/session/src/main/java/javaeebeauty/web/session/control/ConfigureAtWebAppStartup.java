package javaeebeauty.web.session.control;

import java.util.logging.*;
import javaeebeauty.core.ApplicationConfiguration;
import javaeebeauty.core.boundary.Logging;
import javax.enterprise.event.*;
import javax.inject.*;
import javax.servlet.*;
import javax.servlet.annotation.WebListener;

@WebListener
public class ConfigureAtWebAppStartup implements ServletContextListener {

    @Inject
    @ApplicationConfiguration
    private Provider<Object> configProvider;

    @Inject
    private WebSessionConfigurator configurator;

    public void configureWebSession(ServletContext servletContext) {
        Object config = null;
        try {
            config = configProvider.get();
        } catch (RuntimeException e) {
            final Logger logger = Logging.getLogger(this);
            if (logger.isLoggable(Level.FINE)) {
                logger.log(Level.FINE,
                        "Did not find application configuration object, will not attempt to configure the application.",
                        e);
            }
        }
        if (config != null) {
            final WebSessionConfigSnapshot configSnapshot
                    = new WebSessionConfigReader(config).readConfig();
            configurator.updateConfiguration(configSnapshot);
            configurator.configureServletContext(servletContext);
        }
    }

    public void contextInitialized(ServletContextEvent sce) {
        configureWebSession(sce.getServletContext());
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }
}
