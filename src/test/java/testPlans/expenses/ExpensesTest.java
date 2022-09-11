package testPlans.expenses;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.request.expense.CreateExpenseRequest;
import seeders.ExpenseSeeds;
import utils.RestUtils;

public class ExpensesTest {

    @Test
    public void createIncome(){
        CreateExpenseRequest expenseRequest = ExpenseSeeds.createExpenseHappyPath;
        Response expense = RestUtils.post("expenses", expenseRequest);
        Assert.assertEquals(expense.statusCode(), 201);
    }

}
