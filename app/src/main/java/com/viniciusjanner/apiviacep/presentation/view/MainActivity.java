package com.viniciusjanner.apiviacep.presentation.view;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.viniciusjanner.apiviacep.CepApp;
import com.viniciusjanner.apiviacep.databinding.ActivityMainBinding;
import com.viniciusjanner.apiviacep.domain.model.AddressModel;
import com.viniciusjanner.apiviacep.presentation.contract.CepContract;
import com.viniciusjanner.apiviacep.utils.Utils;

import androidx.core.splashscreen.SplashScreen;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements CepContract.View {

    private static final String TAG_LOG = MainActivity.class.getSimpleName();

    private ActivityMainBinding binding;

    @Inject
    CepContract.Presenter presenter;

    private static final int FLIPPER_CHILD_MESSAGE = 0;
    private static final int FLIPPER_CHILD_SUCCESS = 1;
    private static final int FLIPPER_CHILD_LOADING = 2;

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        initSplashScreen();
        initDagger();
        super.onCreate(savedInstanceState);
        initMainScreen();
        setupListeners();
    }

    @Override
    protected void onStart() {
        super.onStart();
        startPresenter();
    }

    @Override
    protected void onStop() {
        stopPresenter();
        super.onStop();
    }

    private void initDagger() {
        CepApp.getAppComponent().inject(this);
    }

    private void initSplashScreen() {
        try {
            // Splash Screen
            // Instalar a Splash Screen usando a compatibilidade do AndroidX
            SplashScreen.Companion.installSplashScreen(this);
            Thread.sleep(2500L);

        } catch (Exception e) {
            Log.e(TAG_LOG, "onCreate: Error: " + e.getMessage());
            finish();
        }
    }

    private void initMainScreen() {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Utils.openKeyboard(binding.edtCep);
    }

    private void startPresenter() {
        if (presenter != null) {
            presenter.attachView(this);
        }
    }

    private void stopPresenter() {
        if (presenter != null) {
            presenter.detachView();
        }
    }

    private void setupListeners() {
        binding.btnBuscar.setOnClickListener(v -> fetchAddress());

        binding.edtCep.setOnEditorActionListener((TextView v, int actionId, KeyEvent event) -> {
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                fetchAddress();
                return true;
            }
            return false;
        });

        binding.includeContentResult.iconShare.setOnClickListener(v -> presenter.shareAddress());

        binding.includeContentResult.iconCopy.setOnClickListener(v -> presenter.copyAddress());
    }

    private String getInputCep() {
        return binding.edtCep.getText().toString().trim();
    }

    private void fetchAddress() {
        Utils.closeKeyboard(binding.edtCep);
        presenter.fetchAddress(getInputCep());
    }

    @Override
    public void showLoading() {
        binding.btnBuscar.setEnabled(false);
        binding.viewFlipper.setDisplayedChild(FLIPPER_CHILD_LOADING);
    }

    @Override
    public void hideLoading() {
        binding.btnBuscar.setEnabled(true);
    }

    @Override
    public void displayAddress(AddressModel addressModel) {
        binding.viewFlipper.setDisplayedChild(FLIPPER_CHILD_SUCCESS);
        binding.includeContentResult.txtResult.setText(
            addressModel.formatAddress()
        );
    }

    @Override
    public void displayError(String message) {
        binding.viewFlipper.setDisplayedChild(FLIPPER_CHILD_MESSAGE);
        binding.messageResult.setText(message);
    }
}
