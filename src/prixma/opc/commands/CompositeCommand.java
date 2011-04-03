package prixma.opc.commands;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CompositeCommand implements OpcWriteCommand {
	
	private BlockingQueue<OpcWriteCommand> queue = new LinkedBlockingQueue<OpcWriteCommand>();
	protected static final int HIGH = 1;
	protected static final int LOW = 0;
	private int delay = 500;
	
	public CompositeCommand(OpcWriteCommand... comandos){
		for(OpcWriteCommand c : comandos){
			addCommand(c);
		}
	}
	
	public CompositeCommand(int delay, OpcWriteCommand... comandos){
		for(OpcWriteCommand c : comandos){
			addCommand(c);
		}
		this.delay = delay;
	}
	
	public void addCommand(OpcWriteCommand c){
		this.queue.add(c);
	}
	

	public void setDelay(int espera){
		if(espera > 0 && espera <= 1000)
			this.delay = espera;
	}
	
	public void execute() throws CommandException {
		for(OpcWriteCommand command : this.queue){
			command.execute();
			waitDelay();
		}
	}
	
	public void waitDelay(){
		try {
			wait(delay);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	

	

}
