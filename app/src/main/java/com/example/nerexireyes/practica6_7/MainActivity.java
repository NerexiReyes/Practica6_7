package com.example.nerexireyes.practica6_7;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button botonVibrar, botonSensores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Vibrator vibrator = (Vibrator)this.getSystemService(Context.VIBRATOR_SERVICE);
        botonVibrar= (Button)findViewById(R.id.btnMVibrar);
        botonSensores= (Button)findViewById(R.id.btnSensores);

        botonVibrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Vibracion.class);
                startActivity(intent);
            }
        });

        botonSensores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, sensor_acelerometro.class);
                startActivity(intent);
            }
        });


    }
}
