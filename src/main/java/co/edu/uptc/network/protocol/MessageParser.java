package co.edu.uptc.network.protocol;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class MessageParser {

    private static final Gson GSON = new Gson();

    private MessageParser() {
    }

    public static String toJson(Object obj) {
        return GSON.toJson(obj);
    }

    public static <T> T fromJson(String json, Class<T> clazz) {
        return GSON.fromJson(json, clazz);
    }

    public static String getType(String json) {
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        return obj.get("type").getAsString();
    }

    public static String getString(String json, String field) {
        JsonObject obj = JsonParser.parseString(json).getAsJsonObject();
        return obj.has(field) ? obj.get(field).getAsString() : null;
    }
}
