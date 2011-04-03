package prixma.opc.services;

import prixma.opc.communication.OpcClient;

public class AutoReconnectMonitor extends Service {

	private OpcClient client;
   
    public AutoReconnectMonitor (OpcClient client) {
    	 this.runStrategy = new RunIfDisconnected();
    	 this.client = client;
    	
    }
    
	public void execute() {
		
		if(!client.isConnected()){
			client.reconnect();
		}
	
	}


}
