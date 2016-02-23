package example.com.application02;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Edmundo on 2/22/16.
 */
public class DragListener implements View.OnDragListener{

    private int colorFondo;
    @Override
    public boolean onDrag(View elLayout, DragEvent event) {
        ColorDrawable colorBackground;
        View escudo;
        ViewGroup viewGroup;
        LinearLayout layoutLineal;



        switch (event.getAction()){
            case DragEvent.ACTION_DRAG_STARTED:
                colorBackground = (ColorDrawable) elLayout.getBackground();
                colorFondo = colorBackground.getColor();
            case DragEvent.ACTION_DRAG_ENTERED:
                elLayout.setBackgroundColor(Color.GRAY);
                break;
            case DragEvent.ACTION_DROP:
                escudo = (View) event.getLocalState();
                viewGroup = (ViewGroup) escudo.getParent();
                viewGroup.removeView(escudo);
                layoutLineal = (LinearLayout) elLayout;
                layoutLineal.addView(escudo);
                escudo.setVisibility(View.VISIBLE);
                elLayout.setBackgroundColor(colorFondo);
                break;
            case DragEvent.ACTION_DRAG_EXITED:
                elLayout.setBackgroundColor(Color.rgb(201, 186, 16));
                break;
            case DragEvent.ACTION_DRAG_ENDED:
                elLayout.setBackgroundColor(colorFondo);
                break;
        }
        return true;
    }
}
