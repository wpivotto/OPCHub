package prixma.opc.communication;

import javafish.clients.opc.variant.Variant;


public interface OpcWriter {

	public void write(String address, Variant valor) throws OpcException;
	
}
