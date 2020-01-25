package com.example.allinone;

public class Message {
    private String name;
    private String message;
    private int photo;

    public Message(String name, String message){
        this.name = name;
        this.message = message;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    public int getPhoto() {
        return photo;
    }
}
