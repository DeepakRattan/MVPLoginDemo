package com.example.deepakrattan.mvplogindemo.presenter;

import com.example.deepakrattan.mvplogindemo.model.User;
import com.example.deepakrattan.mvplogindemo.view.ILoginView;

public class LoginPresenter implements ILoginPresenter {
    ILoginView loginView;

    public LoginPresenter(ILoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        // boolean isLoginSuccessful = user.isValidData();
        int loginCode = user.isValidData();
        if (loginCode == 0)
            loginView.onLoginError("Please enter email");
        else if (loginCode == 1)
            loginView.onLoginError("Please enter valid email");
        else if (loginCode == 2)
            loginView.onLoginError("Password length must be greater that 6");
        else
            loginView.onLoginResult("Login Successful");

        /*if (isLoginSuccessful)
            loginView.onLoginResult("Login Successful");
        else
            loginView.onLoginResult("Login error");*/
    }
}
