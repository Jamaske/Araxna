package com.araxna.tdo;

import lombok.Data;

@Data
public class Message {
    private String from;
    private String to;
    private String content;

    //standard constructors, getters, setters
}