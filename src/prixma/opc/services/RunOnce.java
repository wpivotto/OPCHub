package prixma.opc.services;


public class RunOnce implements RunStrategy {

	private Service service;
	
	
	public RunOnce(Service service) {
		this.service = service;
	}


	public boolean shouldExecute() {
		if(service == null)
			return false;
		return service.getExecutions() == 0;
	}
	
	
	public boolean shouldContinue() {
		return service.getExecutions() < 1;
	}
	

}
