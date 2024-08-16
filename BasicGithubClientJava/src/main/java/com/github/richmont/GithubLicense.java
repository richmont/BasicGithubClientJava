package com.github.richmont;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GithubLicense {

    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    private String name;

    @JsonProperty("spdx_id")
    private String spdxId;

    @JsonProperty("url")
    private String url;

    @JsonProperty("node_id")
    private String nodeId;
}