package javaeebeauty.tests;

import javaeebeauty.core.ApplicationConfiguration;
import static javaeebeauty.tests.testsupport.Constants.SESSION_TIMEOUT_IN_MINUTES;
import javaeebeauty.web.session.*;
import javax.enterprise.context.*;

@ApplicationConfiguration
@ConfigureWebSession(sessionTimeout = SESSION_TIMEOUT_IN_MINUTES)
@Dependent
public class WebSessionAppConfigAnnotation {
}
