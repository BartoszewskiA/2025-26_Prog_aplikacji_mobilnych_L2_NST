package com.example.w05p03;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_ramka;
    RadioGroup rg_obrazki;
    RadioButton rb_obraz1;
    RadioButton rb_obraz2;
    RadioButton rb_obraz3;
    RadioButton rb_obraz4;


    int[] obrazki = {
            R.drawable.wilk01,
            R.drawable.wilk02,
            R.drawable.wilk03,
            R.drawable.wilk04
    };

    Random random = new Random();
    int wybrany_obrazek =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        iv_ramka = findViewById(R.id.iv_ramka);
        rg_obrazki = findViewById(R.id.rg_obrazki);
        rb_obraz1 = findViewById(R.id.rb_obraz1);
        rb_obraz2 = findViewById(R.id.rb_obraz2);
        rb_obraz3 = findViewById(R.id.rb_obraz3);
        rb_obraz4 = findViewById(R.id.rb_obraz4);
        wybrany_obrazek = random.nextInt(obrazki.length);
        iv_ramka.setImageResource(obrazki[wybrany_obrazek]);
        switch (wybrany_obrazek)
        {
            case 0:
                rb_obraz1.setChecked(true);
                break;
            case 1:
                rb_obraz2.setChecked(true);
                break;
            case 2:
                rb_obraz3.setChecked(true);
                break;
            case 3:
                rb_obraz4.setChecked(true);
                break;
        }
        rg_obrazki.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(@NonNull RadioGroup group, int checkedId) {
                if(checkedId == R.id.rb_obraz1) {
                    iv_ramka.setImageResource(obrazki[0]);
                    wybrany_obrazek = 0;
                }
                else if(checkedId == R.id.rb_obraz2) {
                    iv_ramka.setImageResource(obrazki[1]);
                    wybrany_obrazek = 1;
                }
                else if(checkedId == R.id.rb_obraz3) {
                    iv_ramka.setImageResource(obrazki[2]);
                    wybrany_obrazek = 2;
                }
                else if(checkedId == R.id.rb_obraz4) {
                    iv_ramka.setImageResource(obrazki[3]);
                    wybrany_obrazek = 3;
                }
            }
        });
        iv_ramka.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                otwarcie_2_aktywnosci();
                return false;
            }
        });


    }

    private void otwarcie_2_aktywnosci() {
        Intent intent = new Intent(getApplicationContext(), MainActivity2.class);
        intent.putExtra("obrazek", obrazki[wybrany_obrazek]);
        startActivity(intent);
    }
}