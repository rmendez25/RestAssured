package pojo.response.income;

import lombok.Data;
import pojo.response.user.CreateUserResponse;

@Data
public class CreateIncomeResponse {
    private CreateUserResponse user;
    private String date;
    private String incomeSource;
    private String incomeAmount;
    private String _id;
}
