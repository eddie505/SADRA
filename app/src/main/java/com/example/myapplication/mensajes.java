package com.example.myapplication;
public class mensajes {
    private String messageText;
    private boolean isUser;

    public mensajes(String messageText, boolean isUser) {
        this.messageText = messageText;
        this.isUser = isUser;
    }

    public String getMessageText() {
        return messageText;
    }

    public boolean isUser() {
        return isUser;
    }
}