package Chapter7.Object;

import java.lang.Thread.UncaughtExceptionHandler;

public class StateUncaughtExceptionHandler implements UncaughtExceptionHandler{
	
	@Override
	public void uncaughtException(Thread t, Throwable e) {
		// TODO Auto-generated method stub
		
		//uncaughtException(t, e);
		System.out.println("��̬���쳣����");
		e.printStackTrace();
	}

}
