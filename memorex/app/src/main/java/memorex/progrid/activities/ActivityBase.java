package memorex.progrid.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;

import memorex.progrid.base.Common;
import memorex.progrid.base.ManipuladorJson;
import memorex.progrid.http.HttpLoadMes;
import memorex.progrid.memorex2.R;

import com.onesignal.OneSignal;

public class ActivityBase extends AppCompatActivity {

    protected FrameLayout base;
    protected Common common;
    protected ImageView btnListOrCal;
    protected ImageView btnPesquisar;
    protected ImageView btnLembrete;
    protected ImageView botRex;
    protected ImageView botRexInativo;
    protected ImageView memoBtnInativo;
    protected ImageView memoBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_base);

        common = (Common)getApplicationContext();

        botRexInativo = (ImageView) findViewById(R.id.botRexInativo);
        botRexInativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RexActivity.class));

            }
        });

        memoBtnInativo = (ImageView) findViewById(R.id.memoBtnInativo);
        memoBtnInativo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CalendarActivity.class));

            }
        });

        btnListOrCal = (ImageView) findViewById(R.id.btnListOrCal);

        btnPesquisar = (ImageView) findViewById(R.id.btnPesquisar);
        btnPesquisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnLembrete = (ImageView) findViewById(R.id.btnLembrete);
        btnLembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityBase.this, LembreteActivity.class));
            }
        });

        base = (FrameLayout) findViewById(R.id.base);

        try {
            loadDia();
        } catch (JSONException e) {

        }
    }

    private void loadDia() throws JSONException {

        //agencia 11, conta 22, mes 11, ano 2017
        //new HttpLoadMes(common, "dadositemMes/11/22/11/2017", btnLembrete).execute();


        String json = "{\n" +
                "  \"mes\": 10,\n" +
                "  \"ano\": 2017,\n" +
                "  \"dias\":[\n" +
                "    {\n" +
                "      \"dia\":1,\n" +
                "      \"titulos\": [\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"asd\",\n" +
                "          \"valor\": \"R$4050,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdsaf\",\n" +
                "          \"valor\": \"R$50,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"fdasfa\",\n" +
                "          \"valor\": \"R$452,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 1,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"2a\",\n" +
                "          \"valor\": \"R$450,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 2,\n" +
                "          \"sinal\": 2,\n" +
                "          \"grupo\": 2,\n" +
                "          \"nome\": \"1b\",\n" +
                "          \"valor\": \"R$40,00\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"dia\":13,\n" +
                "      \"titulos\": [\n" +
                "        {\n" +
                "          \"id\": 3,\n" +
                "          \"sinal\": 3,\n" +
                "          \"grupo\": 3,\n" +
                "          \"nome\": \"13a\",\n" +
                "          \"valor\": \"R$450,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 4,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"13b\",\n" +
                "          \"valor\": \"R$40,00\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"dia\":16,\n" +
                "      \"titulos\": [\n" +
                "        {\n" +
                "          \"id\": 5,\n" +
                "          \"sinal\": 5,\n" +
                "          \"grupo\": 2,\n" +
                "          \"nome\": \"16a\",\n" +
                "          \"valor\": \"R$52,00\"\n" +
                "        }\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"dia\":18,\n" +
                "      \"titulos\": [\n" +
                "        {\n" +
                "          \"id\": 6,\n" +
                "          \"sinal\": 4,\n" +
                "          \"grupo\": 3,\n" +
                "          \"nome\": \"18a\",\n" +
                "          \"valor\": \"R$52,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 7,\n" +
                "          \"sinal\": 5,\n" +
                "          \"grupo\": 1,\n" +
                "          \"nome\": \"18a\",\n" +
                "          \"valor\": \"R$2,00\"\n" +
                "        },\n" +
                "        {\n" +
                "          \"id\": 8,\n" +
                "          \"sinal\": 1,\n" +
                "          \"grupo\": 2,\n" +
                "          \"nome\": \"18a\",\n" +
                "          \"valor\": \"R$2000,00\"\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        //Toast.makeText(getApplicationContext(), "certo",Toast.LENGTH_LONG).show();
    }
}
