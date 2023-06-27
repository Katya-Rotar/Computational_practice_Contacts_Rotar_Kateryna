package data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CRUD_operations_in_contacts implements List_of_commands {
    List<Contact_Information> contact = new ArrayList<>();
    @Override
    public void readContact() {
        if(!contact.isEmpty()){
            for (Contact_Information information : contact) {
                System.out.println(information);
            }
        }else {
            System.out.println("Контакти відсутні");
        }
    }

    @Override
    public void sortContact(String sort) {
        switch (sort) {
            case "1" -> contact.sort(Comparator.comparing(Contact_Information::name));
            case "2" -> contact.sort(Comparator.comparing(Contact_Information::lastname));
            case "3" -> contact.sort(Comparator.comparing(Contact_Information::date_of_birth));
            default -> System.out.println("Такої дії не існує");
        }
    }

    @Override
    public void addContact(Contact_Information contact_information) {
        contact.add(contact_information);
    }

    @Override
    public void updateContact(String new_name, String new_lastname, int new_phone_number, String new_email,
                              LocalDate new_date_of_birth, int id) {
        LocalDate date_of_comparison = LocalDate.of(0,1,1);
        for (Contact_Information contact_information : contact) {
            if(contact.indexOf(contact_information) == id) {
                if (new_name.equals(" ")) {
                    new_name = contact_information.name();
                }
                if(new_lastname.equals(" ")){
                    new_lastname = contact_information.lastname();
                }
                if(new_phone_number == 0){
                    new_phone_number = contact_information.phone_number();
                }
                if(new_email.equals(" ")){
                    new_email = contact_information.email();
                }
                if(new_date_of_birth.compareTo(date_of_comparison) == 0){
                    new_date_of_birth = contact_information.date_of_birth();
                }
                Contact_Information update_contact_information = new Contact_Information (id, new_name,
                        new_lastname, new_phone_number, new_email, new_date_of_birth);
                deleteContact(id);
                contact.add(id, update_contact_information);
            }
        }
    }
    @Override
    public void deleteContact(int delete) {
        contact.remove(delete);
    }

    @Override
    public int searchContact(String search) {
        int id_contact = -1;
        int the_number_of_searches = 0;
        for (Contact_Information search_information : contact){
            String phone = String.valueOf(search_information.phone_number());
            if(search_information.name().contains(search) || search_information.lastname().contains(search) ||
                    phone.contains(search) || search_information.email().contains(search)){
                System.out.println(search_information);
                id_contact = contact.indexOf(search_information);
                the_number_of_searches++;
            }
        }
        if(the_number_of_searches > 1){
            return -2;
        }else {
            return id_contact;
        }
    }
}
