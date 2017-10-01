package com.example.vishv.a1101015270;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CuisineTypeActivity extends Activity {

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private String inputSelect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuisine_type);
        radioGroup = (RadioGroup) findViewById(R.id.cuisineType_rg);
        Button button = (Button) findViewById(R.id.cuisineNext_btn);
        int selectedId = radioGroup.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(selectedId);
        inputSelect = (String) radioButton.getText();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                inputSelect = (String) radioButton.getText();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), RestaurantListActivity.class);
                intent.putExtra("cuisine_type", inputSelect);
                startActivity(intent);
            }
        });

    }
}
