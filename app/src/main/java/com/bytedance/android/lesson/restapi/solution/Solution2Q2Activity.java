package com.bytedance.android.lesson.restapi.solution;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import com.bytedance.android.lesson.restapi.solution.bean.PostVideoResponse;

import java.io.IOException;

public class Solution2Q2Activity extends AppCompatActivity implements MediaPlayer.OnCompletionListener {

    private boolean isPlayingVideo = false;
    private TextView user_name;
    private TextView user_id;
    private TextView currentTime;
    private TextView totalTime;
    private SurfaceHolder holder;
    private MediaPlayer mediaPlayer = null;

    private final int NORMAL = 0;
    private final int PLAYING = 1;
    private final int PAUSING = 2;
    private final int STOPING = 3;

    private int state = NORMAL;

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solution2_q2);

        user_name = findViewById(R.id.tv_name);
        user_id   = findViewById(R.id.tv_id);
        currentTime = findViewById(R.id.tv_progress_now);
        totalTime   = findViewById(R.id.tv_progress_now);

        SurfaceView surfaceView = findViewById(R.id.sv);
        holder = surfaceView.getHolder();
        intent = getIntent();

        user_id.setText(intent.getStringExtra("USER_ID"));
        user_name.setText(intent.getStringExtra("USER_NAME"));

    }

    public void start(View view){
        if(mediaPlayer != null){
            if(state != PAUSING){
                mediaPlayer.start();
                state = PLAYING;

                isPlayingVideo = false;
                return;
            }
            else if(state == STOPING){
                mediaPlayer.reset();
                mediaPlayer.release();
            }
        }

        play();
    }

    public void  stop(View v){
        if(mediaPlayer != null){
            mediaPlayer.stop();
           // state = STOPING;
        }
    }

    public  void play(){
        String url = intent.getStringExtra("VIDEO_URL");
        //<TODO>二次建对象mediaPlayer是什么操作...
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mediaPlayer.setDisplay(holder);

            mediaPlayer.setDataSource(url);
            mediaPlayer.prepare();
            mediaPlayer.start();

            mediaPlayer.setOnCompletionListener(this);

            state = PLAYING;

            int duration = mediaPlayer.getDuration();

            int m = duration / 1000 / 60;
            int s = duration / 1000 % 60;

            totalTime.setText("/"+m+":"+s);
            currentTime.setText("00:00");

            isPlayingVideo = false;
            new Thread(new UpdateProgressRunnable()).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void pause(View view){
        if(mediaPlayer != null && state == PLAYING){
            mediaPlayer.pause();
            state = PAUSING;

            isPlayingVideo = false;
        }
    }

    public void restart(View view){
        if(mediaPlayer != null){
            mediaPlayer.reset();
            mediaPlayer.release();
            play();
        }
    }
    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        Toast.makeText(this,"Finished,play again",Toast.LENGTH_SHORT).show();
        mediaPlayer.start();
    }

    private class UpdateProgressRunnable implements Runnable {
        @Override
        public void run() {
            while (!isPlayingVideo){
                int currentPosition = mediaPlayer.getCurrentPosition();
                final int m = currentPosition / 1000 / 60;
                final int s = currentPosition / 1000 % 60;

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        currentTime.setText(m+":"+s);
                    }
                });
                SystemClock.sleep(1000);
            }
        }
    }
}
