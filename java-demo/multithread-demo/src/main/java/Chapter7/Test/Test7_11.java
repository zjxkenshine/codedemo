package Chapter7.Test;

public class Test7_11 {
	//�ݹ���ǵݹ�ȡ�����ڶ���
	
	public static void main(String[] args) {
		ThreadGroup mainGroup=Thread.currentThread().getThreadGroup();
		ThreadGroup groupA=new ThreadGroup(mainGroup,"A");
		Runnable run=new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try{
					System.out.println("runMethod!");
					Thread.sleep(5000);
				}catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
			
		};
		 
		ThreadGroup  groupB=new ThreadGroup(groupA,"B");
		//����ռ䣬���ǲ�һ��ȫ��ʹ��
		ThreadGroup[]  listGroup1=new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		//����true�ǵݹ�ȡ�������������
		Thread.currentThread().getThreadGroup().enumerate(listGroup1,true);
		for(int i=0;i<listGroup1.length;i++){
			if(listGroup1[i]!=null){
				System.out.println(listGroup1[i].getName());
			}
		}
		
		ThreadGroup[]  listGroup2=new ThreadGroup[Thread.currentThread().getThreadGroup().activeGroupCount()];
		//����false�Ƿǵݹ�ȡ���Ӷ���
		Thread.currentThread().getThreadGroup().enumerate(listGroup2,false);
		for(int i=0;i<listGroup2.length;i++){
			if(listGroup2[i]!=null){
				System.out.println(listGroup2[i].getName());
			}
		}
		
	}

}
