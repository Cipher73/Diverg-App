package com.example.divergeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class StoreActivity extends AppCompatActivity {
CardView macD,steers,debonairs,pizzahut,nandos,roco,cliquor,pnpliquor,burgerking,romans,kfc,chicken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);
        macD= findViewById(R.id.MacDonalds);
        steers= findViewById(R.id.steers);
        debonairs= findViewById(R.id.debonairs);
        pizzahut= findViewById(R.id.pizzahut);
        nandos= findViewById(R.id.nandos);
        roco= findViewById(R.id.rocomamas);
        cliquor= findViewById(R.id.checkersliquor);
        pnpliquor= findViewById(R.id.pnpliquor);
        burgerking= findViewById(R.id.burgerking);
        romans= findViewById(R.id.romans);
        kfc= findViewById(R.id.kfc);
        chicken= findViewById(R.id.chicken);


        macD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","MacDonalds"));
            }
        });
        steers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","Steers"));
            }
        });
        kfc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","KFC"));
            }
        });
        romans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","Romans Pizza"));
            }
        });
        burgerking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","Burger King"));
            }
        });
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","Chicken Licken"));
            }
        });
        cliquor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","Checkers Liquor"));
            }
        });
        pnpliquor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","PnP Liquor"));
            }
        });
        nandos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","Nandos"));
            }
        });
        roco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","RocoMamas"));
            }
        });
        pizzahut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","Pizza Hut"));
            }
        });
        debonairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StoreActivity.this,Category.class).putExtra("store","Debonairs"));
            }
        });




    }
}