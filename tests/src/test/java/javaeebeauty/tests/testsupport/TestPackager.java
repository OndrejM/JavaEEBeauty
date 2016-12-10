package javaeebeauty.tests.testsupport;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;

public class TestPackager {

    public static WebArchive createDeploymentWithDependencies() {
        return ShrinkWrap.create(WebArchive.class)
                .addAsLibraries(
                        Maven.resolver().loadPomFromFile("pom.xml")
                        .importRuntimeDependencies()
                        .resolve().withTransitivity().asFile());
    }
}
