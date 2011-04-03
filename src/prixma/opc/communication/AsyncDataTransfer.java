package prixma.opc.communication;

import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.variant.Variant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AsyncDataTransfer implements OpcDataTransfer {

	private static final Logger Log = LoggerFactory.getLogger(AsyncDataTransfer.class);
	
	private OpcConnection connection;
	private OpcDatabase database;

	public AsyncDataTransfer(OpcConnection connection, OpcDatabase database){
		this.connection = connection;
		this.database = database;
	}

	private OpcItem getItem(String address){

		OpcItem item = null;

		if(!database.contains(address)){
			Log.warn("ITEM " + address + " NOT FOUND ");
			database.add(address);
		}

		item = database.find(address);

		return item;

	}

	public String read(String address) {
		
		return null;

	}


	public void write(String address, Variant valor) {

		
	}


	private OpcItem readItem(String address) throws OpcException {

		return null;
		
	}

	@Override
	public Boolean isQuality(String address) throws OpcException {

		OpcItem item = readItem(address);

		return new Boolean(item.isQuality());
	}


}


