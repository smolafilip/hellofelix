package net.orchitech.hellofelix.impl;

import java.io.File;

import org.apache.felix.fileinstall.ArtifactInstaller;
import org.apache.felix.ipojo.annotations.Component;
import org.apache.felix.ipojo.annotations.Instantiate;
import org.apache.felix.ipojo.annotations.Provides;

import net.orchitech.hellofelix.HelloService;

@Instantiate
@Component(name = "helloService")
@Provides(specifications = ArtifactInstaller.class)
public class HelloServiceImpl implements HelloService{

    @Override
    public boolean canHandle(File artifact) {
        return artifact.getName().endsWith(".props");
    }

    @Override
    public void install(File artifact) throws Exception {
        System.out.printf("Installing: %s\n", artifact.getName());
    }

    @Override
    public void uninstall(File artifact) throws Exception {
        System.out.printf("Uninstalling: %s\n", artifact.getName());
    }

    @Override
    public void update(File artifact) throws Exception {
        System.out.printf("Updating: %s\n", artifact.getName());
    }

}
