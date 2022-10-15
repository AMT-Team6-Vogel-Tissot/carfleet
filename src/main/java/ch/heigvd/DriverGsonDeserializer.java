package ch.heigvd;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DriverGsonDeserializer implements JsonDeserializer<Driver> {

    @Override
    public Driver deserialize(JsonElement json, Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        if(jsonObject.size() == 0){
            throw new JsonParseException("Json file is empty !");
        }

        if(!jsonObject.has("data")){
            throw new JsonParseException("Bad structure");
        }

        JsonObject items = jsonObject.get("data").getAsJsonObject()
                                     .get("boards").getAsJsonArray()
                                     .get(0).getAsJsonObject()
                                     .get("items").getAsJsonArray()
                                     .get(0).getAsJsonObject();

        JsonObject subItems = items.get("subitems").getAsJsonArray()
                                   .get(0).getAsJsonObject();

        if(!items.has("id") || !items.has("name") || !subItems.has("name")){
            throw new JsonParseException("one of the required field is missing !");
        }

        if(!subItems.has("column_values")){
            throw new JsonParseException("column_values is missing !");
        }

        JsonArray column_values = subItems.get("column_values").getAsJsonArray();

        JsonElement id = items.get("id");
        JsonElement licensePlate = items.get("name");
        JsonElement responsable = subItems.get("name");

        ArrayList<Values> cv = new ArrayList<>();
        for (JsonElement j : column_values) {
            cv.add(new Values(j.getAsJsonObject().get("title").getAsString(), j.getAsJsonObject().get("text").getAsString()));
        }

        return new Driver(id.getAsString(), licensePlate.getAsString(), responsable.getAsString(), cv);
    }

}
