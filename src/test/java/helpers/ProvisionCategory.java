package helpers;

import io.restassured.response.Response;
import seeders.CategorySeeds;
import utils.RestUtils;

public class ProvisionCategory {
    public static Response createCategory(){
        return RestUtils.post("categories", CategorySeeds.createCategoryHappyPath);
    }
}
