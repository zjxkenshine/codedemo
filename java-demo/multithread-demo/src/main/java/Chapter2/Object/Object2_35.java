package Chapter2.Object;

public class Object2_35 {
	//synchronized�������volatileͬ������          
	
	private boolean isRun=true;
	public void runMethod(){
		while(isRun){
	//		synchronized ("AAA") {               //���޿���,_server������������
	//		}
		}
		System.out.println("ͣ��");
	}
	public void stopMethod(){
		isRun=false;
	}

}
