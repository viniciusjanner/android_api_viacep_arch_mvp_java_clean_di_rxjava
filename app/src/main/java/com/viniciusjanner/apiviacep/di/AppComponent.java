package com.viniciusjanner.apiviacep.di;

import com.viniciusjanner.apiviacep.presentation.view.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, RepositoryModule.class, UseCaseModule.class, PresenterModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    static AppComponent create() {
        return DaggerAppComponent.create();
    }
}
