package com.example.lab02p02;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView dzialanie, odpowiedz;
    int a,b,wynik;
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
        dzialanie = findViewById(R.id.tv_dzialanie);
        odpowiedz = findViewById(R.id.tv_odpowiedz);
        wylosuj();
    }

    private void wylosuj() {
        a = random.nextInt(10);
        b = random.nextInt(10);
        if (random.nextBoolean())
            wynik = a * b;
        else
            wynik = random.nextInt(100);
        dzialanie.setText(String.valueOf(a) + " * " + b + " = "+ wynik);
    }

    public void reset(View view) {
        wylosuj();
        odpowiedz.setText("");
    }

    public void sprawdz_czy_tak(View view) {
        if(wynik == a*b)
        odpowiedz.setText("Masz rację");
        else
            odpowiedz.setText("Nie masz racji");
    }

    public void sprawdz_czy_nie(View view) {
        if(wynik != a*b)
            odpowiedz.setText("Masz rację");
        else
            odpowiedz.setText("Nie masz racji");
    }
}