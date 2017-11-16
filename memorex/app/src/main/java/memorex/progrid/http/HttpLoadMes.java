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
                    return;
                }
            }
        }
        Log.i("memorex", "Start");
        context.startActivity(new Intent(context.getApplicationContext(), CalendarActivity.class));
        ((Activity)context).finish();

    }
}