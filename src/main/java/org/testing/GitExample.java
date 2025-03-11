package org.testing;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.Configuration;


@Endpoint(url = "${base_url}/users", methodType = HttpMethodType.GET)
@RequestTemplatePath(path = "res/rq...")
@ResponseTemplatePath(path = "res/rs...")
@SuccessfulHttpStatus(status = HttpResponseStatusType.ACCEPTED_202)
public class GetUserMethods extends AbstractApiMethodV2 {

    public GetUserMethods() {
        replaceUrlPlaceholder("base_url", Configuration.get("api_url"));
    }
}
