package com.example.myapplication;
public class mensajescomedor {
    private String messageText;
    private boolean isUser;

    public mensajescomedor(String messageText, boolean isUser) {
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