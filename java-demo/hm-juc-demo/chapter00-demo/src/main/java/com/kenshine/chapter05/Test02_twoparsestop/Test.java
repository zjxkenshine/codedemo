package com.kenshine.chapter05.Test02_twoparsestop;

/**
 * Volatile实现两阶段终止
 */
public class Test {
	public static void main(String[] args) throws InterruptedException {
		Monitor monitor = new Monitor();
		monitor.start();
		Thread.sleep(3500);
		monitor.stop();
	}
}

class Monitor {
	Thread monitor;
	// 设置标记，用于判断是否被终止了
	private volatile boolean stop = false;
	/**
	 * 启动监控器线程
	 */
	public void start() {
		// 设置线控器线程，用于监控线程状态
		monitor = new Thread() {
			@Override
			public void run() {
				// 开始不停的监控
				while (true) {
					if(stop) {
						System.out.println("处理后续任务");
						break;
					}
					System.out.println("监控器运行中...");
					try {
						// 线程休眠
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						System.out.println("被打断了");
					}
				}
			}
		};
		monitor.start();
	}

	/**
	 * 	用于停止监控器线程
	 */
	public void stop() {
		// 修改标记
		stop = true;
		// 打断线程
		monitor.interrupt();        
	}
}