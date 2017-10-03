package com.example.vishv.a1101015270;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = (TextView) findViewById(R.id.outputOrder);
        StringBuilder builder = new StringBuilder();
        builder.append("Name - ");
        builder.append(getIntent().getStringExtra("name"));
        builder.append("\n");
        builder.append("Address - ");
        builder.append(getIntent().getStringExtra("address"));
        builder.append("\n");
        builder.append("Card Number - ");
        builder.append(getIntent().getStringExtra("card"));
        builder.append("\n");
        builder.append("Cuisine - ");
        builder.append(getIntent().getStringExtra("selectedCuisine"));
        builder.append("\n");
        builder.append("Restaurant - ");
        builder.append(getIntent().getStringExtra("selectedRestaurant"));
        builder.append("\n");
        builder.append("Food Items  - ");
        builder.append(getIntent().getStringExtra("selectedFood"));
        builder.append("\n");
        if(getIntent().getStringExtra("favCuisine") != ""){
            builder.append("Favorite Cuisine - ");
            builder.append(getIntent().getStringExtra("favCuisine"));
            builder.append("\n");
        }
        if(getIntent().getStringExtra("favRestaurant") != ""){
            builder.append("Favorite Restaurant - ");
            builder.append(getIntent().getStringExtra("favRestaurant"));
            builder.append("\n");
        }
        if(getIntent().getStringExtra("specialRequest") != ""){
            builder.append("Special Request - ");
            builder.append(getIntent().getStringExtra("specialRequest"));
            builder.append("\n");
        }
        textView.setText(builder.toString());


        button = (Button) findViewById(R.id.exit_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
    }
}
