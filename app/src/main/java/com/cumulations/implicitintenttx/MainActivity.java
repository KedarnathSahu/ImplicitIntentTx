package com.cumulations.implicitintenttx;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextInputEditText inputEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEditText = findViewById(R.id.editText);
    }

    public void sendMSZ(View view) {

        String data = inputEditText.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, data);
        if(intent.resolveActivity(this.getPackageManager()) != null){
            startActivity(Intent.createChooser(intent,"Send To:"));
        }else {
            Toast.makeText(this, "XXX", Toast.LENGTH_SHORT).show();
        }


    }
}
