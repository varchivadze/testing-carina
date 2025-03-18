package org.testing.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    public String title;
    public Long id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String login) {
        this.title = login;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
