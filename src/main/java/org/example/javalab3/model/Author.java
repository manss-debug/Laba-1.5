package org.example.javalab3.model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.StringProperty;

public class Author {

    private final StringProperty fullName;
    private final StringProperty phone;
    private final StringProperty email;
    private final DoubleProperty rating;

    public Author(String fullName, String phone, String email, double rating) {
        this.fullName = new SimpleStringProperty(fullName);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.rating = new SimpleDoubleProperty(rating);
    }

    public String getFullName() {
        return fullName.get();
    }

    public String getPhone() {
        return phone.get();
    }

    public String getEmail() {
        return email.get();
    }

    public double getRating() {
        return rating.get();
    }

    public StringProperty fullNameProperty() {
        return fullName;
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public DoubleProperty ratingProperty() {
        return rating;
    }
}