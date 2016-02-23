package example.com.application02;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Edmundo on 2/16/16.
 */
public class Transporter {
    public static void goToActivity(Context actividadOrigen, String nombreActividad) {
        Class aClass;
        Intent intentDeLaSiguienteActividad;

        aClass = null;
        try {
            aClass = Class.forName("example.com.application02." + nombreActividad);
        } catch (ClassNotFoundException exception) {

        }
        intentDeLaSiguienteActividad = new Intent(actividadOrigen, aClass);
        actividadOrigen.startActivity(intentDeLaSiguienteActividad);
    }


}
