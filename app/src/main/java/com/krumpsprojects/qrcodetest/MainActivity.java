package com.krumpsprojects.qrcodetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView qrResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrResultTextView = findViewById(R.id.qrResultTextView);
    }

    public void Scan(View view){
        Intent intent = new Intent(this, QRCodeScannerActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Get the QR scan result from QRCodeScannerActivity if available
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("QR_SCAN_RESULT")) {
            String qrResult = intent.getStringExtra("QR_SCAN_RESULT");
            qrResultTextView.setText(qrResult);  // Display the scanned QR code result in a TextView
        }
    }
}