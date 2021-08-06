package learn.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String USER_INPUT = "user_input";

    Button button0;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    Button button8;
    Button button9;
    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiple;
    Button buttonDivide;
    Button buttonDot;
    Button buttonEquals;
    TextView buttonTextView;
    TextView userInputView;

    UserInputDataHolder userInput;

    View.OnClickListener listener = v -> {
        if (v instanceof Button) {
            CharSequence buttonText = ((Button) v).getText();
            buttonTextView.setText(buttonText);
            userInput.getUserInput().append(buttonText);
            userInputView.setText(userInput.getUserInput().toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userInput = new UserInputDataHolder();
        findElements();
        setListeners();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable(USER_INPUT, userInput);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        userInput = savedInstanceState.getParcelable(USER_INPUT);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    private void setListeners() {
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonPlus.setOnClickListener(listener);
        buttonMinus.setOnClickListener(listener);
        buttonMultiple.setOnClickListener(listener);
        buttonDivide.setOnClickListener(listener);
        buttonDot.setOnClickListener(listener);
        buttonEquals.setOnClickListener(listener);
    }

    private void findElements() {
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiple = findViewById(R.id.buttonMultiple);
        buttonDivide = findViewById(R.id.buttonDivide);
        buttonDot = findViewById(R.id.buttonDot);
        buttonEquals = findViewById(R.id.buttonEquals);
        buttonTextView = findViewById(R.id.dataView);
        userInputView = findViewById(R.id.userInput);
    }
}