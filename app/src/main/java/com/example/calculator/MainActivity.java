package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.faendir.rhino_android.RhinoAndroidHelper;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ast.Scope;

public class MainActivity extends AppCompatActivity {

    //importing
    String process;
    TextView hasilsebelumnya, menuhitung;
    Button ac, persen, bagi, kali, kurang, tambah, samadengan, titik, hapus, kosong, satu, dua, tiga, empat, lima, enam, tujuh, delapan, sembilan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //membuat class/variable (id harus sama)
        hasilsebelumnya=findViewById(R.id.hasilsebelumnya);
        menuhitung=findViewById(R.id.menuhitung);
        ac=findViewById(R.id.ac);
        persen=findViewById(R.id.persen);
        bagi=findViewById(R.id.bagi);
        kali=findViewById(R.id.kali);
        kurang=findViewById(R.id.kurang);
        tambah=findViewById(R.id.tambah);
        samadengan=findViewById(R.id.samadengan);
        titik=findViewById(R.id.titik);
        hapus=findViewById(R.id.hapus);
        kosong=findViewById(R.id.kosong);
        satu=findViewById(R.id.satu);
        dua=findViewById(R.id.dua);
        tiga=findViewById(R.id.tiga);
        empat=findViewById(R.id.empat);
        lima=findViewById(R.id.lima);
        enam=findViewById(R.id.enam);
        tujuh=findViewById(R.id.tujuh);
        delapan=findViewById(R.id.delapan);
        sembilan=findViewById(R.id.sembilan);

        // memasukan button ke text 1 1 :(
        satu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //menuhitung.setText(menuhitung.getText() + "1");
                process = menuhitung.getText().toString();
                menuhitung.setText(process + "1");

            }
        });
        dua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "2");

            }
        });
        tiga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "3");

            }
        });
        empat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "4");

            }
        });
        lima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "5");

            }
        });
        enam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "6");

            }
        });
        tujuh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "7");

            }
        });
        delapan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "8");

            }
        });
        sembilan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "9");

            }
        });
        kosong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "0");

            }
        });
        kali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "x");

            }
        });
        kurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String min = menuhitung.getText().toString();
//                    if(!min.substring(0, min.length()-1).trim().equals("-")) {
//                        menuhitung.setText(menuhitung.getText() + "-");
//                    }

                process = menuhitung.getText().toString();
                menuhitung.setText(process + "-");
            //}

            }
        });
        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "+");

            }
        });
        bagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + ":");

            }
        });
        persen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + "%");

            }
        });
        titik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText(menuhitung.getText() + ".");

            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuhitung.setText("");
                hasilsebelumnya.setText("");

            }
        });

        hapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vals = menuhitung.getText().toString();
                vals = vals.substring(0, vals.length() - 1);
                menuhitung.setText(vals);
            }
        });
        samadengan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                process = menuhitung.getText().toString();

                process = process.replaceAll("x","*");
                process = process.replaceAll("%","/100");
                process = process.replaceAll(":","/");

                    Context rhino = Context.enter();

                    rhino.setOptimizationLevel(-1);

                    String finalresult= "";

                    try {
                        Scriptable scriptable = rhino.initStandardObjects();
                        finalresult = rhino.evaluateString(scriptable,process,"javascript",1,null).toString();
                    } catch (Exception e) {
                        finalresult = "0";
                    }
                        menuhitung.setText(finalresult);
                        hasilsebelumnya.setText(process);
            }
        });
    }
    


}
