package com.codika.sampleandroidmvp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.Loader;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.codika.androidmvp.activity.BaseMvpActivity;

/**
 * Created by ignacio on 13/06/16.
 */
public class LoginActivity extends BaseMvpActivity<LoginView, LoginPresenter> implements LoginView{

    private LinearLayout formContainer;
    private EditText email;
    private EditText password;
    private Button login;
    private ProgressBar progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        formContainer = (LinearLayout) findViewById(R.id.form_container);

        email = (EditText) findViewById(R.id.email);

        password = (EditText) findViewById(R.id.password);

        login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().login(email.getText().toString(), password.getText().toString());
            }
        });

        progress = (ProgressBar) findViewById(R.id.progress);
    }

    @Override
    public LoginView getMvpView() {
        return this;
    }

    @Override
    public Loader<LoginPresenter> getPresenterLoader() {
        return new LoginLoader(this);
    }

    @Override
    public void showProgress() {
        progress.setVisibility(View.VISIBLE);
        formContainer.setVisibility(View.GONE);
    }

    @Override
    public void hideProgress() {
        progress.setVisibility(View.GONE);
        formContainer.setVisibility(View.VISIBLE);
    }

    @Override
    public void loginSuccess() {
        //Go to next screen
    }

    @Override
    public void showEmptyFields() {
        Toast.makeText(this, "The fields are empty", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showInvalidMail() {
        email.setError("Invalid email");
    }

    @Override
    public void showInvalidPassword() {
        password.setError("Invalid password. Must contain 6 characters");
    }

    @Override
    public void loginError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_LONG).show();
    }
}
