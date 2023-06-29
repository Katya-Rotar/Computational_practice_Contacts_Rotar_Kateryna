package data.json;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class LocalDateConverter implements JsonSerializer<LocalDate>, JsonDeserializer<LocalDate>{
    @Override
    public JsonElement serialize(LocalDate src, Type typeOfSrc, JsonSerializationContext context) {
        return new JsonPrimitive(String.valueOf(src));
    }

    @Override
    public LocalDate deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
        String dataString = json.getAsString();
        return LocalDate.parse(dataString);
    }
}