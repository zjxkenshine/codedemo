package Chapter2.Object;

public class Service2_16_2 {
	//2_16:synchronized(�����this����x)���������� ,�߼��жϲ�
	
	public Object2_16_2 addMethod(Object2_16_2 list,String data){
		try{
		//	synchronized("aaa"){            //����ʹ��ͬ������������
			if(list.getSize()<1){
				Thread.sleep(2000);       //ģ�⻨�������ȡ���ݣ�Aִ�����ʱ��ʱBִ����getsize()����
				list.add(data);
			}
		//	}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return list;
	}

}
