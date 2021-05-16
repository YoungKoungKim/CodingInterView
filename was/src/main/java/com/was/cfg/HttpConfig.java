package com.was.cfg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class HttpConfig {
	private static final String CONFIG_FILE_PATH = "src/main/config.json";
	private JSONObject jsonObject;

	public HttpConfig() {
		JSONParser parser = new JSONParser();
		try {
			Object obj = parser.parse(new FileReader(CONFIG_FILE_PATH));
			jsonObject = (JSONObject) obj;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Object> getConfigMap() throws IOException {
		return new ObjectMapper().readValue(jsonObject.toJSONString(), Map.class);
	}
}