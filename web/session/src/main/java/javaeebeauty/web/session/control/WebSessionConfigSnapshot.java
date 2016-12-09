package javaeebeauty.web.session.control;

import javaeebeauty.web.session.WebSessionConfig;

public class WebSessionConfigSnapshot implements WebSessionConfig {
    private Integer sessionTimeout;

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }
}
