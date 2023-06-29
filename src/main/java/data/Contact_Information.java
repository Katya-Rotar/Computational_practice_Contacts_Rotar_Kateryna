package data;

import java.time.LocalDate;

public record Contact_Information(String name, String lastname, String phone_number, String email,
                                  LocalDate date_of_birth, Contact_Groups contact_groups) {
    @Override
    public String toString() {
        StringBuilder output_contact = new StringBuilder();
        if(name.length() > 1){
            output_contact.append("\nІм'я: ").append(name);
        }
        if(lastname.length() > 1){
            output_contact.append("\nПрізвище: ").append(lastname);
        }
        if(phone_number.length() > 1){
            output_contact.append("\nТелефон: ").append(phone_number);
            if(phone_number.startsWith("039") || phone_number.startsWith("067") || phone_number.startsWith("068")
            || phone_number.startsWith("096") || phone_number.startsWith("097") || phone_number.startsWith("098")){
                output_contact.append(" (Київстар)");
            }
            if(phone_number.startsWith("050") || phone_number.startsWith("066") || phone_number.startsWith("095")
                    || phone_number.startsWith("099")){
                output_contact.append(" (Vodafone)");
            }
            if(phone_number.startsWith("063") || phone_number.startsWith("073") || phone_number.startsWith("093")){
                output_contact.append(" (Life-cell)");
            }
            if (phone_number.length() != 10 ){
                output_contact.append(" - номер може не існувати");
            }
        }
        if(email.length() > 1){
            output_contact.append("\nEmail: ").append(email);
        }
        LocalDate default_value = LocalDate.of(0,1,1);
        if(!date_of_birth.equals(default_value)) {
            LocalDate today = LocalDate.now();
            if (date_of_birth.getMonth() == today.getMonth() && date_of_birth.getDayOfMonth() == today.getDayOfMonth()){
                output_contact.append("\nДень народження: сьогодні");
            } else {
                output_contact.append("\nДень народження: ").append(date_of_birth);
            }
        }
        output_contact.append("\nГрупа: ").append(contact_groups);
        return output_contact.toString();
    }
}