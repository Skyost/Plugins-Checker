package fr.skyost.checker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import fr.skyost.checker.frames.MainFrame;

public class PluginsChecker {
	
	public static final String version = "0.1";
	
	public static void main(String[] args) {
		new MainFrame();
	}
	
	public static final HashMap<String, String[]> searchProject(final String name) throws IOException, ParseException {
		final HashMap<String, String[]> results = new HashMap<String, String[]>();
		final URLConnection conn = new URL("https://api.curseforge.com/servermods/projects?search=" + URLEncoder.encode(name, "UTF-8")).openConnection();
		conn.addRequestProperty("User-Agent", "Skyost's Plugins Checker v" + version);
		final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		final String response = reader.readLine();
		JSONArray array = (JSONArray)JSONValue.parseWithException(response);
        if(array.size() > 0) {
    		JSONObject parser;
    		for(int i = 0; i != array.size(); i++) {
    			parser = (JSONObject)array.get(i);
    			results.put(String.valueOf(parser.get("name")), new String[]{String.valueOf(parser.get("id")), String.valueOf(parser.get("slug")), String.valueOf(parser.get("stage"))});
    		}
    		return results;
        }
        return null;
	}
	
	public static final String[] getProjectLastFileInformations(final String id) throws IOException, ParseException {
		final URLConnection conn = new URL("https://api.curseforge.com/servermods/files?projectIds=" + id).openConnection();
		conn.addRequestProperty("User-Agent", "Skyost's Plugins Checker v" + version);
		final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		final String response = reader.readLine();
		JSONArray array = (JSONArray)JSONValue.parseWithException(response);
        if(array.size() > 0) {
        	JSONObject latest = (JSONObject) array.get(array.size() - 1);
    		return new String[]{String.valueOf(latest.get("name")), String.valueOf(latest.get("releaseType")), String.valueOf(latest.get("gameVersion")), String.valueOf(latest.get("fileName")), String.valueOf(latest.get("downloadUrl"))};
        }
        return null;
	}

}
