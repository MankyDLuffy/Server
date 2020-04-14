package server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class lee_json {
	public static void main(String args[]) throws java.io.IOException {
		JSONParser parser = new JSONParser();
		try {
			
			Object obj = null;
			try {
				obj = parser.parse(new FileReader("/Users/guillermojimenez/eclipse-workspace/servidor/datos.json"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String blog = (String) jsonObject.get("Blog");
			System.out.println(blog);
			
			String temas = (String) jsonObject.get("Temas");
			System.out.println(temas);
			
			long inicio = (Long) jsonObject.get("Inicio");
			System.out.println(inicio);
			
			JSONObject innerObject = (JSONObject) jsonObject.get("Posts");
			System.out.println(innerObject.toJSONString());
			
			JSONArray tags = (JSONArray) jsonObject.get("Tags");
			@SuppressWarnings("unchecked")
			Iterator<String> iterator = tags.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next());
			}
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();		
		}
	}

}
