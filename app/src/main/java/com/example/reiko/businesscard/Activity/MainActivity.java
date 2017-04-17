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
    Button buttonContact;
    Button buttonLoad;
    Button buttonImport;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCreateCard = (Button)findViewById(R.id.buttonCreateCard);
        buttonSendCard = (Button)findViewById(R.id.buttonSendCard);
        buttonContact = (Button)findViewById(R.id.buttonMyContact);
        buttonLoad = (Button)findViewById(R.id.buttonLoadCard);
        buttonImport = (Button)findViewById(R.id.buttonImportCard);


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

        buttonContact .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ContactActivity.class);
                startActivity(intent);
            }
        });
        buttonLoad.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    Intent intent = new Intent(getApplicationContext(), ListCardActivity.class);
                    startActivity(intent);
                }
        });
        buttonImport.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), ImportActivity.class);
                startActivity(intent);
            }
        });
    }
}
