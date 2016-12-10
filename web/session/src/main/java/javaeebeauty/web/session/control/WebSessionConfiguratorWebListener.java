package javaeebeauty.web.session.control;

import javax.inject.Inject;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;

@WebListener
public class WebSessionConfiguratorWebListener implements HttpSessionListener {

    @Inject
    private WebSessionConfigurator configurator;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        configurator.configureSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
    }

}
