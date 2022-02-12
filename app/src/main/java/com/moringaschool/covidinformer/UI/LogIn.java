package com.moringaschool.covidinformer.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.covidinformer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LogIn extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.username) EditText mUsername;
    @BindView(R.id.password) EditText mPassword;
    @BindView(R.id.loginButton) Button mLoginButton;
    @BindView(R.id.signup) TextView mSignup;
    @BindView(R.id.constrain ) ConstraintLayout constrain;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        ButterKnife.bind(this);
        mLoginButton.setOnClickListener(this);
        mSignup.setOnClickListener(this);

        firebaseAuth=FirebaseAuth.getInstance();
        mAuthListener= new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

            }
        };
    }
    @Override
    public void onClick(View view) {
        if(view==mSignup){
            Intent intent=new Intent(LogIn.this, SignUp.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }
        if(view==mLoginButton){

            loginWithPassword();
        }
    }
    private void loginWithPassword() {
        constrain.setVisibility(View.VISIBLE);
        String email=mUsername.getText().toString().trim();
        String password=mPassword.getText().toString().trim();
        if (email.equals("")) {
            constrain.setVisibility(View.GONE);
            mUsername.setError("Please enter your email");
        }else
        if (password.equals("")) {
            constrain.setVisibility(View.GONE);
            mPassword.setError("Password cannot be blank");
        }else
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            constrain.setVisibility(View.GONE);
//                            Toast.makeText(LogIn.this,"Welcome",Toast.LENGTH_LONG).show();
                            Intent intent= new Intent(LogIn.this, MainActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }else {
                            constrain.setVisibility(View.GONE);
                            mPassword.setError("");
                            mUsername.setError("");
                            Toast.makeText(LogIn.this,"Check email & password and try again",Toast.LENGTH_LONG).show();
                        }

                    }
                });

    }
    @Override
    public void onStart() {
        super.onStart();
        firebaseAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            firebaseAuth.removeAuthStateListener(mAuthListener);
        }
    }
}