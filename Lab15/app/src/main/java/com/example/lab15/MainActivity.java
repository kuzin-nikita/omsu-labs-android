package com.example.lab15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private float convertParrotToMeter(float parrot) {
        return (float) (parrot / 7.6);
    }

    private float convertMeterToParrot(float meter) {
        return (float) (meter * 7.6);
    }

    public void onClick(View view) {

        RadioButton meterRadioButton = findViewById(R.id.radioButton_meters);
        EditText inputEditText = findViewById(R.id.editText);

        if (inputEditText.getText().length() == 0) {
            Toast.makeText(getApplicationContext(), "Введите длину кота",
                    Toast.LENGTH_LONG).show();
            return;
        }

        float inputValue = Float.parseFloat(inputEditText.getText().toString());
        if (meterRadioButton.isChecked()) {
            inputEditText.setText(String
                    .valueOf(convertParrotToMeter(inputValue)));
        } else {
            inputEditText.setText(String
                    .valueOf(convertMeterToParrot(inputValue)));
        }
    }
}