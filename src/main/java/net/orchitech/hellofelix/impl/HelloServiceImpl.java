package net.orchitech.hellofelix.impl;

import java.util.Dictionary;

import net.orchitech.hellofelix.HelloService;

public class HelloServiceImpl implements HelloService{

    public static final String NULL_NAME = "no-name";
    public static final String NAME_PROPERTY = "name";

    private String name = NULL_NAME;

    @Override
    public void updated(Dictionary<String, ?> properties) {
        System.out.println("props updated");
        if (properties != null) {
            name = properties.get(NAME_PROPERTY).toString();
        } else {
            name = NULL_NAME;
        }
        announce();
    }

    @Override
    public void announce(){
        System.out.printf("My name is %s!\n", name);
    }

}
