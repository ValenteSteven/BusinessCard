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

public class EditCardActivity extends AppCompatActivity {
    private Button buttonEditOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_card);
        buttonEditOK = (Button) findViewById(R.id.buttonEditReturnMenu);

        buttonEditOK .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }



}
