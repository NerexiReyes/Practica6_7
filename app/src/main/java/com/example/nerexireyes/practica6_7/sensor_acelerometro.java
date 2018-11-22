package com.example.nerexireyes.practica6_7;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class sensor_acelerometro extends AppCompatActivity implements SensorEventListener {

    TextView texto;
    SensorManager sensorManager;
    private Sensor acelerometro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor_acelerometro);

        texto=(TextView)findViewById(R.id.lblTexto);

        sensorManager=(SensorManager) getSystemService(SENSOR_SERVICE);
        acelerometro= sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x,y,z;
        x= event.values[0];
        y= event.values[1];
        z= event.values[2];
        texto.setText("");
        texto.append("\n El valor de x: " + x + "\n El valor de y:" + y + "\n El valor de z:" + z);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
    @Override
    protected void onResume(){
        super.onResume();
        sensorManager.registerListener(this,acelerometro,sensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    protected void onPause(){
        super.onPause();
        sensorManager.unregisterListener(this);
    }
}
