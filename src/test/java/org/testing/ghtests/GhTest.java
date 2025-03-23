package org.testing.ghtests;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import io.restassured.common.mapper.TypeRef;
import io.restassured.response.Response;
import org.testing.api.GetIssues;
import org.testing.api.GetRepo;
import org.testing.api.GetUserMethods;
import org.testing.domain.Issue;
import org.testing.domain.User;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class GhTest implements IAbstractTest {

    private static final String REPOS_SCHEMA = "api/repos/issues/rs.json";
    private static final String REPO_SCHEMA = "api/repos/rs.json";
    private static final String USER_SCHEMA = "api/user/rs.json";

    @BeforeTest
    public void beforeTest() {
        System.out.println("\n\n\n =>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n\n\n");
    }

    @DataProvider
    public Object[][] dataForUserTest() {
        return new Object[][]{
                {"varchivadze", "testing-carina"},
                {"arivadis", "BitsHit"}
        };
    }

    @Test(description = "Geeting user by name")
    @MethodOwner(owner = "varchivadze")
    public void testGetUser() {
        AbstractApiMethodV2 apiMethod = new GetUserMethods("arivadis");

        String responce = apiMethod.callAPIExpectSuccess().getBody().asString();

        User user = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            user = objectMapper.readValue(responce, User.class);
            System.out.println("This ->>>" + user);
        } catch (Exception e) {
            System.out.println("Error ->>> " + e.getMessage());
        }
        SoftAssert sf = new SoftAssert();
        sf.assertNotNull(user, "User null");
        sf.assertTrue(user.getId() > 10);
        System.out.println(user.getLogin());
        sf.assertFalse(user.getLogin().length() < 5, String.format("Expected size less %d but got %d", 5, user.getLogin().length()));

        sf.assertAll();
        apiMethod.validateResponseAgainstSchema(USER_SCHEMA);
    }

    @Test(description = "Geeting repo by name", dataProvider = "dataForUserTest")
    @MethodOwner(owner = "varchivadze")
    public void getRepo(String owner, String repo) {
        AbstractApiMethodV2 apiMethod = new GetRepo(owner, repo);
        apiMethod.callAPIExpectSuccess();

        apiMethod.validateResponseAgainstSchema(REPO_SCHEMA);
    }

    @Test(description = "Geeting repo issues by name")
    @MethodOwner(owner = "varchivadze")
    public void getRepoIssues() {

        AbstractApiMethodV2 apiMethod = new GetIssues("varchivadze", "testing-carina");
        Response response = apiMethod.callAPIExpectSuccess();
        List<Issue> issues = response.as(new TypeRef<List<Issue>>() {
        });
        SoftAssert softAssert = new SoftAssert();
        for (Issue issue : issues) {
            softAssert.assertTrue(issue.getId() > 0, String.format("Issue id %s to 0", issue.getId()));
            softAssert.assertTrue(issue.getTitle().contains("_") || issue.getTitle().contains("bug") || issue.getTitle().contains("test"), String.format("Issue title %s to _", issue.getTitle()));
        }
        softAssert.assertAll();
    }

//    @Test(description = "create issue")
//    public void createIssue() {
//        PostIssue postIssue = new PostIssue("varchivadze","testing-carina");
//        postIssue.setProperties("api/repos/issue/rq.properties");
//        postIssue.setHeader("Authorization", "Bearer " + Configuration.getRequired("gh_token"));
//        postIssue.callAPIExpectSuccess();
//    }
}
