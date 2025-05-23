package cl.edutech.userservice.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
