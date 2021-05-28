package com.example.c302_p0_sakilaclient;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class ViewFilmsActivity extends AppCompatActivity {

    ListView lvFilms;
    TextView tvCategory;
    ArrayList<Film> alFilms = new ArrayList<Film>();
    ArrayAdapter<Film> aaFilms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvFilms = findViewById(R.id.lvFilms);
        tvCategory = findViewById(R.id.tvCategory);
        aaFilms = new ArrayAdapter<Film>(this, android.R.layout.simple_list_item_1, alFilms);
        lvFilms.setAdapter(aaFilms);

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://10.0.2.2/C302_sakila/getFilms.php", new JsonHttpResponseHandler(){

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {

                try{
                    // remove this whole line System.out.println("Mathias1" + response);
                    for(int i = 0; i < response.length(); i++) {
                        JSONObject film = (JSONObject) response.get(i);
                        Film f = new Film(film.getString("title"), film.getInt("release_year"), film.getString("rating"));
                        alFilms.add(f);
                    }
                }catch (JSONException e) {

                }
                aaFilms.notifyDataSetChanged();
            }
        });
    }
}
