package com.shaiicodez.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int totalMark;

    //questions status
    boolean questionOne;
    boolean questionTwo;
    boolean questionThree;
    boolean questionFour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *  Question one answers check
     * */
    public void questionOneOnRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        RadioButton answer13 = findViewById(R.id.radio_13);
        RadioButton answer50 = findViewById(R.id.radio_50);
        RadioButton answer2 = findViewById(R.id.radio_2);

        // Check which radio button was clicked
        if (answer13.equals(view) || answer50.equals(view)) {
            if (checked)
                questionOne = false;
        } else if (answer2.equals(view)) { // correct answer
            if (checked){
                questionOne = true;
            }
        }
    }

    /**
     *  Question two answers check
     * */
    public void questionTwoOnRadioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();

        RadioButton answerUranus = findViewById(R.id.rb_uranus);
        RadioButton answerMercury = findViewById(R.id.rb_mercury);
        RadioButton answerJupiter = findViewById(R.id.rb_jupiter);
        RadioButton answerEarth = findViewById(R.id.rb_earth);

        if (answerUranus.equals(view) || answerJupiter.equals(view) || answerEarth.equals(view)){
            if (checked)
                questionTwo = false;
        } else if (answerMercury.equals(view)){
            if (checked){
                questionTwo = true;
            }
        }
    }

    /**
     *  Question three answer check
     * */
    public void isQuestionThree(){
        EditText editTextQuestionThree = findViewById(R.id.et_question3_answer);
        String answer = editTextQuestionThree.getText().toString();

        if (answer.equals("Mars") || answer.equals("mars")){
            questionThree = true;
        } else questionThree = false;
    }

    /**
     *  Question four answers check
     * */
    public void isQuestionFour() {

        CheckBox cbHydGas = findViewById(R.id.cb_hyd_gas);
        boolean hydGasChecked = cbHydGas.isChecked();

        CheckBox cbWater = findViewById(R.id.cb_water);
        boolean waterChecked = cbWater.isChecked();

        CheckBox cbDust = findViewById(R.id.cb_dust);
        boolean dustChecked = cbDust.isChecked();

        CheckBox cbHelGas = findViewById(R.id.cb_helium_gas);
        boolean helGasChecked = cbHelGas.isChecked();

        if (hydGasChecked && helGasChecked && !waterChecked && !dustChecked){
                questionFour = true;

        } else if (waterChecked || dustChecked){
                questionFour = false;

        } else questionFour = false;
    }

    /**
     *  Check correct answers and calculate scores
     * @return score
     * */
    public int calculateScore(){
        int score = 0;
        isQuestionThree();
        isQuestionFour();

        if(questionOne){
            score +=1;
        }        if(questionTwo){
            score +=1;
        }        if(questionThree){
            score +=1;
        }      if(questionFour){
            score +=1;
        }

        return score;
    }

    /**
     * Submit Quiz answers
     * @param view
     *
     * */
    public void submitQuiz(View view) {
        totalMark = calculateScore();
        Toast.makeText(this,"Total: " + totalMark, Toast.LENGTH_SHORT).show();

        //reset score
        totalMark = 0;
    }
}