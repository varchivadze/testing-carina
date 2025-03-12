package org.testing;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import org.testng.annotations.Test;

public class GhTest implements IAbstractTest {

    @Test
    @MethodOwner(owner = "varchivadze")
    public void testGetUser() {
        AbstractApiMethodV2 apiMethod = new GetUserMethods("arivadis");

        apiMethod.callAPIExpectSuccess();

        apiMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "varchivadze")
    public void getRepo() {
        AbstractApiMethodV2 apiMethod = new GetRepo("varchivadze","testing-carina");

        apiMethod.callAPIExpectSuccess();

        apiMethod.validateResponse();
    }

    @Test
    @MethodOwner(owner = "varchivadze")
    public void getRepoIssues() {
        AbstractApiMethodV2 apiMethod = new GetRepo("varchivadze","testing-carina");

        apiMethod.callAPIExpectSuccess();
//        apiMethod.get

        apiMethod.validateResponse();
    }
}
