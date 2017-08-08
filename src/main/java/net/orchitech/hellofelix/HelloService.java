package net.orchitech.hellofelix;

import java.util.Dictionary;

import org.osgi.service.cm.ManagedService;

public interface HelloService extends ManagedService{
    @Override
    void updated(Dictionary<String, ?> properties);
}
