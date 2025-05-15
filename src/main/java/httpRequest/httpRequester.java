package httpRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URI;


/* Esta clase se encarga de realizar efectivamente el pedido de feed al servidor de noticias
 * Leer sobre como hacer una http request en java
 * https://www.baeldung.com/java-http-request
 * */

public class httpRequester {
	
	public String getFeedRss(String urlFeed){
		String feedRssXml = null;
		try { 
			// Convertimos el string urlFeed en una URL //
			URI uri = new URI(urlFeed);
			URL url = uri.toURL();
			// Generamos la conexion y peticion //
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			// Con esto leemos la respuesta//
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine = null;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
    			content.append(inputLine);
			}
			// Cerramos el lector del buffer //
			in.close();
			// Cerramos la conexion //
			conn.disconnect();
			// Asignamos la respuesta XML al string feedRssXml //
			feedRssXml = content.toString();
		} catch (Exception e){
			System.err.println("Error al obtener el feed: " + e.getMessage());
		}
		return feedRssXml;
	}

	public String getFeedReedit(String urlFeed) {
		String feedReeditJson = null;
		try { 
			// Convertimos el string urlFeed en una URL //
			URI uri = new URI(urlFeed);
			URL url = uri.toURL();
			// Generamos la conexion y peticion //
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0");
			// Con esto leemos la respuesta//
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine = null;
			StringBuffer content = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
    			content.append(inputLine);
			}
			// Cerramos el lector del buffer //
			in.close();
			// Cerramos la conexion //
			conn.disconnect();
			// Asignamos la respuesta XML al string feedReeditJson //
			feedReeditJson = content.toString();
		} catch (Exception e){
			System.err.println("Error al obtener el feed: " + e.getMessage());
		}
		return feedReeditJson;
	}

}
