package net.orchitech.hellofelix;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.Constants;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.cm.ManagedService;

import net.orchitech.hellofelix.impl.HelloServiceImpl;

public class Activator implements BundleActivator {
    private ServiceRegistration serviceRegistration;

    @Override
    public void start(BundleContext context){
        System.out.println("Starting hellofelix");

        HelloService service = new HelloServiceImpl();
        Dictionary<String, String> properties = new Hashtable<>();
        properties.put(Constants.SERVICE_PID, "helloservice");

        System.out.printf("Props are: %s\n", properties);

        serviceRegistration = context.registerService(ManagedService.class.getName(), service, properties);

        System.out.println("Registerd service");
    }

    @Override
    public void stop(BundleContext context){
        System.out.println("Stopping hellofelix");
        if(serviceRegistration != null){
            serviceRegistration.unregister();
            serviceRegistration = null;
        }
    }
}
