package com.example.reiko.businesscard.Activity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.reiko.businesscard.R;
import com.example.reiko.businesscard.database.DictionaryOpenHelper;
import com.example.reiko.businesscard.database.ExampleContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reiko on 17/04/2017.
 */

public class ListCardActivity extends AppCompatActivity {

    private Button buttonEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_card);
        buttonEdit = (Button)findViewById(R.id.buttonEditCard) ;
        buttonEdit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(), EditCardActivity.class);
                startActivity(intent);
            }
        });


       /* outputText = (TextView) findViewById(R.id.textView1);
        DictionaryOpenHelper helper = new DictionaryOpenHelper(this.getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        String[] projection = {
                ExampleContract.ExampleEntry._ID,
                ExampleContract.ExampleEntry.getColumnNameCategory(),
                ExampleContract.ExampleEntry.getColumnNameWord()
        };

        String sortOrder =
                ExampleContract.ExampleEntry.getColumnNameCategory() + " DESC";

        Cursor cursor = db.query(
                ExampleContract.ExampleEntry.getTableName(),                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause     selection
                null,                            // The values for the WHERE clause    selectionArgs
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );


        List itemIds = new ArrayList<>();
        Log.d("wesh","passe");
        while(cursor.moveToNext()) {
            long itemId = cursor.getLong(cursor.getColumnIndexOrThrow(ExampleContract.ExampleEntry._ID));
            itemIds.add(itemId);
            Log.d("KOUKOUUUUUUUUUUUUUUUU",cursor.getInt(cursor.getColumnIndexOrThrow(ExampleContract.ExampleEntry._ID)) +"");
            Log.d("COUCOUUUUUUUUUUUUUUUU",cursor.getString(cursor.getColumnIndexOrThrow(ExampleContract.ExampleEntry.getColumnNameCategory())));
            Log.d("AAAAAAAAAAAAAAAAAAAAA",cursor.getString(cursor.getColumnIndexOrThrow(ExampleContract.ExampleEntry.getColumnNameWord())));
        }

        cursor.close();*/
    }
}
