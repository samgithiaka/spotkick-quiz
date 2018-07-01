package com.example.android.spotkickquiz;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.Toast;

public class MainActivity extends Activity {
    RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4;
    String radio1 = String.valueOf(radioGroup1.getId());
    String radio2 = String.valueOf(radioGroup2.getId());
    String radio3 = String.valueOf(radioGroup3.getId());
    String radio4 = String.valueOf(radioGroup4.getId());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        radioGroup1 = (RadioGroup) findViewById(R.id.radio_group_1);
        radioGroup1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                                                   @Override
                                                   public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                       // find which radio button is selected and display correct when answer is the required one
                                                       if (checkedId == R.id.radio_button_sociedad) {
                                                           Toast.makeText(getApplicationContext(), "Correct",
                                                                   Toast.LENGTH_SHORT).show();
                                                       } else {
                                                           Toast.makeText(getApplicationContext(), "TRY AGAIN",
                                                                   Toast.LENGTH_SHORT).show();
                                                       }
                                                   }

                                               }
        );

        radioGroup2 = (RadioGroup) findViewById(R.id.radio_group_2);
        radioGroup2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                                                   @Override
                                                   public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                       // find which radio button is selected and display correct when answer is the required one
                                                       if (checkedId == R.id.radio_button_argentina) {
                                                           Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                                                       } else {
                                                           Toast.makeText(getApplicationContext(), "TRY AGAIN",
                                                                   Toast.LENGTH_SHORT).show();
                                                       }
                                                   }
                                               }
        );

        radioGroup3 = (RadioGroup) findViewById(R.id.radio_group_3);
        radioGroup3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                                                   @Override
                                                   public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                       // find which radio button is selected and display correct when answer is the required one
                                                       if (checkedId == R.id.radio_button_odd_brazil) {
                                                           Toast.makeText(getApplicationContext(), "Correct",
                                                                   Toast.LENGTH_SHORT).show();
                                                       } else {
                                                           Toast.makeText(getApplicationContext(), "TRY AGAIN",
                                                                   Toast.LENGTH_SHORT).show();
                                                       }
                                                   }

                                               }
        );

        radioGroup4 = (RadioGroup) findViewById(R.id.radio_group_4);
        radioGroup4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                                                   @Override
                                                   public void onCheckedChanged(RadioGroup group, int checkedId) {
                                                       // find which radio button is selected and display correct when answer is the required one
                                                       if (checkedId == R.id.radio_button_benfica) {
                                                           Toast.makeText(getApplicationContext(), "Correct",
                                                                   Toast.LENGTH_SHORT).show();
                                                       } else {
                                                           Toast.makeText(getApplicationContext(), "TRY AGAIN",
                                                                   Toast.LENGTH_SHORT).show();
                                                       }
                                                   }

                                               }
        );


    }

    public void onCheck(boolean isSouthAfrica, boolean isNetherlands) {

        if (isSouthAfrica) {
            Toast.makeText(getApplicationContext(), "Correct",
                    Toast.LENGTH_SHORT).show();
        } else if (isNetherlands) {

            Toast.makeText(getApplicationContext(), "Correct",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "TRY AGAIN",
                    Toast.LENGTH_SHORT).show();
        }
    }

    private String results(String radio1, String radio2, String radio3, String radio4, boolean isSouthAfrica, boolean isNetherlands) {
        String data = "Quiz 1:" + radio1;
        data = data + "\nQuiz 2:" + radio2;
        data = data + "\nQuiz 3:" + radio3;
        data = data + "\nQuiz 4:" + radio4;
        data = data + "\nQuiz 5:" + isSouthAfrica + "&" + isNetherlands;

        return data;

    }

    public void submit(View view) {


        CheckBox southAfricaCheckBox = (CheckBox) findViewById(R.id.check_box_south_africa);
        boolean isSouthAfrica = southAfricaCheckBox.isChecked();

        CheckBox netherlandsCheckBox = (CheckBox) findViewById(R.id.check_box_netherlands);
        boolean isNetherlands = netherlandsCheckBox.isChecked();
        onCheck(isSouthAfrica, isNetherlands);

        String data = results(radio1, radio2, radio3, radio4, isSouthAfrica, isNetherlands);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "spotkick quiz results");
        intent.putExtra(Intent.EXTRA_TEXT, data);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
