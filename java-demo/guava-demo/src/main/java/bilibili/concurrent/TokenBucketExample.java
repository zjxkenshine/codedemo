package bilibili.concurrent;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 22:05
 * @description：令牌桶示例
 * @modified By：
 * @version: $
 */
public class TokenBucketExample {

    public static void main(String[] args) {

        final TokenBucket tokenBucket = new TokenBucket();

        /**
         * 150个人抢100个产品
         */
        for(int i =0;i<150;i++){
            new Thread(tokenBucket::buy).start();
        }

    }

}
