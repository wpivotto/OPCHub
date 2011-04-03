package prixma.opc.communication;



public interface OpcReader {
	
	public String read(String address) throws OpcException;
	
	public Boolean isQuality(String address) throws OpcException;

}
