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
    DrawScene scene;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scene = new jl.example.drawingmovingballs2.DrawScene(this, start_x, start_y);
        setContentView(scene);
        scene.setOnTouchListener(touchListener);


    }

}