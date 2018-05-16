package com.example.android.quiz;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public String result;
    private int resultID;
    public int ImageTestResult;
    private EditText whatIsYourName;
    private TextView question_1;

    // @parm score will help to define how easy to manipulate the user
    int score = 0;

    private ScrollView hscrollViewMain;
    private TextView NameOfTheTest;
    private TextView introduction;
    private Button letsGo;
    private Button start;
    private TextView reaction1_1;
    private TextView reaction1_2;
    private TextView reaction1_3;
    private TextView reaction1_4;
    private int i = 1;
    private RadioButton answer1_1;
    private RadioButton answer1_2;
    private RadioButton answer1_3;
    private RadioButton answer1_4;
    private String question;
    private RadioGroup rd;
    private CheckBox answer5_1;
    private CheckBox answer5_2;
    private CheckBox answer5_3;
    private CheckBox answer5_4;
    private EditText answer_6;
    private ImageView mosheKazav;
    private ImageView blot;
    private Button next;
    private Button reset;
    private Button submit;
    private Button solution;
    private TextView result1;
    private ImageView innocentVictim;
    private ImageView tartar;
    private ImageView flower;
    private CheckBox shareCheckBox;
    private TextView psychologicalPortrait;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private int questionID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_landscape);
        }

        question_1 = findViewById(R.id.question_1);
        hscrollViewMain = (ScrollView) findViewById(R.id.scrollViewMain);
        NameOfTheTest = findViewById(R.id.NameOfTheTest);
        introduction = findViewById(R.id.introduction);
        start = findViewById(R.id.start);
        whatIsYourName = findViewById(R.id.name);
        whatIsYourName.hasOnClickListeners();
        reaction1_1 = findViewById(R.id.reaction1_1);
        reaction1_2 = findViewById(R.id.reaction1_2);
        reaction1_3 = findViewById(R.id.reaction1_3);
        reaction1_4 = findViewById(R.id.reaction1_4);
        answer1_1 = findViewById(R.id.answer1_1);
        answer1_2 = findViewById(R.id.answer1_2);
        answer1_3 = findViewById(R.id.answer1_3);
        answer1_4 = findViewById(R.id.answer1_4);
        answer5_1 = findViewById(R.id.answer5_1);
        answer5_2 = findViewById(R.id.answer5_2);
        answer5_3 = findViewById(R.id.answer5_3);
        answer5_4 = findViewById(R.id.answer5_4);
        answer_6 = findViewById(R.id.answer_6);
        rd = findViewById(R.id.rd);
        mosheKazav = findViewById(R.id.mosheKazav);
        blot = findViewById(R.id.blot);
        letsGo = findViewById(R.id.letsGo);
        next = findViewById(R.id.next);
        reset = findViewById(R.id.reset);
        submit = findViewById(R.id.submit);
        solution = findViewById(R.id.solution);
        result1 = findViewById(R.id.yourResult);
        innocentVictim = findViewById(R.id.innocent_victim);
        tartar = findViewById(R.id.tartar);
        flower = findViewById(R.id.flower);
        shareCheckBox = findViewById(R.id.share);
        psychologicalPortrait = findViewById(R.id.psychologicalPortrait);
        result = "result";
    }

    public void letsGo(View view) {
        if (whatIsYourName.getText().toString().equals("")) {
            Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show();
        } else {
            //makes button "Start a test" visible
            start.setVisibility(View.VISIBLE);
            letsGo.setVisibility(View.GONE);
        }
    }

    public void startTest(View view) {

        // ad a name of the user to the first question
        question_1.setText(question_1.getText().toString() + " " + whatIsYourName.getText().toString() + "?");

        //make the question visible
        question_1.setVisibility(View.VISIBLE);

        // make 4 possible answers (RadioGroup) for the first question visible to user
        rd.setVisibility(View.VISIBLE);

        // make button "NEXT QUESTION" visible too
        next.setVisibility(View.VISIBLE);

        //make button "TRY AGAIN" visible too
        reset.setVisibility(View.VISIBLE);

        //Makes those views disappear from the screen when user answering the first question
        NameOfTheTest.setVisibility(View.GONE);
        introduction.setVisibility(View.GONE);
        start.setVisibility(View.GONE);
        whatIsYourName.setVisibility(View.GONE);

        Toast.makeText(this, "Scroll down to continue!", Toast.LENGTH_LONG).show();
    }

    public void click(View view) {//show my reaction to user's answer
        // after he/she chose one of 4 answers on first 5 questions (all of them RadioButtons)

        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked as answer
        switch (view.getId()) {

            case R.id.answer1_1:

                //reach to a right string for textView with reaction
                String reaction = "reaction" + i + "_1";
                int reactionID = getResources().getIdentifier(reaction, "string", getPackageName());
                reaction = getResources().getString(reactionID);

                if (checked)
                    //it makes my reaction on user's answer to show up
                    reaction1_1.setText(reaction);
                reaction1_1.setVisibility(View.VISIBLE);

                // make the radioGroup invisible to prevent from user to change his mind.
                // (If he want to change his answer, he can hit the "try again" button
                rd.setVisibility(View.GONE);

                // scroll to my reaction in TextView "reaction1_1"
                reaction1_1.getParent().requestChildFocus(reaction1_1, reaction1_1);

                if (i == 0) {//first answer in question number 1
                    score = score - 10;
                }
                break;

            case R.id.answer1_2:
                //reach to a right string for textView with reaction
                reaction = "reaction" + i + "_2";
                reactionID = getResources().getIdentifier(reaction, "string", getPackageName());
                reaction = getResources().getString(reactionID);

                // make the radioGroup invisible to prevent from user to change his mind.
                // (If he want to change his answer, he can hit the "try again" button
                rd.setVisibility(View.GONE);

                if (checked) reaction1_2.setText(reaction);
                reaction1_2.setVisibility(View.VISIBLE);

                // scroll to my reaction in TextView "reaction1_2"
                reaction1_2.getParent().requestChildFocus(reaction1_2, reaction1_2);

                //uncheck other radioButtons in case they were checked before
                answer1_1.setChecked(false);
                answer1_3.setChecked(false);
                answer1_4.setChecked(false);
                if (i == 0) { //second answer for question number 1
                    score = score + 1;
                }
                if (i == 6) {//second answer for question number 7
                    score = score + 3;
                }
                break;

            case R.id.answer1_3:
                //reach to a right string for textView with reaction
                reaction = "reaction" + i + "_3";
                reactionID = getResources().getIdentifier(reaction, "string", getPackageName());
                reaction = getResources().getString(reactionID);

                // make the radioGroup invisible to prevent from user to change his mind.
                // (If he want to change his answer, he can hit the "try again" button
                rd.setVisibility(View.GONE);
                if (checked) reaction1_3.setText(reaction);
                reaction1_3.setVisibility(View.VISIBLE);

                // scroll to my reaction in TextView "case1_3"
                reaction1_3.getParent().requestChildFocus(reaction1_3, reaction1_3);

                //uncheck other radioButtons in case they were checked before
                answer1_1.setChecked(false);
                answer1_2.setChecked(false);
                answer1_4.setChecked(false);

                score = score + 3;
                break;

            case R.id.answer1_4:
                //reach to a right string for textView with reaction
                reaction = "reaction" + i + "_4";
                reactionID = getResources().getIdentifier(reaction, "string", getPackageName());
                reaction = getResources().getString(reactionID);

                // make the radioGroup invisible to prevent from user to change his mind.
                // (If he want to change his answer, he can hit the "try again" button
                rd.setVisibility(View.GONE);

                if (checked) reaction1_4.setText(reaction);
                reaction1_4.setVisibility(View.VISIBLE);

                // scroll to my reaction in TextView "case1_4"
                reaction1_4.getParent().requestChildFocus(reaction1_4, reaction1_4);

                //uncheck other radioButtons in case they were checked before
                answer1_1.setChecked(false);
                answer1_2.setChecked(false);
                answer1_3.setChecked(false);

                if (i == 0) { //forth answer for question number 1
                    score = score - 2;
                }
                break;
        }

        Toast.makeText(this, "Scroll down to continue!", Toast.LENGTH_SHORT).show();
    }

    public void updateQuestion(View view) {
        //update the question and the answers after the user press "Next question" button

        rd.setVisibility(View.VISIBLE);

        question = "question_" + (i + 1);
        answer1 = "answer" + (i + 1) + "_1";
        answer2 = "answer" + (i + 1) + "_2";
        answer3 = "answer" + (i + 1) + "_3";
        answer4 = "answer" + (i + 1) + "_4";

        //   3 of 7 question are with picture that need to be added to the text
        if (i == 1 || i == 2) { //for question 2 and 3 I use the same ImageView
            mosheKazav.setVisibility(View.VISIBLE);
        } else {
            mosheKazav.setVisibility(View.GONE);
        }

        if (i == 3) { //for question 4 I use another image
            blot.setVisibility(View.VISIBLE);
        } else {
            blot.setVisibility(View.GONE);
        }

        if (i == 4) { //question 5 - CheckBoxes
            rd.setVisibility(View.GONE); //make RagioGroup gone
            answer5_1.setVisibility(View.VISIBLE);//make CheckBoxes visible
            answer5_2.setVisibility(View.VISIBLE);
            answer5_3.setVisibility(View.VISIBLE);
            answer5_4.setVisibility(View.VISIBLE);
        }

        if (i == 5) { //question 6 - EditText
            //make unnecessary views gone
            answer5_1.setVisibility(View.GONE);
            answer5_2.setVisibility(View.GONE);
            answer5_3.setVisibility(View.GONE);
            answer5_4.setVisibility(View.GONE);
            rd.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            answer_6.setVisibility(View.VISIBLE);//make an EditText visible
            submit.setVisibility(View.VISIBLE);//make a "submit my answer" button visible
        }

        //last question have a additional TextView instead of ImageView
        // (the same Psychological Portrait to everyone):
        if (i == 6) { //question 7 - RadioButton again
            psychologicalPortrait.setVisibility(View.VISIBLE);
            answer5_1.setVisibility(View.GONE);
            answer5_2.setVisibility(View.GONE);
            answer5_3.setVisibility(View.GONE);
            answer5_4.setVisibility(View.GONE);
            answer_6.setVisibility(View.GONE);
            next.setVisibility(View.GONE);
            solution.setVisibility(View.VISIBLE);//make a "GET RESULT" button visible
        }

        //update the question
        questionID = getResources().getIdentifier(question, "string", getPackageName());
        question = getResources().getString(questionID);
        question_1.setText(question + " " + whatIsYourName.getText().toString() + "?");

        //update the answers
        if (i != 5) { //in question number 6(when i=5) I don't have answers - I have an EditText
            int answer1ID = getResources().getIdentifier(answer1, "string", getPackageName());
            answer1 = getResources().getString(answer1ID);
            answer1_1.setText(answer1);

            int answer2ID = getResources().getIdentifier(answer2, "string", getPackageName());
            answer2 = getResources().getString(answer2ID);
            answer1_2.setText(answer2);

            int answer3ID = getResources().getIdentifier(answer3, "string", getPackageName());
            answer3 = getResources().getString(answer3ID);
            answer1_3.setText(answer3);

            int answer4ID = getResources().getIdentifier(answer4, "string", getPackageName());
            answer4 = getResources().getString(answer4ID);
            answer1_4.setText(answer4);
        }

        if (i == 7) {
            next.setVisibility(View.GONE);
            solution.setVisibility(View.VISIBLE);
        }
        // clear the radioGroup, checkboxes and editText from previous answers
        rd.clearCheck();
        answer5_1.setChecked(false);
        answer5_2.setChecked(false);
        answer5_3.setChecked(false);
        answer5_4.setChecked(false);
        answer_6.setText("");
        // hide my previous reaction to users answer
        reaction1_1.setVisibility(View.GONE);
        reaction1_2.setVisibility(View.GONE);
        reaction1_3.setVisibility(View.GONE);
        reaction1_4.setVisibility(View.GONE);

        i++;

        // scroll back to the question
        question_1.getParent().requestChildFocus(question_1, question_1);
        Toast.makeText(this, "Scroll down to continue!", Toast.LENGTH_SHORT).show();
    }

    public void checkBox(View view) {//question number 5
        boolean checked = ((CheckBox) view).isChecked();

        // Check which CheckBox was clicked as answer
        switch (view.getId()) {

            case R.id.answer5_1:
                if (checked)
                    score = score - 2;
                break;
            case R.id.answer5_2:
                if (checked)
                    score = score + 3;
                break;
            case R.id.answer5_3:
                if (checked)
                    score = score - 1;
                break;
            case R.id.answer5_4:
                if (checked)
                    score = score - 1;
                break;
        }
    }

    public void submit(View view) { //button to submit user's answer to EditText, question 6
        if (answer_6.getText().toString().equals("")) {
            Toast.makeText(this, "Please make any choice", Toast.LENGTH_SHORT).show();
        } else {
            if (answer_6.getText().toString().equals("Yes")) {
                score = score - 2;
                submit.setVisibility(View.GONE);
                next.setVisibility(View.VISIBLE);
            } else {
                if (answer_6.getText().toString().equals("No")) {
                    score = score + 1;
                    submit.setVisibility(View.GONE);
                    next.setVisibility(View.VISIBLE);
                } else {
                    Toast.makeText(this, "Please make any choice", Toast.LENGTH_SHORT).show();
                }
            }
            // I need this button only for this question -
            // to "listen" what the user have decided to submit as an answer to the EditText question

        }
    }

    public void solution(View view) {

        if (score >= 12) {
            result = "result" + 3;
            resultID = getResources().getIdentifier(result, "string", getPackageName());
            result = getResources().getString(resultID);
            result1.setText(result);
            result1.setVisibility(View.VISIBLE);
            tartar.setVisibility(View.VISIBLE);
            ImageTestResult = R.id.tartar;
            /* scroll to "tartar"*/
            tartar.getParent().requestChildFocus(tartar, tartar);

        } else if (score > 6) {
            result = "result" + 1;
            resultID = getResources().getIdentifier(result, "string", getPackageName());
            result = getResources().getString(resultID);
            result1.setText(result);
            result1.setVisibility(View.VISIBLE);
            innocentVictim.setVisibility(View.VISIBLE);
            ImageTestResult = R.id.innocent_victim;
            /* scroll to "innocentVictim"*/
            innocentVictim.getParent().requestChildFocus(innocentVictim, innocentVictim);

        } else {
            result = "result" + 2;
            resultID = getResources().getIdentifier(result, "string", getPackageName());
            result = getResources().getString(resultID);
            result1.setText(result);
            result1.setVisibility(View.VISIBLE);
            flower.setVisibility(View.VISIBLE);
            ImageTestResult = R.id.flower;
            /* scroll to "flower"*/
            flower.getParent().requestChildFocus(flower, flower);
        }
        shareCheckBox.setVisibility(View.VISIBLE);
        psychologicalPortrait.setVisibility(View.GONE);
        Toast.makeText(this, "Your score is " + score, Toast.LENGTH_SHORT).show();

    }

    public void share(View view) {/* Figure out if the user wants to share the result*/
        boolean share = shareCheckBox.isChecked();
        switch (view.getId()) {
            case R.id.share:
                if (share) {/*user can share the Quiz result with friends (ONLY A TEXT,NOT A PICTURE)*/
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, "Is it easy to manipulate you, " + whatIsYourName.getText().toString() + "? " + result1.getText());
                    sendIntent.setType("text/plain");
                    startActivity(sendIntent);
                }
        }
    }

    public void reset(View view) {
        // clear the radioGroup from last answer.Hide the reactions. Hide the result.
        rd.setVisibility(View.VISIBLE);
        rd.clearCheck();
        result1.setVisibility(View.GONE);
        reaction1_1.setVisibility(View.GONE);
        reaction1_2.setVisibility(View.GONE);
        reaction1_3.setVisibility(View.GONE);
        reaction1_4.setVisibility(View.GONE);
        psychologicalPortrait.setVisibility(View.GONE);
        solution.setVisibility(View.GONE);
        shareCheckBox.setVisibility(View.GONE);
        mosheKazav.setVisibility(View.GONE);
        blot.setVisibility(View.GONE);
        flower.setVisibility(View.GONE);
        innocentVictim.setVisibility(View.GONE);
        tartar.setVisibility(View.GONE);
        next.setVisibility(View.VISIBLE);

        //update the score
        score = 0;
        i = 0;

        //update the question back to the first question with 4 possible answers
        question = getResources().getString(getResources().getIdentifier("question_1", "string", getPackageName()));
        question_1.setText(question + " " + whatIsYourName.getText().toString() + "?");

        answer1 = getResources().getString(getResources().getIdentifier("answer1_1", "string", getPackageName()));
        answer1_1.setText(answer1);

        answer2 = getResources().getString(getResources().getIdentifier("answer1_2", "string", getPackageName()));
        answer1_2.setText(answer2);

        answer3 = getResources().getString(getResources().getIdentifier("answer1_3", "string", getPackageName()));
        answer1_3.setText(answer3);

        answer4 = getResources().getString(getResources().getIdentifier("answer1_4", "string", getPackageName()));
        answer1_4.setText(answer4);

        hscrollViewMain.scrollTo(0, 0); /* scroll to application top*/

        i++;
    }
}





