package org.testing;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.zebrunner.carina.api.AbstractApiMethodV2;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


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
        return new Object[][] {
                {"varchivadze","testing-carina"},
                {"arivadis", "BitsHit"}
        };
    }


    @Test(description = "Geeting user by name", priority = 0)
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

    @Test(description = "Geeting repo by name", priority = 1, dataProvider = "dataForUserTest")
    @MethodOwner(owner = "varchivadze")
    public void getRepo(String owner, String repo) {
        AbstractApiMethodV2 apiMethod = new GetRepo(owner,repo);

        apiMethod.callAPIExpectSuccess();

        apiMethod.validateResponseAgainstSchema(REPO_SCHEMA);
    }

//    @Test(description = "Geeting repo issues by name", priority = 2)
//    @MethodOwner(owner = "varchivadze")
//    public void getRepoIssues() {
//        AbstractApiMethodV2 apiMethod = new GetIssues("varchivadze","testing-carina");
//        apiMethod.callAPIExpectSuccess();
//        apiMethod.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
//        apiMethod.validateResponseAgainstSchema(REPOS_SCHEMA);
//    }

//    @Test(description = "create issue", priority = 3)
//    public void createIssue() {
//        PostIssue postIssue = new PostIssue("varchivadze","testing-carina");
//        postIssue.setProperties("api/repos/issue/rq.properties");
//        postIssue.setHeader("Authorization", "Bearer " + Configuration.getRequired("gh_token"));
//        postIssue.callAPIExpectSuccess();
//    }
}
