package com.fadergs.agenda2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;

public class FormActivity extends AppCompatActivity {

    private EditText etNome, etFone;
    private Spinner spEstados, spCidades;
    private RadioButton rbFeminino, rbMasculino, rbNaobinario;
    private CheckBox cbEstadoCivil;
    private Button btnSalvar;
    private ImageView btnFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNome = (EditText) findViewById(R.id.editText_nome);
        etFone = (EditText) findViewById(R.id.editText_telefone);
        spCidades = (Spinner) findViewById(R.id.spinner_cidade);
        spEstados = (Spinner) findViewById(R.id.spinner_estado);
        rbFeminino = (RadioButton) findViewById(R.id.radio_feminino);
        rbMasculino = (RadioButton) findViewById(R.id.radio_masculino);
        rbNaobinario = (RadioButton) findViewById(R.id.radio_nao_binario);
        btnSalvar = (Button) findViewById(R.id.button_salvar);
        btnFoto = (ImageView) findViewById(R.id.image_camera_button);
        cbEstadoCivil = (CheckBox) findViewById(R.id.checkBox_estado_civil);

        loadCities(0);

        spEstados.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                loadCities( i );
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void loadCities(int position) {
        String[] cidades = {"Você deve selecionar o Estado"};

        if (position == 0) {
            spCidades.setEnabled(false);
        } else {
            spCidades.setEnabled(true);
            if (position == 1) {
                cidades = new String[] {
                        "Selecione a cidade...",
                        "Curitiba",
                        "Londrina",
                        "Maringá"
                };
            } else if (position == 2) {
                cidades = getResources().getStringArray(R.array.cidades_Rs);
            } else if (position == 3) {
                cidades = getResources().getStringArray(R.array.cidades_Sc);
            }
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cidades);
        spCidades.setAdapter(adapter);
    }
}
