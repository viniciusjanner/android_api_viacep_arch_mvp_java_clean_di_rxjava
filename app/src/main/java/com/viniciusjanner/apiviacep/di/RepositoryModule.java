package com.viniciusjanner.apiviacep.di;

import com.viniciusjanner.apiviacep.data.repository.CepRepository;
import com.viniciusjanner.apiviacep.data.repository.CepRepositoryImpl;
import com.viniciusjanner.apiviacep.data.source.remote.api.ViaCepApi;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
public abstract class RepositoryModule {

    @Binds
    abstract CepRepository provideCepRepository(CepRepositoryImpl impl);
}

//@Module
//public class RepositoryModule {
//
//    @Provides
//    public CepRepository provideCepRepository(ViaCepApi viaCepApi) {
//        return new CepRepositoryImpl(viaCepApi);
//    }
//}
