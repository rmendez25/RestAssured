package testPlans.expenses;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.request.expense.CreateExpenseRequest;
import seeders.ExpenseSeeds;
import testPlans.BaseTest;
import utils.RestUtils;

public class ExpensesTest extends BaseTest {

    @Test
    public void createExpense(){
        CreateExpenseRequest expenseRequest = ExpenseSeeds.createExpenseHappyPath;
        Response expense = RestUtils.post("expenses", expenseRequest);
        Assert.assertEquals(expense.statusCode(), 201);
    }

}
