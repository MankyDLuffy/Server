package server;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class Login {
	private Usuario usuario;
	public void main(String args[]) {
		
		JSONParser parser = new JSONParser();
		try {
			Object obj = null;
			try {
				obj = parser.parse(new FileReader("/Users/guillermojimenez/eclipse-workspace/servidor/datos.json"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			JSONObject jsonObject = (JSONObject) obj;
			
			String nick = (String) jsonObject.get("nick");
			usuario.setNick(nick);
			
			String password = (String) jsonObject.get("password"); 
			usuario.setPassword(password); 
			
			
		} catch (FileNotFoundException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();		
		}
	}
}
