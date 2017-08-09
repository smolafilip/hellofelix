package net.orchitech.hellofelix.impl;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

import org.osgi.service.cm.ConfigurationException;

import net.orchitech.hellofelix.HelloFactory;
import net.orchitech.hellofelix.HelloService;

public class HelloFactoryImpl implements HelloFactory{

    private Map<String, HelloService> existingServices = new HashMap<>();

    @Override
    public String getName() {
        return "hello";
    }

    @Override
    public void updated(String pid, Dictionary<String, ?> properties) throws ConfigurationException {
        if (existingServices.containsKey(pid)) {
            existingServices.get(pid).updated(properties);
        } else {
            //Create and register the hello service
            HelloService helloService = new HelloServiceImpl();
            //System.out.printf("Service props are: %s\n", properties);
            helloService.start(properties);
            existingServices.put(pid, helloService);
        }
    }

    @Override
    public void deleted(String pid) {
        //Stop and remove the service on deletion
        if(existingServices.containsKey(pid)){
            existingServices.get(pid).stop();
            existingServices.remove(pid);
        }
    }

    @Override
    public void stop(){
        //System.out.println("Stopping all Hello services.");
        existingServices.forEach((k, v) -> v.stop());
    }

}
