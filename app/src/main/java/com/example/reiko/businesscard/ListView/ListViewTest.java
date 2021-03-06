package com.example.reiko.businesscard.ListView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.reiko.businesscard.R;

import java.util.ArrayList;
import java.util.List;

public class ListViewTest extends AppCompatActivity {

    private ListView myListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        myListView = (ListView) findViewById(R.id.testListView);
        afficherListeElements();
    }

    private void afficherListeElements(){
        List<ElementListView> elementListViews = genererElements();
        ElementAdapter adapter = new ElementAdapter(ListViewTest.this, elementListViews);
        myListView.setAdapter(adapter);
    }

    private List<ElementListView> genererElements(){
        List<ElementListView> newElementsList = new ArrayList<>();
        newElementsList.add(new ElementListView(Color.BLACK, "Florent", "Mon premier tweet !"));
        newElementsList.add(new ElementListView(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        newElementsList.add(new ElementListView(Color.GREEN, "Logan", "Que c'est beau..."));
        newElementsList.add(new ElementListView(Color.RED, "Mathieu", "Il est quelle heure ??"));
        newElementsList.add(new ElementListView(Color.GRAY, "Willy", "On y est presque"));
        newElementsList.add(new ElementListView(Color.BLACK, "Florent", "Mon premier tweet !"));
        newElementsList.add(new ElementListView(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        newElementsList.add(new ElementListView(Color.GREEN, "Logan", "Que c'est beau..."));
        newElementsList.add(new ElementListView(Color.RED, "Mathieu", "Il est quelle heure ??"));
        newElementsList.add(new ElementListView(Color.GRAY, "Willy", "On y est presque"));
        newElementsList.add(new ElementListView(Color.BLACK, "Florent", "Mon premier tweet !"));
        newElementsList.add(new ElementListView(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        newElementsList.add(new ElementListView(Color.GREEN, "Logan", "Que c'est beau..."));
        newElementsList.add(new ElementListView(Color.RED, "Mathieu", "Il est quelle heure ??"));
        newElementsList.add(new ElementListView(Color.GRAY, "Willy", "On y est presque"));
        newElementsList.add(new ElementListView(Color.BLACK, "Florent", "Mon premier tweet !"));
        newElementsList.add(new ElementListView(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        newElementsList.add(new ElementListView(Color.GREEN, "Logan", "Que c'est beau..."));
        newElementsList.add(new ElementListView(Color.RED, "Mathieu", "Il est quelle heure ??"));
        newElementsList.add(new ElementListView(Color.GRAY, "Willy", "On y est presque"));
        newElementsList.add(new ElementListView(Color.BLACK, "Florent", "Mon premier tweet !"));
        newElementsList.add(new ElementListView(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        newElementsList.add(new ElementListView(Color.GREEN, "Logan", "Que c'est beau..."));
        newElementsList.add(new ElementListView(Color.RED, "Mathieu", "Il est quelle heure ??"));
        newElementsList.add(new ElementListView(Color.GRAY, "Willy", "On y est presque"));
        newElementsList.add(new ElementListView(Color.BLACK, "Florent", "Mon premier tweet !"));
        newElementsList.add(new ElementListView(Color.BLUE, "Kevin", "C'est ici que ça se passe !"));
        newElementsList.add(new ElementListView(Color.GREEN, "Logan", "Que c'est beau..."));
        newElementsList.add(new ElementListView(Color.RED, "Mathieu", "Il est quelle heure ??"));
        newElementsList.add(new ElementListView(Color.GRAY, "Willy", "On y est presque"));
        return newElementsList;
    }

}
