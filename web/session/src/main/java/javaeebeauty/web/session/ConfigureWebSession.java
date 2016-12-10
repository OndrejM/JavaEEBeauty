package javaeebeauty.web.session;

import java.lang.annotation.*;
import javaeebeauty.core.boundary.Constants;

/**
 *
 * @author ondrejm
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface ConfigureWebSession {
    int sessionTimeout() default Constants.INT_NOT_SET;
}
