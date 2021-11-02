package com.moringaschool.covidinformer.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.moringaschool.covidinformer.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @BindView(R.id.loginTextView) TextView mLoginTextView;
    @BindView(R.id.passwordError)  TextView mPasswordError;

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);

        mLoginTextView.setOnClickListener(this);
        mCreateUserButton.setOnClickListener(this);
        firebaseAuth=FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View view) {
        if (view == mLoginTextView) {
            Intent intent = new Intent(SignUp.this, LogIn.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if(view==mCreateUserButton){

            createUser();
//            Toast.makeText(SignUp.this, "Log in button clicked", Toast.LENGTH_SHORT).show();

        }
    }
    public void createUser(){
        final String name = mNameEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();

        firebaseAuth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, task -> {

                    if(password.equals(confirmPassword)){
                        if(task.isSuccessful()){
                            Intent intent= new Intent(SignUp.this, CovidSearch.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            Toast.makeText(SignUp.this, "Welcome "+name, Toast.LENGTH_SHORT).show();
                            startActivity(intent);
                        }else {
                            Toast.makeText(SignUp.this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                        }
                   }
                   else{
                        mConfirmPasswordEditText.setError("Password don't match");
                   }
                });

    }
}