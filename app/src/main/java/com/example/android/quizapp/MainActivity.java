package com.example.android.quizapp;

import android.content.Intent;
import android.net.Uri;
import android.opengl.Visibility;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.text.TextUtils;
import android.view.View;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;


/**
 * This app displays results of IQ quiz.
 */

public class MainActivity extends AppCompatActivity {

    String resultsMessage = "";

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // hide Try again and Share button when the app run
        Button tryAgainButton = findViewById(R.id.try_again_button);
        Button shareButton = findViewById(R.id.share_button);

        tryAgainButton.setVisibility(View.GONE);
        shareButton.setVisibility(View.GONE);

    }

    /**
     * This method is called when the results button is clicked.
     */

    public void submitAnswers(View view) {

        // call method to calculate question 1 score and show Toast message if user didn't answer
        int question1Score = calculateQuestion1Score();

        // call method to calculate question 2 score and show Toast message if user didn't answer
        int question2Score = calculateQuestion2Score();

        // call method to calculate question 3 score and show Toast message if user didn't answer
        int question3Score = calculateQuestion3Score();

        // call method to calculate question 4 score and show Toast message if user didn't answer
        int question4Score = calculateQuestion4Score();

        // call method to calculate question 5 score and show Toast message if user didn't answer
        int question5Score = calculateQuestion5Score();

        // call method to calculate question 6 score and show Toast message if user didn't answer
        int question6Score = calculateQuestion6Score();

        // int totalScore of all questions
        int totalScore = question1Score + question2Score + question3Score + question4Score + question5Score + question6Score;

        // Call method to create Result message
        resultsMessage = createResultsMessage(totalScore);

        // display result Toast message
        Toast.makeText(this, getString(R.string.results_message_score, NumberFormat.getIntegerInstance().format(totalScore)), Toast.LENGTH_SHORT).show();

        // display result message
        displayResults(resultsMessage);

        // hide Results button and show Try again and Share button
        Button tryAgainButton = findViewById(R.id.try_again_button);
        Button resultsButton = findViewById(R.id.results_button);
        Button shareButton = findViewById(R.id.share_button);

        tryAgainButton.setVisibility(View.VISIBLE);
        shareButton.setVisibility(View.VISIBLE);
        resultsButton.setVisibility(View.GONE);

    }

    /**
     * This method to calculate score of question 1
     *
     * @return question1Score
     */

    private int calculateQuestion1Score() {

        CheckBox question1AnswerA = findViewById(R.id.question_1_answer_a_checkbox);
        CheckBox question1AnswerB = findViewById(R.id.question_1_answer_b_checkbox);
        CheckBox question1AnswerC = findViewById(R.id.question_1_answer_c_checkbox);
        boolean isCheckedA = question1AnswerA.isChecked();
        boolean isCheckedB = question1AnswerB.isChecked();
        boolean isCheckedC = question1AnswerC.isChecked();

        // get 20 points for right answer
        if (isCheckedB && isCheckedC && !isCheckedA) {
            return 20;
            // show toast message that user didn't answer this question
        } else if ((!isCheckedA) && (!isCheckedB) && (!isCheckedC)) {
            Toast.makeText(this, getString(R.string.toast_not_answer_1), Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * This method to calculate score of question 2
     *
     * @return question2Score
     */

    private int calculateQuestion2Score() {

        RadioButton question2AnswerA = findViewById(R.id.question_2_answer_a);
        RadioButton question2AnswerB = findViewById(R.id.question_2_answer_b);
        RadioButton question2AnswerC = findViewById(R.id.question_2_answer_c);
        boolean isCheckedA = question2AnswerA.isChecked();
        boolean isCheckedB = question2AnswerB.isChecked();
        boolean isCheckedC = question2AnswerC.isChecked();

        // get 20 points for right answer
        if (isCheckedA) {
            return 20;
            // show toast message that user didn't answer this question
        }
        if ((!isCheckedA) && (!isCheckedB) && (!isCheckedC)) {
            Toast.makeText(this, getString(R.string.toast_not_answer_2), Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * This method to calculate score of question 3
     *
     * @return question3Score
     */

    private int calculateQuestion3Score() {

        RadioButton question3AnswerA = findViewById(R.id.question_3_answer_a);
        RadioButton question3AnswerB = findViewById(R.id.question_3_answer_b);
        RadioButton question3AnswerC = findViewById(R.id.question_3_answer_c);
        boolean isCheckedA = question3AnswerA.isChecked();
        boolean isCheckedB = question3AnswerB.isChecked();
        boolean isCheckedC = question3AnswerC.isChecked();

        // get 20 points for right answer
        if (isCheckedB) {
            return 20;
            // show toast message that user didn't answer this question
        }
        if ((!isCheckedA) && (!isCheckedB) && (!isCheckedC)) {
            Toast.makeText(this, getString(R.string.toast_not_answer_3), Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * This method to calculate score of question 4
     *
     * @return question4Score
     */

    private int calculateQuestion4Score() {

        RadioButton question4AnswerA = findViewById(R.id.question_4_answer_a);
        RadioButton question4AnswerB = findViewById(R.id.question_4_answer_b);
        RadioButton question4AnswerC = findViewById(R.id.question_4_answer_c);
        boolean isCheckedA = question4AnswerA.isChecked();
        boolean isCheckedB = question4AnswerB.isChecked();
        boolean isCheckedC = question4AnswerC.isChecked();

        // get 20 points for right answer
        if (isCheckedC) {
            return 20;
            // show toast message that user didn't answer this question
        }
        if ((!isCheckedA) && (!isCheckedB) && (!isCheckedC)) {
            Toast.makeText(this, getString(R.string.toast_not_answer_4), Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * This method to calculate score of question 5
     *
     * @return question5Score
     */

    private int calculateQuestion5Score() {

        RadioButton question5AnswerA = findViewById(R.id.question_5_answer_a);
        RadioButton question5AnswerB = findViewById(R.id.question_5_answer_b);
        RadioButton question5AnswerC = findViewById(R.id.question_5_answer_c);
        RadioButton question5AnswerD = findViewById(R.id.question_5_answer_d);
        boolean isCheckedA = question5AnswerA.isChecked();
        boolean isCheckedB = question5AnswerB.isChecked();
        boolean isCheckedC = question5AnswerC.isChecked();
        boolean isCheckedD = question5AnswerD.isChecked();

        // get 20 points for right answer
        if (isCheckedC) {
            return 20;
        }
        // show toast message that user didn't answer this question
        if ((!isCheckedA) && (!isCheckedB) && (!isCheckedC) && (!isCheckedD)) {
            Toast.makeText(this, getString(R.string.toast_not_answer_5), Toast.LENGTH_SHORT).show();
            return 0;
        } else {
            return 0;
        }
    }

    /**
     * This method to calculate score of question 6
     *
     * @return question6Score
     */

    private int calculateQuestion6Score() {

        EditText question6Answer = findViewById(R.id.question_6_answer);
        String answerString = question6Answer.getText().toString();

        // show toast message that user didn't answer this question
        if (TextUtils.isEmpty(answerString)) {
            Toast.makeText(this, getString(R.string.toast_not_answer_6), Toast.LENGTH_SHORT).show();
            return 0;
        }

        int answerInt = Integer.parseInt(answerString);

        // get 20 points for right answer
        if (answerInt == 125) {
            return 20;
        } else {
            return 0;
        }
    }

    /**
     * this method create results message
     *
     * @param totalScore of order
     * @return resultsMessage text
     */

    private String createResultsMessage(int totalScore) {
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        String resultsMessage = getString(R.string.results_message_score, NumberFormat.getIntegerInstance().format(totalScore)) + "/120";
        resultsMessage += "\n" + getString(R.string.results_message_thank_you, name);
        resultsMessage += "\n" + getString(R.string.using_app);
        return resultsMessage;
    }

    /**
     * This method displays the given results on the screen.
     */

    private void displayResults(String results) {
        TextView resultsTextView = findViewById(R.id.results_text_view);
        resultsTextView.setText(results);
    }

    /**
     * This method is called when the share button is clicked.
     */

    public void shareResults(View view) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, resultsMessage);
        sendIntent.setType("text/plain");
        startActivity(Intent.createChooser(sendIntent, getResources().getText(R.string.share_message)));
        if (sendIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(sendIntent);
        }
    }

    /**
     * This method is called when the Try again button is clicked.
     */

    public void resetAnswers(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}