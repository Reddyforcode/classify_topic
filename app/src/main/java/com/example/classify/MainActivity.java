package com.example.classify;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// Utils
import com.example.classify.Utils;
public class MainActivity extends AppCompatActivity {

    Button btn;
    EditText input;
    TextView output;
    // Util
    Utils ut = new Utils();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        input = findViewById(R.id.input);
        output = findViewById(R.id.output);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s_out = ut.category(input.getText().toString());

                output.setText(s_out);
            }
        });
    }



}
