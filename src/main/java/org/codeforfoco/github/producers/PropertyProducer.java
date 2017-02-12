package org.codeforfoco.github.producers;


import org.codeforfoco.github.annotations.Property;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by afibarra on 2/11/17.
 */
public class PropertyProducer {
    private Properties properties;

    @Property
    @Produces
    public String produceString(final InjectionPoint injectionPoint) {
        return this.properties.getProperty(getKey(injectionPoint));
    }

    private String getKey(final InjectionPoint injectionPoint) {
        String result;

        if (injectionPoint.getAnnotated().isAnnotationPresent(Property.class) && !injectionPoint.getAnnotated().getAnnotation(Property.class).value().isEmpty()) {
            result = injectionPoint.getAnnotated().getAnnotation(Property.class).value();
        } else {
            result = injectionPoint.getMember().getName();
        }

        return result;
    }

    @PostConstruct
    public void init() {
        this.properties = new Properties();
        final InputStream inputStream = PropertyProducer.class.getResourceAsStream("/application.properties");

        if (inputStream == null) {
            throw new RuntimeException("No properties file was found!");
        }

        try {
            this.properties.load(inputStream);
        } catch (final IOException e) {
            throw new RuntimeException("Configuration could not be loaded!");
        }
    }
}
