package br.com.richmont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public abstract class GithubApiGet implements GithubApi{
    private String url;

    private int responseCode;
    private String jsonData;

    public abstract void buildUrl();

    public void doRequest() throws WrongUrlException, NotFound, IOException {
        this.buildUrl();
        try {
            URL url = new URL(this.getUrl());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            this.setResponseCode(connection.getResponseCode());

            if(this.getResponseCode() == 404){
                throw new NotFound("Data not found, try again");
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
            throw new WrongUrlException("Check data inserted and try again " + e);
        }
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
