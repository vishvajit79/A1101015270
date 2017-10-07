package com.example.vishv.a1101015270;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends Activity {

    private Button button;
    private TextView textView;

    public static boolean isEmptyString(String text) {
        return (text == null || text.trim().equals("null") || text.trim()
                .length() <= 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textView = (TextView) findViewById(R.id.outputOrder);
        textView.setMovementMethod(new ScrollingMovementMethod());
        StringBuilder builder = new StringBuilder();
        builder.append("Name - ");
        builder.append(getIntent().getStringExtra("name"));
        builder.append("\n\n");
        builder.append("Address - ");
        builder.append(getIntent().getStringExtra("address"));
        builder.append("\n\n");
        builder.append("Card Number - ");
        builder.append(getIntent().getStringExtra("card"));
        builder.append("\n\n");
        builder.append("Cuisine - ");
        builder.append(getIntent().getStringExtra("selectedCuisine"));
        builder.append("\n\n");
        builder.append("Restaurant - ");
        builder.append(getIntent().getStringExtra("selectedRestaurant"));
        builder.append("\n\n");
        builder.append("Food Items  - \n");
        builder.append(getIntent().getStringExtra("selectedFood"));
        builder.append("\n\n\n");
        if(!isEmptyString(getIntent().getStringExtra("favCuisine"))){
            builder.append("Favorite Cuisine - ");
            builder.append(getIntent().getStringExtra("favCuisine"));
            builder.append("\n\n");
        }
        if(!isEmptyString(getIntent().getStringExtra("favRestaurant"))){
            builder.append("Favorite Restaurant - ");
            builder.append(getIntent().getStringExtra("favRestaurant"));
            builder.append("\n\n");
        }
        if(!isEmptyString(getIntent().getStringExtra("specialRequest"))){
            builder.append("Special Request - ");
            builder.append(getIntent().getStringExtra("specialRequest"));
            builder.append("\n\n");
        }
        textView.setText(builder.toString());


        button = (Button) findViewById(R.id.exit_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    finishAffinity();
                }
            }
        });
    }
}
