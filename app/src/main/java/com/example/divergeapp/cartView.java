package com.example.divergeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class cartView extends AppCompatActivity {
    itemAdapter adapter;
    public ArrayList<fooditem> menu ;
    ArrayList<fooditem> inCart ;
    Button btnCheckOut;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_view);

        btnCheckOut=findViewById(R.id.btnCheckOut);



        Category category = new Category();
        menu=category.getmenu();
        inCart=new ArrayList<>();
        for(fooditem i : menu){
            if(i.getCountInCart()>0){
                inCart.add(i);
            }
        }

        recyclerView=findViewById(R.id.cartlist);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter= new itemAdapter(this,inCart,true);
        recyclerView.setAdapter(adapter);


        btnCheckOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(cartView.this,CheckOut.class));
            }
        });


    }
}