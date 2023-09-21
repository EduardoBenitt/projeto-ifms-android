package com.example.projeto_ifms_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edSenha, edEmail;
    Button btLogin;
    TextView esqSenha, criaUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btLogin = findViewById(R.id.botaoLogin);

        edEmail = findViewById(R.id.EditTextEmail);
        edSenha = findViewById(R.id.EditTextSenha);

        esqSenha = findViewById(R.id.tvEsqueciSenha);
        criaUser = findViewById(R.id.tvCriaUser);

        btLogin.setOnClickListener(this);
        esqSenha.setOnClickListener(this);
        criaUser.setOnClickListener(this);


    }

    public void onClick(View view) {
        String emailDigitado = edEmail.getText().toString();
        String senhaDigitada = edSenha.getText().toString();


        if (emailDigitado.equals("") && senhaDigitada.equals("")) {
            edEmail.setError("Campo vazio");
            edSenha.setError("Campo vazio");
        } else if (emailDigitado.equals("")) {
            edEmail.setError("Campo vazio");
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailDigitado).matches()) {
            edEmail.setError("E-mail inválido");
        } else if (senhaDigitada.equals("")) {
            edSenha.setError("Campo vazio");
        }else {
            String valoresDigitados = "E-mail: " + emailDigitado + ", Senha: " + senhaDigitada;
            Log.e("valores: ", valoresDigitados);
            Toast.makeText(getApplicationContext(), "Usuário Logado", Toast.LENGTH_SHORT).show();
        }

    }

}

