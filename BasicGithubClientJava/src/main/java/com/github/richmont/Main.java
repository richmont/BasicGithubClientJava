package com.github.richmont;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String username = args[0];
        GithubApiGetUser rd = new GithubApiGetUser(username);
        try {
            rd.doRequest();
        }catch(WrongUrlException | IOException | NotFound e){
            throw new RuntimeException(e);
        }

        GithubUserDeserializer deserializer = new GithubUserDeserializer(rd);
        try{
            deserializer.deserialize();
            System.out.println(deserializer.getUser());
        }catch (JsonProcessingException e){
            System.out.println("Error at deserialization"+e);
        }
        GithubUser u = deserializer.getUser();
        GithubApiGetRepository apirepo = new GithubApiGetRepository(u);
        try {
            apirepo.doRequest();
        } catch (WrongUrlException | NotFound | IOException e) {
            throw new RuntimeException(e);
        }
        GithubRepositoryDeserializer repodeserializer = new GithubRepositoryDeserializer(apirepo);
        try {
            repodeserializer.deserialize();
            System.out.println(repodeserializer.getRepositoryList());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}