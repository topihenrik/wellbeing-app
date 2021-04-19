package com.example.olioprojekti;

public class Account {
    //String firstName = "Jari", lastName = "Mattila", username = "jari.mattila", email = "jari.mattila@gmail.com", password = "jartsa123", address = "jarintie 12", weight = "88", height = "182";
    String firstName, lastName, username, email, password, address, weight, height;
    byte[] salt;

    public Account(String firstName, String lastName, String username, String email, String password, String address, String weight, String height, byte[] salt) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.weight = weight;
        this.height = height;
        this.salt = salt;
    }

    public String getUserName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public byte[] getSalt() {
        return salt;
    }

}
