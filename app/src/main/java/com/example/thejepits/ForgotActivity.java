package com.example.thejepits;

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
import android.widget.Toast;

import com.example.thejepits.room.Akun;
import com.example.thejepits.room.AkunDao;
import com.example.thejepits.room.AppDatabase;
import com.example.thejepits.room.RecoveryDatabase;

public class ForgotActivity extends AppCompatActivity {

    private Button btnKode;
    private EditText etEmailRecovery;
    RecoveryDatabase database;
    AkunDao db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);

        etEmailRecovery = findViewById(R.id.etEmailRecovery);
        btnKode = findViewById(R.id.btnKode);

        database = Room.databaseBuilder(this, RecoveryDatabase.class, "mi-database.db")
                .allowMainThreadQueries()
                .build();
        db = database.getRecovery();

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

        btnKode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmailRecovery.getText().toString();

                Akun user = db.getRecovery(email);
                if(user != null) {
                    Intent recovery = new Intent(ForgotActivity.this, RecoveryActivity.class);
                    startActivity(recovery);
                    NotificationCompat.Builder builder = new NotificationCompat.Builder(ForgotActivity.this, "My Notification");
                    builder.setContentTitle("Kode Verifikasi");
                    builder.setContentText("Kode Verifikasi Anda Adalah 34532");
                    builder.setSmallIcon(R.drawable.ic_baseline_account_circle_24);
                    builder.setAutoCancel(true);

                    NotificationManagerCompat managerCompat = NotificationManagerCompat.from(ForgotActivity.this);
                    managerCompat.notify(1, builder.build());
                }
                else{
                    Toast.makeText(ForgotActivity.this, "Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}