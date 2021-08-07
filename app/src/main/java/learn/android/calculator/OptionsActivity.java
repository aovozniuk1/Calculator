package learn.android.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class OptionsActivity extends AppCompatActivity implements View.OnClickListener {

    private Button backButton;
    private static final int THEME_1 = 1;
    private static final int THEME_2 = 2;

    private static final String KEY_SHARED_PREFERENCES = "sp";
    private static final String KEY_CURRENT_THEME = "ct";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(getThemeId(getCurrentTheme()));
        setContentView(R.layout.activity_options);
        initThemes();
        backButton = findViewById(R.id.buttonBack);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(OptionsActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void initThemes() {
        RadioButton theme1 = ((RadioButton) findViewById(R.id.MyTheme1));
        theme1.setOnClickListener(this);
        RadioButton theme2 = ((RadioButton) findViewById(R.id.MyTheme2));
        theme2.setOnClickListener(this);
        switch (getCurrentTheme()){
            case 1 :
                theme1.setChecked(true);
                break;
            case 2 :
                theme2.setChecked(true);
        }
    }

    @Override
    public void onClick(View v) {
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SHARED_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (v.getId()) {
            case R.id.MyTheme1:
                editor.putInt(KEY_CURRENT_THEME, THEME_1);
                break;
            case R.id.MyTheme2:
                editor.putInt(KEY_CURRENT_THEME, THEME_2);
                break;
        }
        editor.apply();
        recreate();
    }

    private int getCurrentTheme(){
        SharedPreferences sharedPreferences = getSharedPreferences(KEY_SHARED_PREFERENCES, MODE_PRIVATE);
        return  sharedPreferences.getInt(KEY_CURRENT_THEME, -1);
    }

    private int getThemeId(int theme){
        switch ( theme){
            case THEME_1:
                return R.style.MyCalculatorTheme1;
            case THEME_2:
                return R.style.MyCalculatorTheme2;
            default:
                return -1;
        }
    }
}