package Chapter1.Thread;

public class Thread1_23_2 extends Thread {
	//suspend()��resume()ȱ�����ӣ���ռͬ����
	private long i=0;
	
	public void run(){
		while(true){
			i++;
			System.out.println(i);       //ȥ�������򲻻����println��ռ���⣬�������main end!
		}
	}
	
	
}
