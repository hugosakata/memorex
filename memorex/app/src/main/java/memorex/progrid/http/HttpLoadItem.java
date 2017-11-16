package memorex.progrid.http;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import memorex.progrid.activities.CalendarActivity;
import memorex.progrid.activities.ItemActivity;
import memorex.progrid.base.Common;
import memorex.progrid.base.ManipuladorJson;

public class HttpLoadItem extends HttpBase {

    private Common common;
    private Context context;
    private View view;

    public HttpLoadItem(Common common, Context context, String url){

        this.common = common;
        this.context = context;
        this.args = common.url_server + url;
        this.view = view;

    }

    @Override
    protected void onPostExecute(String result) {
        if (common.mes == null)
            try {
                //exemplo de carregamento de dados
                //common.mes = ManipuladorJson.jsonMesToBase(result);

                //Todo: carregar o objeto item e passar como paramentro

                Log.i("memorex", "Start Item");
                context.startActivity(new Intent(context.getApplicationContext(), ItemActivity.class));

            } catch (Exception e) {

            }
    }
}