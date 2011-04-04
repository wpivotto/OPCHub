
package prixma.opc.helpers;


/**
 * @author William Pivotto <a href="mailto:william@prixma.com.br">email</a>
 */
public final class Configs {
	
	private static ResourceLoader loader = new ResourceLoader("/opc.properties");
	
	public static String get(String key){
		 return loader.getValue(key);
	 }
	
	
	public static int getInt(String key){
		 return Integer.parseInt(loader.getValue(key));
	}
	
	public static boolean supports(String feature){
		 return Boolean.parseBoolean(loader.getValue(feature));
	}	
	
	public static boolean has(String key){
		 return loader.has(key);
	}	
	
}
