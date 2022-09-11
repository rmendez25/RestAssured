package seeders;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import pojo.request.category.CreateCategoryRequest;

public class CategorySeeds {
    static Faker faker = new Faker();
    public static CreateCategoryRequest createCategoryHappyPath = CreateCategoryRequest.builder()
            .name(faker.funnyName().name())
            .build();
}
