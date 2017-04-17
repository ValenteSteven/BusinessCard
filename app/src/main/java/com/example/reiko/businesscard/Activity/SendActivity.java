package com.example.reiko.businesscard.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.reiko.businesscard.R;

/**
 * Created by reiko on 17/04/2017.
 */

public class SendActivity extends AppCompatActivity {

    private Button sendChoose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
        sendChoose = (Button)findViewById(R.id.buttonSendChooseCard);

        sendChoose .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SendChooseCardActivity.class);
                startActivity(intent);
            }
        });
    }
}
