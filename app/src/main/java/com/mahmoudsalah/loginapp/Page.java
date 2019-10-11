package com.mahmoudsalah.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Page extends AppCompatActivity {
  ListView listView;
  ArrayList<String> starName = new ArrayList<>();
  List<star> actors;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        listView = findViewById(R.id.listView);
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,starName);
        final DataQueryBuilder queryBuilder = DataQueryBuilder.create();
        queryBuilder.setSortBy("name dese");
        Backendless.Data.of(star.class).find(new AsyncCallback<List<star>>() {
            @Override
            public void handleResponse(List<star> response) {
                actors = response;
                for (star star : response) {
                    starName.add(star.getName());
                }
                arrayAdapter.notifyDataSetChanged();
                listView.setAdapter(arrayAdapter);
            }

            @Override
            public void handleFault(BackendlessFault fault) {
                Toast.makeText(Page.this, ""+fault.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              Intent intent = new Intent(Page.this,details.class);
              intent.putExtra("name",actors.get(position).getName());
              intent.putExtra("age",actors.get(position).getAge());
              intent.putExtra("image",actors.get(position).getImage());
              startActivity(intent);

          }
      });
    }

}
