package br.com.richmont;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
Get data from a api in json format then map to a GithubUser instance
 */
public class GithubUserDeserializer extends GithubDeserializer{
    private GithubUser user;
    /*
    Constructor for a GithubUserDeserializer
    @params api Instance for a class to get data in json format from the Github API
     */
    public GithubUserDeserializer(GithubApiGetUser api) {
        this.setApi(api);
        this.setJsonContent(api.getJsonData());
    }

    public GithubUser getUser() {
        return user;
    }

    public void setUser(GithubUser user) {
        this.user = user;
    }



    /*
    First check if the request has status ok in API
    then map the json string to GithubUser instance and set in user variable
     */
    public void deserialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        GithubApiGet api = this.getApi();
        if (api.getResponseCode() == 200){
            GithubUser user = mapper.readValue(this.getJsonContent(), GithubUser.class);
            this.setUser(user);
        }

    }
}