package prixma.opc.services;

/**
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 * Contrato para controlar a execucao de um servico;
 */

public interface RunStrategy {
	
	// Condicao verificada antes da execucao do servico
	public boolean shouldExecute();
	
	// Condicao verificada apos a execucao do servico
	public boolean shouldContinue();
	

}
