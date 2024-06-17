<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" encoding="UTF-8" doctype-public="-//W3C//DTD HTML 4.01 Transitional//EN" doctype-system="http://www.w3.org/TR/html4/loose.dtd"/>

    <xsl:template match="/">
        <html lang="en">
            <head>
                <meta charset="UTF-8"></meta>
                <title>Wygenerowane Dane</title>
                <script src=""></script>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/css/bootstrap.min.css"/>
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
                <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css"/>

                <style>
                    body {
                    min-height: 100vh;
                    background-color: #FFE53B;
                    background-image: linear-gradient(147deg, #FFE53B 0%, #FF2525 100%);
                    }
                </style>
            </head>
            <body>
                <div class="container py-5">
                    <header class="text-center text-white">
                        <h1 class="display-4">XML Datatables</h1>
                    </header>
                    <div class="row py-5">
                        <div class="col-lg-10 mx-auto">
                            <div class="card rounded shadow border-0">
                                <div class="card-body p-5 bg-white rounded">
                                    <div class="table-responsive">
                                        <table id="example" style="width:100%" class="table table-striped table-bordered">
                                            <thead>
                                                <tr>
                                                    <th>ID</th>
                                                    <th>Data</th>
                                                    <th>Organizacja</th>
                                                    <th>Komponent Środowiska</th>
                                                    <th>Typ Karty</th>
                                                    <th>Rodzaj Karty</th>
                                                    <th>Nr Wpisu</th>
                                                    <th>Znak Sprawy</th>
                                                    <th>Link</th>
                                                    <th>Nazwa Wnioskodawcy</th>
                                                    <th>Ulica</th>
                                                    <th>Miejscowość</th>
                                                </tr>
                                            </thead>
                                            <tbody id="table-body">
                                                <xsl:for-each select="//karta_informacyjna">
                                                    <tr>
                                                        <td><xsl:value-of select="id"/></td>
                                                        <td><xsl:value-of select="data"/></td>
                                                        <td><xsl:value-of select="skrot_organizacja"/></td>
                                                        <td><xsl:value-of select="komponent_srodowiska"/></td>
                                                        <td><xsl:value-of select="typ_karty"/></td>
                                                        <td><xsl:value-of select="rodzaj_karty"/></td>
                                                        <td><xsl:value-of select="nr_wpisu"/></td>
                                                        <td><xsl:value-of select="znak_sprawy"/></td>
                                                        <td><a href="{link}">Link</a></td>
                                                        <xsl:variable name="dane" select="dane_wnioskodawcy"/>
                                                        <td>
                                                            <xsl:value-of select="substring-before($dane, ', ')"/>
                                                        </td>
                                                        <td>
                                                            <xsl:value-of select="substring-before(substring-after($dane, ', '), ', ')"/>
                                                        </td>
                                                        <td>
                                                            <xsl:value-of select="substring-after(substring-after($dane, ', '), ', ')"/>
                                                        </td>
                                                    </tr>
                                                </xsl:for-each>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <script>
                    $(function() {
                    $(document).ready(function() {
                    $('#example').DataTable();
                    });
                    });
                </script>
                <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
                <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.3.1/js/bootstrap.bundle.min.js"></script>
                <script src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
                <script src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>
