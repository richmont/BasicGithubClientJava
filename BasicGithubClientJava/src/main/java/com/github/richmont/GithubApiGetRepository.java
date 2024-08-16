package com.github.richmont;

public class GithubApiGetRepository extends GithubApiGet{
    private String url;
    private GithubUser user;
    private int responseCode;
    private String jsonData;

    public GithubApiGetRepository(GithubUser user) {
        this.setUser(user);
    }
    @Override
    public void buildUrl() {
        GithubUser u = this.getUser();
        this.setUrl(u.getReposUrl());
    }
    public GithubUser getUser() {
        return user;
    }
    public void setUser(GithubUser user) {
        this.user = user;
    }

}
