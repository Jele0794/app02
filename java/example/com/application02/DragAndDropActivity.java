package example.com.application02;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class DragAndDropActivity extends AppCompatActivity implements View.OnTouchListener {

    View layoutSuperior;
    View layoutInferior;
    DragListener dragListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop);
        dragListener = new DragListener();

        findViewById(R.id.gecko_img).setOnTouchListener(this);
        findViewById(R.id.croco_img).setOnTouchListener(this);

        layoutSuperior = findViewById(R.id.layout_superior);
        layoutSuperior.setOnDragListener(dragListener);
        layoutInferior = findViewById(R.id.layout_inferior);
        layoutInferior.setOnDragListener(dragListener);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event){
        ClipData clipData;
        View.DragShadowBuilder shadowBuilder;

        if(event.getAction() == MotionEvent.ACTION_DOWN){
            clipData = ClipData.newPlainText("","");
            shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(clipData, shadowBuilder, v, 0);
            v.setVisibility(v.INVISIBLE);
            return true;
        }else {
            return false;
        }
    }
}
