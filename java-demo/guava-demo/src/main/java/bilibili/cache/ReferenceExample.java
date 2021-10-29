package bilibili.cache;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/29 20:36
 * @description：ReferenceExample 引用测试
 * @modified By：
 * @version: $
 *
 *
 * -Xmx128M -Xms64M -XX:+PrintGCDetails
 *
 */
public class ReferenceExample {

    public static void main(String[] args) throws InterruptedException {
        //强引用
//        int counter = 1;
//        List<Ref> container = new ArrayList<>();
//
//        for(;;){
//            int current = counter++;
//            container.add(new Ref(current));
//            System.out.println(current+"会被加入container");
//            TimeUnit.MILLISECONDS.sleep(50);
//        }

        /**
         * 弱引用
         * 在JVM快溢出是会进行GC
         */
//        int counter = 1;
//        List<SoftReference<Ref>> container = new ArrayList<>();
//        for(;;){
//            int current = counter++;
//            container.add(new SoftReference<>(new Ref(current)));
//            System.out.println(current+"会被加入container");
//            TimeUnit.MILLISECONDS.sleep(50);
//        }


        /**
         * 虚引用
         * 进行GC时就有可能被清理
         */
//        int counter = 1;
//        List<WeakReference<Ref>> container = new ArrayList<>();
//        for(;;){
//            int current = counter++;
//            container.add(new WeakReference<>(new Ref(current)));
//            System.out.println(current+"会被加入container");
//            TimeUnit.MILLISECONDS.sleep(50);
//        }

        /**
         * PhantomReference 幻影引用
         */
        Ref ref = new Ref(10);
        ReferenceQueue<Ref> queue = new ReferenceQueue<>();
        PhantomReference<Ref> reference = new PhantomReference<>(ref,queue);
        ref=null;
        //幻影引用无法取出，无法使用，相当于没有引用，仅在一些跟踪方法中会被使用
        System.out.println(reference.get());
    }

    private static class Ref{
        private byte[] data = new byte[1024*1024];

        private final int index;

        private Ref(int index){
            this.index = index;
        }

        @Override
        protected void finalize() throws Throwable{
            System.out.println("index "+index+" 会被gc");
        }

    }

}

