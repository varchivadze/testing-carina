//package org.testing;
//
//import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
//import org.testng.annotations.Test;
//
//public class TestCarina {
//
//    @Test()
//    @MethodOwner(owner = "qpsdemo")
//    public void testCreateUser() throws Exception {
//        System.out.println("test");
//        setCases("4555,54545");
//        PostUserMethod api = new PostUserMethod();
//        api.setProperties("api/users/user.properties");
//
//        AtomicInteger counter = new AtomicInteger(0);
//
//        api.callAPIWithRetry()
//                .withLogStrategy(APIMethodPoller.LogStrategy.ALL)
//                .peek(rs -> counter.getAndIncrement())
//                .until(rs -> counter.get() == 4)
//                .pollEvery(1, ChronoUnit.SECONDS)
//                .stopAfter(10, ChronoUnit.SECONDS)
//                .execute();
//        api.validateResponse();
//    }
//
//    @Test()
//    @MethodOwner(owner = "qpsdemo")
//    public void testCreateUserMissingSomeFields() throws Exception {
//        PostUserMethod api = new PostUserMethod();
//        api.setProperties("api/users/user.properties");
//        api.getProperties().remove("name");
//        api.getProperties().remove("username");
//        api.callAPIExpectSuccess();
//        api.validateResponse();
//    }
//
//    @Test()
//    @MethodOwner(owner = "qpsdemo")
//    public void testGetUsers() {
//        GetUserMethods getUsersMethods = new GetUserMethods();
//        getUsersMethods.callAPIExpectSuccess();
//        getUsersMethods.validateResponse(JSONCompareMode.STRICT, JsonCompareKeywords.ARRAY_CONTAINS.getKey());
//        getUsersMethods.validateResponseAgainstSchema("api/users/_get/rs.schema");
//    }
//
//    @Test()
//    @MethodOwner(owner = "qpsdemo")
//    @TestPriority(Priority.P1)
//    public void testDeleteUsers() {
//        DeleteUserMethod deleteUserMethod = new DeleteUserMethod();
//        deleteUserMethod.setProperties("api/users/user.properties");
//        deleteUserMethod.callAPIExpectSuccess();
//        deleteUserMethod.validateResponse();
//    }
//
//}
//}
