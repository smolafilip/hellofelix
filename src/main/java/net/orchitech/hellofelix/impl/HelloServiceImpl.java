package net.orchitech.hellofelix.impl;

import java.util.Dictionary;

import net.orchitech.hellofelix.HelloService;

public class HelloServiceImpl implements HelloService{

    @Override
    public void updated(Dictionary<String, ?> properties) {
        System.out.println("props updated");
        if (properties != null) {
            System.out.println("name = " + properties.get("name"));
        }
    }

}
