package io.github.charlesanjos.aula0801.atividades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.github.charlesanjos.aula0801.R;
import io.github.charlesanjos.aula0801.entidades.Estudante;

public class Segunda extends AppCompatActivity implements AdapterView.OnItemClickListener {

  private  String dadosJSON;
  private ListView listView;
  private List<Estudante> lista;
  private ArrayAdapter<Estudante> adapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_segunda);
    dadosJSON = getIntent().getStringExtra("dados");
    listView = findViewById(R.id.listViewDados);
    lista = consumirJSON();
    adapter = new ArrayAdapter<>(this,
      android.R.layout.simple_list_item_1,lista);
    listView.setAdapter(adapter);
    listView.setOnItemClickListener(this);
  }

/*  private List<Estudante> consumirJSON() {
    List<Estudante> listaEstudantes = new ArrayList<>();
    try{
      JSONObject jsonObject = new JSONObject(dadosJSON);
      JSONArray jsonArray = jsonObject.getJSONArray("estudantes");
      for(int i=0;i<jsonArray.length();i++){
        JSONObject object = jsonArray.getJSONObject(i);
        Estudante estudante = new Estudante();
        estudante.setNome(object.getString("nomeEstudante"));
        estudante.setDisciplina(object.getString("disciplinaEstudante"));
        estudante.setNota(object.getInt("notaEstudante"));
        listaEstudantes.add(estudante);
      }
    } catch (JSONException e) {
      e.printStackTrace();
    }
    return listaEstudantes;
  }*/

  private List<Estudante> consumirJSON() {
    String resultado = "";
    List<Estudante> listaEstudantes = null;
    if(dadosJSON!=null){
      Gson gson = new Gson();
      Type type = new TypeToken<List<Estudante>>(){}.getType();
      listaEstudantes = gson.fromJson(dadosJSON, type);
      Toast.makeText(getApplicationContext(),listaEstudantes.toString(),Toast.LENGTH_LONG).show();
    }
    return listaEstudantes;
  }

  @Override
  public void onItemClick(AdapterView<?> adapterView, View view, int position,
                          long l) {
    AlertDialog alertDialog1 = new AlertDialog.Builder(Segunda.this).create();
    alertDialog1.setTitle("Dados do Estudante");
    alertDialog1.setMessage(
      "Nome: "+lista.get(position).getNome()+"\n"+
      "Disciplina: "+lista.get(position).getDisciplina()+"\n"+
      "Nota: "+lista.get(position).getNota()
    );
    alertDialog1.show();
  }
}