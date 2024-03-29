package com.kenshine.jacksonproperties;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.dataformat.javaprop.JavaPropsFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;

/**
 * yaml与properties互转
 * @author kenshine
 */
public class TransferUtils {

    private static final String ENCODING = "utf-8";

    /**
     * yaml转换为properties
     */
    public static void yml2Properties(String in) {
        final String DOT = ".";
        List<String> lines = new LinkedList<>();
        try {
            YAMLFactory yamlFactory = new YAMLFactory();
            YAMLParser parser = yamlFactory.createParser(
                    new InputStreamReader(new FileInputStream(in), Charset.forName(ENCODING)));

            String key = "";
            String value = null;
            JsonToken token = parser.nextToken();
            while (token != null) {
                if (JsonToken.START_OBJECT.equals(token)) {
                    // do nothing
                } else if (JsonToken.FIELD_NAME.equals(token)) {
                    if (key.length() > 0) {
                        key = key + DOT;
                    }
                    key = key + parser.getCurrentName();

                    token = parser.nextToken();
                    if (JsonToken.START_OBJECT.equals(token)) {
                        continue;
                    }
                    value = parser.getText();
                    lines.add(key + "=" + value);

                    int dotOffset = key.lastIndexOf(DOT);
                    if (dotOffset > 0) {
                        key = key.substring(0, dotOffset);
                    }
                    value = null;
                } else if (JsonToken.END_OBJECT.equals(token)) {
                    int dotOffset = key.lastIndexOf(DOT);
                    if (dotOffset > 0) {
                        key = key.substring(0, dotOffset);
                    } else {
                        key = "";
                        lines.add("");
                    }
                }
                token = parser.nextToken();
            }
            parser.close();

            System.out.println(lines);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * properties转yaml
     */
    public static void properties2Yaml(String in,String out) {
        JsonParser parser = null;
        JavaPropsFactory factory = new JavaPropsFactory();
        try {
            parser = factory.createParser(
                    new InputStreamReader(new FileInputStream(in), Charset.forName(ENCODING)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            YAMLFactory yamlFactory = new YAMLFactory();
            YAMLGenerator generator = yamlFactory.createGenerator(
                    new OutputStreamWriter(new FileOutputStream(out), Charset.forName(ENCODING)));

            JsonToken token = parser.nextToken();

            while (token != null) {
                if (JsonToken.START_OBJECT.equals(token)) {
                    generator.writeStartObject();
                } else if (JsonToken.FIELD_NAME.equals(token)) {
                    generator.writeFieldName(parser.getCurrentName());
                } else if (JsonToken.VALUE_STRING.equals(token)) {
                    generator.writeString(parser.getText());
                } else if (JsonToken.END_OBJECT.equals(token)) {
                    generator.writeEndObject();
                }
                token = parser.nextToken();
            }
            parser.close();
            generator.flush();
            generator.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}