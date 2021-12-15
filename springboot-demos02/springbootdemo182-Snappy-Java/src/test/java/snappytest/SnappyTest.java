package snappytest;

import org.junit.Test;
import org.xerial.snappy.BitShuffle;
import org.xerial.snappy.Snappy;

import java.io.IOException;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/15 23:22
 * @description：测试
 * @modified By：
 * @version: $
 */
public class SnappyTest {

    /**
     * 基本使用
     * @throws IOException
     */
    @Test
    public void baseTest() throws IOException {
        String input = "Hello snappy-java! Snappy-java is a JNI-based wrapper of "
                + "Snappy, a fast compresser/decompresser.";
        byte[] compressed = Snappy.compress(input.getBytes("UTF-8"));
        byte[] uncompressed = Snappy.uncompress(compressed);

        String result = new String(uncompressed, "UTF-8");
        System.out.println(result);
    }

    /**
     * BitShuffle测试
     */
    @Test
    public void testBitShuffle() throws IOException {
        int[] data = new int[] {1, 3, 34, 43, 34};
        byte[] shuffledByteArray = BitShuffle.shuffle(data);
        byte[] compressed = Snappy.compress(shuffledByteArray);
        byte[] uncompressed = Snappy.uncompress(compressed);
        int[] result = BitShuffle.unshuffleIntArray(uncompressed);
        System.out.println(result);
    }



}
