package Chapter2.Thread;

public class Thread2_32_2 extends Thread{
	//volatile�ķ�ԭ������
	
	volatile public static int count;        //volatile���Բ���
	synchronized static private void addCount(){         //���static������
		for(int i=0;i<1000;i++){
			count++;
		}
		System.out.println("count="+count);
	}
	
	public void run() {
		// TODO Auto-generated method stub
		addCount();
	}

}
