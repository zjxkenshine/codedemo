package Chapter2.Test;

import Chapter2.Object.Object2_26.Inner;

public class Test2_26 {
	//��������ͬ��ʵ��1
	
	/**
	 * ����:��������������ͬ����������ʹ�õ��ǲ�ͬ��������ӡ�Ľ��Ҳ���첽��
	 * 
	 * ���Խ�����첽����ӡ�������
	 */
	
	public static void main(String[] args) {
		final Inner inn=new Inner();
		
		Thread a=new Thread(new Runnable(){                //�Ƚϵ���̴߳�������
			@Override
			public void run() {
				// TODO Auto-generated method stub
				inn.MethodA();
			}
		},"A");
		
		Thread b=new Thread(new Runnable(){                //�Ƚϵ���̴߳�������
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					inn.MethodB();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		},"B");
		
		a.start();
		b.start();
	}

}
