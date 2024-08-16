package com.github.richmont;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
Get data from a api in json format then map to a GithubUser instance
 */
public class GithubUserDeserializer {
    private GithubUser user;
    private String jsonContent;
    private GithubApiGetUser api;

    /*
    Constructor for a GithubUserDeserializer
    @params api Instance for a class to get data in json format from the Github API
     */
    public GithubUserDeserializer(GithubApiGetUser api) {

        this.api = api;
        this.setJsonContent(api.getJsonData());
    }

    public GithubUser getUser() {
        return user;
    }

    public void setUser(GithubUser user) {
        this.user = user;
    }

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public GithubApiGetUser getApi() {
        return api;
    }

    public void setApi(GithubApiGetUser api) {
        this.api = api;
    }
    /*
    First check if the request has status ok in API
    then map the json string to GithubUser instance and set in user variable
     */
    public void deserialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        if (api.getResponseCode() == 200){
            GithubUser user = mapper.readValue(this.getJsonContent(), GithubUser.class);
            this.setUser(user);
        }

    }
}