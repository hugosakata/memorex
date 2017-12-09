package memorex.progrid.base;

import android.app.Application;
import android.content.Intent;
import android.util.Log;

import java.util.Date;
import java.util.List;

import com.onesignal.OSNotificationAction;
import com.onesignal.OSNotificationOpenResult;
import com.onesignal.OneSignal;

import org.json.JSONObject;

import memorex.progrid.activities.CalendarActivity;
import memorex.progrid.activities.ItemActivity;

/**
 * Created by progrid on 19/10/17.
 */
public class Common extends Application {

    public static Mes mes = null;
    public static Date diaCorrente;
    public static String url_server = "http://192.168.43.47:8080/MemorexWs/webresources/memorex/memorex/";


    public Item getItem(int customKey) {
        Item item = null;




        List<Dia> dias = mes.getDias();

        Log.i("memorex", "dias *****************" + dias);
        for (int i = 0; i < dias.size(); i++) {
            List<Item> itens= dias.get(i).getItens();

            Log.i("memorex", "itens *****************" + itens);
            for (int j = 0; j < itens.size(); j++) {

                if (itens.get(j).getId() == customKey) {
                    Log.i("memorex", "Item encontrado *****************");
                    item = itens.get(j);
                    break;
                }
            }
        }

        return item;
    }

    public Dia getDate(int intDia, int intMes, int intANo) {
        Dia dia = null;

        for (int i = 0; i < mes.getDias().size(); i++) {
            Dia aux_dia = mes.getDias().get(i);
            if (aux_dia.getDia() == intDia && aux_dia.getMes() == intMes && aux_dia.getAno() == intANo)
                dia = aux_dia;
        }

        return dia;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Logging set to help debug issues, remove before releasing your app.
        //OneSignal.setLogLevel(OneSignal.LOG_LEVEL.DEBUG, OneSignal.LOG_LEVEL.WARN);

        OneSignal.startInit(this)
                .autoPromptLocation(false) // default call promptLocation later
                .setNotificationOpenedHandler(new ExampleNotificationOpenedHandler())
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        // Call syncHashedEmail anywhere in your app if you have the user's email.
        // This improves the effect.iveness of OneSignal's "best-time" notification scheduling feature.
        // OneSignal.syncHashedEmail(userEmail);
    }


    private class ExampleNotificationOpenedHandler implements OneSignal.NotificationOpenedHandler {
        // This fires when a notification is opened by tapping on it.
        @Override
        public void notificationOpened(OSNotificationOpenResult result) {
            OSNotificationAction.ActionType actionType = result.action.type;
            JSONObject data = result.notification.payload.additionalData;
            String launchUrl = result.notification.payload.launchURL; // update docs launchUrl

            String customKey = "0";
            String openURL = null;
            Object activityToLaunch = CalendarActivity.class;

            if (data != null) {
                customKey = data.optString("ID", null);
                openURL = data.optString("openURL", null);

                if (customKey != null)
                    Log.i("OneSignalExample", "customkey set with value: " + customKey);

                if (openURL != null)
                    Log.i("OneSignalExample", "openURL to webview with URL value: " + openURL);
            }

            if (actionType == OSNotificationAction.ActionType.ActionTaken) {
                Log.i("OneSignalExample", "Button pressed with id: " + result.action.actionID);
                if (result.action.actionID.equals("id1")) {
                    Log.i("OneSignalExample", "button id called: " + result.action.actionID);
                    activityToLaunch = ItemActivity.class;
                } else {
                    Log.i("OneSignalExample", "button id called: " + result.action.actionID);
                }

            }
            // The following can be used to open an Activity of your choice.
            // Replace - getApplicationContext() - with any Android Context.
            // Intent intent = new Intent(getApplicationContext(), YourActivity.class);
            Intent intent = new Intent(getApplicationContext(), ItemActivity.class);
            // intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT | Intent.FLAG_ACTIVITY_NEW_TASK);

            Log.i("memorex", "customKEY: " + customKey);
            Item item = getItem(Integer.parseInt(customKey));
            intent.putExtra("item", item);
            Log.i("OneSignalExample", "openURL = " + openURL);
            // startActivity(intent);
            startActivity(intent);

            // Add the following to your AndroidManifest.xml to prevent the launching of your main Activity
            //   if you are calling startActivity above.
     /*
        <application ...>
          <meta-data android:name="com.onesignal.NotificationOpened.DEFAULT" android:value="DISABLE" />
        </application>
     */


        }

    }
}
