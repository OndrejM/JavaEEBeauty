package javaeebeauty.demoapp;

import javaeebeauty.demoapp.testsupport.TestPackager;
import javaeebeauty.web.session.control.WebSessionConfigSnapshot;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@ApplicationScoped
public class WebSessionTest {

    @Inject
    private TestContext context; 
    
    @Deployment
    public static WebArchive createDeployment() {
        return TestPackager.createDeploymentWithDependencies()
                .addClass(DemoAppConfig.class);
    }

    public void setConfig(@Observes WebSessionConfigSnapshot config) {
        context.config = config;
    }

    @Test
    public void should_be_deployed() {
        Assert.assertNotNull(context.config);
    }

    @ApplicationScoped
    public static class TestContext {

        private WebSessionConfigSnapshot config;

    }

}
