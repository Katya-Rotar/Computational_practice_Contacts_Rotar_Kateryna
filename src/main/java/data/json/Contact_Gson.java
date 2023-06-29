package data.json;

import data.Contact_Information;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Contact_Gson {

    private final JsonConverter jsonConverter;

    public Contact_Gson(JsonConverter jsonConverter) {
        this.jsonConverter = jsonConverter;
    }
    public List<Contact_Information> readContact(){
        try {
            Path path = Paths.get("contact.json");
            String s = Files.readString(path);
            return jsonConverter.fromJson(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void writeContact(List<Contact_Information> informationList){
        try {
            Path path = Paths.get("contact.json");
            String jsonContact = jsonConverter.toJson(informationList);
            Files.writeString(path, jsonContact);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}