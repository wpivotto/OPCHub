package prixma.opc.services;

import prixma.opc.communication.ConnectionListener;
import prixma.opc.communication.OpcClient;


/**
 * Libera execução do serviço somente se conexão OPC estiver ativa 
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 * @version RunIfConnected.java, v 1.0 17/02/2009 21:47:48
 */

public class RunIfConnected implements RunStrategy, ConnectionListener {

	private boolean test;
	
	public RunIfConnected(){
		OpcClient.connection().addConnectionStateListener(this);
	}
	
	/** Condição verificada antes da execução do serviço
	 * @return Executa sempre que conectado
	*/
	public boolean shouldExecute() {
		return test;
	}
	
	/** Condição verificada antes da execução do serviço
	 * @return Sempre tenta executar novamente
	*/
	public boolean shouldContinue() {
		return true;
	}

	public void setService(Service servico) {}


	public void connected() {
		test = true;
	}

	public void disconnected() {
		test = false;
	}
	
}
