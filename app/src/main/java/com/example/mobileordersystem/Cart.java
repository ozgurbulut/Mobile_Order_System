package com.example.mobileordersystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class Cart extends AppCompatActivity {

    private ListView VeriListele;
    public void Listele(){
        Database vt = new Database(Cart.this);
        List<String> list = vt.VeriListele();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(Cart.this, android.R.layout.simple_list_item_1,android.R.id.text1,list);
        VeriListele.setAdapter(adapter);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        //TextView label = findViewById(R.id.textfirebase);
        ImageButton temizle =findViewById(R.id.imageButton);
        ImageButton geri = findViewById(R.id.imageButton2);

        VeriListele.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Listele();//Burada program çöküyor geri dön bak
            }
        });



        final Database veritabani = new Database(Cart.this);
        temizle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veritabani.VeriSil();

            }
        });

        geri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Cart.this, MainActivity.class);
                // intent.putExtra("anahtar",Menulist[position]);//Gönderilecek veriyi ve bir anahtar belirledik.
                Cart.this.startActivity(intent);
                Cart.this.finish();
            }
        });


    }
}
