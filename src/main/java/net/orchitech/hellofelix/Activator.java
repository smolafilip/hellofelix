package net.orchitech.hellofelix;

import java.util.Dictionary;
import java.util.Hashtable;

import org.apache.felix.fileinstall.ArtifactInstaller;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;

import net.orchitech.hellofelix.impl.ConfigServiceImpl;
import net.orchitech.hellofelix.impl.HelloServiceImpl;

public class Activator implements BundleActivator {
    private ServiceRegistration helloRegistration;
    private ServiceRegistration configRegistration;

    @Override
    public void start(BundleContext context){
        System.out.println("Starting hellofelix");

        //Create and register the config installer service
        ConfigService configService = new ConfigServiceImpl();
        Dictionary<String, String> configProperties = new Hashtable<>();
        String[] configClasses = new String[]{ConfigService.class.getName(), ArtifactInstaller.class.getName()};
        configRegistration = context.registerService(configClasses, configService, configProperties);

        //Create and register the hello service
        HelloService helloService = new HelloServiceImpl();
        Dictionary<String, String> helloProperties = new Hashtable<>();
        helloProperties.put(Constants.SERVICE_PID, "helloservice");
        System.out.printf("Props are: %s\n", helloProperties);
        String[] helloClasses = new String[]{HelloService.class.getName(), ManagedService.class.getName()};
        helloRegistration = context.registerService(helloClasses, helloService, helloProperties);
    }

    @Override
    public void stop(BundleContext context){
        System.out.println("Stopping hellofelix");
        if(helloRegistration != null){
            helloRegistration.unregister();
            helloRegistration = null;
        }
        if(configRegistration != null){
            configRegistration.unregister();
            configRegistration = null;
        }
    }
}
