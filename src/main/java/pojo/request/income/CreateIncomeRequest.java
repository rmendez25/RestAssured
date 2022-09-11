package pojo.request.income;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateIncomeRequest {
    private String userId;
    private String date;
    private Integer incomeAmount;
    private String incomeSource;
}
