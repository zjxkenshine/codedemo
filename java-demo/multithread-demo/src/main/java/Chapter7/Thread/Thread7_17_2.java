package Chapter7.Thread;

public class Thread7_17_2 extends Thread{
	//�߳����ڴ����쳣
	
	/**���ʵ���߳�����һ���߳��쳣�����߳�ֹͣ
	 * 
	 * ע��:ʹ���Զ���ThreadGroup�߳��鲢����дuncaughtException�������������߳��ж���Ϊʱ��ÿ���̶߳����ڶ�������catch��䣬
	 *     ����У���uncaughtException(Thread t, Throwable e)������ִ��
	 * 
	 * 
	 */
	
	private String num;
	
	public Thread7_17_2(ThreadGroup group,String name,String num) {
		// TODO Auto-generated constructor stub
		super(group,name);
		this.num=num;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		int numInt=Integer.parseInt(num);
		while(this.isInterrupted()==false){
			System.out.println("��ѭ���У�"+Thread.currentThread().getName());
		}
		
	}

}
