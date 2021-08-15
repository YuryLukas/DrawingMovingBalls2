package jl.example.drawingmovingballs2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class DrawScene<touchListener> extends View {
    private Paint canvasPaint;
    private Paint circlePaint;

    private Boolean stopRun = true;
    private int x;
    private int y;
    private int circleRadius=50;

    private int dx = 5;
    private int dy = 5;
    private final int FRAME_RATE = 30;

    private int scene_width;
    private int scene_height;

    private float touchX;
    private float touchY;

    private Handler h;

    public DrawScene(Context context, int start_x, int start_y) {
        super(context);
        x=start_x;
        y=start_y;

        canvasPaint = new Paint();
        canvasPaint.setStyle(Paint.Style.FILL);
        canvasPaint.setColor(Color.YELLOW);

        circlePaint = new Paint();
        circlePaint.setColor(Color.GREEN);

        h = new Handler();
    }

    private Runnable r = new Runnable() {
        @Override
        public void run()
        {
                invalidate();
        }
    };

    @Override
    protected void onDraw(Canvas sceneCanvas) {


            super.onDraw(sceneCanvas);

            sceneCanvas.drawPaint(canvasPaint);
            scene_width = this.getWidth();
            scene_height = this.getHeight();

            sceneCanvas.drawCircle(x, y, circleRadius, circlePaint);
        if(stopRun) {
            x += dx;
            y += dy;

            if ((x > scene_width - circleRadius) || (x < circleRadius)) {
                dx = dx * -1;
            }

            if ((y > scene_height - circleRadius) || (y < circleRadius)) {
                dy = dy * -1;
            }
        }
            h.postDelayed(r, FRAME_RATE);

    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public Boolean getStopRun() {
        return stopRun;
    }

    public void setStopRun(Boolean stopRun) {
        this.stopRun = stopRun;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX=event.getX();
        touchY=event.getY();


        if(touchX + 50 > getX() & touchX - 50 < getX() & touchY+50 > getY() & touchY-50 < getY() )
        {
            setStopRun(!getStopRun());
        }
        return super.onTouchEvent(event);
    }
}

