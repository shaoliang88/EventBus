package com.bwie.eventbusnian;

public class EventBusMessage {
    //定义了发送的消息必须是String.
    public String Message;
    public EventBusMessage(String message) {
        Message = message;
    }
 }