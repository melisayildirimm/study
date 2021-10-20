package yte.intern.spring_web;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.*;
import java.time.LocalDate;


@Getter
@Setter
@ToString
public class User {

    @NotBlank(message = "Name can't be empty!")
    private String name;
    @NotBlank(message = "Surname can't be empty!")
    private String surname;
    @Min(12)
    @Max(100)
    private Integer age;
    @NotBlank
    @Email
    private String email;
    @Size(min=11,max=11)
    private String tcKimlikNo;
    @PastOrPresent
    private LocalDate birthDate;
    @Size(max = 250)
    private String address;
    @NotBlank
    private String username;

    @AssertTrue
    public boolean isNotAdmin(){
        return !username.equals("admin");
    }

}
