package javaeebeauty.demoapp;

import javaeebeauty.core.ApplicationConfiguration;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Arquillian.class)
public class DemoApplicationTest {

    @Inject
    @ApplicationConfiguration
    private DemoApplication demoApplication;
    
    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                                .addAsLibraries(
                                        Maven.resolver().loadPomFromFile("pom.xml")
                                        .importRuntimeDependencies()
                                        .resolve().withTransitivity().asFile())
                .addClass(DemoApplication.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void should_be_deployed() {
        Assert.assertNotNull(demoApplication);
    }

}
