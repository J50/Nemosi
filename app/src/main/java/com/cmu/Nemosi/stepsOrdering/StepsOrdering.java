package com.cmu.Nemosi.stepsOrdering;





import android.os.SystemClock;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.MotionEvent;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.cmu.Nemosi.R;


public class StepsOrdering extends Activity implements View.OnClickListener{
    private ViewGroup mainLayout;
    private ImageView image1,image2,image3,image4,image5,image6;

    private int xDelta,yDelta;


    private EditText inputOrder;
    private Button submit;
    private TextView result;
    private int numberToFind=654321,numberTries;
    private Chronometer timer;
    private long lastPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_steps_ordering);
        mainLayout=(RelativeLayout) findViewById(R.id.main);
        image1=(ImageView) findViewById(R.id.iv_1);
        image2=(ImageView) findViewById(R.id.iv_2);
        image3=(ImageView) findViewById(R.id.iv_3);
        image4=(ImageView) findViewById(R.id.iv_4);
        image5=(ImageView) findViewById(R.id.iv_5);
        image6=(ImageView) findViewById(R.id.iv_6);

        timer=(Chronometer) findViewById(R.id.timer);
        result=(TextView) findViewById(R.id.result);
        inputOrder=(EditText) findViewById(R.id.order);
        submit=(Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);

        image1.setOnTouchListener(onTouchListener());
        image2.setOnTouchListener(onTouchListener());
        image3.setOnTouchListener(onTouchListener());
        image4.setOnTouchListener(onTouchListener());
        image5.setOnTouchListener(onTouchListener());
        image6.setOnTouchListener(onTouchListener());

        newGame();

    }

    private OnTouchListener onTouchListener(){
        return new OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                final int x=(int) event.getRawX();
                final int y=(int) event.getRawY();

                switch(event.getAction() & MotionEvent.ACTION_MASK){
                    case MotionEvent.ACTION_DOWN:
                        RelativeLayout.LayoutParams lParams=(RelativeLayout.LayoutParams)
                                view.getLayoutParams();

                        xDelta=x-lParams.leftMargin;
                        yDelta=y-lParams.topMargin;
                        break;

                    case MotionEvent.ACTION_UP:
                        break;

                    case MotionEvent.ACTION_MOVE:
                        RelativeLayout.LayoutParams layoutParams=(RelativeLayout.LayoutParams)
                                view.getLayoutParams();
                        layoutParams.leftMargin=x-xDelta;
                        layoutParams.topMargin=y-yDelta;
                        layoutParams.rightMargin=0;
                        layoutParams.bottomMargin=0;
                        view.setLayoutParams(layoutParams);
                        break;
                }
                mainLayout.invalidate();
                return true;
            }
        };
    }

    @Override
    public void onClick(View view){
        if(view==submit){
            validate();
        }
    }

    private void validate(){
        int n=Integer.parseInt(inputOrder.getText().toString());
        numberTries++;
        if(n==numberToFind){
            result.setText(R.string.correct);
            Toast.makeText(this,"Congratulations! You find the order in "+numberTries+" tries ",Toast.LENGTH_SHORT).show();
            timer.stop();
        }else{
            result.setText(R.string.wrong);
            Toast.makeText(this,"Sad! You didn't find the order in "+numberTries+" tries ",Toast.LENGTH_SHORT).show();
        }
    }

    public void newGame(){
        numberToFind=354621;
        result.setText("");
        numberTries=0;
        timer.setBase(SystemClock.elapsedRealtime());
        timer.start();
    }
}



