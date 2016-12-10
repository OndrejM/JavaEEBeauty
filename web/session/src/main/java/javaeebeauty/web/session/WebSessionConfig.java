package javaeebeauty.web.session;

import java.util.Set;
import javax.servlet.*;
/**
 * Interface to provide configuration that usually defined in session-config element in web.xml 
 * @author ondrejm
 */
public interface WebSessionConfig {

    void setSessionTimeout(Integer timeout);

    Integer getSessionTimeout();
    
    SessionCookieConfig getSessionCookieConfig();
    
    Set<SessionTrackingMode> getSessionTrackingModes();
    
    void addSessionTrackingModes(SessionTrackingMode... modes);

}
