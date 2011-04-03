package prixma.opc.services;

import prixma.opc.communication.ConnectionListener;
import prixma.opc.communication.OpcClient;


/**
 * Libera execucao do servico somente se conexao OPC estiver ativa 
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 * @version RunIfConnected.java, v 1.0 17/02/2009 21:47:48
 */

public class RunIfConnected implements RunStrategy, ConnectionListener {

	private boolean test;
	
	public RunIfConnected(){
		OpcClient.connection().addConnectionStateListener(this);
	}
	
	/** Condicao verificada antes da execucao do servico
	 * @return Executa sempre que conectado
	*/
	public boolean shouldExecute() {
		return test;
	}
	
	/** Condicao verificada apos execucao do servico
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
