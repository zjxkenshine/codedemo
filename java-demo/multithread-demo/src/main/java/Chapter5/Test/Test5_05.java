package Chapter5.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Test5_05 {
	//����schedule(TimeTask task,Date firstTime,long period) ִ�������ʱ�����ڵ�ǰʱ�䣺��δ��ִ�е�Ч��
	
	/**schedule(TimeTask task,Date firstTime,long period)��������������ָ��������firstTime��
	 *  ����ָ���ļ�������Ե�����ѭ��ִ��ĳһ����
	 */
	
	static public class Mytask extends TimerTask{
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("�����ˣ�ʱ��Ϊ"+new Date());
		}
	}
	
	public static void main(String[] args) {
		try{
			Mytask tsk=new Mytask();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String day="2017-10-11 11:07:00";
			Timer time=new Timer();
			Date d1=sdf.parse(day);
			System.out.println("�ַ���ʱ��"+d1.toLocaleString()+"��ǰʱ��"+new Date().toLocaleString());
			time.schedule(tsk, d1, 4000);                       //ÿ4��ѭ��һ��
		}catch (ParseException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	

}
