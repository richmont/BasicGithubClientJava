package br.com.richmont;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class GithubRepositoryDeserializer extends GithubDeserializer{
    private List<GithubRepository> repositoryList;

    public GithubRepositoryDeserializer(GithubApiGetRepository api) {
        this.setApi(api);
        this.setJsonContent(api.getJsonData());
    }

    public List<GithubRepository> getRepositoryList() {
        return this.repositoryList;
    }

    public void setRepositoryList(List<GithubRepository> repositoryList) {
        this.repositoryList = repositoryList;
    }
    public void deserialize() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        GithubApiGet api = this.getApi();
        if (api.getResponseCode() == 200){
            List<GithubRepository> repoList = mapper.readValue(
                    this.getJsonContent(), new TypeReference<List<GithubRepository>>() { });
            //GithubRepository repository = mapper.readValue(this.getJsonContent(), GithubRepository.class);
            this.setRepositoryList(repoList);
        }
    }
}
