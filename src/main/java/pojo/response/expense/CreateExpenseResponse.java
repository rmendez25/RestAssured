package pojo.response.expense;

import lombok.Data;
import pojo.request.category.CreateCategoryRequest;
import pojo.request.user.CreateUserRequest;

@Data
public class CreateExpenseResponse {
    private String name;
    private Integer amount;
    private CreateCategoryRequest category;
    private String purchaseDate;
    private CreateUserRequest user;
    private String notes;
    private String _id;
}
