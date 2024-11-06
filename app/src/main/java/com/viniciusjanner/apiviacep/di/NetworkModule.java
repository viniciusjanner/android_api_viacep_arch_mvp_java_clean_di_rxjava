package com.viniciusjanner.apiviacep.di;

import com.viniciusjanner.apiviacep.data.source.remote.api.ViaCepApi;
import com.viniciusjanner.apiviacep.data.source.remote.network.RetrofitClient;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

//@Module
//public abstract class NetworkModule {
//
//    @Provides
//    static Retrofit provideRetrofit() {
//        return RetrofitClient.getRetrofitInstance();
//    }
//
//    @Binds
//    abstract ViaCepApi provideViaCepApi(ViaCepApi impl);
//}

@Module
public class NetworkModule {

    @Provides
    public Retrofit provideRetrofit() {
        return RetrofitClient.getRetrofitInstance();
    }

    @Provides
    public ViaCepApi provideViaCepApi(Retrofit retrofit) {
        return retrofit.create(ViaCepApi.class);
    }
}
