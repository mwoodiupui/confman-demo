/*
 * Copyright 2019 Indiana University.  All rights reserved.
 *
 * Mark H. Wood, IUPUI University Library, Dec 2, 2019
 */

package edu.iupui.ulib.saxon_integrated_functions;

import java.util.HashMap;
import java.util.Map;

/**
 * Mock DSpace ConfigurationManager for testing.
 * @author Mark H. Wood <mwood@iupui.edu>
 */
public class ConfigurationManager {
    /** The key/value map. */
    private static final Map<String, String> config = new HashMap<>();

    /** Do not instantiate. */
    private ConfigurationManager() {}

    /**
     * Look up a named configuration property.
     * @param key name to look up.
     * @return value of that name, or null if undefined.
     */
    public static String getProperty(String key) {
        return config.get(key);
    }

    /**
     * Look up a named configuration property and return its integer value
     * or a default.
     *
     * @param key name of property to return.
     * @param defaultValue value to return if undefined.
     * @return property's value if defined, else {@link defaultValue}.
     * @throws NumberFormatException if key is defined but value is not integer.
     */
    public static long getIntProperty(String key, long defaultValue)
            throws NumberFormatException {
        if (config.containsKey(key)) {
            return Integer.valueOf(config.get(key));
        } else {
            return defaultValue;
        }
    }

    /**
     * Put a property into the configuration.
     * @param key name of the property.
     * @param value value of the property.
     */
    public static void setProperty(String key, String value) {
        config.put(key, value);
    }
}
