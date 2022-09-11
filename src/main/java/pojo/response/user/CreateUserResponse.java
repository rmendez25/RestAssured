package pojo.response.user;

import lombok.Data;

@Data
public class CreateUserResponse {
    private String _id;
    private String firstName;
    private String lastName;
    private String role;
}
