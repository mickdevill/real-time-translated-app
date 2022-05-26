package com.example.realtimelanguagechange;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.realtimelanguagechange.Helper.LocalHelper;

import io.paperdb.Paper;

public class activityWithSomeText extends AppCompatActivity {


    Button button2, button3;

    TextView textView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_with_some_text);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        textView2 = findViewById(R.id.textView2);

        button2.setText(R.string.english_lanuage);
        button3.setText(R.string.russian);
        textView2.setText(R.string.some_text_here);

        //for english
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().write("language","en");
                switchLang(Paper.book().read("language"));
            }
        });

        //for russaian
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paper.book().write("language","ru");
                switchLang(Paper.book().read("language"));

            }
        });

    }


private void switchLang(String lang){
    Context context = LocalHelper.onAttach(activityWithSomeText.this,lang);
    Resources resources = context.getResources();
    button2.setText(resources.getString(R.string.english_lanuage));
    button3.setText(resources.getString(R.string.russian));
    textView2.setText(resources.getString(R.string.some_text_here));
}

}