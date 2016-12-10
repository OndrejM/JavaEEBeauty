package javaeebeauty.web.session.control;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.http.*;

@ApplicationScoped
public class WebSessionConfigurator {

    private WebSessionConfigSnapshot configSnapshot;

    public void updateConfiguration(WebSessionConfigSnapshot configSnapshot) {
        this.configSnapshot = configSnapshot;
    }
    
    public void configureSession(HttpSession session) {
        if (configSnapshot != null) {
            if (configSnapshot.getSessionTimeout() != null) {
                session.setMaxInactiveInterval(configSnapshot.getSessionTimeout() * 60);
            }
        }
    }

}
