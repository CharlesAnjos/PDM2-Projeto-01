package io.github.charlesanjos.aula0801;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import io.github.charlesanjos.aula0801.atividades.Segunda;
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
    lista = new ArrayList<>();
  }

  public void criarLista(View v) {
    lista.add(
      new Estudante(
        ti_nome.getText().toString(),
        ti_disciplina.getText().toString(),
        Integer.parseInt(ti_nota.getText().toString())));
    Toast.makeText(
      getApplicationContext(),
      "Intem inserido",
      Toast.LENGTH_SHORT).show();
  }

/*  public String criarJson() {
    JSONArray jsonArray = new JSONArray();
    for (int i=0;i<lista.size();i++){
      JSONObject jsonObject = new JSONObject();
      try {
        jsonObject.put("nomeEstudante",lista.get(i).getNome());
        jsonObject.put("disciplinaEstudante",lista.get(i).getDisciplina());
        jsonObject.put("notaEstudante",lista.get(i).getNota());
        jsonArray.put(jsonObject);
      } catch (JSONException e) {
        e.printStackTrace();
      }
    }
    return "{estudantes:"+jsonArray.toString()+"}";
  }*/

  public String criarJson(List<Estudante> dados){
    Gson gson = new Gson();
    String stringJson = gson.toJson(dados);
    return stringJson;
  }

  public void gerarJson(View v) {
    retorno = criarJson(lista);
    tv_resultado.setText(retorno);
  }

  public void abrirTela(View v){
    Intent intent = new Intent(this, Segunda.class);
    intent.putExtra("dados",retorno);
    startActivity(intent);
  }
}