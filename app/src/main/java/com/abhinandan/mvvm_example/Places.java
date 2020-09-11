package com.abhinandan.mvvm_example;

public class Places {
    private String title;
    private String imageURL;

    public Places(String title, String imageURL) {
        this.title = title;
        this.imageURL = imageURL;
    }

    public Places() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
