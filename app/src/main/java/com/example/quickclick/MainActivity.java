package com.example.quickclick;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Point;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //instantiate app elements
    Button press1, press2;
    TextView textView1, textView2, highScore;
    int clickNum = 0;
    int seconds = 20;
    int hs = 0;
    //bool flip = true;

    /*
    Display display = getWindowManager().getDefaultDisplay();
    Point size = new Point();
    display.getSize(size);
    int width = size.x;
    int height = size.y;
    */
    Random r = new Random();
    //int i1 = r.nextInt(80 - 65) + 65;


    //count down timer, 1 second == 1000 milisecond
    final CountDownTimer timer = new CountDownTimer(20000, 1000) {
        @Override
        public void onTick(long millisUntilFinished) {
            seconds--;
            textView1.setText("Time Left: "+seconds+" s");
        }

        //When the timer runs out
        @Override
        public void onFinish() {
            press1.setEnabled(false);
            press2.setEnabled(true);
            seconds = 20;
            press2.setText("Start Game");
            press1.setText("Don't Click Here");
            if(clickNum > hs)
            {
                hs = clickNum;
            }
            highScore.setText("High Score: "+hs+" ");
        }
    };



    //####################################################
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set objects to variables
        press1 = (Button) findViewById(R.id.press1);
        press2 = (Button) findViewById(R.id.press2);

        textView1 = (TextView) findViewById(R.id.textView1);
        textView2 = (TextView) findViewById(R.id.textView2);
        highScore = (TextView) findViewById(R.id.highScore);


        press1.setEnabled(false);
        press2.setEnabled(true);
        press2.setText("Start Game");
        press1.setText("Don't Click Here");

        //when start button is pressed
        press2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-----------------------------

                if(seconds >= 20)
                {
                    press1.setEnabled(true);
                    press2.setEnabled(false);
                    clickNum = 0;
                    textView2.setText(("Number Of Clicks: "+clickNum));
                    press2.setText("Don't Click Here");
                    press1.setText("Click Here");
                    timer.start();

                }
                else {
                    press2.setText("Don't Click Here");
                    press1.setText("Click Here");
                    clickNum++;
                    textView2.setText(("Number Of Clicks: " + clickNum));
                    press1.setEnabled(true);
                    press2.setEnabled(false);
                }

            }
        });



        //when click button is pressed
        press1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-----------------------------
                //press1.setX(press1.getX()+100);
               //press1.setX( r.nextInt(0 - 1 ) + 1);
               //press1.setY( r.nextInt(0 - 10) + 10);
                clickNum++;
                textView2.setText(("Number Of Clicks: "+clickNum));
                //set button active/inactive
                press2.setEnabled(true);
                press1.setEnabled(false);

                press1.setText("Don't Click Here");
                press2.setText("Click Here");
            }
        });

    }
}
