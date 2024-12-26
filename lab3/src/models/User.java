package models;

import annotations.*;

/**
 * Class representing a user.
 */
public class User {
    @NotNull
    private String name;

    @NotNull
    @StringLength(min = 5, max = 50)
    private String email;

    @MinValue(18)
    @MaxValue(100)
    private int age;

    /**
     * Constructor to create a user.
     *
     * @param name  the name of the user
     * @param email the email address of the user
     * @param age   the age of the user
     */
    public User(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }
}
