package pojo.request.category;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateCategoryRequest{
	private String name;
}
