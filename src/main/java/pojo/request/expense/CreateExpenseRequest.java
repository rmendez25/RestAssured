package pojo.request.expense;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateExpenseRequest {
    private String name;
    private Integer amount;
    private String category;
    private String purchaseDate;
    private String user;
    private String notes;
}
