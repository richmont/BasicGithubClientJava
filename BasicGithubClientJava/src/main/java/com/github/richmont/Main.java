package com.github.richmont;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        GithubApiGetUser rd = new GithubApiGetUser("!!!!!!!1212");
        try {
            rd.doRequest();
        }catch(WrongUrlException |IOException| UserNotFound e){
            System.out.println(e);
        }
        System.out.println(rd.getResponseCode());
        System.out.println(rd.getJsonData());
        GithubUserDeserializer deserializer = new GithubUserDeserializer(rd);
        try{
            deserializer.deserialize();
            System.out.println(deserializer.getUser());
        }catch (JsonProcessingException e){
            System.out.println("Error at deserialization"+e);
        }
        //System.out.println(deserializer.getUser());
    }
}