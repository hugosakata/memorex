package memorex.progrid.http;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpBase extends AsyncTask<Void, Void, String> {

    protected String args;

    HttpURLConnection urlConnection;

    @Override
    protected String doInBackground(Void... args) {

        StringBuilder result = new StringBuilder();

        try {
            URL url = new URL(this.args);
            Log.i("memorex", this.args);
            Log.i("memorex", "******************* conectando");
            urlConnection = (HttpURLConnection) url.openConnection();
            Log.i("memorex", "******************* conectado!!!!");
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            Log.i("memorex", "******************* recebeu json");

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
            Log.i("memorex", "******************* server nao encontrado");
            result.append("server nao encontrado");
        } finally {
            urlConnection.disconnect();
            Log.i("memorex", "******************* desconectado");
        }

        Log.i("memorex", "json: " + result.toString());
        return result.toString();
    }
}