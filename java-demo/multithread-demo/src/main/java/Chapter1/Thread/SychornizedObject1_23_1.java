package Chapter1.Thread;

public class SychornizedObject1_23_1 {
	
	//suspend()��resume()ȱ�����ӣ���ռ����ͬ������
	
	synchronized public void printString(){
		System.out.println("begin");
		if(Thread.currentThread().getName().equals("a")){
			System.out.println("a�߳���Զ��ͣ��");
			Thread.currentThread().suspend();
		}
		System.out.println("end!");
	}

}
