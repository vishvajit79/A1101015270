package com.example.vishv.a1101015270;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class RestaurantListActivity extends  Activity {

    private Spinner spinner;
    private String inputSelect;
    private Map<String, List<String>> food_items;
    private LinearLayout linearLayout;
    private Button button;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        spinner = (Spinner) findViewById(R.id.restaurantList_sp);
        Bundle appData = getIntent().getExtras();
        inputSelect = appData.getString("cuisine_type");
        button = (Button) findViewById(R.id.button);

        assert inputSelect != null;
        switch (inputSelect){
            case "American":
                showSpinner(new String[]{"American Restaurant 1", "American Restaurant 2", "American Restaurant 3"});
                break;
            case "Italian":
                showSpinner(new String[]{"Italian Restaurant 1", "Italian Restaurant 2", "Italian Restaurant 3"});
                break;
            case "Chinese":
                showSpinner(new String[]{"Chinese Restaurant 1", "Chinese Restaurant 2", "Chinese Restaurant 3"});
                break;
            case "Indian":
                showSpinner(new String[]{"Indian Restaurant 1", "Indian Restaurant 2", "Indian Restaurant 3"});
                break;
            case "International":
                showSpinner(new String[]{"International Restaurant 1", "International Restaurant 2", "International Restaurant 3"});
                break;
        }

        food_items = new HashMap<>();
        ArrayList<String> american_1 = new ArrayList<>();
        american_1.add("American 1 Food Item 1");
        american_1.add("American 1 Food Item 2");
        american_1.add("American 1 Food Item 3");
        american_1.add("American 1 Food Item 4");
        food_items.put("American Restaurant 1", american_1);
        ArrayList<String> american_2 = new ArrayList<>();
        american_2.add("American 2 Food Item 1");
        american_2.add("American 2 Food Item 2");
        american_2.add("American 2 Food Item 3");
        american_2.add("American 2 Food Item 4");
        food_items.put("American Restaurant 2", american_2);
        ArrayList<String> american_3 = new ArrayList<>();
        american_3.add("American 3 Food Item 1");
        american_3.add("American 3 Food Item 2");
        american_3.add("American 3 Food Item 3");
        american_3.add("American 3 Food Item 4");
        food_items.put("American Restaurant 3", american_3);
        ArrayList<String> italian_3 = new ArrayList<>();
        italian_3.add("Italian 3 Food Item 1");
        italian_3.add("Italian 3 Food Item 2");
        italian_3.add("Italian 3 Food Item 3");
        italian_3.add("Italian 3 Food Item 4");
        food_items.put("Italian Restaurant 3", italian_3);
        ArrayList<String> italian_2 = new ArrayList<>();
        italian_2.add("Italian 2 Food Item 1");
        italian_2.add("Italian 2 Food Item 2");
        italian_2.add("Italian 2 Food Item 3");
        italian_2.add("Italian 2 Food Item 4");
        food_items.put("Italian Restaurant 2", italian_2);
        ArrayList<String> italian_1 = new ArrayList<>();
        italian_1.add("Italian 1 Food Item 1");
        italian_1.add("Italian 1 Food Item 2");
        italian_1.add("Italian 1 Food Item 3");
        italian_1.add("Italian 1 Food Item 4");
        food_items.put("Italian Restaurant 1", italian_1);
        ArrayList<String> chinese_1 = new ArrayList<>();
        chinese_1.add("chinese 1 Food Item 1");
        chinese_1.add("chinese 1 Food Item 2");
        chinese_1.add("chinese 1 Food Item 3");
        chinese_1.add("chinese 1 Food Item 4");
        food_items.put("Chinese Restaurant 1", chinese_1);
        ArrayList<String> chinese_2 = new ArrayList<>();
        chinese_2.add("chinese 2 Food Item 1");
        chinese_2.add("chinese 2 Food Item 2");
        chinese_2.add("chinese 2 Food Item 3");
        chinese_2.add("chinese 2 Food Item 4");
        food_items.put("Chinese Restaurant 2", chinese_2);
        ArrayList<String> chinese_3 = new ArrayList<>();
        chinese_3.add("chinese 3 Food Item 1");
        chinese_3.add("chinese 3 Food Item 2");
        chinese_3.add("chinese 3 Food Item 3");
        chinese_3.add("chinese 3 Food Item 4");
        food_items.put("Chinese Restaurant 3", chinese_3);
        ArrayList<String> indian_1 = new ArrayList<>();
        indian_1.add("indian 1 Food Item 1");
        indian_1.add("indian 1 Food Item 2");
        indian_1.add("indian 1 Food Item 3");
        indian_1.add("indian 1 Food Item 4");
        food_items.put("Indian Restaurant 1", indian_1);
        ArrayList<String> indian_2 = new ArrayList<>();
        indian_2.add("indian 2 Food Item 1");
        indian_2.add("indian 2 Food Item 2");
        indian_2.add("indian 2 Food Item 3");
        indian_2.add("indian 2 Food Item 4");
        food_items.put("Indian Restaurant 2", indian_2);
        ArrayList<String> indian_3 = new ArrayList<>();
        indian_3.add("indian 3 Food Item 1");
        indian_3.add("indian 3 Food Item 2");
        indian_3.add("indian 3 Food Item 3");
        indian_3.add("indian 3 Food Item 4");
        food_items.put("Indian Restaurant 3", indian_3);
        ArrayList<String> international_1 = new ArrayList<>();
        international_1.add("international 1 Food Item 1");
        international_1.add("international 1 Food Item 2");
        international_1.add("international 1 Food Item 3");
        international_1.add("international 1 Food Item 4");
        food_items.put("International Restaurant 1", international_1);
        ArrayList<String> international_2 = new ArrayList<>();
        international_2.add("international 2 Food Item 1");
        international_2.add("international 2 Food Item 2");
        international_2.add("international 2 Food Item 3");
        international_2.add("international 2 Food Item 4");
        food_items.put("International Restaurant 2", international_2);
        ArrayList<String> international_3 = new ArrayList<>();
        international_3.add("international 3 Food Item 1");
        international_3.add("international 3 Food Item 2");
        international_3.add("international 3 Food Item 3");
        international_3.add("international 3 Food Item 4");
        food_items.put("International Restaurant 3", international_3);

        linearLayout = (LinearLayout) findViewById(R.id.food_ll);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                linearLayout.removeAllViews();
                List<String> foodItemsRestaurant = food_items.get(spinner.getSelectedItem().toString());
                for(String str: foodItemsRestaurant){
                    CheckBox checkBox = new CheckBox(RestaurantListActivity.this);
                    checkBox.setText(str);
                    linearLayout.addView(checkBox);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkSelected()){
                    Toast.makeText(getApplicationContext(), "Please select food items", Toast.LENGTH_LONG).show();
                    return;
                }

                if(spinner.getSelectedItemPosition()!=-1){
                    Intent intent = new Intent(RestaurantListActivity.this, OrderActivity.class);
                    intent.putExtra("selectedRestaurant", spinner.getSelectedItem().toString());
                    intent.putExtra("selectedCuisine", inputSelect);
                    StringBuilder builder = new StringBuilder();
                    for (int i=0; i<linearLayout.getChildCount(); i++){
                        CheckBox checkBox = (CheckBox) linearLayout.getChildAt(i);
                        if (checkBox.isChecked()){
                            builder.append(checkBox.getText()).append("\n");
                        }
                    }
                    intent.putExtra("selectedFood",builder.toString());
                    startActivity(intent);
                }

            }
        });
    }

    private void showSpinner(String[] items){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(RestaurantListActivity.this, android.R.layout.simple_list_item_1, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }

    private boolean checkSelected(){
        for (int i=0; i < linearLayout.getChildCount(); i++){
            if (((CheckBox) linearLayout.getChildAt(i)).isChecked())
                return true;
        }
        return false;
    }
}
