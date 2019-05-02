package com.example.loginscreen;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edtLogin;
    private EditText edtPassword;
    private Button btnLogar;
    private final String CorrectLogin = "Matheus";
    private final String CorrectPassword = "123";
    private AlertDialog.Builder builder;
    private AlertDialog alerta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtLogin = findViewById(R.id.edtLogin);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogar = findViewById(R.id.btnLogin);
        builder = new AlertDialog.Builder(this);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidaLogin();
            }
        });
    }

    public void ValidaLogin(){
        String Login = edtLogin.getText().toString();
        String Password = edtPassword.getText().toString();

        if(Login.equals(CorrectLogin) && Password.equals(CorrectPassword)){
            builder.setTitle("Verificação de Login:");
            builder.setMessage("LOGIN EFETUADO COM SUCESSO!!!");
            alerta = builder.create();
            alerta.show();

            new android.os.Handler().postDelayed(
            new Runnable() {
                public void run() {
                    alerta.cancel();
                }
            },
            2000);
        }
        else{
            builder.setTitle("Verificação de Login:");
            builder.setMessage("LOGIN INVÁLIDO!!!");
            alerta = builder.create();
            alerta.show();

            new android.os.Handler().postDelayed(
            new Runnable() {
                public void run() {
                    alerta.cancel();
                }
            },
            2000);
        }
    }
}
