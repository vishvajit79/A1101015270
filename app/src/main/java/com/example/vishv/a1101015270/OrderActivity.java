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
    private EditText favorieteRestaurantEdit;
    private Button orderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        nameEdit = (EditText) findViewById(R.id.nameEdit);
        addressEdit = (EditText) findViewById(R.id.addressEdit);
        cardNumberEdit = (EditText) findViewById(R.id.cardEdit);
        favoriteCuisineEdit = (EditText) findViewById(R.id.favCuiEdit);
        favorieteRestaurantEdit = (EditText) findViewById(R.id.favRestEdit);
        orderButton = (Button) findViewById(R.id.orderBtn);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateTextEdits())
                    return;
                Intent intent = new Intent(v.getContext(), ResultActivity.class);
                intent.putExtra("name", nameEdit.getText().toString());
                intent.putExtra("address", addressEdit.getText().toString());
                intent.putExtra("card", cardNumberEdit.getText().toString());
                intent.putExtra("favCuisine", favoriteCuisineEdit.getText().toString());
                intent.putExtra("favRestaurant", favorieteRestaurantEdit.getText().toString());
                startActivity(intent);
            }
        });
    }

    private boolean validateTextEdits() {
        if (nameEdit.getText().length() <= 0) {
            nameEdit.setError("Enter your name");
            return false;
        }
        if (addressEdit.getText().length() <= 0) {
            addressEdit.setError("Enter your Address");
            return false;
        }
        if (cardNumberEdit.getText().length() == 16) {
            cardNumberEdit.setError("Enter your credit card number and it should be 16 digit ");
            return false;
        }
        return true;
    }
}
