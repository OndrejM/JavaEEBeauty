package javaeebeauty.tests;

import javaeebeauty.core.ApplicationConfiguration;
import javaeebeauty.demoapp.DemoAppConfig;
import javaeebeauty.tests.testsupport.TestPackager;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DemoApplicationTest {

    @Inject
    @ApplicationConfiguration
    private DemoAppConfig demoApplication;
    
    @Deployment
    public static WebArchive createDeployment() {
        return TestPackager.createDeploymentWithDependencies()
                .addClass(DemoAppConfig.class);
    }

    @Test
    public void should_be_deployed() {
        Assert.assertNotNull(demoApplication);
    }

}
