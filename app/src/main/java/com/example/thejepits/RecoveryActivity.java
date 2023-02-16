package com.example.thejepits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RecoveryActivity extends AppCompatActivity {

    private EditText etKodeRecovery;
    private Button btnRecovery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recovery);

        etKodeRecovery = findViewById(R.id.etKodeRecovery);
        btnRecovery = findViewById(R.id.btnRecovery);

        int koderecovery = 34532;
        btnRecovery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int kode = Integer.parseInt(etKodeRecovery.getText().toString().trim());

                if(kode == koderecovery){
                    Intent i = new Intent(RecoveryActivity.this, HomeActivity.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(RecoveryActivity.this, "Masukan Data Dengan Benar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}