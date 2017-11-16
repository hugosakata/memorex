package memorex.progrid.base;


import android.app.Application;
import android.os.Environment;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoadMes extends Application {

    private Common common;

    public LoadMes(Common common){
        this.common = common;
    }

    public boolean loadMes(String mes, String ano) throws JSONException {

        boolean resp = false;

        //todo: conectar ao server e puxar o arquivo.json do mes/ano

//        File file = new File(common.path + );
//
//        String services = ReadFromfile(mes+ano+".json");
//
//
//
//        return resp;

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

        if (common.mes == null)
            common.mes = ManipuladorJson.jsonMesToBase(json);
        //Toast.makeText(getApplicationContext(), "certo",Toast.LENGTH_LONG).show();

        return resp;
    }

    private String ReadFromfile(String fileName) {

        String resp = "";

        File sdcard = Environment.getExternalStorageDirectory();

        File file = new File(sdcard,fileName);

        StringBuilder text = new StringBuilder();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                text.append(line);
                text.append('\n');
            }
            br.close();

            resp = text.toString();

        }
        catch (IOException e) {
        }

        return resp;
    }

}