package com.example.reiko.businesscard.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.reiko.businesscard.R;
import com.example.reiko.businesscard.SMS.SmsActivity;

public class MainActivity extends AppCompatActivity {

    Button buttonCreateCard ;
    Button buttonSendCard;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreateCard = (Button)findViewById(R.id.buttonCreateCard);
        buttonSendCard = (Button)findViewById(R.id.buttonSendCard);


        buttonCreateCard .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), CreationCardActivity.class);
                startActivity(intent);
                }
        });

        buttonSendCard .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SmsActivity.class);
                startActivity(intent);
            }
        });
    }
}
