package memorex.progrid.activities;

import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.ServiceCallback;

import memorex.progrid.memorex2.R;

public class RexActivity extends ActivityBase {
//AppCompatActivity

    protected ImageView logoRex;
    protected ImageView btnRex;
    protected ImageView btnlistOrCal;
    protected TextView titulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_rex);
        //Alterações de ícones

        memoBtn = (ImageView) findViewById(R.id.memoBtn);
        memoBtn.setVisibility(View.GONE);
        memoBtnInativo = (ImageView) findViewById(R.id.memoBtnInativo);
        memoBtnInativo.setVisibility(View.VISIBLE);

        botRexInativo = (ImageView) findViewById(R.id.botRexInativo);
        botRexInativo.setVisibility(View.GONE);
        botRex = (ImageView) findViewById(R.id.botRex);
        botRex.setVisibility(View.VISIBLE);

        btnlistOrCal = (ImageView) findViewById(R.id.btnListOrCal);
        btnlistOrCal.setImageResource(R.drawable.rexlogoredm);
        titulo = (TextView) findViewById(R.id.textBase);
        titulo.setText("Rex");


        //btnPesquisar.setOnClickListener(new View.OnClickListener() {
        //   @Override
        //    public void onClick(View v) {
        //        startActivity(new Intent(getApplicationContext(), PesquisarActivity.class ));
        //    }
        //});



        //Instância do base
        LinearLayout linear = (LinearLayout) View.inflate(this,
                R.layout.activity_rex, null);
        base.addView(linear, new ViewGroup.LayoutParams(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT));
        //***********

        final TextView conversation = (TextView)findViewById(R.id.conversation);//Saída
        final EditText userInput = (EditText)findViewById(R.id.user_input);//Entrada

        // A classe conversationService instância o SDK do Watson
        final ConversationService myConversationService =
                new ConversationService(
                        "2017-05-26",//Define o Version, padrão do Watson
                        getString(R.string.username), //Puxando o UserName
                        getString(R.string.password) //Puxando a senha
                );

        //Escuta o texto do editText
        userInput.setOnEditorActionListener(new TextView
                .OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView tv,
                                          int action, KeyEvent keyEvent) {
                if(action == EditorInfo.IME_ACTION_DONE) {
                    // More code here
                    final String inputText = userInput.getText().toString();
                    conversation.append(
                            Html.fromHtml("<p><b>Você:</b> " + inputText + "</p>")
                    );
                    // Optionally, clear edittext
                    userInput.setText("");

                    //Mensagem sendo enviada para o Watson
                    MessageRequest request = new MessageRequest.Builder()
                            .inputText(inputText)
                            .build();

                    myConversationService
                            .message(getString(R.string.workspace), request)//envia a mensagem
                            .enqueue(new ServiceCallback<MessageResponse>() {//Obtém a resposta do serviço
                                @Override
                                public void onResponse(MessageResponse response) {
                                    // More code here
                                    final String outputText = response.getText().get(0);
                                    //Anexa no TextView
                                    runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            conversation.append(
                                                    Html.fromHtml("<p><b>Rex:</b> " +
                                                            outputText + "</p>")
                                            );
                                        }
                                    });
                                }

                                @Override
                                public void onFailure(Exception e) {}
                            });
                }
                return false;
            }
        });
    }
}
