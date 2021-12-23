<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" omit-xml-declaration="yes"
                encoding="UTF-8" indent="yes" />
    <!-- GLOBAL VARIABLES -->
    <xsl:variable name="target" select="/school/students" />

    <!-- transform template -->
    <xsl:template match="/">
        <cityMall>
            <store>
                <xsl:for-each select="$target/student">
                    <xsl:if test="(boolean(gender ='Female'))">
                        <xsl:copy-of select="name"></xsl:copy-of>
                    </xsl:if>
                </xsl:for-each>
            </store>
        </cityMall>
    </xsl:template>
</xsl:stylesheet>