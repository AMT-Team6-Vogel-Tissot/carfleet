package ch.heigvd;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class DriverGsonDeserializer implements JsonDeserializer<Driver> {

    @Override
    public Driver deserialize(JsonElement json, Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        JsonObject items = jsonObject.get("data").getAsJsonObject()
                                     .get("boards").getAsJsonArray()
                                     .get(0).getAsJsonObject()
                                     .get("items").getAsJsonArray()
                                     .get(0).getAsJsonObject();

        JsonElement id = items.get("id");
        JsonElement licensePlate = items.get("name");
        JsonObject subItems = items.get("subitems").getAsJsonArray()
                                   .get(0).getAsJsonObject();

        JsonElement responsable = subItems.get("name");

        JsonArray column_values = subItems.get("column_values").getAsJsonArray();

        ArrayList<Values> cv = new ArrayList<>();

        for (JsonElement j : column_values) {
            cv.add(new Values(j.getAsJsonObject().get("title").getAsString(), j.getAsJsonObject().get("text").getAsString()));
        }

        return new Driver(id.getAsString(), licensePlate.getAsString(), responsable.getAsString(), cv);
    }

}
