package Chapter3.Test;

public class Test3_02_1 {
	//�ȴ�/֪ͨ���Ƶ�ʵ�֣�wait/notify������
	
	/**1.wait():
	 * 	--ʹ��ǰִ�д�����߳̽��еȴ�
	 * 	--wait��Object��ķ���������ǰִ�е��̷߳���"Ԥִ�ж���"������wait()���ڵĴ��봦ֹͣ���У�ֱ���ӵ�֪ͨ���ж�Ϊֹ
	 * 	--*����wait֮ǰ�̱߳����øö���Ķ��󼶱�����ֻ����ͬ��������ͬ�����е���wait����
	 *  --�������waitʱû�г����ʵ����������׳�IlleaglMonistorStateExcption����
	 * 
	 * 2.notify()
	 * 	--ҲҪ��ͬ�������е��ã����򱨴�IlleaglMonistorStateExcption��ͬwait
	 * 	--�÷�������֪ͨ��Щ���ܵȴ����ö���Ķ��������������߳�,����ж���̣߳�
	 *    �������ѡһ����wait״̬���̣߳���ʹ�����ȴ�����ȡ�ö������
	 *  --��ִ����notify()�����󣬵�ǰ�̲߳����������ͷ�������ѡ�е�wait�߳�Ҳ�������̻�øö�����
	 *    Ҫ�ȵ�ִ��notify()�������߳�ִ������룬�˳�synchronizeͬ����ſ���
	 *  --��һ����ȡ�ö����waitִ���������ö���û���ٴ�ִ��notify��������ʹ�ö����Ѿ����У�
     *    ����wait�ȴ����߳�����δ�յ�֪ͨ���������������wait״̬��ֱ���ö��󷢳�һ��notify��notifyAll
     *    
     *  3.waitʹ�߳�ֹͣ���У���notifyʹ�̼߳�������
	 * 
	 */
	
	//����û�ж��������ʱ���쳣
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			String newString=new String("");
			newString.wait();
		}catch(InterruptedException e){
			e.printStackTrace();
		}

	}

}
