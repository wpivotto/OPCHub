package prixma.opc.communication;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javafish.clients.opc.component.OpcGroup;
import javafish.clients.opc.component.OpcItem;
import javafish.clients.opc.exception.UnableAddGroupException;
import javafish.clients.opc.exception.UnableAddItemException;
import javafish.clients.opc.exception.UnableRemoveGroupException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import prixma.opc.helpers.Configs;


public class OpcDatabase {

	private static final Logger Log = LoggerFactory.getLogger(OpcDatabase.class);
	
	/* todos os itens independentes de grupo */
	private HashMap<String, OpcItem> opcItems;
	private OpcGroup group;
	private OpcConnection connection; 

	public OpcDatabase(OpcConnection connection) {
		this.connection = connection;
		this.group = new OpcGroup(Configs.getValue("opc.tags.group"), true, Configs.getIntValue("opc.tags.refresh"), 0.0f);
	}

	public OpcGroup getGroup(){
		return this.group;
	}
	

	public OpcItem find(String tag) throws OpcException{

		if(opcItems == null){
			opcItems = group.getItemsAsMap();
		}

		if(opcItems.containsKey(tag)){
			return opcItems.get(tag);
		}
		else 
			throw new OpcException("A tag "+ tag +" não foi encontrada na lista de tags de leitura");
	}
	

	public List<OpcItem> itens(){
		
		return group.getListItems();
		
	}



	public boolean hasGroup(OpcGroup grupo){

		for(OpcGroup g : connection.getGroups()){
			if(g.equals(grupo))
				return true;
		}

		return false;
	}


	public void registerGroups(){
		try {
			connection.registerGroups();
		} catch (UnableAddGroupException e) {
			throw new OpcException("Erro ao adicionar grupo OPC");
		} catch (UnableAddItemException e) {
			throw new OpcException("Algum item da lista de tags não existe, verifique endereçamento ");
		}
	}

	public void unregisterAll(){
			try {
				connection.unregisterGroups();
				clear();
			} catch (UnableRemoveGroupException e) {
				throw new OpcException("Erro ao atualizar grupo OPC");
			}
		
	}

	private void register(String itemName, String groupName) {
		
		if(opcItems == null){
			opcItems = group.getItemsAsMap();
		}
	
		if(!contains(itemName)){
			
			OpcItem item = new OpcItem(itemName, true, "");
			group.addItem(item);
			
		}	

	}
	
	public void add(Collection<String> items, String group){
		for(String item : items){
			register(item, group);
		}
		update();
	}
	
	public void add(String group, String ...items){
		for(String item : items){
			register(item, group);
		}
		update();
	}
	
	public void add(String tag, String group){
		register(tag, group);
		update();
	}


	public void update() {
		
		try {
			unregisterAll();
			connection.addGroup(group);
			connection.registerGroups();
			opcItems = group.getItemsAsMap();
			Log.info("REGISTER ITEMS " + opcItems.keySet() + " IN OPC GROUP " + group.getGroupName());
		} catch (UnableAddGroupException e) {
			throw new OpcException("Erro ao adicionar grupo OPC");
		} catch (UnableAddItemException e) {
			throw new OpcException("Algum item da lista de tags não existe, verifique endereçamento ");
		} 

	}
	


	public void clear(){
		if(this.opcItems != null) 
			this.opcItems.clear();
	}


	public boolean contains(String item){
		return opcItems != null && opcItems.containsKey(item);
	}

}
