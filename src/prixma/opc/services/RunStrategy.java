package prixma.opc.services;

/**
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 * @version RunStrategy.java, v 1.0 2009/02/16 14:26:00
 * Contrato que um objeto deve respeitar para controlar a execução de um serviço;
 */

public interface RunStrategy {
	
	/** Condição verificada antes da execução do serviço
	 * @return Serviço deve ser executado ou não
	*/
	public boolean shouldExecute();
	
	/** Condição verificada após a execução do serviço
	 * @return Serviço deve continuar sendo executado ou não
	*/
	public boolean shouldContinue();
	

}
