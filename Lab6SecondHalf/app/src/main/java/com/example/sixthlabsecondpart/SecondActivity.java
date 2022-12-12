package com.example.sixthlabsecondpart;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    public final static String THIEF = "com.example.sixthlabsecondpart.THIEF";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);


        radioGroup.setOnCheckedChangeListener((radioGroup1, i) -> {
            Intent intent = getIntent();
            switch (i){
                case R.id.nikitosRadioButton:
                    intent.putExtra(THIEF, "Никитос");
                    break;
                case R.id.IluskinRadioButton:
                    intent.putExtra(THIEF, "Ильюшкин");
                    break;
                case R.id.seregaRadioButton:
                    intent.putExtra(THIEF, "Серега");
                    break;
                default:
                    break;
            }
            setResult(RESULT_OK, intent);
            finish();
        });
    }
}
