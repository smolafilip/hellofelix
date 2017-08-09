package net.orchitech.hellofelix;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedServiceFactory;

import net.orchitech.hellofelix.impl.HelloFactoryImpl;

public class Activator implements BundleActivator {
    private ServiceRegistration factoryRegistration;
    //private ServiceRegistration configRegistration;

    @Override
    public void start(BundleContext context){
        System.out.println("Starting hellofelix");

        //Create and register the config installer service
        /*ConfigService configService = new ConfigServiceImpl();
        Dictionary<String, String> configProperties = new Hashtable<>();
        String[] configClasses = new String[]{ConfigService.class.getName(), ArtifactInstaller.class.getName()};
        configRegistration = context.registerService(configClasses, configService, configProperties);*/

        //Create and register the hello factory
        HelloFactory helloFactory = new HelloFactoryImpl();
        Dictionary<String, String> factoryProperties = new Hashtable<>();
        factoryProperties.put(Constants.SERVICE_PID, "hello");
        System.out.printf("Factory props are: %s\n", factoryProperties);
        String[] helloClasses = new String[]{HelloFactory.class.getName(), ManagedServiceFactory.class.getName()};
        factoryRegistration = context.registerService(helloClasses, helloFactory, factoryProperties);
    }

    @Override
    public void stop(BundleContext context){
        System.out.println("Stopping hellofelix");
        if(factoryRegistration != null){
            factoryRegistration.unregister();
            factoryRegistration = null;
        }
        /*if(configRegistration != null){
            configRegistration.unregister();
            configRegistration = null;
        }*/
    }
}
