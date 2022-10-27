package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }

    /**
     * Gets the number of cities
     * @return count of cities
     */
    public int getCount(){
        return cities.size();
    }

    /**
     * adds a new city to the city list
     * @param city to add
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     * checks if a city is in cities
     * @param city to check
     * @return if city is in
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * removes city from city list
     * @param city to remove
     */
    public void deleteCity(City city) {
        cities.remove(city);
    }

}
