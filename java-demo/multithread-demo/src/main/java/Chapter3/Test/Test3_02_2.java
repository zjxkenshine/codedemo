package Chapter3.Test;

public class Test3_02_2 {
	//�����ж����������wait����û��notify����
	
	//wait���������ִ��
	
	public static void main(String[] args) {
		try{
			String lock=new String();
			System.out.println("synchronized�������");
			synchronized (lock) {
				System.out.println("synchronized��һ��");
				lock.wait();
				System.out.println("wait����Ĵ���");
			}
			System.out.println("synchronized�������Ĵ���");
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
