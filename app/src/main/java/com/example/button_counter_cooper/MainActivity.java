package com.example.button_counter_cooper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int count = 0;

    Button incButton;
    Button decButton;
    Button resButton;
    TextView counter;


    // to save state, onSavedInstance state, onRestoreInstanceState
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = (TextView) findViewById(R.id.counter);

        incButton = (Button) findViewById(R.id.IncButton);
        incButton.setOnClickListener(this);

        decButton = (Button) findViewById(R.id.DecButton);
        decButton.setOnClickListener(this);

        resButton = (Button) findViewById(R.id.ResButton);
        resButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v == incButton){
            count++;
            counter.setText("" + count);
        }

        if(v == decButton){
            count--;
            counter.setText("" + count);
        }

        if(v == resButton){
            count = 0;
            counter.setText("" + count);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        int counterInt = count;
        outState.putInt("counterIntKey", counterInt);

        String counterStr = counter.getText().toString();  //need to save state of counter
        outState.putString("counterStrKey", counterStr);


    }

    @Override
    protected void onRestoreInstanceState(Bundle bundle){
        super.onRestoreInstanceState(bundle);

        int counterInt = bundle.getInt("counterIntKey");
        count = counterInt;

        String counterStr = bundle.getString("counterStrKey");
        counter.setText(counterStr);

    }
}
