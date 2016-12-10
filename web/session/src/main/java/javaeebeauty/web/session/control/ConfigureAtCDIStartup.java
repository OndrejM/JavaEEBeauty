package javaeebeauty.web.session.control;

import java.util.logging.*;
import javaeebeauty.core.ApplicationConfiguration;
import javaeebeauty.core.boundary.Logging;
import javax.enterprise.context.*;
import javax.enterprise.event.*;
import javax.inject.*;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

@Dependent
public class ConfigureAtCDIStartup {

    @Inject
    @ApplicationConfiguration
    private Provider<Object> configProvider;

    @Inject
    private Event<WebSessionConfigSnapshot> sessionConfiguredEvent;
    
    @Inject
    private WebSessionConfigurator configurator;
    
    public void configureWebSession(@Observes @Initialized(ApplicationScoped.class) Object event) {
        Object config = null;
        try {
            config = configProvider.get();
        } catch (RuntimeException e) {
            Logging.getLogger(this).log(Level.FINE, e, 
                    () -> "Did not find application configuration object, will not attempt to configure the application.");
        }
        if (config != null) {
            final WebSessionConfigSnapshot configSnapshot
                    = new WebSessionConfigReader(config).readConfig();
            configurator.updateConfiguration(configSnapshot);
            sessionConfiguredEvent.fire(configSnapshot);
        }
    }
}
