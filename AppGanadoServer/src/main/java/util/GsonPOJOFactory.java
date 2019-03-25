package util;

import java.io.BufferedReader;

import com.google.gson.Gson;

public class GsonPOJOFactory {

	private static Gson gson;

	static {
		System.out.println("Initializing GSON Factory");
		gson = new Gson();
	}

	public static <T> T getPOJO(BufferedReader gsonElement, Class<T> entityReference) {// Generating a instance entity  using JSON string
		T entity = gson.fromJson(gsonElement, entityReference);
		System.out.println(entity);
		return entity;
	}

	public static <T> String getJson(T entity) {
		return gson.toJson(entity);
	}
}
