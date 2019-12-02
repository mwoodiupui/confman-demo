<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : test-transform.xsl
    Created on : December 2, 2019, 3:29 PM
    Author     : mwood
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:confman='http://edu.iupui.ulib/dspace'>

    <xsl:output method="html"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>test-transform.xsl</title>
            </head>
            <body>
                foo = <xsl:value-of select="confman:getProperty('foo')"/>
                baz = <xsl:value-of select="confman:getIntProperty('baz', 4)"/>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
