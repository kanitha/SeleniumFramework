package org.selenium.pom.utils;

import java.io.IOException;
import java.io.InputStream;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonUtils {
	
	public static <T> T deserializeJson(String dataSourceFileName, Class<T> T) throws IOException {
		InputStream inputStream = JacksonUtils.class.getClassLoader().getResourceAsStream(dataSourceFileName);
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(inputStream, T);
	}
	
}
