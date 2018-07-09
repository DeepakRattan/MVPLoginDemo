package com.example.deepakrattan.mvplogindemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.deepakrattan.mvplogindemo.presenter.LoginPresenter;
import com.example.deepakrattan.mvplogindemo.view.ILoginView;

public class LoginActivity extends AppCompatActivity implements ILoginView {
    EditText edtEmail, edtPassword;
    TextView txtLogin;


    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        txtLogin = findViewById(R.id.txtLogin);

        loginPresenter = new LoginPresenter(this);
        txtLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                loginPresenter.onLogin(email, password);
            }
        });
    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

    }
}
