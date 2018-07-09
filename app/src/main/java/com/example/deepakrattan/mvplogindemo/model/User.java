package com.example.deepakrattan.mvplogindemo.model;

import android.text.TextUtils;
import android.util.Patterns;


public class User implements IUser {

    String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        /*This method will return
        0 if email is empty
        1 if email pattern is not matched
        2 if  password <=6
        -1 if credentials are valid
        */

        if (TextUtils.isEmpty(email))
            return 0;
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1;
        else if (password.length() <= 6)
            return 2;
        else
            return -1;


    }

    // return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches() && password.length()>6 ;
}

