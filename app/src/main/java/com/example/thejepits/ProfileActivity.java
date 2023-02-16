package com.example.thejepits;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.thejepits.room.AkunDao;
import com.example.thejepits.room.DataDatabase;
import com.example.thejepits.room.UserData;
import com.example.thejepits.room.UserDataDao;
import com.example.thejepits.util.PreferencesHelper;


public class ProfileActivity extends AppCompatActivity {

    ImageButton btnBacktoHome;
    TextView tvEmail;
    Button btnSimpanProfile;
    EditText etNama, etAlamat;
    private UserDataDao dataDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnBacktoHome = findViewById(R.id.btnBacktoHome);
        tvEmail = findViewById(R.id.tvEmail);
        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        btnSimpanProfile = findViewById(R.id.btnSimpanProfile);

        String emailprofile = getIntent().getStringExtra("email");
        tvEmail.setText(emailprofile);

        btnBacktoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backtohome = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(backtohome);
            }
        });
        dataDao = Room.databaseBuilder(this, DataDatabase.class, "data-database.db").allowMainThreadQueries().build().getDataDao();
        btnSimpanProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = etNama.getText().toString().trim();
                String alamat = etAlamat.getText().toString().trim();
                UserData simpan = new UserData(nama, alamat);
                dataDao.insertAllData(simpan);
                Toast.makeText(ProfileActivity.this, "Data Telah Tersimpan", Toast.LENGTH_SHORT).show();
            }
        });
    }
}