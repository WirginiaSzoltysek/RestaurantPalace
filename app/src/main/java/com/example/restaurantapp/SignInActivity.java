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

public class SignInActivity extends AppCompatActivity {



    EditText password , email;
    Button signBtn;
    FirebaseAuth fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);



         fire= FirebaseAuth.getInstance();

         password =  findViewById(R.id.signIn_password);
         email= findViewById(R.id.signIn_UserName);
         signBtn = findViewById(R.id.button_sign);

         signBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 String e = email.getText().toString();
                 String p = password.getText().toString();
                 if (!(e.isEmpty() && p.isEmpty())) {
                     fire.createUserWithEmailAndPassword(e, p).addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                         @Override
                         public void onComplete(@NonNull Task<AuthResult> task) {
                             if (!task.isSuccessful()) {
                                 Toast.makeText(SignInActivity.this, "Sign in unsuccessfull, Please try again!", Toast.LENGTH_SHORT);
                             } else {
                                  String sign = "sign";
                                  Intent intent= new Intent(SignInActivity.this, WelcomeActivity.class);
                                  intent.putExtra("user_signed",sign);
                                  startActivity(intent);

                             }

                         }
                     });
                 }
             }
         });



    }
}
