package javaeebeauty.web.session.control;

import java.util.*;
import javaeebeauty.web.session.WebSessionConfig;
import javax.servlet.*;

/**
 * Snapshot of session configuration that represents data usually defined in in session-config element in web.xml
 * @author ondrejm
 */
public class WebSessionConfigSnapshot implements WebSessionConfig {
    private Integer sessionTimeout;
    private final SessionCookieConfigSnapshot cookieConfig = new SessionCookieConfigSnapshot();
    private final HashSet<SessionTrackingMode> trackingModes = new HashSet<SessionTrackingMode>();

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public SessionCookieConfigSnapshot getSessionCookieConfig() {
        return cookieConfig;
    }

    public Set<SessionTrackingMode> getSessionTrackingModes() {
        return trackingModes;
    }

    public void addSessionTrackingMode(SessionTrackingMode... modes) {
        for (SessionTrackingMode mode : modes) {
            getSessionTrackingModes().add(mode);
        }
    }
}
