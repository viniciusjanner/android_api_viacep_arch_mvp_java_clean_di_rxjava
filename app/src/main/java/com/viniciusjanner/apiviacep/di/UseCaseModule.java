package com.viniciusjanner.apiviacep.di;

import com.viniciusjanner.apiviacep.domain.usecase.FetchAddressUseCase;
import com.viniciusjanner.apiviacep.domain.usecase.FetchAddressUseCaseImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class UseCaseModule {

    @Binds
    abstract FetchAddressUseCase provideFetchAddressUseCase(FetchAddressUseCaseImpl impl);
}

//@Module
//public class UseCaseModule {
//
//    @Provides
//    public FetchAddressUseCaseImpl provideFetchAddressUseCase(CepRepository cepRepository) {
//        return new FetchAddressUseCaseImpl(cepRepository);
//    }
//}
