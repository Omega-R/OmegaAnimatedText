package com.omega.omegaanimatedtext;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.omega.animatedtext.AnimatedTextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AnimatedTextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.fwd_button).setOnClickListener(this);
        findViewById(R.id.fwd_italic_button).setOnClickListener(this);
        findViewById(R.id.back_button).setOnClickListener(this);
        findViewById(R.id.back_italic_button).setOnClickListener(this);
        mTextView = findViewById(R.id.strokeTextView);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case (R.id.fwd_button):
                mTextView.createStrokeAnimator(0.05f).start();
                break;
            case (R.id.fwd_italic_button):
                mTextView.createItalicAnimator(0.4f)
                        .setDuration(1000)
                        .start();
                break;
            case (R.id.back_button):
                mTextView.createStrokeAnimator(0.0f).start();
                break;
            case (R.id.back_italic_button):
                mTextView.createItalicAnimator(0.0f)
                        .setDuration(1000)
                        .start();
                break;
            default:
                break;
        }
    }
}
