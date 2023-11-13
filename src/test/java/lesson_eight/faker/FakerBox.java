package lesson_eight.faker;

import java.util.Locale;

public class FakerBox {
    com.github.javafaker.Faker faker = new com.github.javafaker.Faker(new Locale("en"));
    public String firstName = faker.name().firstName();
    public String lastName = faker.name().lastName();
    public String userEmai = faker.internet().emailAddress();
    public String streetAddress = faker.address().fullAddress();
    public String gender = faker.options().option("Male", "Female", "Other");
    public String phone = Long.toString(faker.number().numberBetween(1000000000L,7999999999L));
    public String year = Integer.toString(faker.number().numberBetween(2000,2024));
    public String month = faker.options().option("February", "March", "April", "May", "June", "July", "August", "September");
    public String subjects = faker.options().option("Computer Science", "Match","History","English");
    public String hobbies = faker.options().option("Sports", "Reading","Music");
    public String state =faker.options().option("NCR");//,"Uttar Pradesh","Haryana"
    public String city =faker.options().option("Delhi","Noida","Gurgaon");
}
