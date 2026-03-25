package com.budgetsgenerator.xml.models;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.StringReader;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;


public class PdfGenerator {
    private FopFactory fopFactory;

    public PdfGenerator() {
        this.fopFactory = FopFactory.newInstance(new File(".").toURI());
    }

    public void generatePdf(String xmlData, File xsltFile, File outFile) throws Exception {
        try (OutputStream out = new BufferedOutputStream(new FileOutputStream(outFile))) {
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);

            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            Source src = new StreamSource(new StringReader(xmlData));
            Result res = new SAXResult(fop.getDefaultHandler());

            transformer.transform(src, res);
        }
    }
}
