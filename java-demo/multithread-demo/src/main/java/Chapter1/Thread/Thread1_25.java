package Chapter1.Thread;

public class Thread1_25 extends Thread{
	//yield()������ʹ�̷߳�����ǰCPU��Դ�������ø���������ȥռ��cpuִ��ʱ��
	
	public void run(){
		long begin=System.currentTimeMillis();
		int count=0;
		for(int i=0;i<500000;i++){ 
			//Thread.yield();            //����ע�Ϳ��Բ���yield����Դ
			count=count+1;
		}
		long end=System.currentTimeMillis();
		System.out.println("��ʱ��"+(end-begin)+"����!");
	}

}
