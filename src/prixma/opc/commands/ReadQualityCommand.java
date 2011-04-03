package prixma.opc.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prixma.opc.communication.OpcClient;
import prixma.opc.communication.OpcException;
import prixma.opc.communication.OpcReader;

public class ReadQualityCommand implements OpcReadCommand<Boolean> {
	
	private static final Logger Log = LoggerFactory.getLogger(ReadQualityCommand.class);
	
	private String item;
	
	public ReadQualityCommand(String item){
		this.item = item;
	}
	
	
	public Boolean execute(){
		
		OpcReader reader;
		
		try {
			
			reader = OpcClient.getReader();
			
			Boolean value = reader.isQuality(item);
			
			Log.debug(String.format("EXECUTE COMMAND READ QUALITY %s = %s", item, value));
			
			return value;
		
		} catch (OpcException e) {
			Log.error(String.format("READ QUALITY COMMAND ERROR {%s} = %s", item, e.toString()));
			//throw new CommandException(e);
			return Boolean.FALSE;
		}
	}

}
