package Chapter3.Object;

public class Object3_17 {
	//ʵս���ȴ�/֪ͨ���汸��--������
	
	volatile private boolean prevIsB=false;
	
	synchronized public void backup1(){
		try{
			while(prevIsB==false){
				wait();
			}
			for(int i=0;i<5;i++){
				System.out.println("������");
			}
			prevIsB=false;
			notifyAll();
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	synchronized public void backup2(){
		try{
			while(prevIsB==true){
				wait();
			}
			for(int i=0;i<5;i++){
				System.out.println("������");
			}
			prevIsB=true;
			notifyAll();
			
		}catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
