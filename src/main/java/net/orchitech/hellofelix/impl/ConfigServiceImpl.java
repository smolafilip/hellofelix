package net.orchitech.hellofelix.impl;

import java.io.File;

import net.orchitech.hellofelix.ConfigService;

public class ConfigServiceImpl implements ConfigService{

    @Override
    public void install(File artifact) throws Exception {
        System.out.printf("install %s\n", artifact.getName());
    }

    @Override
    public void update(File artifact) throws Exception {
        System.out.printf("update %s\n", artifact.getName());
    }

    @Override
    public void uninstall(File artifact) throws Exception {
        System.out.printf("uninstall %s\n", artifact.getName());
    }

    @Override
    public boolean canHandle(File artifact) {
        System.out.printf("Testing whether can handle %s\n", artifact.getName());
        return artifact.getName().endsWith(".test");
    }

}
