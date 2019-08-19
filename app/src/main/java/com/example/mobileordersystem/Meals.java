package com.example.mobileordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Meals extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
       TextView etiket = findViewById(R.id.textView);
        Button geri =findViewById(R.id.button3);


        Bundle extras = getIntent().getExtras();
        String value = extras.getString("anahtar");
        ListView listemiz=(ListView) findViewById(R.id.mealslist);
  //      etiket.setText(value);// Kontrol
        geri.setText("Back");
        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Meals.this, MainActivity.class);
               // intent.putExtra("anahtar",Menulist[position]);//Gönderilecek veriyi ve bir anahtar belirledik.
                Meals.this.startActivity(intent);
                Meals.this.finish();
            }
        });
        final String[] soups = {"Spaniac Salad","Caprese Salad","French Onion Soup","Lopster Bisque"};
        final String[] steak = {"Fileg Mignon 8 Ons","Fileg Mignon 12 Ons","Fileg Mignon 16 Ons","Classic New York Sirlion"};
        final String[] seafood = {"Stuffed Lobster Tail","Maryland Crab Cake Dinner","Whole Lobster","Sardalya"};
        final String[] appedizers ={"Spicy Lobster","Baked Escargot","Seared Ahi Tuna","Mozzarella"};
        final String[] sides={"Sesame Green Beans","Cole Slaw","Baby Brussels Sprouts","Mashed Potatoes","Hand-Cut Fries","Creamed Spinach"};




        final Database veritabani = new Database(Meals.this);

        if(value=="Salads and Soups"){

            ArrayAdapter<String> dataAdaptoru=new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, android.R.id.text1, soups);


            listemiz.setAdapter(dataAdaptoru);
            listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    veritabani.sepeteEkle(soups[(int) id],soups[position]);
                }
            });

        }
           else if(value=="Steak Cuts"){
            ArrayAdapter<String> dataAdaptoru1=new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, android.R.id.text1, steak);


            listemiz.setAdapter(dataAdaptoru1);
            listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    veritabani.sepeteEkle(soups[(int) id],soups[position]);
                }
            });

        }

        else if(value=="Seafood"){
            ArrayAdapter<String> dataAdaptoru2=new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, android.R.id.text1, seafood);


            listemiz.setAdapter(dataAdaptoru2);
            listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    veritabani.sepeteEkle(soups[(int) id],soups[position]);
                }
            });

        }

        else if(value=="Appetizers"){
            ArrayAdapter<String> dataAdaptoru3=new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, android.R.id.text1, appedizers);


            listemiz.setAdapter(dataAdaptoru3);
            listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    veritabani.sepeteEkle(soups[(int) id],soups[position]);
                }
            });

        }
        else{
            ArrayAdapter<String> dataAdaptoru4=new ArrayAdapter<String>
                    (this, android.R.layout.simple_list_item_1, android.R.id.text1, sides);


                    listemiz.setAdapter(dataAdaptoru4);
            listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    veritabani.sepeteEkle(soups[(int) id],soups[position]);
                }
            });

        }

    }
}
