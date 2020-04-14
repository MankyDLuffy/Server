package server;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONException;
import org.json.simple.parser.ParseException;

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;


public class Registro {
	public static String nameRead;
	public static void escribe_json(String nick, String password) throws JSONException, FileNotFoundException, IOException, ParseException {
		Gson gson = new Gson();
		//Con esto leo del fichero línea a línea 
		String fichero = "";
		try (BufferedReader br = new BufferedReader(new FileReader("/Users/guillermojimenez/eclipse-workspace/servidor/Paquete de fuentes/server/datos.json"))) {
		    String linea;
		
		    //mientras que siga habiendo información
		    while ((linea = br.readLine()) != null) {
		        fichero += linea;
		    }
		    if (fichero.contains(nick))
		    {
		    	System.out.println("Este usuario ya existe");
		    }
			else {
				 try {
			         JsonParser parser = new JsonParser();
			         Object obj = parser.parse(new FileReader("/Users/guillermojimenez/eclipse-workspace/servidor/Paquete de fuentes/server/datos.json"));
			         JsonObject jsonObject = (JsonObject) obj;
			         JsonArray msg = (JsonArray)jsonObject.get("usuarios");
			         Iterator<JsonElement> iterator = msg.iterator();
			         while(iterator.hasNext()) {
			            nameRead = iterator.next().toString();
			         }
			         Usuario usuario = new Usuario();
			         usuario.setNick(nick);
			         usuario.setPassword(password);

			         FileWriter file = new FileWriter("/Users/guillermojimenez/eclipse-workspace/servidor/Paquete de fuentes/server/datos.json", false);
			         JsonWriter jw = new JsonWriter(file);
			         iterator = msg.iterator();
			         Usuarios usuarios = new Usuarios();
			         while(iterator.hasNext()) {
			            usuarios.addUsuario(gson.fromJson(iterator.next().toString() + "\n", Usuario.class));
			         }
			         usuarios.addUsuario(usuario);
			         gson.toJson(usuarios, Usuarios.class, jw);
			         file.close();
			         System.out.println(usuario.getNick() + "registered successfully");
			      } catch(Exception e) {
			         e.printStackTrace();
			      }
			}
		}
	}
		
	
	
	public static void main (String args[]) throws JSONException, FileNotFoundException, IOException, ParseException {
		escribe_json(args[0], args[1]);
	}
}
