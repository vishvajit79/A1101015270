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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_list);
        spinner = (Spinner) findViewById(R.id.restaurantList_sp);
        Bundle appData = getIntent().getExtras();
        inputSelect = appData.getString("cuisine_type");
        Button button = (Button) findViewById(R.id.button);

        assert inputSelect != null;
        switch (inputSelect){
            case "American":
                showSpinner(new String[]{"A&W Restaurants", "America's Incredible Pizza Company", "Black Angus Steakhouse"});
                break;
            case "Italian":
                showSpinner(new String[]{"Luigi's Lasagne", "Taste of Rome", "Venice Italian Cuisine"});
                break;
            case "Chinese":
                showSpinner(new String[]{"Asian Legend", "Asian Town", "Hakkasan"});
                break;
            case "Indian":
                showSpinner(new String[]{"Little India Restaurant", "Amaya Express", "Brar's - Trinity Common"});
                break;
            case "International":
                showSpinner(new String[]{"Papa John's Pizza", "Paris Baguette", "Perkins Restaurant & Bakery"});
                break;
        }

        food_items = new HashMap<>();
        ArrayList<String> american_1 = new ArrayList<>();
        american_1.add("Bacon & Egg");
        american_1.add("Breakfast Wrap");
        american_1.add("Omelette's");
        american_1.add("Hash Brown");
        food_items.put("A&W Restaurants", american_1);
        ArrayList<String> american_2 = new ArrayList<>();
        american_2.add("Pepperoni");
        american_2.add("Canadian Bacon");
        american_2.add("Beef");
        american_2.add("BBQ Chicken");
        food_items.put("America's Incredible Pizza Company", american_2);
        ArrayList<String> american_3 = new ArrayList<>();
        american_3.add("Classics");
        american_3.add("Ribs");
        american_3.add("Steak & Sea Food");
        american_3.add("Salads");
        food_items.put("Black Angus Steakhouse", american_3);
        ArrayList<String> italian_3 = new ArrayList<>();
        italian_3.add("Breadsticks");
        italian_3.add("Capocollo");
        italian_3.add("Nervetti – pressed beef cartilage seasoned with onions");
        italian_3.add("Culatello");
        food_items.put("Venice Italian Cuisine", italian_3);
        ArrayList<String> italian_2 = new ArrayList<>();
        italian_2.add("Bresaola");
        italian_2.add("Strolghino");
        italian_2.add("Tortano");
        italian_2.add("Vezione verro");
        food_items.put("Taste of Rome", italian_2);
        ArrayList<String> italian_1 = new ArrayList<>();
        italian_1.add("Verdure in pinzimonio");
        italian_1.add("Insalata caprese");
        italian_1.add("Crostini – means \"little toast\" in Italian");
        italian_1.add("Curried braised rabbit stew");
        food_items.put("Luigi's Lasagne", italian_1);
        ArrayList<String> chinese_1 = new ArrayList<>();
        chinese_1.add("Chinese noodles");
        chinese_1.add("Chow mein");
        chinese_1.add("Noodle soup");
        chinese_1.add("Zhajiangmian");
        food_items.put("Asian Legend", chinese_1);
        ArrayList<String> chinese_2 = new ArrayList<>();
        chinese_2.add("Lamian");
        chinese_2.add("White rice");
        chinese_2.add("Braised pork");
        chinese_2.add("Char siu");
        food_items.put("Asian Town", chinese_2);
        ArrayList<String> chinese_3 = new ArrayList<>();
        chinese_3.add("Peking Duck");
        chinese_3.add("Buddha's delight");
        chinese_3.add("Baozi");
        chinese_3.add("Fried rice");
        food_items.put("Hakkasan", chinese_3);
        ArrayList<String> indian_1 = new ArrayList<>();
        indian_1.add("Aloo baingan masala");
        indian_1.add("Aloo ki tikki");
        indian_1.add("Amriti with rabdi");
        indian_1.add("Amritsari kulcha");
        food_items.put("Little India Restaurant", indian_1);
        ArrayList<String> indian_2 = new ArrayList<>();
        indian_2.add("Biryani");
        indian_2.add("Butter chicken");
        indian_2.add("Chapati");
        indian_2.add("Chana masala");
        food_items.put("Amaya Express", indian_2);
        ArrayList<String> indian_3 = new ArrayList<>();
        indian_3.add("Chicken Tikka masala");
        indian_3.add("Dal makhani (kali dal)");
        indian_3.add("Dum aloo");
        indian_3.add("Gajar ka halwa");
        food_items.put("Brar's - Trinity Common", indian_3);
        ArrayList<String> international_1 = new ArrayList<>();
        international_1.add("\"Blanketed\" Eggplant");
        international_1.add("\"Bow-Tie\" Pasta with Zucchini");
        international_1.add("\"California Roll\" Salad");
        international_1.add("\"Cocotte\" of Vegetables");
        food_items.put("Papa John's Pizza", international_1);
        ArrayList<String> international_2 = new ArrayList<>();
        international_2.add("\"Paella\" Fried Rice");
        international_2.add("\"Seethed\" Mussels with Parsley and Vinegar");
        international_2.add("Tuna");
        international_2.add("Twice Boiled");
        food_items.put("Paris Baguette", international_2);
        ArrayList<String> international_3 = new ArrayList<>();
        international_3.add("Acapulo Chicken");
        international_3.add("Indian Corn");
        international_3.add("Aguachile de Camarón (Shrimp Cooked in Lime and Chile) Aguachile de Camarón");
        international_3.add("Ajo Blanco");
        food_items.put("Perkins Restaurant & Bakery", international_3);

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
