<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="xml" encoding="UTF-8" indent="yes" omit-xml-declaration="yes" />

    <xsl:template match="/Presupuesto">
        <html>
            <head>
                <style>
                    body {
                    font-family: 'Arial', sans-serif;
                    margin: 40px;
                    color: #333;
                    }
                    h1 {
                    color: #2c3e50; border-bottom: 2px solid #3498db;
                    padding-bottom: 10px;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    }
                    th {
                    background-color: #3498db;
                    color: white;
                    padding: 10px;
                    text-align: left;
                    }
                    td {
                    border: 1px solid #ddd;
                    padding: 8px;
                    }
                    tr:nth-child(even) {
                    background-color: #f2f2f2;
                    }
                    .total {
                    font-weight: bold;
                    font-size: 1.2em;
                    text-align: right;
                    margin-top:20px;
                    }
                </style>
            </head>
            <body>
                <h2>Presupuesto</h2>
                <h3>Orange Empresas</h3>
                <table>
                    <thead>
                        <tr>
                            <th>CANTIDAD</th>
                            <th>DESCRIPCIÓN</th>
                            <th>IMPORTE</th>
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
                        <tr>
                            <td colspan="2" class="total">Total:</td>
                            <td>
                                <xsl:value-of select="Total" />
                            </td>
                        </tr>
                    </tbody>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>