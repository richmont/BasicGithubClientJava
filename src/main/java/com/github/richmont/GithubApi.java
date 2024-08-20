package com.github.richmont;
import java.io.IOException;
public interface GithubApi {
    public void doRequest() throws WrongUrlException, NotFound, IOException;
    public void buildUrl();
    public String getUrl();
    public void setUrl(String url);
    public int getResponseCode();
    public void setResponseCode(int responseCode);
    public String getJsonData();
    public void setJsonData(String jsonData);
}
