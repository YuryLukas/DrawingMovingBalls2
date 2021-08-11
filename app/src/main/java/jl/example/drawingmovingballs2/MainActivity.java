package jl.example.drawingmovingballs2;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private int start_x =50;
    private int start_y =50;
    private View.OnTouchListener touchListener;
    private float touchX;
    private float touchY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jl.example.drawingmovingballs2.DrawScene scene = new jl.example.drawingmovingballs2.DrawScene(this, start_x, start_y);
        setContentView(scene);
        scene.setOnTouchListener(touchListener);

        touchListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                touchX = motionEvent.getX();
                touchY = motionEvent.getY();

                if(scene.getX()+50 < touchX & scene.getX()-50 > touchX & scene.getY()+50 < touchY & scene.getY()-50 >touchY ) {

                }
                return false;
            }
        }
    }




}