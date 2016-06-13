package com.codika.sampleandroidmvp;

import android.os.AsyncTask;

import com.codika.androidmvp.presenter.BasePresenter;

/**
 * Created by ignacio on 13/06/16.
 */
public class LoginPresenter extends BasePresenter<LoginView> {

    private boolean isLoading = false;

    @Override
    public void onAttachView(LoginView view) {
        super.onAttachView(view);
        if(isLoading){
            getView().showProgress();
        }
    }

    public void login(String email, String password){

        if(isEmptyFields(email, password)){
            getView().showEmptyFields();
            return;
        }

        if(!isValidEmail(email)){
            getView().showInvalidMail();
            return;
        }

        if(!isValidPassword(password)){
            getView().showInvalidPassword();
            return;
        }

        new LoginTask().execute(email, password);
    }

    private boolean isEmptyFields(String email, String password){
        return email.trim().length() == 0 || password.trim().length() == 0;
    }

    private boolean isValidEmail(String email){
        return ValidationUtils.isValidEmail(email.trim());
    }

    private boolean isValidPassword(String password){
        return password.trim().length() > 5;
    }

    private class LoginTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            isLoading = true;

            if(isViewAttached())
                getView().showProgress();
        }

        @Override
        protected Boolean doInBackground(String... strings) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean success) {
            super.onPostExecute(success);
            isLoading = false;

            if(!isViewAttached())
                return;

            getView().hideProgress();

            if(success){
                getView().loginSuccess();
            }else{
                getView().loginError("Login error");
            }
        }
    }

}
