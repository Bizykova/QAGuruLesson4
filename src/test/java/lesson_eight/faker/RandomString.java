package lesson_eight.faker;

import java.util.Random;


public class RandomString {

    public static String getRandomMonth() {

        String[] array = new String[]{"February", "March", "April", "May", "June", "July", "August", "September"};
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    public static String getRandomPhone() {
        String number = "";
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            number += random.nextInt(10);
        }
        return number;
    }
    public static String getRandomYear() {
        int pref = 2000;
        Random random = new Random();
        int year = pref+ random.nextInt(24);
        return  Integer.toString(year);
    }

    public static String getRandomGender() {
        String[] array = new String[]{"Male", "Female", "Other"};
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

    public static String getRandomSubjects() {
        String[] array = new String[]{"Computer Science", "Match","History","English"};
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }
    public static String getRandomHobbies() {
        String[] array = new String[]{"Sports", "Reading","Music"};
        Random random = new Random();
        int index = random.nextInt(array.length);
        return array[index];
    }

}
