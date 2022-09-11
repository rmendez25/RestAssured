package pojo.request.user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUserRequest {
    private String firstName;
    private String lastName;
    private String role;
}
