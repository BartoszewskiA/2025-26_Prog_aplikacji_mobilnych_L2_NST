package com.example.lab03p01_atlas;

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

public class MainActivity extends AppCompatActivity {

    TextView tv_nazwa, tv_opis;
    Button btn_np, btn_ws;
    ImageView ramka;
    int[] grafiki = {
            R.drawable.prawdziwek,
            R.drawable.podgrzybek,
            R.drawable.muchomor,
            R.drawable.kania
    };
    String[] nazwy;
    String[] opisy;
    int pozycja =0;
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
        tv_nazwa = findViewById(R.id.tv_nazwa);
        tv_opis = findViewById(R.id.tv_opis);
        btn_np = findViewById(R.id.btn_np);
        btn_ws = findViewById(R.id.btn_ws);
        ramka = findViewById(R.id.ramka);
        nazwy = getResources().getStringArray(R.array.nazwy);
        opisy = getResources().getStringArray(R.array.opisy);
        wyswietl();
        dodaj_sluchacza();
    }

    private void dodaj_sluchacza() {
        btn_np.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pozycja++;
                if (pozycja >= grafiki.length) {
                    pozycja = 0;
                }
                wyswietl();
            }
        });
        btn_ws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pozycja--;
                if (pozycja < 0) {
                    pozycja = grafiki.length - 1;
                }
                wyswietl();
            }
        });
    }

    private void wyswietl() {
        tv_nazwa.setText(nazwy[pozycja]);
        tv_opis.setText(opisy[pozycja]);
        ramka.setImageResource(grafiki[pozycja]);
    }
}