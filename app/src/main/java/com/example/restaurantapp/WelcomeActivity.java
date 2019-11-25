package com.example.restaurantapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class WelcomeActivity extends AppCompatActivity {

    Button button;
    Button log_button;
    Button signBtn;
    EditText email,password;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    static final String EMAIL= "user_name";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        button= findViewById(R.id.button);
        signBtn=findViewById(R.id.register);
        log_button=findViewById(R.id.log_button);
        mFirebaseAuth=FirebaseAuth.getInstance();
        email= findViewById(R.id.User_name);
        password=findViewById(R.id.passwordView);

        Intent intent=getIntent();
        intent.getExtras();

        if(intent.hasExtra("user_signed")) {
            Toast.makeText(WelcomeActivity.this, "Your account is registered", Toast.LENGTH_LONG).show();
        }



        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if (mFirebaseUser!=null) {

                    Toast.makeText(WelcomeActivity.this, "Welcome!", Toast.LENGTH_SHORT).show();
                    Intent intent= new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                else {
                    Toast.makeText(WelcomeActivity.this, "Please Log in", Toast.LENGTH_SHORT).show();
                }
            }
        };

        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String e = email.getText().toString();
                String p = password.getText().toString();
                if (!(e.isEmpty() && p.isEmpty())) {
                    mFirebaseAuth.signInWithEmailAndPassword(e,p).addOnCompleteListener(WelcomeActivity.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()) {
                                Toast.makeText(WelcomeActivity.this, "Log in unsuccessfull, Please try again!", Toast.LENGTH_SHORT).show();
                            } else {

                                Intent intent= new Intent(WelcomeActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                        }
                    });


                }
            }
        });



        signBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(WelcomeActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);

                startActivity(intent);

            }
        });


    }


    @Override
    protected void onStart() {
        super.onStart();
       mFirebaseAuth.addAuthStateListener(mAuthStateListener);
    }


}
