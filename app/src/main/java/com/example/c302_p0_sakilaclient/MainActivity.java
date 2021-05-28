package com.example.c302_p0_sakilaclient;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.*;
import cz.msebera.android.httpclient.*;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvCategories;
    ArrayList<Category> alCategories = new ArrayList<Category>();
        ArrayAdapter<Category> aaCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCategories = (ListView) findViewById(R.id.listViewCategories);
        aaCategories = new ArrayAdapter<Category>(this, android.R.layout.simple_list_item_1, alCategories);
        lvCategories.setAdapter(aaCategories);

        //TODO: Task 1: Consume getCategories.php using AsyncHttpClient
        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2/C302_sakila/getCategories.php", new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                try{
                    // remove this whole line System.out.println("Mathias1" + response);
                    for(int i = 0; i < response.length(); i++) {
                        JSONObject category = (JSONObject) response.get(i);
                        Category c = new Category(category.getInt("category_id"), category.getString("name"));
                        alCategories.add(c);
                    }
                }catch (JSONException e) {

                }
                aaCategories.notifyDataSetChanged();
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String response, Throwable e) {
                // remove this whole method. System.out.println("Mathias" + response);
            }
        });

        lvCategories.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Category c = alCategories.get(i);  // Get the selected Category

            }
        });
    }
}
