package com.example.androidstudio.loginactivityanicietej;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Main_Menu extends AppCompatActivity {
    float x1 =0, x2 = 0, y1 = 0, y2 = 0;

    EditText editText_init;
    EditText editText_final;
    EditText editText_diff;
    EditText editText_motion;
    EditText editText_quadrant;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu);

        editText_init = (EditText) findViewById(R.id.editText_init);
        editText_final = (EditText) findViewById(R.id.editText_final);
        editText_diff = (EditText) findViewById(R.id.editText_diff);
        editText_motion = (EditText) findViewById(R.id.editText_motion);
        editText_quadrant = (EditText) findViewById(R.id.editText_quadrant);
 
        final ImageView image = (ImageView)findViewById(R.id.imageView);
        image.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int event = motionEvent.getAction();
                switch (event){
                    case MotionEvent.ACTION_DOWN:
                        x1 = motionEvent.getX();
                        y1 = motionEvent.getY();
                        editText_init.setText(""+String.format("X: %2f, Y: %.2f",x1,y1));
                        return true;
                    case MotionEvent.ACTION_UP:
                        x2 = motionEvent.getX();
                        y2 = motionEvent.getY();
                        editText_final.setText(""+ String.format("X: %2f, Y: %.2f",x2,y2));
                        motionDisplay(x1,x2,y1,y2);
                        quadrantDisplay(x1,x2,y1,y2);
                }
                return false;
            }

            public void motionDisplay(float x1, float x2, float y1, float y2){
                String msg = "";
                float X=0, Y=0;
                if (x1<x2) {
                    msg += String.format("Left to Right");
                    X = x2 - x1;
                } else if (x1>x2){
                    msg += String.format("Right to Left");
                    X = x1 - x2;
                }

                if (y1<y2){
                    msg += String.format("   Up to Down");
                    Y = y2 - y1;
                } else  if (y1>y2){
                    msg += String.format("   Down to Up");
                    Y = y1 - y2;
                }
                editText_motion.setText(""+msg);

                editText_diff.setText(""+String.format("X: %2f, Y: %.2f",X,Y));
            }

            public void quadrantDisplay(float x1, float x2, float y1, float y2){
                if (x1<x2 && y1<y2){
                    editText_quadrant.setText("Quadrant 4");
                } else if (x1>x2 && y1<y2){
                    editText_quadrant.setText("Quadrant 3");
                } else if (x1>x2 && y1>y2){
                    editText_quadrant.setText("Quadrant 2");
                } else if(x1<x2 && y1>y2){
                    editText_quadrant.setText("Quadrant 1");
                } else{
                    editText_quadrant.setText("");
                }

            }

        });
    }
}
