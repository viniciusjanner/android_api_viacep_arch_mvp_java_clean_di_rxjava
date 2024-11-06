package com.viniciusjanner.apiviacep.domain.usecase;

import com.viniciusjanner.apiviacep.domain.model.AddressModel;

import io.reactivex.rxjava3.core.Observable;

public interface FetchAddressUseCase extends BaseUseCase<AddressModel, String> {

    public abstract Observable<AddressModel> execute(String cep);
}
