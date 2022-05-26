package com.example.realtimelanguagechange;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.realtimelanguagechange.Helper.LocalHelper;

import io.paperdb.Paper;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        Paper.init(this);
        String language = Paper.book().read("language");
        if (language == null){
            Paper.book().write("language","en");
            Context context = LocalHelper.onAttach(this,Paper.book().read("language"));
            Resources resources = context.getResources();
            textView.setText(resources.getString(R.string.hello_transtated));
            button.setText(resources.getString(R.string.open_swith_n_lang_activity));
        }else {
            Context context = LocalHelper.onAttach(this,Paper.book().read("language"));
            Resources resources = context.getResources();
            textView.setText(resources.getString(R.string.hello_transtated));
            button.setText(resources.getString(R.string.open_swith_n_lang_activity));

        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, activityWithSomeText.class);
                startActivity(intent);
            }
        });


    }
}