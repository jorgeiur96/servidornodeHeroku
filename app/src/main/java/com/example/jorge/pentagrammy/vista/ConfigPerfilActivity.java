package com.example.jorge.pentagrammy.vista;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorge.pentagrammy.R;
import com.example.jorge.pentagrammy.modelo.CuentaInstagram;

public class ConfigPerfilActivity extends AppCompatActivity {


    /**
     * Id to identity READ_CONTACTS permission request.
     */
    private TextView ctaSeleccionada;
    private Button btnNext;
    private CuentaInstagram cuentaActual;
    private RadioButton r1,r2, r3, r4, rAct;
    private RadioGroup grupoRadio;
    private int iRadio;
    private String nRadio;


    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_perfil);

        Toolbar actionBar = (Toolbar) findViewById(R.id.barraSup);
        setSupportActionBar(actionBar);

        actionBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ConfigPerfilActivity.this, "Regresando", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        r1 = (RadioButton) findViewById(R.id.op1);
        r2 = (RadioButton) findViewById(R.id.op2);


        ctaSeleccionada=(TextView) findViewById(R.id.ctaSeleccionada);
        btnNext = (Button) findViewById(R.id.btn_next);

        cuentaActual = CuentaInstagram.getItem(0);
        r1.setText(cuentaActual.getUserFullName());
        cuentaActual = CuentaInstagram.getItem(1);
        r2.setText(cuentaActual.getUserFullName());
       /* cuentaActual = CuentaInstagram.getItem(2);
        r3.setText(cuentaActual.getUserFullName());
        cuentaActual = CuentaInstagram.getItem(3);
        r4.setText(cuentaActual.getUserFullName());*/
        grupoRadio = (RadioGroup) findViewById(R.id.grupoRadios);

        fueSeleccionado();

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CuentaInstagram.userSelected = cuentaActual.getUserID();
                Toast.makeText(ConfigPerfilActivity.this, "Regresando", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
    public void fueSeleccionado() {
        iRadio = grupoRadio.getCheckedRadioButtonId();
        rAct = (RadioButton) findViewById(iRadio);
        iRadio = grupoRadio.indexOfChild(rAct);
        cuentaActual = CuentaInstagram.getItem(iRadio);
        ctaSeleccionada.setText(cuentaActual.getUserName());
    }
    public void radioClicked(View view) {
        fueSeleccionado();
    }
}
