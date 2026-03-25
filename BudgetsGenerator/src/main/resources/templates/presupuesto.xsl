<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4" page-height="29.7cm" page-width="21cm"
                    margin="2cm">
                    <fo:region-body />
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block font-size="24pt" font-weight="bold" text-align="center"
                        space-after="10mm">
                        Budget Report
                    </fo:block>

                    <fo:block font-size="12pt" border-bottom="1pt solid black" space-after="5mm">
        Date: <xsl:value-of select="current-date()" />
                    </fo:block>

                    <fo:block font-size="14pt" font-family="sans-serif"> Total Amount: <fo:inline
                            font-weight="bold">
                            <xsl:value-of select="budget/totalAmount" />
                        </fo:inline>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>