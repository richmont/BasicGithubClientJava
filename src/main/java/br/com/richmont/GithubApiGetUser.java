package br.com.richmont;

public class GithubApiGetUser extends GithubApiGet{
    private String url;
    private String username;
    private int responseCode;
    private String jsonData;

    public GithubApiGetUser(String username) {
        this.username = username;
    }
    @Override
    public void buildUrl() {
        this.setUrl("https://api.github.com/users/" + this.getUsername());
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

