package com.viniciusjanner.apiviacep.di;

import com.viniciusjanner.apiviacep.presentation.contract.CepContract;
import com.viniciusjanner.apiviacep.presentation.presenter.CepPresenterImpl;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class PresenterModule {

    @Binds
    abstract CepContract.Presenter provideCepPresenter(CepPresenterImpl impl);
}

//@Module
//public class PresenterModule {
//
//    @Provides
//    public CepContract.Presenter provideCepPresenter(FetchAddressUseCaseImpl fetchAddressUseCase) {
//        return new CepPresenterImpl(fetchAddressUseCase);
//    }
//}
