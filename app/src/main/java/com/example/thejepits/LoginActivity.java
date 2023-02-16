package com.example.thejepits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thejepits.akun.AddAkunActivity;
import com.example.thejepits.room.Akun;
import com.example.thejepits.room.AkunDao;
import com.example.thejepits.room.AppDatabase;
import com.example.thejepits.util.PreferencesHelper;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private TextView btnRegister, btnLupa;
    private EditText etEmail;
    private EditText etPassword;

    PreferencesHelper preferencesHelper;
    AkunDao db;
    AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnLupa = findViewById(R.id.btnLupa);
        btnRegister = findViewById(R.id.btnRegister);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);

        database = Room.databaseBuilder(this, AppDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();
        db = database.getUserDao();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                Akun user = db.getUser(email, password);
               if (user != null) {
                   Intent i = new Intent(LoginActivity.this, HomeActivity.class);
                   i.putExtra("User", user);
                   startActivity(i);
                   finish();
               }
               else {
                   Toast.makeText(LoginActivity.this, "Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();
               }
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent = new Intent(LoginActivity.this, AddAkunActivity.class);
                startActivity(secondIntent);
            }
        });
        btnLupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondIntent = new Intent(LoginActivity.this, ForgotActivity.class);
                startActivity(secondIntent);
            }
        });

    }
}