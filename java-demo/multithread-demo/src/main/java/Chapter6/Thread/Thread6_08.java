package Chapter6.Thread;

import Chapter6.Object.Object6_08;

public class Thread6_08 extends Thread{
	//�ӳټ���/����ģʽ��ȱ��Ľ������4��DCL˫���������(Double-Check Locking)
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println(Object6_08.getInstance().hashCode());
	}

}
