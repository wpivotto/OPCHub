package prixma.opc.services;


/**
 * Libera execução do serviço permanentemente 
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 * @version RunLikeADaemon.java, v 1.0 17/02/2009 21:49:09
 */

public class RunLikeADaemon implements RunStrategy{
	
	
	/** Condição verificada antes da execução do serviço
	 * @return Executa sempre
	*/
	public boolean shouldExecute() {
		return true;
	}
	
	/** Condição verificada antes da execução do serviço
	 * @return Sempre executa novamente
	*/
	public boolean shouldContinue() {
		return true;
	}

	public void setService(Service servico) {}
	
	
}
