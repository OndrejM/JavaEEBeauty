package javaeebeauty.web.session;

import java.lang.annotation.*;
import javaeebeauty.core.boundary.Constants;
import javax.servlet.SessionTrackingMode;

/**
 * Annotation to be placed on a CDI bean marked with @ApplicationConfiguration 
 * to declare the configuration that could be defined also by implementing ConfigureWebSession.
 * @author ondrejm
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface ConfigureWebSession {
    int sessionTimeout() default Constants.INT_NOT_SET;
    SessionTrackingMode[] trackingModes() default {};
    ConfigureSessionCookie[] cookieConfig() default {};
}
