package prixma.opc.communication;

/**
 * 
 * Permite espeficicar diferentes maneiras de se registrar um item no servidor
 * 
 * Ex: 
 * DatabaseItemRegister - Registra tags vindos de um banco de dados
 * CsvItemRegister - Registra tags vindos de um arquivo csv...
 * 
 * @author william
 */

public interface OpcItemRegister {
	
	void registerItems(OpcDatabase database);

}
