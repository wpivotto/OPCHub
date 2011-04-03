package prixma.opc.communication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prixma.opc.helpers.Configs;
import prixma.opc.services.AutoReconnectMonitor;
import prixma.opc.services.ConnectionMonitor;
import prixma.opc.services.Service;

public class OpcClient {
	
	private static final Logger Log = LoggerFactory.getLogger(OpcClient.class);
	
	private OpcConnection connection;
	private OpcDatabase database;
	private OpcDataTransfer syncProvider;
	private OpcDataTransfer asyncProvider;
	private Service connectionMonitor;
	private Service reconnectMonitor;
	
	private static final OpcClient client = new OpcClient();
	
	private OpcClient(){

		try {
			
			newConnection();
			startServices();
			
		}catch (Exception e) {
			Log.info("START OPC COMMUNICATION ERROR: "+e.getMessage());
			e.printStackTrace();
			stopServices();
			shutdown();
		}
	}
	
	
	private void newConnection(){
		
		connection = new OpcConnection();
		connection.connect();
		
	}
	
	public void register(OpcItemRegister register){
		
		database = new OpcDatabase(connection);
		register.registerItems(database);
		database.registerGroups();
		
		syncProvider = new SyncDataTransfer(connection, database);
		asyncProvider = new AsyncDataTransfer(connection, database);
		
	}

	public void startServices(){
		
		if(Configs.getBoolValue("opc.connection.monitor.enable"))
			enableConnectionMonitor(Configs.getIntValue("opc.connection.monitor.interval"));
		
		if(Configs.getBoolValue("opc.autoreconnection.enable"))
			enableAutoReconnectMonitor(Configs.getIntValue("opc.autoreconnection.interval"));

	}

	public static OpcClient connection() {
			return client;  
	}
	
	public OpcClient reconnect() {
		if(client != null){
			client.shutdown();
			client.newConnection();
		}
		return client;  
	}

	
	public static OpcReader getReader(){
		return client.syncProvider;
	}
	
	public static OpcWriter getWriter(){
		return client.syncProvider;
	}
	
	public static OpcReader getAsyncReader(){
		return client.asyncProvider;
	}
	
	public static OpcWriter getAsyncWriter(){
		return client.asyncProvider;
	}
	
	public boolean isConnected(){
		if(connection == null)
			return false;
		return connection.ping();
	}
	
	
	public void shutdown(){
		
		stopServices();
		
		if(database != null)
			database.unregisterAll();
		
		if(connection != null)
			connection.disconnect();
		
	}	
	

	public void addConnectionStateListener(ConnectionListener listener){
		if(connectionMonitor != null )
			((ConnectionMonitor) connectionMonitor).addListener(listener);
	}
	
	public void enableConnectionMonitor(int interval){
		if(connectionMonitor == null){
			connectionMonitor = new ConnectionMonitor(this)
								  		.withFrequency(interval)
								  		.withDelay(5)
								  		.enableDebug()
								  		.start();
		}
		
	}
	
	public void enableAutoReconnectMonitor(int interval){
		if(reconnectMonitor == null ){
			reconnectMonitor = new AutoReconnectMonitor(this)
								   .withFrequency(interval)
								   .withDelay(5)
								   .enableDebug();
		}

	}
	
	public void stopServices(){
		
		if(connectionMonitor != null )
			connectionMonitor.stop();
		
		if(reconnectMonitor != null )
			reconnectMonitor.stop();
		
	}
	

	

}
