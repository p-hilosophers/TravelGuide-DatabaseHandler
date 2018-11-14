package FlickrJSON;

import com.google.gson.JsonObject;

public class JsonParser {

    private JsonObject jsonObject;

    public JsonParser(JsonObject jsonObject) {
        this.jsonObject = jsonObject;
    }

    public JsonObject getJsonObject() {
        return jsonObject;
    }
}
