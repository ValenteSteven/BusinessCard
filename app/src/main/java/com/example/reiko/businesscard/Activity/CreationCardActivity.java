package com.example.reiko.businesscard.Activity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.reiko.businesscard.R;
import com.example.reiko.businesscard.database.DictionaryOpenHelper;
import com.example.reiko.businesscard.database.ExampleContract;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.ArrayList;
import java.util.List;

public class CreationCardActivity  extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private EditText editTextName;
    private EditText editTextSurName;
    private EditText editTextAdress;
    private EditText editTextMail;
    private EditText editTextFunction;
    private EditText editTextPhone;
    private EditText editTextCompagny;
    private EditText editTextWebSite;
    private String EditTextValue ;
    private Thread thread ;
    private final static int QRcodeWidth = 500 ;
    private Bitmap bitmap ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creation_card);


        Intent intent = getIntent();

        imageView = (ImageView)findViewById(R.id.imageView);
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextSurName = (EditText)findViewById(R.id.editTextsurname);
        editTextAdress = (EditText)findViewById(R.id.editTextAdress);
        editTextMail = (EditText)findViewById(R.id.editTextEmail);
        editTextFunction = (EditText)findViewById(R.id.editTextFunction);
        editTextPhone = (EditText)findViewById(R.id.editTextPhoneNumber);
        editTextCompagny = (EditText)findViewById(R.id.editTextCompanyName);
        editTextPhone = (EditText)findViewById(R.id.editTextPhoneNumber);
        editTextWebSite = (EditText)findViewById(R.id.editTextWebsite);

        button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditTextValue = editTextName.getText().toString() + "\n" +
                        editTextSurName.getText().toString() +  "\n" +
                        editTextAdress.getText().toString() + "\n" +
                        editTextMail.getText().toString() + "\n" +
                        editTextFunction.getText().toString() + "\n" +
                        editTextPhone.getText().toString() + "\n" +
                        editTextCompagny.getText().toString() + "\n" +
                        editTextPhone.getText().toString() + "\n" +
                        editTextWebSite.getText().toString();

                try {
                    bitmap = TextToImageEncode(EditTextValue);

                    imageView.setImageBitmap(bitmap);

                } catch (WriterException e) {
                    e.printStackTrace();
                }

            }
        });

        DictionaryOpenHelper helper = new DictionaryOpenHelper(this.getApplicationContext());
        SQLiteDatabase db = helper.getReadableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put("category","caca");
        contentValues.put("word","monsieur");

        long newRowId = db.insert(ExampleContract.ExampleEntry.getTableName(),null,contentValues);

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

        cursor.close();


    }


    Bitmap TextToImageEncode(String Value) throws WriterException {
        BitMatrix bitMatrix;
        try {
            bitMatrix = new MultiFormatWriter().encode(
                    Value,
                    BarcodeFormat.DATA_MATRIX.QR_CODE,
                    QRcodeWidth, QRcodeWidth, null
            );

        } catch (IllegalArgumentException Illegalargumentexception) {

            return null;
        }
        int bitMatrixWidth = bitMatrix.getWidth();

        int bitMatrixHeight = bitMatrix.getHeight();

        int[] pixels = new int[bitMatrixWidth * bitMatrixHeight];

        for (int y = 0; y < bitMatrixHeight; y++) {
            int offset = y * bitMatrixWidth;

            for (int x = 0; x < bitMatrixWidth; x++) {

                pixels[offset + x] = bitMatrix.get(x, y) ?
                        getResources().getColor(R.color.QRCodeBlackColor):getResources().getColor(R.color.QRCodeWhiteColor);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(bitMatrixWidth, bitMatrixHeight, Bitmap.Config.ARGB_4444);

        bitmap.setPixels(pixels, 0, 500, 0, 0, bitMatrixWidth, bitMatrixHeight);
        return bitmap;
    }
}

