package data.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.Contact_Information;

import java.util.List;

public class GsonConverter implements JsonConverter{
    private final Gson gson;

    public GsonConverter(Gson gson) {
        this.gson = gson;
    }

    @Override
    public String toJson(List<Contact_Information> list) {
        return gson.toJson(list);
    }

    @Override
    public List<Contact_Information> fromJson(String contacts) {
        TypeToken<List<Contact_Information>> typeToken = new TypeToken<>(){};
        return gson.fromJson(contacts, typeToken);
    }
}
