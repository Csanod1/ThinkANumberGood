package com.example.thinkanumbergood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btnPlusz;
    private Button btnMinusz;
    private Button btnTipp;
    private Button btnKonnyu;
    private Button btnNehez;
    private ImageView hp1;
    private ImageView hp2;
    private ImageView hp3;
    private ImageView hp4;
    private ImageView hp5;
    private ImageView[] eletek;
    private TextView tippErtek;
    private int tipp;
    private int gondolt;
    private int elet;
    private Random rnd;
    private AlertDialog.Builder jatekVegeDialogBuilder;
    private AlertDialog.Builder nehezsegDialogBuilder;
    /**
     * A játék nehézsége: false esetén legyen könnyű, true esetén legyen nehéz
     */
    private boolean nehezseg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListeners();
    }

    private void addListeners() {
        btnPlusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp < 10) {
                    tipp++;
                    tippErtek.setText(String.valueOf(tipp));
                } else {
                    Toast.makeText(MainActivity.this,
                            "A gongolt szám nem lehet nagyobb, mint 10", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnMinusz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp > 1) {
                    tipp--;
                    tippErtek.setText(String.valueOf(tipp));
                } else {
                    Toast.makeText(MainActivity.this,
                            "A gondolt szám nem lehet kisebb, mint 1", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnTipp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tipp < gondolt) {
                    eletCsokkent();
                    Toast.makeText(MainActivity.this,
                            "A gondolt szám nagyobb", Toast.LENGTH_SHORT).show();
                } else if (tipp > gondolt) {
                    eletCsokkent();
                    Toast.makeText(MainActivity.this,
                            "A gondolt szám kisebb", Toast.LENGTH_SHORT).show();
                } else {
                    // TODO: győzelem
                }
            }
        });
        btnKonnyu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnNehez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        jatekVegeDialogBuilder.setCancelable(false);
        nehezsegDialogBuilder = new AlertDialog.Builder("Biztosan új játékot szeretne kezdeni?");
        nehezsegDialogBuilder.set

    }

    private void eletCsokkent() {
        if (elet > 0){
            elet--;
        }
        eletek[elet].setImageResource(R.drawable.heart1);
        if (elet == 0) {
            // TODO: Vereség
        }
    }

    private void eletCsokkentSwitchCase() {
        elet--;
        switch (elet) {
            case 3:
                hp4.setImageResource(R.drawable.heart1);
                break;
            case 2:
                hp3.setImageResource(R.drawable.heart1);
                break;
            case 1:
                hp2.setImageResource(R.drawable.heart1);
                break;
            case 0:
                hp1.setImageResource(R.drawable.heart1);
                break;
        }
        if (elet == 0) {
            jatekVegeDialogBuilder.setTitle();
        }
    }

    private void init() {
        btnPlusz = findViewById(R.id.btnPlusz);
        btnMinusz = findViewById(R.id.btnMinusz);
        btnTipp = findViewById(R.id.btnTipp);
        btnKonnyu = findViewById(R.id.btnKonnyu);
        btnNehez = findViewById(R.id.btnNehez);
        hp1 = findViewById(R.id.hp_1);
        hp2 = findViewById(R.id.hp_2);
        hp3 = findViewById(R.id.hp_3);
        hp4 = findViewById(R.id.hp_4);
        hp5 = findViewById(R.id.hp_5);
        eletek = new ImageView[] {hp1, hp2, hp3, hp4};
        tippErtek = findViewById(R.id.tippErtek);
        rnd = new Random();
        nehezseg = false;
        gondolt = rnd.nextInt(10) + 1;
        Log.d("gondolt", String.valueOf(gondolt));
        jatekVegeDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        jatekVegeDialogBuilder.setMessage("Szeretne új játékot kezdeni?");
        jatekVegeDialogBuilder.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        jatekVegeDialogBuilder.setPositiveButton("igen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
    }
    private void ujJatek(){
        tipp = 1;
        elet = 4;
        gondoltMax = 10;
        if (nehezseg){
            gondoltMax = 40;
            elet = 5;
            hp4.setVisibility(View.VISIBLE);
            hp5.setVisibility(View.VISIBLE);
        }else{
            hp4.setVisibility(View.GONE);
            hp5.setVisibility(View.GONE);
        }
        tippErtek.setText(String.valueOf(tipp));
        for (ImageView iv; eletek) {
            iv.setImageResource(R.drawable.heart2);
        }
    }
}