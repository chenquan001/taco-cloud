package tacos.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Data;
import tacos.User;

@Data
public class RegistrationForm {

    private String userName;
    private String passsword;
    private String fullname;
    private String street;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;

    public User toUser(PasswordEncoder passwordEncoder){
        return new User(userName, passwordEncoder.encode(passsword),
                fullname, street, city, state, zipCode, phoneNumber);
    }

}
