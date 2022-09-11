package testPlans.user;

import com.github.javafaker.Faker;
import enums.Roles;
import io.qameta.allure.*;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import pojo.request.user.CreateUserRequest;
import pojo.response.user.CreateUserResponse;
import seeders.UserSeeds;
import testPlans.BaseTest;
import utils.RestUtils;
import io.qameta.allure.testng.Tag;

import java.util.HashMap;
import java.util.Map;

@Feature("Post User API")
public class POSTUserTest extends BaseTest {
    Faker faker = new Faker();

    @Test()
    @Story("Base support for bdd annotations")
    @Story("Advanced support for bdd annotations")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Some detailed test description")
    @Tag("User")
    public void createUserHappyPath(ITestContext context) {
        CreateUserRequest userRequest = UserSeeds.createUserHappyPath;

        Response response = RestUtils.post("users", userRequest);
        Assert.assertEquals(response.statusCode(), 201);

        context.setAttribute("response", response);

        CreateUserResponse userResponse = response.as(CreateUserResponse.class);

        Assert.assertEquals(userResponse.getFirstName(), userRequest.getFirstName());
        Assert.assertEquals(userResponse.getLastName(), userRequest.getLastName());
        Assert.assertEquals(userResponse.getRole(), userRequest.getRole());
    }

    @Test(dependsOnMethods = "createUserHappyPath")
    public void getUserById(ITestContext context) {
        Response response = (Response) context.getAttribute("response");
        CreateUserResponse userResponse = response.as(CreateUserResponse.class);

        Map<String, String> id = new HashMap<>();
        id.put("id", userResponse.get_id());

        Response user = RestUtils.get("users/{id}", id);
        Assert.assertEquals(user.getStatusCode(), 200);

        CreateUserResponse as = user.as(CreateUserResponse.class);
        Assert.assertEquals(as.get_id(), userResponse.get_id());
        Assert.assertEquals(as.getFirstName(), userResponse.getFirstName());
        Assert.assertEquals(as.getLastName(), userResponse.getLastName());
        Assert.assertEquals(as.getRole(), userResponse.getRole());
    }

    @Test
    public void createUserMissingAllInformation() {
        CreateUserRequest userRequest = UserSeeds.createUserMissingAllInformation;

        Response response = RestUtils.post("users", userRequest);
        Assert.assertEquals(response.statusCode(), 500);

        Assert.assertEquals(response.jsonPath().get("msg._message").toString(),
                "User validation failed");
    }

    @Test
    public void createUserWithNullInformation() {
        CreateUserRequest userRequest = UserSeeds.createUserWithNullValues;

        Response response = RestUtils.post("users", userRequest);
        Assert.assertEquals(response.statusCode(), 500);

        Assert.assertEquals(response.jsonPath().get("msg._message").toString(),
                "User validation failed");
    }

    @Test
    public void createUserWithoutFirstName() {
        CreateUserRequest userRequest = UserSeeds.createUserWithoutFirstName;

        Response response = RestUtils.post("users", userRequest);
        Assert.assertEquals(response.statusCode(), 500);

        Assert.assertEquals(response.jsonPath().get("msg.message").toString(),
                "User validation failed: firstName: Path `firstName` is required.");
    }

    @Test
    public void createUserWithoutLastName() {
        CreateUserRequest userRequest = UserSeeds.createUserWithoutLastName;

        Response response = RestUtils.post("users", userRequest);
        Assert.assertEquals(response.statusCode(), 500);

        Assert.assertEquals(response.jsonPath().get("msg.message").toString(),
                "User validation failed: lastName: Path `lastName` is required.");
    }

    @Test
    public void createUserWithoutRollAsNull() {
        CreateUserRequest userRequest = UserSeeds.createUserWithRoleAsNull;

        Response response = RestUtils.post("users", userRequest);
        Assert.assertEquals(response.statusCode(), 500);

        Assert.assertEquals(response.jsonPath().get("msg.message").toString(),
                "User validation failed: role: `null` is not a valid enum value for path `role`.");
    }

    @Test
    public void createUserWithoutRollAsNullTest() {
        CreateUserRequest userRequest = CreateUserRequest
                .builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .role(Roles.MOM.getRole())
                .build();

        Response response = RestUtils.post("users", userRequest);
        Assert.assertEquals(response.statusCode(), 201);
    }

}
