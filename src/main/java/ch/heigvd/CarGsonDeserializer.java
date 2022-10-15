package ch.heigvd;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class CarGsonDeserializer implements JsonDeserializer<Car> {

    @Override
    public Car deserialize(JsonElement json, Type type,
                              JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {

        JsonObject jsonObject = json.getAsJsonObject();

        JsonObject items = jsonObject.get("data").getAsJsonObject()
                                     .get("boards").getAsJsonArray()
                                     .get(0).getAsJsonObject()
                                     .get("items").getAsJsonArray()
                                     .get(0).getAsJsonObject();

        JsonElement id = items.get("id");
        JsonElement licensePlate = items.get("name");

        JsonArray column_values = items.get("column_values").getAsJsonArray();

        ArrayList<Values> cv = new ArrayList<>();

        for (JsonElement j : column_values) {
            cv.add(new Values(j.getAsJsonObject().get("title").getAsString(), j.getAsJsonObject().get("text").getAsString()));
        }

        return new Car(id.getAsString(), licensePlate.getAsString(), cv);
    }
}
