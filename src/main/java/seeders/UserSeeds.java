package seeders;

import com.github.javafaker.Faker;
import enums.Roles;
import org.apache.commons.lang3.StringUtils;
import pojo.request.user.CreateUserRequest;

public class UserSeeds {
    static Faker faker = new Faker();
    public static  CreateUserRequest createUserHappyPath = CreateUserRequest.builder()
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .role(Roles.MOM.getRole())
            .build();

    public static  CreateUserRequest createUserMissingAllInformation = CreateUserRequest.builder()
            .firstName(StringUtils.EMPTY)
            .lastName(StringUtils.EMPTY)
            .role(StringUtils.EMPTY)
            .build();

    public static  CreateUserRequest createUserWithNullValues = CreateUserRequest.builder()
            .firstName(null)
            .lastName(null)
            .role(null)
            .build();

    public static  CreateUserRequest createUserWithoutFirstName = CreateUserRequest.builder()
            .firstName(StringUtils.EMPTY)
            .lastName(faker.name().lastName())
            .role(Roles.BABY.getRole())
            .build();

    public static  CreateUserRequest createUserWithoutLastName = CreateUserRequest.builder()
            .firstName(faker.name().firstName())
            .lastName(StringUtils.EMPTY)
            .role(Roles.BABY.getRole())
            .build();

    public static  CreateUserRequest createUserWithRoleAsNull = CreateUserRequest.builder()
            .firstName(faker.name().firstName())
            .lastName(faker.name().lastName())
            .role(null)
            .build();
}
