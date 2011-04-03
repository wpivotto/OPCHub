package prixma.opc.services;

import java.util.Timer;

public class ServiceScheduler {
	
	private Timer timer;
	private ServiceTask task;
	private boolean isDaemon;
	
	public ServiceScheduler(boolean isDaemon) {
		this.isDaemon = isDaemon;
	}

	public void schedule(ServiceTask task, long delay, long frequency){
		this.task = task;
		timer = new Timer(isDaemon);
		timer.scheduleAtFixedRate(task, delay, frequency);
	}
	
	public void stop(){
		if(timer != null){
			timer.cancel();
			task.cancel();
			timer.purge();
			timer = null;
		}
	}

	public boolean isTaskRunning() {
		return timer != null && task != null;
	}
	
}
