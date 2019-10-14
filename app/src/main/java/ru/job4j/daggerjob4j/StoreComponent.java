package ru.job4j.daggerjob4j;

import java.util.List;

import dagger.Component;

@Component(modules = StoreModule.class)
public interface StoreComponent{
    void injectTo(MainActivity activity);

}
