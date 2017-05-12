package com.dummies.silentmodetoggle;
import android.media.AudioManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        audioManager=(AudioManager)getSystemService(AUDIO_SERVICE);
        setContentView(R.layout.activity_main);
        FrameLayout contentView=(FrameLayout)findViewById(R.id.content);
        contentView.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                RingerHelper.performToggle(audioManager);
                updateUI();
            }
        });
    }
    private void updateUI(){
        ImageView imageView=(ImageView)findViewById(R.id.phone_icon);
        int phoneImage = RingerHelper.isPhoneSilent(audioManager)
                ? R.drawable.ringer_off
                : R.drawable.ringer_on;
// Set the imageView to the image in phoneImage
        imageView.setImageResource(phoneImage);
    }
    @Override
    protected void onResume() {
        super.onResume();
// Update our UI in case anything has changed.
        updateUI();
    }
}
