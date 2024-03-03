package Chapter3.Object;

public class Substract3_08 {
	
	private String lock;
	public Substract3_08(String lock){
		super();
		this.lock=lock;
	}
	/*
	//错误方法：出现溢出异常

   public void Subtract(){
		try{
			synchronized (lock) {
			if(Object3_08.list.size()==0){
				System.out.println("线程开始等待："+Thread.currentThread().getName());
				lock.wait();
				System.out.println("线程结束等待："+Thread.currentThread().getName());
			}
			Object3_08.list.remove(0);
			System.out.println("list size="+Object3_08.list.size());
			}
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	*/
	
	//对的方法
	 public void Subtract(){
			try{
				synchronized (lock) {
				while(Object3_08.list.size()==0){
					System.out.println("线程开始等待："+Thread.currentThread().getName());
					lock.wait();
					System.out.println("线程结束等待："+Thread.currentThread().getName());
				}
				Object3_08.list.remove(0);
				System.out.println("list size="+Object3_08.list.size());
				}
			}catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}

}
