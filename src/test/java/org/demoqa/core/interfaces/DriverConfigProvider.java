package org.demoqa.core.interfaces;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface DriverConfigProvider {

    /**
     * Capabilities file string.
     *
     * @return the string
     */
    String CapabilitiesFile() default "";
}
