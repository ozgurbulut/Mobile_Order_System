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
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String[] Menulist = {"Appetizers","Steak Cuts","Seafood","Prix Fixe","Salads and Soups","Sides"};
        ListView listemiz=(ListView) findViewById(R.id.menulist);
        Button cart = findViewById(R.id.button2);


        ArrayAdapter<String> dataAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, Menulist);


        listemiz.setAdapter(dataAdaptoru);
        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(MainActivity.this, Menulist[position], Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(MainActivity.this, Meals.class);
               // intent.putExtra("anahtar",Menulist[position]);//Gönderilecek veriyi ve bir anahtar belirledik.
                intent.putExtra("anahtar",Menulist[(int) id]);
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();
            }
        });


        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Cart.class);
                // intent.putExtra("anahtar",Menulist[position]);//Gönderilecek veriyi ve bir anahtar belirledik.
                MainActivity.this.startActivity(intent);
                MainActivity.this.finish();

            }
        });



    }
}
