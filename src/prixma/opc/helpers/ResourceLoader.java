/**
 * 
 */
package prixma.opc.helpers;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 * @version ConfigLocator.java, v 1.0 17/02/2009 15:44:58
 */
public class ResourceLoader {

	private Properties configs;
	private String fileName;
	
	public ResourceLoader(String fileName){
		
		this.fileName =  fileName;
		
		try {
			configs = new Properties();
			configs.load(this.getClass().getResourceAsStream(fileName));
		} catch (FileNotFoundException e) {
			 throw new RuntimeException("Arquivo "+this.fileName+" não encontrado");
		} catch (IOException e) {
			throw new RuntimeException("Erro de leitura no arquivo "+this.fileName+" : "+e.getMessage());
		}
		

	}


	 public String getValue(String configKey){
		 if(!configs.containsKey(configKey))
			 throw new IllegalArgumentException("Valor com a chave "+configKey+" não encontrado no arquivo "+fileName);
		 return configs.getProperty(configKey);
	 }
	 
	 public void setValue(String configKey, String value){
		 if(!configs.containsKey(configKey))
			 throw new IllegalArgumentException("Valor com a chave "+configKey+" não encontrado no arquivo "+fileName);
		 configs.setProperty(configKey, value);
		 
	 }
	 
	 

	 
	 
}
