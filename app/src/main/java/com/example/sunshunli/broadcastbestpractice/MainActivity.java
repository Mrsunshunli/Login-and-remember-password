package com.example.sunshunli.broadcastbestpractice;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button forceoffline = findViewById(R.id.fore_offlinen);
        forceoffline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.broadcastpractice.FORCE_OFFLINE");
                sendBroadcast(intent);
            }
        });
    }
}
