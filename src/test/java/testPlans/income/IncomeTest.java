package testPlans.income;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.request.income.CreateIncomeRequest;
import seeders.IncomeSeeds;
import utils.RestUtils;

public class IncomeTest {


    @Test
    public void createIncome(){
        CreateIncomeRequest incomeRequest = IncomeSeeds.createIncomeHappyPath;
        Response incomes = RestUtils.post("incomes", incomeRequest);
        Assert.assertEquals(incomes.statusCode(), 201);
    }
}
