package Chapter2.Object;

import java.util.concurrent.atomic.AtomicLong;

public class Object2_34 {
	//��ԭ����Ҳ������ȫ��ȫ
	
	public static AtomicLong along=new AtomicLong();
	
//	synchronized public void addNum(){                 //��Ҫͬ��,������֮�䲻��ԭ�ӵ�
	public void addNum(){
		System.out.println(Thread.currentThread().getName()+" ����100���ֵ�ǣ�"+along.addAndGet(100));
		along.addAndGet(1);
	}

}
