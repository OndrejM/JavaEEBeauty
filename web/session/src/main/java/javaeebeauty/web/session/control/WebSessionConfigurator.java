package javaeebeauty.web.session.control;

import javax.enterprise.context.ApplicationScoped;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 * A singleton bean that stores gathered session configuration and can apply the configuration at some other point later (e.g. in a web listener).
 * @author ondrejm
 */
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
    
    public void configureServletContext(ServletContext ctx) {
        ctx.setSessionTrackingModes(configSnapshot.getSessionTrackingModes());

        final SessionCookieConfig cookieConf = ctx.getSessionCookieConfig();
        final SessionCookieConfigSnapshot cookieConfSnapshot = configSnapshot.getSessionCookieConfig();
        if (cookieConfSnapshot.getName() != null) {
            cookieConf.setName(cookieConfSnapshot.getName());
        }
        if (cookieConfSnapshot.getComment() != null) {
            cookieConf.setComment(cookieConfSnapshot.getComment());
        }
        if (cookieConfSnapshot.getDomain() != null) {
            cookieConf.setDomain(cookieConfSnapshot.getDomain());
        }
        if (cookieConfSnapshot.getPath() != null) {
            cookieConf.setPath(cookieConfSnapshot.getPath());
        }
        if (cookieConfSnapshot.isHttpOnlySet()) {
            cookieConf.setHttpOnly(cookieConfSnapshot.isHttpOnly());
        }
        if (cookieConfSnapshot.isSecureSet()) {
            cookieConf.setSecure(cookieConfSnapshot.isSecure());
        }
        if (cookieConfSnapshot.isMaxAgeSet()) {
            cookieConf.setMaxAge(cookieConfSnapshot.getMaxAge());
        }
    }

}
