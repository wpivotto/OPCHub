
package prixma.opc.helpers;


/**
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 */
public final class Configs {
	
	private static ResourceLoader loader = new ResourceLoader("/opc.properties");
	
	public String findValue(String configKey){
		return loader.getValue(configKey);
	}
	
	public static String getValue(String configKey){
		 return loader.getValue(configKey);
	 }
	
	
	public static int getIntValue(String configKey){
		 return Integer.parseInt(loader.getValue(configKey));
	}
	
	public static boolean getBoolValue(String configKey){
		 return "true".equalsIgnoreCase(loader.getValue(configKey));
	}	
	
	
}
