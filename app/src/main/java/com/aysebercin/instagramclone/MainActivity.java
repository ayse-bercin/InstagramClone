package com.aysebercin.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {

    EditText nameText ;
    EditText passText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.nameText);
        passText = findViewById(R.id.passwordText);

        ParseUser user = ParseUser.getCurrentUser();

        if(user != null){
            Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
            startActivity(intent);
        }

    }


    public void signIn(View view){

        ParseUser.logInInBackground(nameText.getText().toString(), passText.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Welcome "+user.getUsername(),Toast.LENGTH_LONG).show();

                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);

                }
            }
        });


    }

    public void signUp(View view){

        ParseUser user = new ParseUser();
        user.setUsername(nameText.getText().toString());
        user.setPassword(passText.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if (e != null){
                   Toast.makeText(getApplicationContext(),e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                }else{
                    Toast.makeText(getApplicationContext(),"User created!!" ,Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getApplicationContext(),FeedActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
}
