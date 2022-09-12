package testPlans.category;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.request.category.CreateCategoryRequest;
import pojo.response.category.CreateCategoryResponse;
import seeders.CategorySeeds;
import testPlans.BaseTest;
import utils.RestUtils;

public class CategoriesTest extends BaseTest {
    CreateCategoryRequest categorySeeds = CategorySeeds.createCategoryHappyPath;

    @Test
    @Story("GET Request")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Create Category")
    public void createCategory(){
        CreateCategoryResponse as = RestUtils
                .post("categories", categorySeeds)
                .as(CreateCategoryResponse.class);

        Assert.assertEquals(as.getName(), categorySeeds.getName());


    }
    @Test
    public void createCategory1(){
        CreateCategoryResponse as = RestUtils
                .post("categories", categorySeeds)
                .as(CreateCategoryResponse.class);

        Assert.assertEquals(as.getName(), categorySeeds.getName());

    }
}
