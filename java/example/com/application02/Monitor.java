package example.com.application02;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

/**
 * Created by Edmundo on 2/16/16.
 */
public class Monitor {

    static Toast toast;

    public static void showMessage(Context activityOrigen, String mensaje){

        toast = Toast.makeText(activityOrigen, mensaje, Toast.LENGTH_SHORT);
        toast.show();

    }

}
