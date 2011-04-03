package prixma.opc.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 */

public abstract class Service {
	
	private static final Logger Log = LoggerFactory.getLogger(Service.class);
	
	protected RunStrategy runStrategy;
	protected ServiceScheduler scheduler;
	
	protected long frequency = 10, delay = 0;
	protected String name;
	protected int executions;
	protected boolean debugMode;
	
	public Service(){
	}

	public Service (RunStrategy runStrategy){
		this.runStrategy = runStrategy;
		this.name = getClass().getSimpleName();
	}
	
	public Service withDelay(int delay, int scale){
		this.delay = delay * scale;
		return this;
	}
	
	public Service withDelay(int delay){
		return withDelay(delay, 1000);
	}
	
	public Service withFrequency(int period, int unit){
		this.frequency = period * unit;
		return this;
	}
	
	public Service withFrequency(int period){
		return withFrequency(period, 1000);
	}
	
	
	public Service start(){

		if(!isRunning()) {
			scheduler = new ServiceScheduler(false);
			scheduler.schedule(new ServiceTask(this), delay, frequency);
		}
		
		return this;
	}
	
	public void stop(){
		if(isRunning()){
			scheduler.stop();
			executions = 0;
		}
	}
	
	protected void sleep(long period){
		try {
			Thread.sleep(period);
		} catch (InterruptedException e) {
			throw new ServiceException(e);
		}
	}
	
	public boolean isRunning(){
		return scheduler.isTaskRunning();
	}
	
	public boolean shouldExecute(){
		return this.runStrategy.shouldExecute();
	}
	
	public boolean shouldContinue(){
		return runStrategy.shouldContinue();
	}
	
	public String getName(){
		return this.name;
	}

	public int getExecutions() {
		return this.executions;
	}
	
	public void hasExecuted(){
		this.executions++;
	}
	
	
	
	public Service enableDebug(){
		this.debugMode = true;
		return this;
	}
	
	public Service disableDebug(){
		this.debugMode = false;
		return this;
	}
	
	public boolean debugEnable(){
		return this.debugMode;
	}
	
	public void log(String message){
		if(debugEnable())
			Log.debug(message);
	}
	
	public abstract void execute();	
	

}
