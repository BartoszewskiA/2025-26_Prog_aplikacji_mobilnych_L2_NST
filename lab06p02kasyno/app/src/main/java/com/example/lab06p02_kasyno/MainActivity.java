package com.example.lab06p02_kasyno;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_01, iv_02, iv_03;
    TextView tv_kwota;
    Button btn_graj;

    int kwota = 100;

    int obrazek_1, obrazek_2, obrazek_3;

    int[] grafiki = {
            R.drawable.rys01,
            R.drawable.rys02,
            R.drawable.rys03,
            R.drawable.rys04,
            R.drawable.rys05,
            R.drawable.rys06
    };
    Random random = new Random();
    
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
        przygotuj_ekran();
        btn_graj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                graj();
            }
        });
    }

    private void graj() {
        losuj_obrazki();
        if (obrazek_1 == obrazek_2 && obrazek_2 == obrazek_3) {
            kwota += 50;
        } else if (obrazek_1 == obrazek_2 || obrazek_1 == obrazek_3 || obrazek_2 == obrazek_3) {
            kwota += 5;
        } else {
            kwota -= 15;
        }
        tv_kwota.setText("$ "+kwota);
        if (kwota <= 0) {
            btn_graj.setEnabled(false);
            btn_graj.setText("KONIEC GRY");
        }

    }

    private void przygotuj_ekran() {
        iv_01 = findViewById(R.id.iv_01);
        iv_02 = findViewById(R.id.iv_02);
        iv_03 = findViewById(R.id.iv_03);
        tv_kwota = findViewById(R.id.tv_kwota);
        btn_graj = findViewById(R.id.btn_graj);
        losuj_obrazki();
    }

    private void losuj_obrazki() {
        obrazek_1 = random.nextInt(grafiki.length);
        obrazek_2 = random.nextInt(grafiki.length);
        obrazek_3 = random.nextInt(grafiki.length);
        iv_01.setImageResource(grafiki[obrazek_1]);
        iv_02.setImageResource(grafiki[obrazek_2]);
        iv_03.setImageResource(grafiki[obrazek_3]);
    }
}