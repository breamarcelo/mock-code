<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" encoding="UTF-8" indent="yes" omit-xml-declaration="yes" />

    <xsl:template match="/Presupuesto">
        <html>
            <head>
                <style>
                    body { font-family: 'Arial', sans-serif; margin: 40px; color: #333; }
                    h1 { color: #2c3e50; border-bottom: 2px solid #3498db; padding-bottom: 10px; }
        .summary { margin-bottom: 30px; background: #f9f9f9; padding: 15px; border-radius: 5px; }
        table { width: 100%; border-collapse: collapse; }
                    th { background-color: #3498db; color: white; padding: 10px; text-align: left; }
        td { border: 1px solid #ddd; padding: 8px; }
                    tr:nth-child(even) { background-color: #f2f2f2; }
                    .total { font-weight: bold; font-size: 1.2em; text-align: right; margin-top:
        20px; }
                </style>
            </head>
            <body>
                <h1>Budget Report</h1>
                <!-- 
                    <div class="summary">
                        <p><strong>Client:</strong> <xsl:value-of select="clientName"/></p>
                        <p><strong>Date:</strong> <xsl:value-of select="date"/></p>
                    </div>
                -->

                <table>
                    <thead>
                        <tr>
                            <th>Cantidad</th>
                            <th>Descripcion</th>
                            <th>Importe</th>
                        </tr>
                    </thead>
                    <tbody>
                        <xsl:for-each select="LineasPresupuesto/Linea">
                            <tr>
                                <td>
                                    <xsl:value-of select="Cantidad" />
                                </td>
                                <td>
                                    <xsl:value-of select="Descripcion" />
                                </td>
                                <td>
                                    <xsl:value-of select="Importe" />
                                </td>
                            </tr>
                        </xsl:for-each>
                    </tbody>
                </table>

                <div class="total"> Total Amount: <xsl:value-of select="Totla" />
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>