package javaeebeauty.web.session;

import javaeebeauty.core.boundary.Constants;

/**
 *
 * @author ondrejm
 */
public @interface ConfigureSessionCookie {
    String name() default "";
    String comment() default "";
    String domain() default "";
    String path() default "";
    boolean httpOnly() default false;
    boolean secure() default false;
    int maxAge() default Constants.INT_NOT_SET;
}
