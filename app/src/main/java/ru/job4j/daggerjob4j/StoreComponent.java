package ru.job4j.daggerjob4j;

import java.util.List;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = StoreModule.class)
public interface StoreComponent{
    void injectTo(MainActivity activity);

}
