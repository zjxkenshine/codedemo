package Chapter3.Thread;

import Chapter3.Object.C3_11;

public class Thread3_11B extends Thread{
	//һ������һ���ѣ�������ջ��
    private C3_11 c;
    
    public Thread3_11B(C3_11 c) {
		// TODO Auto-generated constructor stub
    	this.c=c;
	}
    @Override
    public void run() {
    	// TODO Auto-generated method stub
    	super.run();
    	while(true){
    		c.popService();
    	}
    }
}
