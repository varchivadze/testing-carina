package org.testing;

import com.zebrunner.carina.utils.config.Configuration;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;


@Endpoint(url = "${base_url}/repos/${owner}/${repo}/issues", methodType = HttpMethodType.POST)
@RequestTemplatePath(path = "api/repos/issue/rq.json")
//@ResponseTemplatePath(path = "api/repos/_post/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class PostIssue extends AbstractApiMethodV2 {

    public PostIssue(String owner, String repo) {

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("owner", owner);
    }
}
