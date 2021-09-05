package com.gauravssnl.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.gauravssnl.countdowntimer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;

    private long timeElapsed;
    private boolean timerHasStarted = false;
    private final long startTime = 50* 1000;
    private final long interval = 1 * 1000;

    private Button startButton;
    private TextView timerTextView;
    private TextView timeElapsedTextView;

    private MyCountDownTimer countDownTimer;

    private TextView developerTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        startButton = binding.button;
        startButton.setOnClickListener(this);

        timerTextView = binding.timerTextView;
        timeElapsedTextView = binding.timeElapsedTextView;
        developerTextView = binding.developerTextView;

        countDownTimer = new MyCountDownTimer(startTime, interval);
        timerTextView.setText(timerTextView.getText() + String.valueOf(startTime));

    }

    @Override
    public void onClick(View view) {
        if (!timerHasStarted) {
            countDownTimer.start();
            timerHasStarted = true;
            startButton.setText("RESET");
        } else {
            countDownTimer.cancel();
            timerHasStarted = false;
            startButton.setText("Start");
        }
    }

    public class MyCountDownTimer extends CountDownTimer {

        public MyCountDownTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            timerTextView.setText("Time remaining: " + millisUntilFinished);
            Log.d("millisUntilFinished: " , String.valueOf(millisUntilFinished));
            timeElapsed = startTime - millisUntilFinished;
            timeElapsedTextView.setText("Time Elapsed: " + timeElapsed);

            developerTextView.setText(" " + developerTextView.getText());
        }

        @Override
        public void onFinish() {
            timerTextView.setText("Time's up!");
            timeElapsedTextView.setText("Time Elapsed: " + String.valueOf(startTime));

            developerTextView.setText(developerTextView.getText().toString().trim());
        }
    }
}
