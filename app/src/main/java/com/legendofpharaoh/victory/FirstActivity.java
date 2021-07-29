package com.legendofpharaoh.victory;

import android.content.Intent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_first);
    }
    public void onClick(View v) {
        Button button = findViewById(v.getId());
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        switch (button.getTag().toString()) {

            case "start" : {
                startActivity(new Intent(this, MainActivity.class));
                finish();
                break;
            }

            case "policy": {
                startActivity(new Intent(this, ActivityPolicy.class));
                finish();
                break;
            }
            case "exit": {
                finish();
                break;
            }

            default:
                break;
        }
    }
}


