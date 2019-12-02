/*
 * Copyright 2019 Indiana University.  All rights reserved.
 *
 * Mark H. Wood, IUPUI University Library, Dec 2, 2019
 */

package edu.iupui.ulib.saxon_integrated_functions;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import net.sf.saxon.Configuration;
import net.sf.saxon.jaxp.SaxonTransformerFactory;
import net.sf.saxon.lib.FeatureKeys;

/**
 *
 * @author Mark H. Wood <mwood@iupui.edu>
 */
public class Tryout {
    private Tryout() {}

    public static void main(String[] argv)
            throws TransformerConfigurationException, TransformerException {
        // Get an XSL-T transformer factory.
        TransformerFactory tf = TransformerFactory.newInstance();
        System.out.format("TransformerFactory class = %s%n", tf.getClass().getCanonicalName());

        // Register our custom XPath functions.
        Configuration configuration = (Configuration) tf.getAttribute(FeatureKeys.CONFIGURATION);
        configuration.registerExtensionFunction(new ConfmanGetPropertyDefinition());
        configuration.registerExtensionFunction(new ConfmanGetIntProperty2Definition());

        // Get a transformer and load our transform
        StreamSource transform = new StreamSource(Tryout.class.getResourceAsStream("/test-transform.xsl"));
        Transformer transformer = tf.newTransformer(transform);

        // Set some properties
        ConfigurationManager.setProperty("foo", "bar");
        ConfigurationManager.setProperty("baz", "3");

        // Transform the input to standard output.
        StreamSource document = new StreamSource(Tryout.class.getResourceAsStream("/input.xml"));
        StreamResult result = new StreamResult(System.out);
        transformer.transform(document, result);

        System.exit(0);
    }
}
