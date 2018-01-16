package com.bwie.eventbuslian;

public class EventBusMessage {
    //建一个消息容器
    //方便另一个接收者接收消息
    //定义了发送的消息必须是String.
    public String Message;
    public EventBusMessage(String message) {
        Message = message;
    }
 }