package javaeebeauty.demoapp;

import javaeebeauty.demoapp.testsupport.TestPackager;
import javaeebeauty.web.session.control.WebSessionConfig;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
@ApplicationScoped
public class WebSessionTest {

    private WebSessionConfig config;
    
    @Deployment
    public static WebArchive createDeployment() {
        return TestPackager.createDeploymentWithDependencies()
                .addClass(DemoApplication.class);
    }

    public void setConfig(@Observes WebSessionConfig config) {
        this.config = config;
    }

    @Test
    public void should_be_deployed() {
        Assert.assertNotNull(config);
    }

}
