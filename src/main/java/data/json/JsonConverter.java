package data.json;

import data.Contact_Information;

import java.util.List;

public interface JsonConverter {
    String toJson(List<Contact_Information> list);
    List<Contact_Information> fromJson (String contacts);
}