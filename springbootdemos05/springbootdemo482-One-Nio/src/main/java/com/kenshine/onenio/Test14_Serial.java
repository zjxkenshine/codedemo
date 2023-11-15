package com.kenshine.onenio;

import one.nio.serial.*;
import one.nio.serial.gen.Delegate;
import one.nio.serial.gen.DelegateGenerator;
import org.junit.Test;

import java.io.IOException;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * @author by kenshine
 * @Classname Test14_Serial
 * @Description 序列化反序列化
 * @Date 2023-11-15 17:32
 * @modified By：
 * @version: 1.0$
 */
public class Test14_Serial {

    /**
     * 序列化读取
     */
    @Test
    public void testReadPlace() throws IOException, ClassNotFoundException {
        Place place = new Place("blah", "", "");

        Serializer<Place> serializer = Repository.get(Place.class);
        CalcSizeStream css = new CalcSizeStream();
        serializer.calcSize(place, css);
        int length = css.count();

        byte[] buf = new byte[length];
        SerializeStream out = new SerializeStream(buf);
        serializer.write(place, out);
        DeserializeStream in = new DeserializeStream(buf);
        Place place2 = serializer.read(in);
        assertEquals(place, place2);
    }

    /**
     * Json
     */
    @Test
    public void testJson() throws IOException {
        Object obj = Arrays.asList("abc", 1, 2.0, true);
        System.out.println(Json.toJson(obj));

        TestObject object = new TestObject();
        object.name = "Maxim";
        System.out.println(Json.toJson(object));
    }

    public static class TestObject implements Serializable {
        @JsonName("test_name")
        public String name;
    }

    private static class Place implements Serializable {
        private String name;
        private String altName;
        private String intName;

        public Place(String name, String altName, String intName) {
            this.name = name;
            this.altName = altName;
            this.intName = intName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Place place = (Place) o;
            if (intName != null ? !intName.equals(place.intName) : place.intName != null) {
                return false;
            }
            if (name != null ? !name.equals(place.name) : place.name != null) {
                return false;
            }
            if (altName != null ? !altName.equals(place.altName) : place.altName != null) {
                return false;
            }
            return true;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (altName != null ? altName.hashCode() : 0);
            result = 31 * result + (intName != null ? intName.hashCode() : 0);
            return result;
        }
    }
}
