package Chapter3.Test;

public class Test3_24 {
	//get()������null 0ol,
	
	/**1.����ֵ�Ĺ������ʹ��public static��������ʽ�������̶߳�ʹ��ͬһ��public static����
	 * 
	 * 2.�����ÿһ���̶߳����Լ��Ĺ������----JDK���ṩ��ThreadLocal��
	 * 
	 * 3.ThreadLocal��Ҫ����ľ���ÿ���̶߳����Լ���ֵ�����Խ�ThreadLocal�����ȫ�ִ�����ݵĺ��ӣ���������Դ��
	 * 
	 * 4.ThreadLocal������Ǳ����ڲ�ͬ�߳��еĸ����ԣ���ͬ�߳��в�ͬ��ֵ����ͬ�߳���ֵҲ���Է���ThreadLocal����б���
	 */
	
	public static ThreadLocal t1=new  ThreadLocal();
	
	public static void main(String[] args) {
		if(t1.get()==null){
			System.out.println(t1.get());
			System.out.println("��ʱThreadLocal��û��ֵ");
			t1.set("��ֵ��");
		}
		System.out.println(t1.get());
		System.out.println(t1.get());
	}

}
