package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

import org.json.JSONException;
import com.google.gson.*;
import com.google.gson.stream.*;


public class escribe_json {
	public static String nameRead;
	public static void escribe_json(String nick, String password) throws JSONException {
		Gson gson = new Gson();
		//Con esto leo del fichero línea a línea 
		String fichero = "";
		try (BufferedReader br = new BufferedReader(new FileReader("datos.json"))) {
		    String linea;
		    Usuario usuario = new Usuario();
		   
		    //mientras que siga habiendo información
		    while ((linea = br.readLine()) != null) {
		        fichero += linea;
		        //si el fichero ya esta en el JSON
		       
		        //Una vez tenemos el objeto nuevo con el nick y el password lo añadimos al JSON
		       
		        
		    }
		    Properties properties = gson.fromJson(fichero, Properties.class);
		    if (nick == properties.get("nick"))
			{
				System.out.println("ya existe este usurio");
			}
			else {
				try {
			         JsonParser parser = new JsonParser();
			         Object obj = parser.parse(new FileReader("/Users/guillermojimenez/eclipse-workspace/servidor/Paquete de fuentes/server/datos.json"));
			         JsonObject jsonObject = (JsonObject) obj;
			         System.out.println("The values of employee1.json file:\n" + jsonObject);
			         JsonArray msg = (JsonArray) jsonObject.get("usuarios");
			         Iterator<JsonElement> iterator = msg.iterator();
			         while(iterator.hasNext()) {
			            nameRead = iterator.next().toString();
			            System.out.println(nameRead);
			         }
			         Usuario user = new Usuario();
			    //     user.setNick();
			        // Gson gson = new Gson();
			         String json = gson.toJson(user);

			         FileWriter file = new FileWriter("/Users/guillermojimenez/eclipse-workspace/servidor/Paquete de fuentes/server/datos.json", false);
			         JsonWriter jw = new JsonWriter(file);
			         iterator = msg.iterator();
			         Usuarios usuarios = new Usuarios();
			         while(iterator.hasNext()) {
			            usuarios.addUsuario(gson.fromJson(iterator.next().toString(), Usuario.class));
			         }
			         usuarios.addUsuario(user);
			         gson.toJson(usuarios, Usuarios.class, jw);
			        
			         file.close();
			         System.out.println("data added to an existing employee1.json file successfully");
			      } catch(Exception e) {
			         e.printStackTrace();
			      }
			}
		 
		} catch (FileNotFoundException ex) {
		    System.out.println(ex.getMessage());
		} catch (IOException ex) {
		    System.out.println(ex.getMessage());
		}
		
		
		
		
		
		
	/*	JSONArray list = new JSONArray();
		list.add("chechu");
		list.add("k ase tio");
		
		obj.put("CitasCelebres", list);
		*/
		
		
		//System.out.println(obj);
	}
	
	public static void main (String args[]) throws JSONException {
		escribe_json(args[0], args[1]);
	}
}
