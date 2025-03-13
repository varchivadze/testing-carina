package org.testing;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;
import com.zebrunner.carina.utils.config.Configuration;


public class GhTest implements IAbstractTest {

    @Test(description = "Geeting user by name", priority = 0)
    @MethodOwner(owner = "varchivadze")
    public void testGetUser() {
        AbstractApiMethodV2 apiMethod = new GetUserMethods("arivadis");

        apiMethod.callAPIExpectSuccess();

        apiMethod.validateResponse();
    }

    @Test(description = "Geeting repo by name", priority = 1)
    @MethodOwner(owner = "varchivadze")
    public void getRepo() {
        AbstractApiMethodV2 apiMethod = new GetRepo("varchivadze","testing-carina");

        apiMethod.callAPIExpectSuccess();

        apiMethod.validateResponse();
    }

    @Test(description = "Geeting repo issues by name", priority = 2)
    @MethodOwner(owner = "varchivadze")
    public void getRepoIssues() {
        AbstractApiMethodV2 apiMethod = new GetRepo("varchivadze","testing-carina");

        apiMethod.callAPIExpectSuccess();

        apiMethod.validateResponse();
    }

    @Test(description = "create issue", priority = 3)
    public void createIssue() {
        PostIssue postIssue = new PostIssue("varchivadze","testing-carina");
        postIssue.setProperties("api/repos/issue/rq.properties");
        postIssue.setHeader("Authorization", "Bearer " + Configuration.getRequired("gh_token"));
        postIssue.callAPIExpectSuccess();
        postIssue.validateResponse();
    }
}
