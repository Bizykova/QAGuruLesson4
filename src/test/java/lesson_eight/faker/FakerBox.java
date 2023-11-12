package lesson_eight.faker;

import java.util.Locale;

public class FakerBox {
    com.github.javafaker.Faker faker = new com.github.javafaker.Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmai = faker.internet().emailAddress();
    public String streetAddress = faker.address().fullAddress();
}
