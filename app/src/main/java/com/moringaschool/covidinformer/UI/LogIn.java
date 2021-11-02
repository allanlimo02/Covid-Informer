package com.moringaschool.covidinformer.UI;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
    @BindView(R.id.login) Button mLoginButton;
    @BindView(R.id.signup) TextView mSignup;

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
        String email=mUsername.getText().toString().trim();
        String password=mPassword.getText().toString().trim();
        if (email.equals("")) {
            mUsername.setError("Please enter your email");
        }else
        if (password.equals("")) {
            mPassword.setError("Password cannot be blank");
        }else
        firebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(LogIn.this,"Welcome back ",Toast.LENGTH_LONG).show();
                            Intent intent= new Intent(LogIn.this, CovidSearch.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LogIn.this,"Wrong credentials",Toast.LENGTH_LONG).show();
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