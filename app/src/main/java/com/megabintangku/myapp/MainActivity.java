package com.megabintangku.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {


    public EditText angka1, angka2;
    public TextView total;
    public TextView total2;
    public String num1, num2;
    public Double hasil;
    public Double hasil2;
    public Spinner spinner;
    public Button btnsubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = (Spinner) findViewById(R.id.dropdownmenu);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,
                R.array.hitung, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        angka1 = (EditText) findViewById(R.id.angka1);
        angka2 = (EditText) findViewById(R.id.angka2);
        total = (TextView) findViewById(R.id.total);
        total2 = (TextView) findViewById(R.id.total2);
        btnsubmit = (Button) findViewById(R.id.submit);

        btnsubmit.setOnClickListener(new OnClickListener() {

            public void onClick(View v) {

                String aksi = String.valueOf(spinner.getSelectedItem());
                num1 = angka1.getText().toString();
                num2 = angka2.getText().toString();

                double na1 = num1.length() > 0 ? Double.valueOf(num1) : 0;
                double na2 = num2.length() > 0 ? Double.valueOf(num2) : 0;

                if (aksi.equals("Persegi")) {

                    hasil = na1 * na2;
                    hasil2 = (2* na1)+(2*na2);
                } else if(aksi.equals("Lingkaran")) {

                    hasil = Math.PI* Math.pow(na1, 2);;
                    hasil2 = Math.PI*(2*na1);

                } else if(aksi.equals("Segitiga")) {

                    hasil = (na1*na2)/2;
                    hasil2 = (na1+na2+(Math.sqrt(Math.pow(na1,2)+Math.pow(na2,2))));
                } else {

                    hasil = 0.00;
                    hasil2 = 0.00;

                }

                total.setText("Luas:  " + Double.toString(hasil));
                total2.setText("Keliling " + Double.toString(hasil2));


    /*Toast.makeText(MainActivity.this,
      "OnItemSelectedListener : " + aksi,
      Toast.LENGTH_SHORT).show();*/

            }
        });


    }

}