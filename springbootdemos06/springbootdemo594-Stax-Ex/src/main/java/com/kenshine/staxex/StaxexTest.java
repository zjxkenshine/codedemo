package com.kenshine.staxex;


import org.junit.Test;
import org.jvnet.staxex.util.XMLStreamReaderToXMLStreamWriter;

import javax.xml.namespace.NamespaceContext;
import javax.xml.namespace.QName;
import javax.xml.stream.*;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @author by kenshine
 * @Classname StaxexTest
 * @Description Staxex使用
 * @Date 2023-12-16 16:54
 * @modified By：
 * @version: 1.0$
 */
public class StaxexTest {

    /**
     * 官方测试代码
     * XMLStreamReaderToXMLStreamWriter 桥接读写
     */
    @Test
    public void test01() throws XMLStreamException {
        XMLInputFactory infact = XMLInputFactory.newInstance();
        String xmlString = "<sendMessage xmlns=\"http://www.foo.bar/schema/\" xmlns:ns2=\"http://www.foo.bar/types/\">" +
                "<message xsi:type=\"ns2:someType\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"/>" +
                "</sendMessage>";
        XMLStreamReader in = new XMLStreamReaderNullPrefix(infact.createXMLStreamReader(new StringReader(xmlString)));
        StringWriter sw = new StringWriter();
        XMLStreamWriter out = new XMLStreamWriterNoNullPrefixes(XMLOutputFactory.newInstance().createXMLStreamWriter(sw));
        XMLStreamReaderToXMLStreamWriter readerToWriter = new XMLStreamReaderToXMLStreamWriter();
        readerToWriter.bridge(in, out);
        System.out.println(sw.toString());
    }

    private static class XMLStreamWriterNoNullPrefixes implements XMLStreamWriter {
        private XMLStreamWriter delegate;

        public XMLStreamWriterNoNullPrefixes(XMLStreamWriter delegate) {
            this.delegate = delegate;
        }
        @Override
        public void close() throws XMLStreamException {
            delegate.close();
        }
        @Override
        public void flush() throws XMLStreamException {
            delegate.flush();
        }
        @Override
        public NamespaceContext getNamespaceContext() {
            return delegate.getNamespaceContext();
        }
        @Override
        public String getPrefix(String arg0) throws XMLStreamException {
            return delegate.getPrefix(arg0);
        }
        @Override
        public Object getProperty(String arg0) throws IllegalArgumentException {
            return delegate.getProperty(arg0);
        }
        @Override
        public void setDefaultNamespace(String arg0) throws XMLStreamException {
            delegate.setDefaultNamespace(arg0);
        }
        @Override
        public void setNamespaceContext(NamespaceContext arg0)
                throws XMLStreamException {
            delegate.setNamespaceContext(arg0);
        }
        @Override
        public void setPrefix(String arg0, String arg1)
                throws XMLStreamException {
            delegate.setPrefix(arg0, arg1);
        }
        @Override
        public void writeAttribute(String arg0, String arg1, String arg2,
                                   String arg3) throws XMLStreamException {
            delegate.writeAttribute(arg0, arg1, arg2, arg3);
        }
        @Override
        public void writeAttribute(String arg0, String arg1, String arg2)
                throws XMLStreamException {
            delegate.writeAttribute(arg0, arg1, arg2);
        }
        @Override
        public void writeAttribute(String arg0, String arg1)
                throws XMLStreamException {
            delegate.writeAttribute(arg0, arg1);
        }
        @Override
        public void writeCData(String arg0) throws XMLStreamException {
            delegate.writeCData(arg0);
        }
        @Override
        public void writeCharacters(char[] arg0, int arg1, int arg2)
                throws XMLStreamException {
            delegate.writeCharacters(arg0, arg1, arg2);
        }
        @Override
        public void writeCharacters(String arg0) throws XMLStreamException {
            delegate.writeCharacters(arg0);
        }
        @Override
        public void writeComment(String arg0) throws XMLStreamException {
            delegate.writeComment(arg0);
        }
        @Override
        public void writeDTD(String arg0) throws XMLStreamException {
            delegate.writeDTD(arg0);
        }
        @Override
        public void writeDefaultNamespace(String arg0)
                throws XMLStreamException {
            delegate.writeDefaultNamespace(arg0);
        }
        @Override
        public void writeEmptyElement(String arg0, String arg1, String arg2)
                throws XMLStreamException {
            delegate.writeEmptyElement(arg0, arg1, arg2);
        }
        @Override
        public void writeEmptyElement(String arg0, String arg1)
                throws XMLStreamException {
            delegate.writeEmptyElement(arg0, arg1);
        }
        @Override
        public void writeEmptyElement(String arg0) throws XMLStreamException {
            delegate.writeEmptyElement(arg0);
        }
        @Override
        public void writeEndDocument() throws XMLStreamException {
            delegate.writeEndDocument();
        }
        @Override
        public void writeEndElement() throws XMLStreamException {
            delegate.writeEndElement();
        }
        @Override
        public void writeEntityRef(String arg0) throws XMLStreamException {
            delegate.writeEntityRef(arg0);
        }
        @Override
        public void writeNamespace(String prefix, String ns)
                throws XMLStreamException {
            if (prefix == null) {
                throw new XMLStreamException("NS Prefix from XMLStreamReaderToXMLStreamWriter cannot be null!");
            }
            delegate.writeNamespace(prefix, ns);
        }
        @Override
        public void writeProcessingInstruction(String arg0, String arg1)
                throws XMLStreamException {
            delegate.writeProcessingInstruction(arg0, arg1);
        }
        @Override
        public void writeProcessingInstruction(String arg0)
                throws XMLStreamException {
            delegate.writeProcessingInstruction(arg0);
        }
        @Override
        public void writeStartDocument() throws XMLStreamException {
            delegate.writeStartDocument();
        }
        @Override
        public void writeStartDocument(String arg0, String arg1)
                throws XMLStreamException {
            delegate.writeStartDocument(arg0, arg1);
        }
        @Override
        public void writeStartDocument(String arg0) throws XMLStreamException {
            delegate.writeStartDocument(arg0);
        }
        @Override
        public void writeStartElement(String arg0, String arg1, String arg2)
                throws XMLStreamException {
            delegate.writeStartElement(arg0, arg1, arg2);
        }
        @Override
        public void writeStartElement(String arg0, String arg1)
                throws XMLStreamException {
            delegate.writeStartElement(arg0, arg1);
        }
        @Override
        public void writeStartElement(String arg0) throws XMLStreamException {
            delegate.writeStartElement(arg0);
        }
    }
    private static class XMLStreamReaderNullPrefix implements XMLStreamReader {
        private XMLStreamReader delegate;

        public XMLStreamReaderNullPrefix(XMLStreamReader reader) {
            delegate = reader;
        }
        @Override
        public void close() throws XMLStreamException {
            delegate.close();
        }
        @Override
        public int getAttributeCount() {
            return delegate.getAttributeCount();
        }
        @Override
        public String getAttributeLocalName(int arg0) {
            return delegate.getAttributeLocalName(arg0);
        }
        @Override
        public QName getAttributeName(int arg0) {
            return delegate.getAttributeName(arg0);
        }
        @Override
        public String getAttributeNamespace(int arg0) {
            return delegate.getAttributeNamespace(arg0);
        }
        @Override
        public String getAttributePrefix(int arg0) {
            return delegate.getAttributePrefix(arg0);
        }
        @Override
        public String getAttributeType(int arg0) {
            return delegate.getAttributeType(arg0);
        }
        @Override
        public String getAttributeValue(int arg0) {
            return delegate.getAttributeValue(arg0);
        }
        @Override
        public String getAttributeValue(String arg0, String arg1) {
            return delegate.getAttributeValue(arg0, arg1);
        }
        @Override
        public String getCharacterEncodingScheme() {
            return delegate.getCharacterEncodingScheme();
        }
        @Override
        public String getElementText() throws XMLStreamException {
            return delegate.getElementText();
        }
        @Override
        public String getEncoding() {
            return delegate.getEncoding();
        }

        @Override
        public int getEventType() {
            return delegate.getEventType();
        }

        @Override
        public String getLocalName() {
            return delegate.getLocalName();
        }

        @Override
        public Location getLocation() {
            return delegate.getLocation();
        }

        @Override
        public QName getName() {
            return delegate.getName();
        }
        @Override
        public NamespaceContext getNamespaceContext() {
            return delegate.getNamespaceContext();
        }

        @Override
        public int getNamespaceCount() {
            return delegate.getNamespaceCount();
        }

        @Override
        public String getNamespacePrefix(int arg0) {
            String prefix = delegate.getNamespacePrefix(arg0);
            if ("".equals(prefix)) {
                return null;
            }
            return prefix;
        }

        @Override
        public String getNamespaceURI() {
            return delegate.getNamespaceURI();
        }

        @Override
        public String getNamespaceURI(int arg0) {
            return delegate.getNamespaceURI(arg0);
        }

        @Override
        public String getNamespaceURI(String arg0) {
            return delegate.getNamespaceURI(arg0);
        }

        @Override
        public String getPIData() {
            return delegate.getPIData();
        }

        @Override
        public String getPITarget() {
            return delegate.getPITarget();
        }

        @Override
        public String getPrefix() {
            return delegate.getPrefix();
        }

        @Override
        public Object getProperty(String arg0) throws IllegalArgumentException {
            return delegate.getProperty(arg0);
        }

        @Override
        public String getText() {
            return delegate.getText();
        }

        @Override
        public char[] getTextCharacters() {
            return delegate.getTextCharacters();
        }

        @Override
        public int getTextCharacters(int arg0, char[] arg1, int arg2, int arg3)
                throws XMLStreamException {
            return delegate.getTextCharacters(arg0, arg1, arg2, arg3);
        }

        @Override
        public int getTextLength() {
            return delegate.getTextLength();
        }

        @Override
        public int getTextStart() {
            return delegate.getTextStart();
        }

        @Override
        public String getVersion() {
            return delegate.getVersion();
        }

        @Override
        public boolean hasName() {
            return delegate.hasName();
        }

        @Override
        public boolean hasNext() throws XMLStreamException {
            return delegate.hasNext();
        }

        @Override
        public boolean hasText() {
            return delegate.hasText();
        }

        @Override
        public boolean isAttributeSpecified(int arg0) {
            return delegate.isAttributeSpecified(arg0);
        }

        @Override
        public boolean isCharacters() {
            return delegate.isCharacters();
        }

        @Override
        public boolean isEndElement() {
            return delegate.isEndElement();
        }

        @Override
        public boolean isStandalone() {
            return delegate.isStandalone();
        }

        @Override
        public boolean isStartElement() {
            return delegate.isStartElement();
        }

        @Override
        public boolean isWhiteSpace() {
            return delegate.isWhiteSpace();
        }

        @Override
        public int next() throws XMLStreamException {
            return delegate.next();
        }

        @Override
        public int nextTag() throws XMLStreamException {
            return delegate.nextTag();
        }

        @Override
        public void require(int arg0, String arg1, String arg2)
                throws XMLStreamException {
            delegate.require(arg0, arg1, arg2);
        }

        @Override
        public boolean standaloneSet() {
            return delegate.standaloneSet();
        }
    }

}
