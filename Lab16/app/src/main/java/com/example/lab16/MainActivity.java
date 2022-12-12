package com.example.lab16;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private SoundPool mSoundPool;
    private AssetManager mAssetManager;
    private int mCatSound, mDonkeySound, mLionSound, mDogSound, mPigSound, mHorseSound;
    private int mStreamID;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
              // Для устройств до Android 5
              createOldSoundPool();
          } else {
              // Для новых устройств
              createNewSoundPool();
          }

          mAssetManager = getAssets();

//        // получим идентификаторы
        mCatSound = loadSound("MeowSound.ogg");
        mDonkeySound = loadSound("DonkeySound.ogg");
        mLionSound = loadSound("LionSound.wav");
        mDogSound = loadSound("DogSound.ogg");
        mPigSound = loadSound("PigSound.ogg");
        mHorseSound = loadSound("HorseSound.mp3");

        ImageView horseImageButton = findViewById(R.id.horseImage);
        horseImageButton.setOnClickListener(onClickListener);

        ImageView lionImageButton = findViewById(R.id.lionImage);
        lionImageButton.setOnClickListener(onClickListener);

        ImageView catImageButton = findViewById(R.id.catImage);
        catImageButton.setOnClickListener(onClickListener);

        ImageView pigImageButton = findViewById(R.id.pigImage);
        pigImageButton.setOnClickListener(onClickListener);

        ImageView donkeyImageButton = findViewById(R.id.oselImage);
        donkeyImageButton.setOnClickListener(onClickListener);

        ImageView dogImageButton = findViewById(R.id.dogImage);
        dogImageButton.setOnClickListener(onClickListener);


        horseImageButton.setOnTouchListener(new View.OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                int eventAction = event.getAction();
                if (eventAction == MotionEvent.ACTION_UP) {
                    // Отпускаем палец
                    if (mStreamID > 0)
                        mSoundPool.stop(mStreamID);
                }
                if (eventAction == MotionEvent.ACTION_DOWN) {
                    // Нажимаем на кнопку
                    mStreamID = playSound(mHorseSound);
                }
                if (event.getAction() == MotionEvent.ACTION_CANCEL) {
                    mSoundPool.stop(mStreamID);
                }
                return true;
            }
        });

    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.lionImage:
                    playSound(mLionSound);
                    break;
                case R.id.oselImage:
                    playSound(mDonkeySound);
                    break;
                case R.id.catImage:
                    playSound(mCatSound);
                    break;
                case R.id.pigImage:
                    playSound(mPigSound);
                    break;
                case R.id.horseImage:
                    playSound(mHorseSound);
                    break;
                case R.id.dogImage:
                    playSound(mDogSound);
                    break;
            }
        }
    };

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createNewSoundPool() {
        AudioAttributes attributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .build();
        mSoundPool = new SoundPool.Builder()
                .setAudioAttributes(attributes)
                .build();
    }

    @SuppressWarnings("deprecation")
    private void createOldSoundPool() {
        mSoundPool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0);
    }

    private int playSound(int sound) {
        if (sound > 0) {
            mStreamID = mSoundPool.play(sound, 1100, 1100, 1, 0, 1);
        }
        return mStreamID;
    }

    private int loadSound(String fileName) {
        AssetFileDescriptor afd;
        try {
            afd = mAssetManager.openFd(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), "Не могу загрузить файл " + fileName,
                    Toast.LENGTH_SHORT).show();
            return -1;
        }
        return mSoundPool.load(afd, 1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            // Для устройств до Android 5
            createOldSoundPool();
        } else {
            // Для новых устройств
            createNewSoundPool();
        }

        mAssetManager = getAssets();

        // получим идентификаторы
        mCatSound = loadSound("MeowSound.ogg");
        mDonkeySound = loadSound("DonkeySound.ogg");
        mLionSound = loadSound("LionSound.wav");
        mDogSound = loadSound("DogSound.ogg");
        mPigSound = loadSound("PigSound.ogg");
        mHorseSound = loadSound("HorseSound.mp3");

    }

    @Override
    protected void onPause() {
        super.onPause();
        mSoundPool.release();
        mSoundPool = null;
    }
}