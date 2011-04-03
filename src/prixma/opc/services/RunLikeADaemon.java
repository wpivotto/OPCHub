package prixma.opc.services;


public class RunLikeADaemon implements RunStrategy{
	
	
	public boolean shouldExecute() {
		return true;
	}
	
	public boolean shouldContinue() {
		return true;
	}

	public void setService(Service servico) {}
	
	
}
