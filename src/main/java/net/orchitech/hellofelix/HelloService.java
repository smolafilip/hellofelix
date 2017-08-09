package net.orchitech.hellofelix;

import java.util.Dictionary;

import org.osgi.service.cm.ManagedService;

public interface HelloService extends ManagedService{

    static final String NULL_NAME = "no-name";
    static final String NULL_PID = "no-pid";
    static final String NAME_PROPERTY = "name";

    @Override
    void updated(Dictionary<String, ?> properties);

    void announce();

    void start(Dictionary<String, ?> properties);
}
