package com.example.divergeapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class itemAdapter extends RecyclerView.Adapter<itemAdapter.ViewHolder> {

    Context context ;
    ArrayList<fooditem> fooditems;
    Boolean flag;

    public itemAdapter(Context context, ArrayList<fooditem> fooditems,Boolean flag) {
        this.context = context;
        this.fooditems = fooditems;
        this.flag=flag;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        fooditem i =fooditems.get(position);
        holder.foodtitle.setText(i.getFoodtitle());
        holder.description.setText(i.getDescription());
        holder.price.setText(i.getPrice());
        holder.countincart=i.getCountInCart();
        holder.count.setText(i.getCountInCart()+"");
        holder.cart.setVisibility(View.VISIBLE);
       holder.countpart.setVisibility(View.GONE);
       if(i.getFoodtitle().equals("Big Mac")){
           holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mbigmac));
       }
        if(i.getFoodtitle().equals("Big Mac Meal")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mbigmacmeal));
        }
        if(i.getFoodtitle().equals("McFizz")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mfizz));
        }
        if(i.getFoodtitle().equals("Small Fries")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mfries));
        }
        if(i.getFoodtitle().equals("Cappuccino")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mcappucino));
        }
        if(i.getFoodtitle().equals("Vanilla Shake")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mvanilla));
        }
        if(i.getFoodtitle().equals("Cheeseburger Happy Meal")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mhappymeal));
        }
        if(i.getFoodtitle().equals("Chilli Cheese Double")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mchilliecheese));
        }
        if(i.getFoodtitle().equals("Double Mozzarella Lover")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.bdoublecheese));
        }
        if(i.getFoodtitle().equals("Double Whooper")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.bdoublewooper));
        }
        if(i.getFoodtitle().equals("Whooper")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.bhooper));
        }
        if(i.getFoodtitle().equals("Chicken Tenders")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.bchickentenders));
        }
        if(i.getFoodtitle().equals("Pepsi")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.bpepsi));
        }
        if(i.getFoodtitle().equals("Kentucky Feast")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.kfckenturky));
        }
        if(i.getFoodtitle().equals("KFC All in 1")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.kfcallin1));
        }
        if(i.getFoodtitle().equals("Steers Ribs")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.nandosribs));
        }
        if(i.getFoodtitle().equals("Shake It Up Combo")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.steersshakeitup));
        }
        if(i.getFoodtitle().equals("Classic Cheese")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.chillicheesebomb));
        }
        if(i.getFoodtitle().equals("Classic Cheese Burger")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mbigmac));
        }
        if(i.getFoodtitle().equals("Chilli Cheese Bomb")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mbigmacmeal));
        }
        if(i.getFoodtitle().equals("Los Nachos")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mcappucino));
        }
        if(i.getFoodtitle().equals("Pork Ribs")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mvanilla));
        }
        if(i.getFoodtitle().equals("Cheeseburger Happy Meal")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mhappymeal));
        }
        if(i.getFoodtitle().equals("Chilli Cheese Meal")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mchilliecheese));
        }
        if(i.getFoodtitle().equals("Mexicana")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mexicana8698));
        }
        if(i.getFoodtitle().equals("Pepperoni")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pepperoni7600));
        }
        if(i.getFoodtitle().equals("Super Supreme")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.supersupreme));
        }
        if(i.getFoodtitle().equals("Smokey Beef Sausage")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pizza));
        }
        if(i.getFoodtitle().equals("Cappuccino")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mcappucino));
        }
        if(i.getFoodtitle().equals("Something Meaty")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pizza1));
        }
        if(i.getFoodtitle().equals("Beef Steak and Mushrooms")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pizza2));
        }
        if(i.getFoodtitle().equals("Four Seasons")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pizza3));
        }
        if(i.getFoodtitle().equals("Mexican Fiesta")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pizza4));
        }
        if(i.getFoodtitle().equals("Hawaiian")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pizza5));
        }
        if(i.getFoodtitle().equals("Smirnoff")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.cl2));
        }
        if(i.getFoodtitle().equals("Smirnoff")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.cl2));
        }
        if(i.getFoodtitle().equals("Russian Bear")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.cl1));
        }
        if(i.getFoodtitle().equals("Margherita")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pizza5));
        }
        if(i.getFoodtitle().equals("Beef 'N Cheese")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.pizza3));
        }
        if(i.getFoodtitle().equals("6 Hot Wings")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.wings6));
        }
        if(i.getFoodtitle().equals("12 Hot Wings")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.wings12));
        }
        if(i.getFoodtitle().equals("Chicken Burger and Chips")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.chicken));
        }
        if(i.getFoodtitle().equals("Big Mac")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mbigmac));
        }
        if(i.getFoodtitle().equals("Big Mac")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mbigmac));
        }
        if(i.getFoodtitle().equals("Big Mac")){
            holder.itempic.setImageDrawable(context.getDrawable(R.drawable.mbigmac));
        }

      if(flag==true){
           holder.countpart.setVisibility(View.VISIBLE);
           holder.cart.setVisibility(View.GONE);
           holder.minus.setVisibility(View.GONE);
            holder.plus.setVisibility(View.GONE);


            holder.price.setText(Integer.parseInt(i.getPrice())*i.getCountInCart()+"");
        }
         holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i.setCountInCart(i.getCountInCart()+1);
                Toast.makeText(holder.plus.getContext(), "item added to cart",Toast.LENGTH_SHORT).show();
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i.getCountInCart()>0){
                    i.setCountInCart(i.getCountInCart()-1);
                    Toast.makeText(holder.minus.getContext(), "items removed from cart",Toast.LENGTH_SHORT).show();}
                else{
                    Toast.makeText(holder.minus.getContext(), "this item is not in the cart",Toast.LENGTH_SHORT).show();}
                }

        });



    }

    @Override
    public int getItemCount() {
        return fooditems.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView foodtitle,price,description;
        ImageView plus ,minus;
        LinearLayout cart;
        LinearLayout countpart;
        TextView count;
        int countincart;
        ImageView itempic;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            foodtitle=itemView.findViewById(R.id.foodtitle);
            price = itemView.findViewById(R.id.price);
            description=itemView.findViewById(R.id.description);
            plus=itemView.findViewById(R.id.plus);
            minus=itemView.findViewById(R.id.minus);
           cart =itemView.findViewById(R.id.cart);
            countpart=itemView.findViewById(R.id.countpart);
            count=itemView.findViewById(R.id.itemcount);
            itempic = itemView.findViewById(R.id.itempic);
        }
    }
}
