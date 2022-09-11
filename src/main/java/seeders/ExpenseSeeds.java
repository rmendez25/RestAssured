package seeders;

import com.github.javafaker.Faker;
import pojo.request.expense.CreateExpenseRequest;
import pojo.response.category.CreateCategoryResponse;
import pojo.response.user.CreateUserResponse;
import utils.RestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExpenseSeeds {
    static Faker faker = new Faker();
    static String pattern = "yyyy-MM-dd";
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    static String date = simpleDateFormat.format(new Date());

    public static CreateUserResponse getUser(){
        return RestUtils.post("users", UserSeeds.createUserHappyPath).as(CreateUserResponse.class);
    }

    private static CreateCategoryResponse getCategory(){
        return RestUtils.post("categories", CategorySeeds.createCategoryHappyPath).as(CreateCategoryResponse.class);
    }

    public static CreateExpenseRequest createExpenseHappyPath = CreateExpenseRequest.builder()
            .name(faker.food().vegetable())
            .amount(faker.number().numberBetween(1000, 10000))
            .category(getCategory().get_id())
            .purchaseDate(date)
            .user(getUser().get_id())
            .notes(faker.hobbit().quote())
            .build();
}
