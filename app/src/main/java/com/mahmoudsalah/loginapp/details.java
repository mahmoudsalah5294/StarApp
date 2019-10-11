package com.mahmoudsalah.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class details extends AppCompatActivity {

    ImageView imageView,fullscreenImage;
    TextView nameText,ageText;
    String urlImage;
    ListView listView;
    ArrayList<String> films = new ArrayList<>();
    ArrayAdapter<String> adapter;
    boolean fullscreen = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        fullscreenImage = findViewById(R.id.fullscreenImage);
        fullscreenImage.setVisibility(View.INVISIBLE);
        imageView = findViewById(R.id.imageView);
        nameText = findViewById(R.id.nameText);
        ageText = findViewById(R.id.ageText);
        Intent intent = getIntent();
        nameText.setText(intent.getStringExtra("name"));
        ageText.setText(intent.getStringExtra("age"));
        urlImage = intent.getStringExtra("image");

        Picasso.get().load(urlImage).into(imageView);
        Picasso.get().load(urlImage).into(fullscreenImage);
        DataQueryBuilder builder = DataQueryBuilder.create();
        builder.setWhereClause("stars like '%"+intent.getStringExtra("name")+"%'");
        Backendless.Data.of(film.class).find(builder, new AsyncCallback<List<film>>() {
            @Override
            public void handleResponse(List<film> response) {
                for (film film : response) {
                    films.add(film.getTitle());
                    adapter.notifyDataSetChanged();
                }

            }

            @Override
            public void handleFault(BackendlessFault fault) {

            }
        });
        listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,films);
        listView.setAdapter(adapter);



    }

    public void fullScreen(View view) {
        if (fullscreen == false) {
            fullscreenImage.setVisibility(View.VISIBLE);
            fullscreen = true;
        } else {
            fullscreenImage.setVisibility(View.INVISIBLE);
            fullscreen = false;
        }
    }
}
