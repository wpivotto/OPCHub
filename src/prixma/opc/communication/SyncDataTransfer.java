package prixma.opc.communication;

import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.ComponentNotFoundException;
import javafish.clients.opc.exception.SynchReadException;
import javafish.clients.opc.exception.SynchWriteException;
import javafish.clients.opc.variant.Variant;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SyncDataTransfer implements OpcDataTransfer {

	private static final Logger Log = LoggerFactory.getLogger(SyncDataTransfer.class);
	
	private OpcConnection connection;
	private OpcDatabase database;

	public SyncDataTransfer(OpcConnection connection, OpcDatabase database){
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


		OpcItem item = readItem(address);

		if(!item.isQuality())
			Log.warn(String.format("OPC BAD QUALITY FLAG FOUND, ITEM %s DOES NOT CONTAIN AN ACCURATE VALUE", item.getItemName()));

		return item.getValue().toString();


	}


	public void write(String address, Variant valor) {

		OpcItem item = null;

		try {

			item = getItem(address);

			item.setValue(valor);

			connection.getConnection().synchWriteItem(database.getGroup(), item);

		} catch (ComponentNotFoundException e) {
			throw new OpcException("Item "+item.getItemName()+" não encontrado no servidor OPC");
		} catch (SynchWriteException e) {
			throw new OpcException("Erro de escrita do item "+item.getItemName());
		}	
	}


	private OpcItem readItem(String address) throws OpcException {

		OpcItem item = null;

		try {

			item = getItem(address);

			return connection.getConnection().synchReadItem(database.getGroup(), item);

		} catch (ComponentNotFoundException e) {
			throw new OpcException("Item "+item.getItemName()+" não encontrado no servidor OPC");
		} catch (SynchReadException e) {
			throw new OpcException("Erro de leitura do item "+item.getItemName());
		}
	}

	@Override
	public Boolean isQuality(String address) throws OpcException {

		OpcItem item = readItem(address);

		return new Boolean(item.isQuality());
	}


}


