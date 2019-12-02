/*
 * Copyright 2019 Indiana University.  All rights reserved.
 *
 * Mark H. Wood, IUPUI University Library, Dec 2, 2019
 */

package edu.iupui.ulib.saxon_integrated_functions;

import java.math.BigInteger;
import net.sf.saxon.expr.XPathContext;
import net.sf.saxon.lib.ExtensionFunctionCall;
import net.sf.saxon.lib.ExtensionFunctionDefinition;
import net.sf.saxon.om.Sequence;
import net.sf.saxon.om.StructuredQName;
import net.sf.saxon.trans.XPathException;
import net.sf.saxon.value.Int64Value;
import net.sf.saxon.value.IntegerValue;
import net.sf.saxon.value.SequenceType;
import net.sf.saxon.value.StringValue;

/**
 * Define a Saxon integrated extension function for access to the DSpace
 * ConfigurationManager's getIntProperty method.
 *
 * @author Mark H. Wood <mwood@iupui.edu>
 */
public class ConfmanGetIntProperty2Definition
        extends ExtensionFunctionDefinition {
    @Override
    public StructuredQName getFunctionQName() {
        return new StructuredQName("confman", "http://edu.iupui.ulib/dspace", "getIntProperty");
    }

    @Override
    public SequenceType[] getArgumentTypes() {
        return new SequenceType[]{
            SequenceType.SINGLE_STRING, // property name
            SequenceType.SINGLE_INTEGER // default value
        };
    }

    @Override
    public SequenceType getResultType(SequenceType[] sts) {
        return SequenceType.SINGLE_INTEGER;
    }

    @Override
    public ExtensionFunctionCall makeCallExpression() {
        return new ExtensionFunctionCall() {
            @Override
            public Sequence call(XPathContext context, Sequence[] arguments)
                    throws XPathException {
                String key = ((StringValue) arguments[0]).getStringValue();
                long defaultValue = ((IntegerValue) arguments[1]).longValue();
                long value = ConfigurationManager.getIntProperty(key, defaultValue);
                return IntegerValue.makeIntegerValue(BigInteger.valueOf(value));
            }
        };
    }
}
