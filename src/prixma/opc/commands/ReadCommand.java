package prixma.opc.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prixma.opc.communication.OpcClient;
import prixma.opc.communication.OpcException;
import prixma.opc.communication.OpcReader;

public class ReadCommand<T> implements OpcReadCommand<T> {
	
	private static final Logger Log = LoggerFactory.getLogger(ReadCommand.class);
	
	private String item;
	
	private T defaultValue;
	
	public ReadCommand(String item, T defaultValue){
		
		this.item = item;
		this.defaultValue = defaultValue;
		
	}
	
	public ReadCommand(String tag){
		
		this.item = tag;
		
	}
	
	public T execute(){
		
		OpcReader reader;
		
		try {
			
			reader = OpcClient.getReader();
			
			T value = (T) reader.read(item);
			
			Log.debug(String.format("EXECUTE COMMAND READ %s = %s", item, value));
			
			return value;
		
		} catch (OpcException e) {
			
			Log.error(String.format("READ COMMAND ERROR {%s} = %s", item, e.toString()));
			
			if (defaultValue != null) 
				return defaultValue;
			else
				throw new CommandException(e);
			
		}
	}

}
