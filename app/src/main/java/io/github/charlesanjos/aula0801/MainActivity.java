package io.github.charlesanjos.aula0801;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import io.github.charlesanjos.aula0801.entidades.Estudante;

public class MainActivity extends AppCompatActivity {

    private EditText ti_nome, ti_disciplina, ti_nota;
    private Button bt_adicionar, bt_gerar, bt_consumir;
    private TextView tv_resultado;

    private List<Estudante> lista;
    private String retorno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ti_nome = findViewById(R.id.ti_nome);
        ti_disciplina = findViewById(R.id.ti_disciplina);
        ti_nota = findViewById(R.id.ti_nota);
        bt_adicionar = findViewById(R.id.bt_adicionar);
        bt_gerar = findViewById(R.id.bt_gerar);
        bt_consumir = findViewById(R.id.bt_consumir);
        tv_resultado = findViewById(R.id.tv_resultado);
    }


}