package helpers;

import io.restassured.response.Response;
import seeders.UserSeeds;
import utils.RestUtils;

public class ProvisionUser {
    public static Response createUser(){
        return RestUtils.post("categories", UserSeeds.createUserHappyPath);
    }
}
