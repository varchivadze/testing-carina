package org.testing.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;
import com.zebrunner.carina.utils.config.Configuration;


@Endpoint(url = "${base_url}/users/${user}", methodType = HttpMethodType.GET)
//@RequestTemplatePath(path = "res/rq...")
@ResponseTemplatePath(path = "api/user/rs.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class GetUserMethods extends AbstractApiMethodV2 {

    public GetUserMethods(String user) {

//        super(null, "api/user/rs.json");

        String apiUrl = Configuration.getRequired("api_url");
        System.out.println(apiUrl);

        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        replaceUrlPlaceholder("user", user);
    }
}
