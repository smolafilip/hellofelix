package net.orchitech.hellofelix;

import org.osgi.service.cm.ManagedServiceFactory;

public interface HelloFactory extends ManagedServiceFactory{
    void stop();
}
