package com.viniciusjanner.apiviacep.domain.usecase;

import com.viniciusjanner.apiviacep.domain.model.AddressModel;
import com.viniciusjanner.apiviacep.data.repository.CepRepository;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class FetchAddressUseCaseImpl implements FetchAddressUseCase {

    private final CepRepository repository;

    @Inject
    public FetchAddressUseCaseImpl(CepRepository repository) {
        this.repository = repository;
    }

    @Override
    public Observable<AddressModel> execute(String cep) {
        return repository.getAddressByCep(cep);
    }
}
