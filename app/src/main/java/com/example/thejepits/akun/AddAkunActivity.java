package com.example.thejepits.akun;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.room.Room;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.thejepits.LoginActivity;
import com.example.thejepits.R;
import com.example.thejepits.room.Akun;
import com.example.thejepits.room.AkunDao;
import com.example.thejepits.room.AppDatabase;

public class AddAkunActivity extends AppCompatActivity {

    private ImageButton btnBacktoLogin;
    private Button btnDaftar;
    private EditText etEmailR, etPasswordR, etPasswordRetype;
    private AkunDao akunDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_akun);

        btnBacktoLogin = findViewById(R.id.btnBacktoLogin);
        btnDaftar = findViewById(R.id.btnDaftar);

        etEmailR = findViewById(R.id.etEmailR);
        etPasswordR = findViewById(R.id.etPasswordR);
        etPasswordRetype = findViewById(R.id.etPasswordRetypeR);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btnBacktoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backtoLogin = new Intent(AddAkunActivity.this, LoginActivity.class);
                startActivity(backtoLogin);
            }
        });

        akunDao = Room.databaseBuilder(this, AppDatabase.class, "mi-database.db").allowMainThreadQueries()
                .build().getUserDao();

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = etEmailR.getText().toString().trim();
                String password = etPasswordR.getText().toString().trim();
                String passwordretype = etPasswordRetype.getText().toString().trim();

//                NotificationCompat.Builder builder = new NotificationCompat.Builder(AddAkunActivity.this, "My Notification");
//                builder.setContentTitle("Ayang NgeChat NICH....");
//                builder.setContentText("Tapi Bo'ong Awokwokwokwok");
//                builder.setSmallIcon(R.drawable.ic_launcher_background);
//                builder.setAutoCancel(true);
//
//                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(AddAkunActivity.this);
//                managerCompat.notify(1, builder.build());

                if (password.equals(passwordretype)) {
                    Akun user = new Akun(email, password);
                    akunDao.insertAll(user);
                    Intent moveToLogin = new Intent(AddAkunActivity.this, LoginActivity.class);
                    startActivity(moveToLogin);

                } else {
                    Toast.makeText(AddAkunActivity.this, "Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}