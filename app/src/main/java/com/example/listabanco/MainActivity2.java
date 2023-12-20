package com.example.listabanco;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity2 extends AppCompatActivity implements WebService.Asynchtask {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Map<String, String> datos = new HashMap<String, String>();
        WebService.WebService ws= new WebService.WebService("\"https://api-uat.kushkipagos.com/transfer/v1/bankList",
                datos, MainActivity2.this, MainActivity2.this);
        ws.execute("GET","Public-Merchant-Id","84e1d0de1fbf437e9779fd6a52a9ca18");
    }


    @Override
    public void processFinish(String result) throws JSONException {
        TextView txtlista= findViewById(R.id.txtlista);
        ArrayList<String> lstturistico = new ArrayList<String> ();
        JSONObject JSONobjeto =  new JSONObject(result);
        JSONArray JSONlista= JSONobjeto.getJSONArray("data");
        String Lista="";
        for(int i=0; i< JSONlista.length();i++){
            JSONObject turistico=  JSONlista.getJSONObject(i);
            Lista= Lista + "Categoria: "+turistico.getString("categoria") + "; Nombre: "+ turistico.getString("nombre_lugar")  + "; Telefono: "+turistico.getString("telefono") + "\n";
        }
        txtlista.setText(Lista);
    }
}

