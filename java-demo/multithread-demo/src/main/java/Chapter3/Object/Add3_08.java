package Chapter3.Object;

public class Add3_08 {
	//¼Ó·¨
	
	private String lock;
	public Add3_08(String lock){
		super();
		this.lock=lock;
	}
	
	public void add(){
		synchronized (lock) {
		    Object3_08.list.add("6666666");
		    lock.notifyAll();
		}
	}

}
