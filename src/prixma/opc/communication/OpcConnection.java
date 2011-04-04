package prixma.opc.communication;

import javafish.clients.opc.JEasyOpc;
import javafish.clients.opc.JOpc;
import javafish.clients.opc.browser.JOpcBrowser;
import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.exception.ConnectivityException;
import javafish.clients.opc.exception.HostException;
import javafish.clients.opc.exception.NotFoundServersException;
import javafish.clients.opc.exception.UnableAddGroupException;
import javafish.clients.opc.exception.UnableAddItemException;
import javafish.clients.opc.exception.UnableRemoveGroupException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prixma.opc.helpers.Configs;

public class OpcConnection {
	
	private static final Logger Log = LoggerFactory.getLogger(OpcConnection.class);
	
	private JEasyOpc connection; 
	private String host;
	private String server;
	
	public OpcConnection(String host, String server) {
		this.host = host;
		this.server = server;
	}

	public OpcConnection() {
		this.host = Configs.get("opc.server.ip");  
		this.server = Configs.get("opc.server.name");
	}
	
	public void connect(){
		
		try {
			JOpc.coInitialize();
			connection = new JEasyOpc(host, server, "");
			connection.connect();
			Log.info("START COMMUNICATION WITH OPC SERVER " + server + " ON HOST " + host);
		} catch (ConnectivityException e) {
			throw new OpcException("Erro ao estabelecer conexão com servidor OPC ", e);
		}

	
	}
	
	public void disconnect(){
		
		if(connection != null) 
			connection.terminate();
		
		JOpc.coUninitialize();		
		
		connection = null;
		Log.info("CLOSE COMMUNICATION WITH OPC SERVER " + server + " ON HOST " + host);
		
	}
	
	
	
	public JOpc getConnection() {
		if(connection == null)
			throw new NotConnectedException("Erro - conexão com o servidor Opc é nula");
		return this.connection;
	}
	
	public boolean ping(){
		if(this.connection == null) return false;
		return this.connection.ping();
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getServer() {
		return server;
	}

	public void setServer(String server) {
		this.server = server;
	}
	
	public void registerGroups() throws UnableAddGroupException, UnableAddItemException{
		getConnection().registerGroups();
	}

	
	public void unregisterGroups() throws UnableRemoveGroupException{
		getConnection().unregisterGroups();
	}
	

	public OpcGroup[] getGroups() {
		return getConnection().getGroupsAsArray();
	}

	public void addGroup(OpcGroup group) {
		if(containsGroup(group))
			getConnection().removeGroup(group);
		getConnection().addGroup(group);
	}
	
	private boolean containsGroup(OpcGroup group) {
		for (OpcGroup g : getConnection().getGroupsAsArray()){
			if(g.equals(group))
				return true;
		}
		return false;
	}

	public String[] findAllServers(String host){
		
		JOpcBrowser.coInitialize();
		String[] servers = null;

		try {
			servers = JOpcBrowser.getOpcServers(host);
			
			return servers;
		}
		catch (HostException e) {
			e.printStackTrace();
		}
		catch (NotFoundServersException e) {
			e.printStackTrace();
		}
		
		JOpcBrowser.coUninitialize();
		return servers;

	}


	
}
