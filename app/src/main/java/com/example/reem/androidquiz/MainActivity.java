package com.example.reem.androidquiz;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // Question 4 correct answer
    final String QUESTION_FOUR_CORRECT_ANSWER = "Android development tool";
    // Create a variable to save the overall score & initialize it to zero
    int totalScore = 0;
    // No of quiz questions
    int numberOfQuestions = 7;
    // Boolean variables for each question to identify if it was answered correctly
    Boolean questionOneAnswerStatus = false;
    Boolean questionTwoAnswerStatus = false;
    Boolean questionThreeAnswerStatus = false;
    Boolean questionFourAnswerStatus = false;
    Boolean questionFiveAnswerStatus = false;
    Boolean questionSixAnswerStatus = false;
    Boolean questionSevenAnswerStatus = false;

    // Main Layout
    LinearLayout mainViewLayout;

    // Submit Button
    Button submitButton;

    // Retake Button
    Button retakeButton;

    // CheckBoxes (first question answers options)
    CheckBox questionOneAnsOneCheckBox;
    CheckBox questionOneAnsTwoCheckBox;
    CheckBox questionOneAnsThreeCheckBox;
    CheckBox questionOneAnsFourCheckBox;

    // Question 2 views
    RadioGroup questionTwoRadioGroup;
    RadioButton questionTwoAnswerOneRadioButton;
    RadioButton questionTwoAnswerTwoRadioButton;
    RadioButton questionTwoAnswerThreeRadioButton;
    RadioButton questionTwoAnswerFourRadioButton;
    RadioButton questionTwoAnswerFiveRadioButton;
    RadioButton questionTwoAnswerSixRadioButton;

    // Question 3 views
    RadioGroup questionThreeRadioGroup;
    RadioButton questionThreeAnswerOneRadioButton;
    RadioButton questionThreeAnswerTwoRadioButton;

    // Question 4 view
    EditText questionFourAnswerEditText;

    // Question 5 views
    RadioGroup questionFiveRadioGroup;
    RadioButton questionFiveAnswerOneRadioButton;
    RadioButton questionFiveAnswerTwoRadioButton;

    // Question 6 views
    RadioGroup questionSixRadioGroup;
    RadioButton questionSixAnswerOneRadioButton;
    RadioButton questionSixAnswerTwoRadioButton;

    // Question 7 views
    RadioGroup questionSevenRadioGroup;
    RadioButton questionSevenAnswerOneRadioButton;
    RadioButton questionSevenAnswerTwoRadioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewLayout = findViewById(R.id.mainViewLayout);

        submitButton = findViewById(R.id.submitButton);
        retakeButton = findViewById(R.id.retakeButton);

        questionOneAnsOneCheckBox = findViewById(R.id.questionOneAnsOneCheckBox);
        questionOneAnsTwoCheckBox = findViewById(R.id.questionOneAnsTwoCheckBox);
        questionOneAnsThreeCheckBox = findViewById(R.id.questionOneAnsThreeCheckBox);
        questionOneAnsFourCheckBox = findViewById(R.id.questionOneAnsFourCheckBox);

        questionTwoRadioGroup = findViewById(R.id.questionTwoRadioGroup);
        questionTwoAnswerOneRadioButton = findViewById(R.id.questionTwoAnswerOneRadioButton);
        questionTwoAnswerTwoRadioButton = findViewById(R.id.questionTwoAnswerTwoRadioButton);
        questionTwoAnswerThreeRadioButton = findViewById(R.id.questionTwoAnswerThreeRadioButton);
        questionTwoAnswerFourRadioButton = findViewById(R.id.questionTwoAnswerFourRadioButton);
        questionTwoAnswerFiveRadioButton = findViewById(R.id.questionTwoAnswerFiveRadioButton);
        questionTwoAnswerSixRadioButton = findViewById(R.id.questionTwoAnswerSixRadioButton);

        questionThreeRadioGroup = findViewById(R.id.questionThreeRadioGroup);
        questionThreeAnswerOneRadioButton = findViewById(R.id.questionThreeAnswerOneRadioButton);
        questionThreeAnswerTwoRadioButton = findViewById(R.id.questionThreeAnswerTwoRadioButton);

        // Hide the Retake button
        retakeButton.setVisibility(View.GONE);

        questionFourAnswerEditText = findViewById(R.id.questionFourAnswerEditText);
        // Make sure the keyboard only pops up when a user clicks into the EditText
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        questionFiveRadioGroup = findViewById(R.id.questionFiveRadioGroup);
        questionFiveAnswerOneRadioButton = findViewById(R.id.questionFiveAnswerOneRadioButton);
        questionFiveAnswerTwoRadioButton = findViewById(R.id.questionFiveAnswerTwoRadioButton);

        questionSixRadioGroup = findViewById(R.id.questionSixRadioGroup);
        questionSixAnswerOneRadioButton = findViewById(R.id.questionSixAnswerOneRadioButton);
        questionSixAnswerTwoRadioButton = findViewById(R.id.questionSixAnswerTwoRadioButton);

        questionSevenRadioGroup = findViewById(R.id.questionSevenRadioGroup);
        questionSevenAnswerOneRadioButton = findViewById(R.id.questionSevenAnswerOneRadioButton);
        questionSevenAnswerTwoRadioButton = findViewById(R.id.questionSevenAnswerTwoRadioButton);
    }

    // This method is executed whenever the Submit button is clicked
    public void submitClicked(View v) {
        // Handling 1st question answers.
        // Check if the correct answers are checked AND the incorrect answers are not checked.
        if (questionOneAnsOneCheckBox.isChecked() && questionOneAnsTwoCheckBox.isChecked() && questionOneAnsFourCheckBox.isChecked() && !questionOneAnsThreeCheckBox.isChecked()) {
            // correct answer of question one so increment the score by 1
            totalScore += 1;
            questionOneAnswerStatus = true;
        } else {
            // Wrong answer
            questionOneAnswerStatus = false;
        }

        // Handling 2nd question answers.
        // Get selected radio button from radioGroup
        int questionTwoSelectedAnswerId = questionTwoRadioGroup.getCheckedRadioButtonId();
        // Correct answer of Q2 is choice No 6
        if (questionTwoSelectedAnswerId == R.id.questionTwoAnswerSixRadioButton) {
            // correct answer so increment the score by 1
            totalScore += 1;
            questionTwoAnswerStatus = true;
        } else {
            // Wrong answer
            questionTwoAnswerStatus = false;
        }

        // Handling 3rd question answers.
        // Get selected radio button from radioGroup
        int questionThreeSelectedAnswerId = questionThreeRadioGroup.getCheckedRadioButtonId();
        // Correct answer of Q3 is "True"
        if (questionThreeSelectedAnswerId == R.id.questionThreeAnswerOneRadioButton) {
            // correct answer so increment the score by 1
            totalScore += 1;
            questionThreeAnswerStatus = true;
        } else {
            // Wrong answer
            questionThreeAnswerStatus = false;
        }

        // Handling 4th question answer.
        // Get the entered text by user from the EditText
        String questionFourUserAnswer = questionFourAnswerEditText.getText().toString();
        if (questionFourUserAnswer.equalsIgnoreCase(QUESTION_FOUR_CORRECT_ANSWER)) {
            totalScore += 1;
            questionFourAnswerStatus = true;
        } else {
            // Wrong answer
            questionFourAnswerStatus = false;
        }

        // Handling 5th question answers.
        // Get selected radio button from radioGroup
        int questionFiveSelectedAnswerId = questionFiveRadioGroup.getCheckedRadioButtonId();
        // Correct answer of Q5 is "True"
        if (questionFiveSelectedAnswerId == R.id.questionFiveAnswerOneRadioButton) {
            // correct answer so increment the score by 1
            totalScore += 1;
            questionFiveAnswerStatus = true;
        } else {
            // Wrong answer
            questionFiveAnswerStatus = false;
        }

        // Handling 6th question answers.
        // Get selected radio button from radioGroup
        int questionSixSelectedAnswerId = questionSixRadioGroup.getCheckedRadioButtonId();
        // Correct answer of Q6 is "False"
        if (questionSixSelectedAnswerId == R.id.questionSixAnswerTwoRadioButton) {
            // correct answer so increment the score by 1
            totalScore += 1;
            questionSixAnswerStatus = true;
        } else {
            // Wrong answer
            questionSixAnswerStatus = false;
        }

        // Handling 7th question answers.
        // Get selected radio button from radioGroup
        int questionSevenSelectedAnswerId = questionSevenRadioGroup.getCheckedRadioButtonId();
        // Correct answer of Q7 is "True"
        if (questionSevenSelectedAnswerId == R.id.questionSevenAnswerOneRadioButton) {
            // correct answer so increment the score by 1
            totalScore += 1;
            questionSevenAnswerStatus = true;
        } else {
            // Wrong answer
            questionSevenAnswerStatus = false;
        }

        // The grading button displays a toast which accurately displays the results of the quiz.
        createToast("Score: " + totalScore + " out of " + numberOfQuestions + "\n"
                + "Q1: " + questionOneAnswerStatus + "\n"
                + "Q2: " + questionTwoAnswerStatus + "\n"
                + "Q3: " + questionThreeAnswerStatus + "\n"
                + "Q4: " + questionFourAnswerStatus + "\n"
                + "Q5: " + questionFiveAnswerStatus + "\n"
                + "Q6: " + questionSixAnswerStatus + "\n"
                + "Q7: " + questionSevenAnswerStatus + "\n");

        // Disable answering after submission
        // Disable all contents of the main Linear Layout
        for (int i = 0; i < mainViewLayout.getChildCount(); i++) {
            View view = mainViewLayout.getChildAt(i);
            view.setEnabled(false);
            // Disable RadioButtons of Q2
            for (int j = 0; j < questionTwoRadioGroup.getChildCount(); j++) {
                View view2 = questionTwoRadioGroup.getChildAt(j);
                view2.setEnabled(false);
            }
            // Disable RadioButtons of Q3
            for (int j = 0; j < questionThreeRadioGroup.getChildCount(); j++) {
                View view2 = questionThreeRadioGroup.getChildAt(j);
                view2.setEnabled(false);
            }
            // Disable RadioButtons of Q5
            for (int j = 0; j < questionFiveRadioGroup.getChildCount(); j++) {
                View view2 = questionFiveRadioGroup.getChildAt(j);
                view2.setEnabled(false);
            }
            // Disable RadioButtons of Q6
            for (int j = 0; j < questionSixRadioGroup.getChildCount(); j++) {
                View view2 = questionSixRadioGroup.getChildAt(j);
                view2.setEnabled(false);
            }
            // Disable RadioButtons of Q7
            for (int j = 0; j < questionSevenRadioGroup.getChildCount(); j++) {
                View view2 = questionSevenRadioGroup.getChildAt(j);
                view2.setEnabled(false);
            }
        }
        // Disable the submit button
        submitButton.setEnabled(false);

        // Display the Retake button
        retakeButton.setVisibility(View.VISIBLE);
    }

    // This method is executed whenever the Retake button is clicked
    public void retakeClicked(View view) {
        // Reset variables
        totalScore = 0;

        // Reset the UI
        // Enable all contents of the main Linear Layout
        for (int i = 0; i < mainViewLayout.getChildCount(); i++) {
            View view1 = mainViewLayout.getChildAt(i);
            view1.setEnabled(true);
            // Enable RadioButtons of Q2
            for (int j = 0; j < questionTwoRadioGroup.getChildCount(); j++) {
                View view2 = questionTwoRadioGroup.getChildAt(j);
                view2.setEnabled(true);
            }
            // Enable RadioButtons of Q3
            for (int j = 0; j < questionThreeRadioGroup.getChildCount(); j++) {
                View view2 = questionThreeRadioGroup.getChildAt(j);
                view2.setEnabled(true);
            }
            // Enable RadioButtons of Q5
            for (int j = 0; j < questionFiveRadioGroup.getChildCount(); j++) {
                View view2 = questionFiveRadioGroup.getChildAt(j);
                view2.setEnabled(true);
            }
            // Enable RadioButtons of Q6
            for (int j = 0; j < questionSixRadioGroup.getChildCount(); j++) {
                View view2 = questionSixRadioGroup.getChildAt(j);
                view2.setEnabled(true);
            }
            // Enable RadioButtons of Q7
            for (int j = 0; j < questionSevenRadioGroup.getChildCount(); j++) {
                View view2 = questionSevenRadioGroup.getChildAt(j);
                view2.setEnabled(true);
            }
        }
        // Enable the submit button
        submitButton.setEnabled(true);

        // Hide the Retake button
        retakeButton.setVisibility(View.GONE);
    }

    // A method to display a Toast on the screen.
    public void createToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}

