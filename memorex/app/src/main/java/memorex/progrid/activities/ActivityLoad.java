package memorex.progrid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONException;

import java.io.Serializable;
import java.nio.file.Files;

import memorex.progrid.base.Common;
import memorex.progrid.base.Item;
import memorex.progrid.http.HttpLoadItem;
import memorex.progrid.http.HttpLoadMes;
import memorex.progrid.memorex2.R;

public class ActivityLoad extends AppCompatActivity {

    private Common common;
    private Item item;
    private TextView txtmsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        common = (Common)getApplicationContext();

        Intent intent = getIntent();
        Serializable objeto = intent.getSerializableExtra("item");
        if (objeto !=null)
            item = (Item) objeto;

        txtmsg = (TextView) findViewById(R.id.txtmsg);

        try {
            loadDia();
        } catch (JSONException e) {

        }
    }

    private void loadDia() throws JSONException {

        if (item == null)
        //agencia 11, conta 22, mes 11, ano 2017
            new HttpLoadMes(common, this, "dadositemMes/2763/105159/12/2017", txtmsg).execute();
        else
            new HttpLoadItem(common, this, "dadositemMes/2763/105159/12/2017").execute();

    }
}
