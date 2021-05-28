package com.example.c302_p0_sakilaclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class FilmAdapter  {

    ArrayList<Film> films;
    private Context context;
    TextView tvTitle, tvYear, tvRating;


    public FilmAdapter(Context context, int resource, ArrayList<Film> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        films = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.film_list, parent, false);
        // Get the TextView object
        tvTitle = (TextView) rowView.findViewById(R.id.tvTitle);
        tvYear = (TextView) rowView.findViewById(R.id.tvYear);
        tvRating = (TextView) rowView.findViewById(R.id.tvRating);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Film currentFilm = films.get(position);
        // Set the TextView to show the food

        tvTitle.setText(currentFilm.getTitle());
        tvYear.setText(currentFilm.getYear());
        tvRating.setText(currentFilm.getRating());
        // Set the image to star or nostar accordingly
        // Return the nicely done up View to the ListView
        return rowView;
    }
}

