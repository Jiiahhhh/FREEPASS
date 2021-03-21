package com.ilal.freepass21;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class LandingPage extends AppCompatActivity {

    private static final int SPLASH_SCREEN = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        new Handler().postDelayed(() -> {
            Intent intent = new Intent(LandingPage.this, DashboardPage.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
            ProgressDialog dialog = ProgressDialog.show(this, "Menyiapkan Freepass", "Harap Tunggu...", true);
            new Thread(() -> {
                try {
                    Thread.sleep(3000);
                    dialog.dismiss();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            startActivity(intent);
            finish();
        }, SPLASH_SCREEN);
    }
}