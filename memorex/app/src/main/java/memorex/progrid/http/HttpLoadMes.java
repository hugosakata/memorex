package memorex.progrid.http;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import memorex.progrid.activities.CalendarActivity;
import memorex.progrid.base.Common;
import memorex.progrid.base.ManipuladorJson;

public class HttpLoadMes extends HttpBase {

    private Common common;
    private Context context;
    private View view;

    public HttpLoadMes(Common common, Context context, String url, View view){

        this.common = common;
        this.context = context;
        this.args = common.url_server + url;
        this.view = view;

    }

    @Override
    protected void onPostExecute(String result) {
        if (common.mes == null) {
            try {
                common.mes = ManipuladorJson.jsonMesToBase(result);
            } catch (JSONException e) {
                if (result.equals("server nao encontrado")) {
                    ((TextView) view).setText(result);
                    try {
                        common.mes = ManipuladorJson.jsonMesToBase(getJsonStatic());
                    } catch (JSONException e1) {

                    }
                    //return;
                }
            }
        }
        Log.i("memorex", "Start");
        context.startActivity(new Intent(context.getApplicationContext(), CalendarActivity.class));
        ((Activity)context).finish();

    }

    private String getJsonStatic(){

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

        return json;
    }
}