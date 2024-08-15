package com.github.richmont;



import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GithubUserDeserializerTest {

    @org.junit.jupiter.api.Test
    void testSuccess() {
        GithubApiGetUser mockedGithubApiGetUser = mock(GithubApiGetUser.class);
        //doNothing().when(mockedGithubApiGetUser).doRequest(); // void the execution of doRequest method, default behavior
        when(mockedGithubApiGetUser.getResponseCode()).thenReturn(200);
        when(mockedGithubApiGetUser.getJsonData()).thenReturn("{\n" +
                "  \"login\": \"java\",\n" +
                "  \"id\": 126123820,\n" +
                "  \"node_id\": \"O_kgDOB4R_LA\",\n" +
                "  \"avatar_url\": \"https://avatars.githubusercontent.com/u/126123820?v=4\",\n" +
                "  \"gravatar_id\": \"\",\n" +
                "  \"url\": \"https://api.github.com/users/java\",\n" +
                "  \"html_url\": \"https://github.com/java\",\n" +
                "  \"followers_url\": \"https://api.github.com/users/java/followers\",\n" +
                "  \"following_url\": \"https://api.github.com/users/java/following{/other_user}\",\n" +
                "  \"gists_url\": \"https://api.github.com/users/java/gists{/gist_id}\",\n" +
                "  \"starred_url\": \"https://api.github.com/users/java/starred{/owner}{/repo}\",\n" +
                "  \"subscriptions_url\": \"https://api.github.com/users/java/subscriptions\",\n" +
                "  \"organizations_url\": \"https://api.github.com/users/java/orgs\",\n" +
                "  \"repos_url\": \"https://api.github.com/users/java/repos\",\n" +
                "  \"events_url\": \"https://api.github.com/users/java/events{/privacy}\",\n" +
                "  \"received_events_url\": \"https://api.github.com/users/java/received_events\",\n" +
                "  \"type\": \"Organization\",\n" +
                "  \"site_admin\": false,\n" +
                "  \"name\": \"Java Developer Relations\",\n" +
                "  \"company\": null,\n" +
                "  \"blog\": \"https://dev.java\",\n" +
                "  \"location\": null,\n" +
                "  \"email\": \"java_devrel_grp@oracle.com\",\n" +
                "  \"hireable\": null,\n" +
                "  \"bio\": null,\n" +
                "  \"twitter_username\": \"java\",\n" +
                "  \"public_repos\": 7,\n" +
                "  \"public_gists\": 0,\n" +
                "  \"followers\": 648,\n" +
                "  \"following\": 0,\n" +
                "  \"created_at\": \"2023-02-22T23:57:43Z\",\n" +
                "  \"updated_at\": \"2023-05-08T12:50:09Z\"\n" +
                "}\n");

        mockedGithubApiGetUser.doRequest();
        assertEquals(200,mockedGithubApiGetUser.getResponseCode());

        GithubUserDeserializer deserializer = new GithubUserDeserializer(mockedGithubApiGetUser);
        GithubUser user = deserializer.getUser();
        assertEquals(user.getLogin(),"java");
        System.out.println(user);

    }
}