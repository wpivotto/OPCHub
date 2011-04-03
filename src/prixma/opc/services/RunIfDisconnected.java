package prixma.opc.services;

import prixma.opc.communication.ConnectionListener;
import prixma.opc.communication.OpcClient;




/**
 * Libera execução do serviço somente se conexão OPC estiver inativa 
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 * @version RunIfDisconnected.java, v 1.0 17/02/2009 21:48:37
 */

public class RunIfDisconnected implements RunStrategy, ConnectionListener {

	private boolean test = true;
	
	public RunIfDisconnected(){
		OpcClient.connection().addConnectionStateListener(this);
	}
	
	/** Condição verificada antes da execução do serviço
	 * @return Executa sempre que desconectado
	*/
	public boolean shouldExecute() {
		return test;
	}
	
	/** Condição verificada antes da execução do serviço
	 * @return Sempre executar novamente caso permaneça desconectado
	*/
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
