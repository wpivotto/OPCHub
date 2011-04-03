package prixma.opc.services;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import prixma.opc.communication.ConnectionListener;
import prixma.opc.communication.OpcClient;


public class ConnectionMonitor extends Service {

	private Set<ConnectionListener> listeners = new CopyOnWriteArraySet<ConnectionListener>();
	private OpcClient client;
	
	public ConnectionMonitor(OpcClient client) {
		this.runStrategy = new RunLikeADaemon();
		this.client = client;
	}
	

	public void execute() {

		 if(client.isConnected())
			 notifyConnected();
		 else
			 notifyDisconnected();
		
	}
	
	public void notifyConnected() {
		
		for(ConnectionListener listener : listeners){
			listener.connected();
		}
		
	}
	
	public void notifyDisconnected() {
		
		for(ConnectionListener listener : listeners){
			listener.disconnected();
		}
		
	}
	
	
	public void addListener(ConnectionListener listener){
		this.listeners.add(listener);
	}
	
	public void removeListener(ConnectionListener listener){
		this.listeners.remove(listener);
	}

	

}
