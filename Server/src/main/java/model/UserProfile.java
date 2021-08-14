package model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserProfile {
    @Id
    private long userId;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String hobbies;
    private Address address;




}
