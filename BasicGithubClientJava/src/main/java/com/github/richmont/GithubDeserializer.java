package com.github.richmont;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GithubDeserializer {
    private String jsonContent;
    private GithubApiGet api;

    public String getJsonContent() {
        return jsonContent;
    }

    public void setJsonContent(String jsonContent) {
        this.jsonContent = jsonContent;
    }

    public GithubApiGet getApi() {
        return api;
    }

    public void setApi(GithubApiGet api) {
        this.api = api;
    }
}
