package Chapter2.Object;

public class Object2_06_1 {
	//synchronized��������,�Ǽ̳л���
	
	synchronized public void service1(){
		System.out.println("service1");
		service2();
	}
	
	synchronized public void service2(){
		System.out.println("service2");
		service3();
	}
	
	synchronized public void service3(){
		System.out.println("service3");
	}

}
