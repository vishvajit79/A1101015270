package com.example.vishv.a1101015270;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;


public class RestaurantListActivity extends  Activity {

    private Spinner spinner;
    private ListView listView;
    private String inputSelect;
    private int showSpinner;
    private Button button;

    String[] americanRestaurant1 = {"American 1 Food Item 1", "American 1 Food Item 2", "American 1 Food Item 3", "American 1 Food Item 4"};
    String[] americanRestaurant2 = {"American 2 Food Item 1", "American 2 Food Item 2", "American 2 Food Item 3", "American 2 Food Item 4"};
    String[] americanRestaurant3 = {"American 3 Food Item 1", "American 3 Food Item 2", "American 3 Food Item 3", "American 3 Food Item 4"};
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);

        Bundle appData = getIntent().getExtras();
        inputSelect = appData.getString("cuisine_type");

        assert inputSelect != null;
        switch (inputSelect){
            case "American":
                showSpinner = R.array.american_restaurant_list;
                break;
            case "Italian":
                showSpinner = R.array.italian_restaurant_list;
                break;
            case "Chinese":
                showSpinner = R.array.chinese_restaurant_list;
                break;
            case "Indian":
                showSpinner = R.array.indian_restaurant_list;
                break;
            case "International":
                showSpinner = R.array.international_restaurant_list;
                break;
        }

        spinner = (Spinner) findViewById(R.id.restaurantList_sp);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, showSpinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String name_promotion_selected = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        ArrayAdapter adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, americanRestaurant1);
        listView = (ListView) findViewById(R.id.restaurantList_lv);
        listView.setAdapter(adapter1);

        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OrderActivity.class);
                startActivity(intent);
            }
        });
    }
}
