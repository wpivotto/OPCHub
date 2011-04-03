package prixma.opc.commands;

import javafish.clients.opc.variant.Variant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prixma.opc.communication.OpcClient;
import prixma.opc.communication.OpcWriter;


public class ToggleCommand implements OpcWriteCommand {

	private static final Logger Log = LoggerFactory.getLogger(ToggleCommand.class);
	
	private String item;
	
	public ToggleCommand(String item){
		this.item = item;
	}
	
	public Variant swapCurrentValue(){
		Integer currentValue = new ReadCommand<Integer>(item).execute();
		return new Variant(currentValue ^ 1); 
	}

	public void execute(){
		
		OpcWriter writer;
		
		try {
			
			writer = OpcClient.getWriter();
	
			writer.write(item,  swapCurrentValue());
			
			Log.debug(String.format("EXECUTE COMMAND TOGGLE %s", item));
		
		} catch (Exception e) {
			Log.error("TOGGLE COMMAND ERROR "+this.item);
			throw new CommandException(e);
		}
	}
}
