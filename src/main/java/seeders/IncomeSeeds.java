package seeders;

import com.github.javafaker.Faker;
import pojo.request.income.CreateIncomeRequest;
import pojo.response.user.CreateUserResponse;
import utils.RestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class IncomeSeeds {
    static Faker faker = new Faker();
    static String pattern = "yyyy-MM-dd";
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    static String date = simpleDateFormat.format(new Date());

    private static CreateUserResponse getUser(){
        return RestUtils.post("users", UserSeeds.createUserHappyPath).as(CreateUserResponse.class);
    }

    public static CreateIncomeRequest createIncomeHappyPath = CreateIncomeRequest.builder()
            .userId(getUser().get_id())
            .date(date)
            .incomeAmount(faker.number().numberBetween(10000, 15000))
            .incomeSource(faker.job().position())
            .build();
}
