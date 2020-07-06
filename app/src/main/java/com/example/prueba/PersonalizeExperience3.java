package com.example.prueba;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;

import android.widget.Toast;
import android.widget.Toolbar;

import com.braintreepayments.cardform.view.CardForm;

import com.google.android.material.appbar.CollapsingToolbarLayout;

public class PersonalizeExperience3 extends AppCompatActivity {

    CardForm cardForm;
    Button buy;
    AlertDialog.Builder alertBuilder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalize_experience3);

        showToolbar("", true);


        cardForm = findViewById(R.id.card_form);
        buy = findViewById(R.id.btnBuy);
        cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(true)
                .mobileNumberRequired(true)
                .mobileNumberExplanation("SMS puede no ser requerido ")
                .setup(PersonalizeExperience3.this);
        cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cardForm.isValid()) {
                    alertBuilder = new AlertDialog.Builder(PersonalizeExperience3.this);
                    alertBuilder.setTitle("Confirma antes de comprar");
                    alertBuilder.setMessage("Número de tarjeta: " + cardForm.getCardNumber() + "\n" +
                            "Fecha vencimiento: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                            "Código CVV: " + cardForm.getCvv() + "\n" +
                            "Código postal: " + cardForm.getPostalCode() + "\n" +
                            "Número teléfono: " + cardForm.getMobileNumber());
                    alertBuilder.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                            Toast.makeText(PersonalizeExperience3.this, "Gracias por tu compra", Toast.LENGTH_LONG).show();
                        }
                    });
                    alertBuilder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            dialogInterface.dismiss();
                        }
                    });
                    AlertDialog alertDialog = alertBuilder.create();
                    alertDialog.show();

                } else {
                    Toast.makeText(PersonalizeExperience3.this, "Rellena todos los campos", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    public void showToolbar (String tittle, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tittle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbar);
    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public void SiguientePerson (View view){
        Intent siguiente = new Intent(this, ContainerActivity.class);
        startActivity(siguiente);
    }



}