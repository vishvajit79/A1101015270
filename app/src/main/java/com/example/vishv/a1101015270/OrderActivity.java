package com.example.vishv.a1101015270;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class OrderActivity extends Activity {

    private EditText nameEdit;
    private EditText addressEdit;
    private EditText cardNumberEdit;
    private EditText favoriteCuisineEdit;
    private EditText favoriteRestaurantEdit;
    private EditText specialRequestEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        nameEdit = (EditText) findViewById(R.id.nameEdit);
        addressEdit = (EditText) findViewById(R.id.addressEdit);
        cardNumberEdit = (EditText) findViewById(R.id.cardEdit);
        favoriteCuisineEdit = (EditText) findViewById(R.id.favCuiEdit);
        favoriteRestaurantEdit = (EditText) findViewById(R.id.favRestEdit);
        specialRequestEdit = (EditText) findViewById(R.id.specialRequestEdit);
        Button orderButton = (Button) findViewById(R.id.orderBtn);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateTextEdits())
                    return;
                Intent intent = new Intent(v.getContext(), ResultActivity.class);
                intent.putExtra("selectedRestaurant", getIntent().getStringExtra("selectedRestaurant"));
                intent.putExtra("selectedFood", getIntent().getStringExtra("selectedFood"));
                intent.putExtra("selectedCuisine", getIntent().getStringExtra("selectedCuisine"));
                intent.putExtra("name", nameEdit.getText().toString());
                intent.putExtra("address", addressEdit.getText().toString());
                intent.putExtra("card", cardNumberEdit.getText().toString());
                intent.putExtra("favCuisine", favoriteCuisineEdit.getText().toString());
                intent.putExtra("favRestaurant", favoriteRestaurantEdit.getText().toString());
                intent.putExtra("specialRequest", specialRequestEdit.getText().toString());
                startActivity(intent);
            }
        });
    }

    private boolean validateTextEdits() {
        if (isEmptyString(nameEdit.getText().toString())) {
            nameEdit.setError("Enter your name");
            return false;
        }
        if (isEmptyString(addressEdit.getText().toString())) {
            addressEdit.setError("Enter your address");
            return false;
        }
        if (cardNumberEdit.length() != 16 ) {
            cardNumberEdit.setError("Enter your credit card number and it should be 16 digit ");
            return false;
        }
        return true;
    }

    public static boolean isEmptyString(String text) {
        return (text == null || text.trim().equals("null") || text.trim()
                .length() <= 0);
    }
}

