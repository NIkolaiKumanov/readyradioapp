package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    String RADIO_STREAM_URL = "https://us2.internet-radio.com/proxy/woro?mp=/stream;";
    MediaPlayer mediaPlayer;
    boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void launchRock(View view){
        Intent i = new Intent(this, RockActivity.class);
        startActivity(i);
    }

//    public void onPlayPauseClicked(View view) {
//        Button playPauseButton = findViewById(R.id.btnPlay);
//        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
//            mediaPlayer.pause();
//            isPlaying = false;
//            playPauseButton.setText("Play");
//        } else {
//            if (!isPlaying) {
//               initializeMediaPlayer();
//                }
//            playPauseButton.setText("Pause");
//        }
//
//    }

    private void initializeMediaPlayer() {
            mediaPlayer = new MediaPlayer();
            mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setLegacyStreamType(AudioManager.STREAM_MUSIC)
                    .build());
            try {
                mediaPlayer.setDataSource(RADIO_STREAM_URL);
                mediaPlayer.prepare();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            mediaPlayer.start();
    }

}