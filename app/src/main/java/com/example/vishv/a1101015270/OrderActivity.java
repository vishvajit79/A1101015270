package com.example.vishv.a1101015270;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class OrderActivity extends Activity {

    private EditText nameEdit;
    private EditText addressEdit;
    private EditText cardNumberEdit;
    private EditText favoriteCuisineEdit;
    private EditText favoriteRestaurantEdit;
    private EditText specialRequestEdit;
    private Button orderButton;
    final Pattern pattern = Pattern.compile("^(?:4[0-9]{12}(?:[0-9]{3})?|[25][1-7][0-9]{14}|6(?:011|5[0-9][0-9])[0-9]{12}|3[47][0-9]{13}|3(?:0[0-5]|[68][0-9])[0-9]{11}|(?:2131|1800|35\\d{3})\\d{11})$");

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
        orderButton = (Button) findViewById(R.id.orderBtn);

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
        if (nameEdit.getText().length() <= 0) {
            nameEdit.setError("Enter your name");
            return false;
        }
        if (addressEdit.getText().length() <= 0) {
            addressEdit.setError("Enter your address");
            return false;
        }
        if (cardNumberEdit.getText().length() != 16) {
            cardNumberEdit.setError("Enter your credit card number and it should be 16 digit ");
            return false;
        }
        return true;
    }
}

