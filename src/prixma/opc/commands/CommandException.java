package prixma.opc.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




public class CommandException extends RuntimeException {

	private static final long serialVersionUID = -372961799239874671L;
	private static final Logger Log = LoggerFactory.getLogger(CommandException.class);
   
	public CommandException(Throwable t) {  
    	super(t); 
    }   
    
    public CommandException(String msg, Throwable t) {   
        super(msg, t);
        t.setStackTrace(t.getStackTrace());
        Log.error(msg);
    } 
    
    public CommandException(String msg) {   
        super(msg);
    } 
      
 
    
	
}
