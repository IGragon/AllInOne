package com.example.allinone;

public class News { // news class for creating news
    private String text;
    public News(String text){
        this.text = text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
