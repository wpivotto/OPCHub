package prixma.opc.communication;

public class OpcException extends RuntimeException{	   


	private static final long serialVersionUID = -7988384874805881435L;

	public OpcException() {
 		super();
 	}
 	
 	public OpcException(Throwable e) {
 		super(e);
 		Throwable root = getRootCause(e);
 		this.setStackTrace(root.getStackTrace());
 	}
 	
 	public OpcException(String msg) {
 		super(msg);
 	}
 	
 	public OpcException(String msg, Throwable e) {
 		
 		super(msg, e);
 		Throwable root = getRootCause(e);
 		this.setStackTrace(root.getStackTrace());
 	}
 	
 	private static Throwable getRootCause(Throwable t) {
 		
 		Throwable root = t.getCause();
 		
 		if (root == null) return t;
 		
 		while(root.getCause() != null) {
 			
 			root = root.getCause();
 		}
 		
 		return root;
 	
 	}	
 	
 	
 	
 	
}