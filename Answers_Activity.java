package edu.msmary.jepordymain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class Answers_Activity extends AppCompatActivity {

    ArrayList<String> jsAnswers = new ArrayList<>();
    ArrayList<String> phpAnswers = new ArrayList<>();
    ArrayList<String> andAnswers = new ArrayList<>();

    int value;
    int index;
    String input;
    String cat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answers);

        Collections.addAll(jsAnswers,"Client","document.write()", "document.getElementById()", "var", "No", "===","<script></script>","function");
        Collections.addAll(phpAnswers,"Server","$","GET","POST","No","dot","<?...?>","echo");
        Collections.addAll(andAnswers,"Intent","Layout","Activities","match_parent","findViewById(R.id.id)","onCreate()","AndroidManifest.XML","onSaveInstanceState()");

        Intent intent = getIntent();
        index = intent.getIntExtra("index", 0);
        cat = intent.getStringExtra("category");
        input = intent.getStringExtra("input");
        value = intent.getIntExtra("points",0);

        TextView Answer_View = (TextView) findViewById(R.id.Answer);
        if(input.equals(jsAnswers.get(index))|| input.equals(phpAnswers.get(index)) || input.equals(andAnswers.get(index)))
            Answer_View.setText("Correct Answer! You've been awarded: "+value+" points.");
        else {
            Answer_View.setText("Incorrect! Hit the return button to keep playing.");
            value = 0;
        }
    }

    public void onReturn(View view) {
        Intent Return = new Intent(this, Questions_Activity.class);
        Return.putExtra("points", value);
        setResult(RESULT_OK, Return);
        finish();
    }
}
