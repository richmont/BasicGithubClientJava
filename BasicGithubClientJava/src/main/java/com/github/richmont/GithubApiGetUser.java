package com.github.richmont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class GithubApiGetUser {
    private String url;
    private String username;
    private int responseCode;
    private String jsonData;

    public GithubApiGetUser(String username) {
        this.username = username;
    }

    public void doRequest() throws WrongUrlException,UserNotFound, IOException{
        this.buildUrl();
        try {
            URL url = new URL(this.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            this.setResponseCode(connection.getResponseCode());

            if(this.getResponseCode() == 404){
                throw new UserNotFound("User not found, try again");
            }else{
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                this.setJsonData(response.toString());
            }


        } catch (ProtocolException e) {
            throw new WrongUrlException("Check your connection to Github API " + e);
        } catch (MalformedURLException e) {
            throw new WrongUrlException("Check username inserted and try again " + e);
        }
    }
    private void buildUrl() {
        this.setUrl("https://api.github.com/users/" + this.getUsername());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getJsonData() {
        return jsonData;
    }

    public void setJsonData(String jsonData) {
        this.jsonData = jsonData;
    }
}
