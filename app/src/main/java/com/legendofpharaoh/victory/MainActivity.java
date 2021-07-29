package com.legendofpharaoh.victory;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button goMenuButton;
    private Button falseBtn;
    private Button trueBtn;
    private ImageButton nextBtn;
    private ImageView Image;
    private TextView QuestionsTextView;
    private int correct = 0;

    private int currentQuestionsIndex = 0;

    private Questions[] QuestionsBank = new Questions[] {

            new Questions(R.string.a, true),
            new Questions(R.string.b, false),
            new Questions(R.string.c, true),
            new Questions(R.string.d, true),
            new Questions(R.string.e, true),
            new Questions(R.string.f, false),
            new Questions(R.string.g, true),
            new Questions(R.string.h, false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        goMenuButton = findViewById(R.id.goMenu);
        falseBtn = findViewById(R.id.false_button);
        trueBtn = findViewById(R.id.true_button);
        nextBtn = findViewById(R.id.next_button);
        QuestionsTextView = findViewById(R.id.answer_text_view);
        Image = findViewById(R.id.myimage);
        falseBtn.setOnClickListener(this);
        trueBtn.setOnClickListener(this);
        nextBtn.setOnClickListener(this);
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View v)

    {

        switch (v.getId()) {

            case R.id.goMenu:
                    startActivity(new Intent(this, FirstActivity.class));
                finish();
                break;

            case R.id.false_button:
                checkAnswer(false);
                break;

            case R.id.true_button:
                checkAnswer(true);
                break;

            case R.id.next_button:

                if (currentQuestionsIndex < 9) {
                    currentQuestionsIndex
                            = currentQuestionsIndex + 1;

                    if (currentQuestionsIndex == 8) {
                        QuestionsTextView.setText(getString(
                                R.string.correct, correct));
                        nextBtn.setVisibility(
                                View.INVISIBLE);
                        trueBtn.setVisibility(
                                View.INVISIBLE);
                        falseBtn.setVisibility(
                                View.INVISIBLE);
                        if (correct > 3)

                            QuestionsTextView.setText(
                                    "CORRECTNESS IS " + correct
                                            + " "
                                            + "OUT OF 8");

                        else
                            Image.setImageResource(
                                    R.drawable.a);

                    }
                    else {
                        updateQuestions();
                    }


                }


        }

    }

    private void updateQuestions()
    {
        Log.d("Current",
                "onClick: " + currentQuestionsIndex);

        QuestionsTextView.setText(
                QuestionsBank[currentQuestionsIndex]
                        .getAnswerResId());

        switch (currentQuestionsIndex) {
            case 1:
                Image.setImageResource(R.drawable.num10);
                break;
            case 2:
                Image.setImageResource(R.drawable.anubis);
                break;
            case 3:
                Image.setImageResource(R.drawable.pharaoh);
                break;
            case 4:
                Image.setImageResource(R.drawable.ra);
                break;
            case 5:
                Image.setImageResource(R.drawable.q);
                break;
            case 6:
                Image.setImageResource(R.drawable.j);
                break;
            case 7:
                Image.setImageResource(R.drawable.a);
                break;
            case 8:
                Image.setImageResource(R.drawable.k);
                break;
                case 9:
                Image.setImageResource(R.drawable.kleo);
                break;
        }
    }
    private void checkAnswer(boolean userChooseCorrect)
    {
        boolean answerIsTrue
                = QuestionsBank[currentQuestionsIndex]
                .isAnswerTrue();

        int toastMessageId;


        if (userChooseCorrect == answerIsTrue) {
            toastMessageId = R.string.correct_answer;
            correct++;
        }
        else {

            toastMessageId = R.string.wrong_answer;
        }

        Toast
                .makeText(MainActivity.this, toastMessageId,
                        Toast.LENGTH_SHORT)
                .show();
    }


}

