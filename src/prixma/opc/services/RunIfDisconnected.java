package prixma.opc.services;

import prixma.opc.communication.ConnectionListener;
import prixma.opc.communication.OpcClient;



public class RunIfDisconnected implements RunStrategy, ConnectionListener {

	private boolean test = true;
	
	public RunIfDisconnected(){
		OpcClient.connection().addConnectionStateListener(this);
	}
	

	public boolean shouldExecute() {
		return test;
	}
	
	public boolean shouldContinue() {
		return test;
	}

	public void setService(Service servico) {}


	public void connected() {
		test = false;
	}

	public void disconnected() {
		test = true;
	}

	

}
