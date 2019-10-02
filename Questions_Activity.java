package edu.msmary.jepordymain;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Questions_Activity extends AppCompatActivity {

    ArrayList<String> jsQuestions = new ArrayList<>();
    ArrayList<String> phpQuestions = new ArrayList<>();
    ArrayList<String> andQuestions = new ArrayList<>();

    ArrayList<String> jsHints = new ArrayList<>();
    ArrayList<String> phpHints = new ArrayList<>();
    ArrayList<String> andHints = new ArrayList<>();


    int value;
    String cat;
    int random;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        
        Collections.addAll(jsQuestions,"In the Client/Server Model, what side does JS run?", "How can you send text directly to an html page in JS?", "How do you grab specific HTML elements using JS?",
                                                "What set of chars is required to declare variables in JS?", "Are types required in variable declaration in JS?","This operation checks if both the type and value of an object are equal in JS?",
                                                "What tags can you use in HTML files to define JS functions?", "What built in method defines functions in JS?");

        Collections.addAll(phpQuestions,"In the Client/Server Model, what side does PHP run?", "What keyboard char is required in variable declaration?","What method of sending data utilizes the URL in PHP?",
                                                "What method of sending data relies on HTML requests in PHP?", "Does PHP utilize types in variable declaration?", "PHP relies on this type of concatenation?",
                                                "What tags can you use in HTML files to define PHP scripts?","PHP utilizes this method to write to the document");

        Collections.addAll(andQuestions,"Android uses this method to send data and start activates","This XML files defines the UI/design of each linked activity in Android?","Android utilizes this to give apps functionality? ",
                                                "Fill in the blank to make this object the same width as its parent", "What method does Android use to find specific views?", "What is the first method in the Activity life Cycle defined by Android?",
                                                "This file holds and declares essential information concerning the App, such as its name, activities, and permissions", "What method is implemented to ensure the state of applications is preserved in Android?");

        //Silly hints are given in the text field where the user provides his/her answer
        Collections.addAll(jsHints,"Browser","d.w","d.gebi","starts with a V!","niet","3*=","<...></...>","func");
        Collections.addAll(phpHints,"Not Browser","Make it Rain", "G!","P!","niet",".","<...>", "This happens in caves" );
        Collections.addAll(andHints,"A synonym is purpose","It can be found in the resource file", "Constructed in JAVA", "android:layout_width=", "fVBI(..)","oC()","Its an XML file!","oSIS()" );

        //Random value is stored for later use when comparing question to answer indicies.
        Random r = new Random();
        random = r.nextInt(jsQuestions.size());

        Intent intent = getIntent();
        cat = intent.getStringExtra("category");
        value = intent.getIntExtra("points", 0);

        TextView question_View = (TextView) findViewById(R.id.Question);
        EditText hint_View = (EditText) findViewById(R.id.Input);
        if(cat.equals("JS"))
        {
            question_View.setText(" "+jsQuestions.get(random));
            hint_View.setHint(""+jsHints.get(random));

        }
        if(cat.equals("PHP"))
        {
            question_View.setText(" "+phpQuestions.get(random));
            hint_View.setHint(""+phpHints.get(random));
        }
        if(cat.equals("Android"))
        {
            question_View.setText(" "+andQuestions.get(random));
            hint_View.setHint(""+andHints.get(random));
        }
    }
    public void onSubmit(View view)
    {
        Intent intent = new Intent(this, Answers_Activity.class);
        EditText inputView = (EditText) findViewById(R.id.Input);
        input = inputView.getText().toString();
        intent.putExtra("input", input);
        intent.putExtra("index", random);
        intent.putExtra("points", value);
        intent.putExtra("category", cat);
        startActivityForResult(intent, 0);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent)
    {
        if(resultCode != Activity.RESULT_OK)
            return;
        else
        {
            value = intent.getIntExtra("points", 0);
            Intent point_send = new Intent(this, MainActivity.class);
            point_send.putExtra("points", value);
            setResult(RESULT_OK, point_send);
            finish();
        }
    }
}
