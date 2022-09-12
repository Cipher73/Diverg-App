package com.example.divergeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Category extends AppCompatActivity {
        ImageView storeicon;
        RecyclerView recyclerView;
        itemAdapter adapter;
        fooditem item;
        Bundle bundle;
        String store;
        public static ArrayList<fooditem> menu ;
        TextView storename;
        ImageView plus,minus;
        Button cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView=findViewById(R.id.itemlist);

        recyclerView.setHasFixedSize(true);
        storeicon=findViewById(R.id.storeicon);
        storename=findViewById(R.id.storename);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        bundle= getIntent().getExtras();
        store = bundle.getString("store");
        storename.setText(store);
        cart = findViewById(R.id.cartID);

        menu = getMenu(store);


        adapter= new itemAdapter(this,menu,false);
        recyclerView.setAdapter(adapter);
        storeicon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Category.this, menu.get(0).getCountInCart()+" ",Toast.LENGTH_LONG).show();
            }
        });

       cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Intent intent  = new Intent(Category.this,cartView.class);
              //intent.putExtra("menu",getmenu());
              startActivity(intent);

            }
        });
    }


    public static ArrayList<fooditem> getMenu(String store) {

        ArrayList<fooditem> menu = new ArrayList<>();

        if (store.equals("MacDonalds")) {

            menu.add(new fooditem("Big Mac", "80", "Big Mac"));
            menu.add(new fooditem("McFizz", "70", "McFizz"));
            menu.add(new fooditem("Big Mac Meal", "90", "Big Mac Meal"));
            menu.add(new fooditem("Cappuccino", "70", "Cappuccino"));
            menu.add(new fooditem("Vanilla Shake", "80", "Vanilla Shake"));
            menu.add(new fooditem("Small Fries", "70", "Small Fries"));
            menu.add(new fooditem("Chilli Cheese Double", "90", "Chilli Cheese Double"));
            menu.add(new fooditem("Cheeseburger Happy Meal", "70", "Cheeseburger Happy Meal"));
        }
        if (store.equals("Burger King")) {
            menu.add(new fooditem("Double Whooper", "70", "Double Whooper"));
            menu.add(new fooditem("Whooper", "80", "Whooper"));
            menu.add(new fooditem("Double Mozzarella Lover", "90", "Double Mozzarella Lover"));
            menu.add(new fooditem("Chicken Tenders", "70", "Chicken Tenders"));
            menu.add(new fooditem("Pepsi", "80", "Pepsi"));
        }
        if (store.equals("Pizza Hut")) {
            menu.add(new fooditem("Mexicana", "70", "Mexicana"));
            menu.add(new fooditem("Pepperoni", "80", "Pepperoni"));
            menu.add(new fooditem("Super Supreme", "90", "Super Supreme"));
            menu.add(new fooditem("Smokey Beef Sausage", "70", "Smokey Beef Sausage"));
            menu.add(new fooditem("Meat Lovers", "80", "Meat Lovers"));
        }
        if (store.equals("RocoMamas")) {
            menu.add(new fooditem("Classic Cheese Burger", "70", "Classic Cheese Burger"));
            menu.add(new fooditem("Chilli Cheese Bomb", "80", "Chilli Cheese Bomb"));
            menu.add(new fooditem("Los Nachos", "90", "Los Nachos"));
            menu.add(new fooditem("Pork Ribs", "70", "Pork Ribs"));
        }
        if (store.equals("KFC")) {
            menu.add(new fooditem("nice", "70", "Kentucky Feast"));
            menu.add(new fooditem("bad", "80", "KFC All in 1"));
        }
        if (store.equals("Debonairs")) {
            menu.add(new fooditem("Something Meaty","70","Something Meaty"));
            menu.add(new fooditem("Beef Steak and Mushrooms","80","Beef Steak and Mushrooms"));
            menu.add(new fooditem("Four Seasons","90","Four Seasons"));
            menu.add(new fooditem("Mexican Fiesta","40","Mexican Fiesta"));
            menu.add(new fooditem("Ham,Pineapple","38","Hawaiian"));


        }
        if (store.equals("Steers")) {
            menu.add(new fooditem("Steers Ribs","70","Steers Ribs"));
            menu.add(new fooditem("Shake It Up Combo","80","Shake It Up Combo"));
        }
        if (store.equals("Checkers Liquor")) {
            menu.add(new fooditem("Smirnoff","70","Smirnoff"));
            menu.add(new fooditem("Russian Bear","80","Russian Bear"));


        }
        if (store.equals("Romans Pizza")) {
            menu.add(new fooditem("Classic Cheese","70","Classic Cheese"));
            menu.add(new fooditem("Margherita","80","Margherita"));
            menu.add(new fooditem("Beef 'N Cheese","90","Beef 'N Cheese"));

        }
        if (store.equals("Chicken Licken")) {
            menu.add(new fooditem("6 Hot Wings", "70", "6 Hot Wings"));
            menu.add(new fooditem("12 Hot Wings", "80", "12 Hot Wings"));
            menu.add(new fooditem("Chicken Burger and Chips", "70", "Chicken Burger and Chips"));

    }
        if(store.equals("Nandos")){
            menu.add(new fooditem("Full Chicken","70","Full Chicken"));
            menu.add(new fooditem("1/4 Chicken","80","1/4 Chicken"));
            menu.add(new fooditem("The Grande Salad","90","The Grande Salad"));
        }

        return menu;

    }
    public static ArrayList<fooditem> getmenu(){
        return menu;
    }
}