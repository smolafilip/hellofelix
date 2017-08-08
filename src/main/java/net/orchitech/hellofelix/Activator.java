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
        System.out.println("Starting bundle");
        HelloService service = new HelloServiceImpl();
        Dictionary<String, String> properties = new Hashtable<>();
        properties.put(Constants.SERVICE_PID, "helloservice");
        System.out.printf("Props are: %s", properties);
        String[] classes = new String[] {HelloService.class.getName(), ManagedService.class.getName()};
        serviceRegistration = context.registerService(classes, service, properties);
        System.out.printf("Registerd service %s", serviceRegistration.toString());
    }

    @Override
    public void stop(BundleContext context){
        serviceRegistration.unregister();
    }
}
