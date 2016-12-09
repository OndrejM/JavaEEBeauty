package javaeebeauty.web.session;

import javaeebeauty.core.control.UndefinedConfigurationValueException;

public interface WebSessionConfig {

    default Integer getSessionTimeout() {
        throw new UndefinedConfigurationValueException();
    }

}
