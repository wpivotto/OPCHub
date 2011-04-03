package prixma.opc.commands;

import javafish.clients.opc.variant.Variant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prixma.opc.communication.OpcClient;
import prixma.opc.communication.OpcWriter;

public class WriteCommand implements OpcWriteCommand {

	private static final Logger Log = LoggerFactory.getLogger(WriteCommand.class);
	
	protected String item;
	protected Variant value;
	
	public WriteCommand(String item, Variant value){
		this.item = item;
		this.value = value;
	}

	public WriteCommand(String tag, String value){
		this(tag, new Variant(value));
	}
	
	public WriteCommand(String tag, Number value){
		this(tag, new Variant(value.doubleValue()));
	}
	
	
	public void execute(){
		
		OpcWriter writer;
		
		try {
			
			writer = OpcClient.getWriter();
			
			writer.write(item, value);
			
			Log.debug(String.format("EXECUTE COMMAND WRITE %s = %s", item, value));
		
		} catch (Exception e) {
			Log.error("SET COMMAND ERROR", e);
			throw new CommandException(e);
		}
	}
	
}


