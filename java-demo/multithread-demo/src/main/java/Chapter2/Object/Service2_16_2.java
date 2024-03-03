package Chapter2.Object;

public class Service2_16_2 {
	//2_16:synchronized(任意非this对象x)解决脏读问题 ,逻辑判断层
	
	public Object2_16_2 addMethod(Object2_16_2 list,String data){
		try{
		//	synchronized("aaa"){            //这里使用同步解决脏读问题
			if(list.getSize()<1){
				Thread.sleep(2000);       //模拟花了两秒获取数据，A执行这段时间时B执行了getsize()方法
				list.add(data);
			}
		//	}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		return list;
	}

}
