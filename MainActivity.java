package edu.msmary.jepordymain;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import javax.xml.datatype.Duration;

public class MainActivity extends AppCompatActivity {

    boolean JSQ1 = false;
    boolean JSQ2 = false;
    boolean JSQ3 = false;

    boolean PHPQ1 = false;
    boolean PHPQ2 = false;
    boolean PHPQ3 = false;

    boolean AndQ1 = false;
    boolean AndQ2 = false;
    boolean AndQ3 = false;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null)
        {
            JSQ1 = savedInstanceState.getBoolean("JSQ1");
            JSQ2 = savedInstanceState.getBoolean("JSQ2");
            JSQ3 = savedInstanceState.getBoolean("JSQ3");

            PHPQ1 = savedInstanceState.getBoolean("PHPQ1");
            PHPQ2 = savedInstanceState.getBoolean("PHPQ2");
            PHPQ3 = savedInstanceState.getBoolean("PHPQ3");

            AndQ1 = savedInstanceState.getBoolean("AndQ1");
            AndQ2 = savedInstanceState.getBoolean("AndQ2");
            AndQ3 = savedInstanceState.getBoolean("AndQ3");

            score = savedInstanceState.getInt("score");
        }
        TextView scoreView = (TextView) findViewById(R.id.Score);
        scoreView.setText(String.valueOf(score));
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putBoolean("JSQ1",JSQ1);
        savedInstanceState.putBoolean("JSQ2",JSQ2);
        savedInstanceState.putBoolean("JSQ3",JSQ3);

        savedInstanceState.putBoolean("PHPQ1", PHPQ1);
        savedInstanceState.putBoolean("PHPQ2", PHPQ2);
        savedInstanceState.putBoolean("PHPQ3", PHPQ3);

        savedInstanceState.putBoolean("AndQ1",AndQ1);
        savedInstanceState.putBoolean("AndQ2",AndQ2);
        savedInstanceState.putBoolean("AndQ3",AndQ3);

        savedInstanceState.putInt("score",score);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if(resultCode != Activity.RESULT_OK)
            return;
        else{
            TextView scoreView = (TextView) findViewById(R.id.Score);
            int s = intent.getIntExtra("points", 0);
            score += s;
            scoreView.setText(String.valueOf(score));
        }
    }
//JS QUESTION INTENTS
    public void JSQ1(View view) {
        if (JSQ1 == false)
        {
            JSQ1 = true;
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 100);
            intent.putExtra("category", "JS");
            startActivityForResult(intent,0);
        }
        JSQ1 = true;
        view.setBackgroundResource(R.drawable.button_change);

    }
    public void JSQ2(View view) {
        if(JSQ2 == false)
        {
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 200);
            intent.putExtra("category", "JS");
            startActivityForResult(intent, 0);
            JSQ2 = true;
        }
        view.setBackgroundResource(R.drawable.button_change);
    }
    public void JSQ3(View view) {
        if(JSQ3 == false)
        {
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 300);
            intent.putExtra("category", "JS");
            startActivityForResult(intent, 0);
            JSQ3 = true;
        }
        view.setBackgroundResource(R.drawable.button_change);
    }
// PHP QUESTION INTENTS
    public void PHPQ1(View view) {
        if (PHPQ1 == false)
        {
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 100);
            intent.putExtra("category", "PHP");
            startActivityForResult(intent, 0);
            PHPQ1 = true;
            view.setBackgroundResource(R.drawable.button_change);
        }
    }
    public void PHPQ2(View view) {
        if (PHPQ2 == false) {
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 200);
            intent.putExtra("category", "PHP");
            startActivityForResult(intent, 0);
            PHPQ2 = true;
            view.setBackgroundResource(R.drawable.button_change);
        }
    }
    public void PHPQ3(View view) {
        if (PHPQ3 == false)
        {
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 300);
            intent.putExtra("category", "PHP");
            startActivityForResult(intent, 0);
            PHPQ3 = true;
            view.setBackgroundResource(R.drawable.button_change);
        }
    }
//ANDROID QUESTION INTENTS
    public void AndQ1(View view) {
        if (AndQ1 == false) {
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 100);
            intent.putExtra("category", "Android");
            startActivityForResult(intent, 0);
            AndQ1 = true;
            view.setBackgroundResource(R.drawable.button_change);
        }
    }
    public void AndQ2(View view) {
        if(AndQ2 == false) {
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 200);
            intent.putExtra("category", "Android");
            startActivityForResult(intent, 0);
            AndQ2 = true;
            view.setBackgroundResource(R.drawable.button_change);
        }
    }
    public void AndQ3(View view) {
        if(AndQ3 == false) {
            Intent intent = new Intent(this, Questions_Activity.class);
            intent.putExtra("points", 300);
            intent.putExtra("category", "Android");
            startActivityForResult(intent, 0);
            AndQ3 = true;
            view.setBackgroundResource(R.drawable.button_change);
        }
    }
}
