package Chapter1.Thread;

public class Thread1_22 extends Thread{
	//��ͣ�̣߳�suspend()����resume()�ָ�
	private long i=0;
	
	public long getI() {
		return i;
	}

	public void setI(long i) {
		this.i = i;
	}

	public void run(){
		while(true){
			i++;
		}
	}
}
