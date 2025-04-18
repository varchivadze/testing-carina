package org.testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${base_url}/repos/${owner}/${repo}", methodType = HttpMethodType.GET)
//@RequestTemplatePath(path = "res/rq...")
@ResponseTemplatePath(path = "api/repos/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetRepo extends AbstractApiMethodV2 {

    public GetRepo(String owner, String repo) {

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("owner", owner);
    }

}
