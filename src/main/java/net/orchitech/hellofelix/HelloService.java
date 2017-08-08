package net.orchitech.hellofelix;

import java.io.File;

import org.apache.felix.fileinstall.ArtifactInstaller;

public interface HelloService extends ArtifactInstaller{

    @Override
    boolean canHandle(File artifact);

    @Override
    void install(File artifact) throws Exception;

    @Override
    void uninstall(File artifact) throws Exception;

    @Override
    void update(File artifact) throws Exception;
}
