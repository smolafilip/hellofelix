package net.orchitech.hellofelix.impl;

import java.util.Dictionary;

import org.osgi.framework.Constants;

import net.orchitech.hellofelix.HelloService;

public class HelloServiceImpl implements HelloService{

    private volatile String name = NULL_NAME;
    private String pid;

    @Override
    public void start(Dictionary<String, ?> properties){
        //Read the properties
        if (properties != null) {
            name = properties.get(NAME_PROPERTY).toString();
            pid = properties.get(Constants.SERVICE_PID).toString();
        } else {
            name = NULL_NAME;
            pid = NULL_PID;
        }

        //Announce start
        System.out.printf("Service \"%s\" starting with name \"%s\"\n", pid, name);
    }

    @Override
    public void updated(Dictionary<String, ?> properties) {
        //Update the name
        if (properties != null) {
            name = properties.get(NAME_PROPERTY).toString();
        } else {
            name = NULL_NAME;
        }

        //Announce the update
        System.out.printf("Updating service \"%s\" with name \"%s\"\n", pid, name);
    }

    @Override
    public synchronized void announce(){
        System.out.printf("%s: My name is %s!\n", pid, name);
    }
}
