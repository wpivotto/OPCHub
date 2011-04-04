/**
 * 
 */
package prixma.opc.helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ResourceLoader {

	private Properties properties;
	private String fileName;
	
	public ResourceLoader(String fileName){
		
		this.fileName =  fileName;
		
		try {
			properties = new Properties();
			properties.load(this.getClass().getResourceAsStream(fileName));
		} catch (FileNotFoundException e) {
			 throw new RuntimeException("Arquivo "+this.fileName+" não encontrado");
		} catch (IOException e) {
			throw new RuntimeException("Erro de leitura no arquivo "+this.fileName+" : "+e.getMessage());
		}
		

	}


	 public String getValue(String key){
		 if(!has(key))
			 throw new IllegalArgumentException("Valor com a chave "+key+" nao encontrado no arquivo "+fileName);
		 return properties.getProperty(key);
	 }
	 
	 public void setValue(String key, String value){
		 if(!has(key))
			 throw new IllegalArgumentException("Valor com a chave "+key+" nao encontrado no arquivo "+fileName);
		 properties.setProperty(key, value);
		 
	 }
	 
	 public boolean has(String key){
		 return properties.containsKey(key);
	 }
	 
	 
	public Iterable<String> getKeys() {
		return (Iterable<String>) properties.stringPropertyNames();
	}

	 
	 
}
