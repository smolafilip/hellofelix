package net.orchitech.hellofelix;

import org.apache.felix.fileinstall.ArtifactInstaller;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

@Instantiate
@Component(name = "activator")
@Provides(specifications = ArtifactInstaller.class)
public class Activator implements BundleActivator {

    @Override
    public void start(BundleContext arg0) throws Exception {
        System.out.println("Starting hellofelix");
    }

    @Override
    public void stop(BundleContext arg0) throws Exception {
        System.out.println("Stopping hellofelix");
    }


}
