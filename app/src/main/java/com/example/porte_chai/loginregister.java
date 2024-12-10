package com.example.porte_chai;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;

public class loginregister extends AppCompatActivity {
    TextInputEditText email, password;
    Button loginButton, registerButton;
    TextView forgetPassword;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginregister);

        email = findViewById(R.id.editTextTextEmailAddress); // ID for email input
        password = findViewById(R.id.editTextTextPassword); // ID for password input
        loginButton = findViewById(R.id.buttonLogin); // ID for login button
        registerButton = findViewById(R.id.buttonRegister); // ID for register button
        forgetPassword = findViewById(R.id.forgetPassword); // ID for "Forget Password"
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar111);

        // Set up status bar color
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.yellow));

        loginButton.setOnClickListener(v -> loginUser());
        registerButton.setOnClickListener(v -> registerUser());
        forgetPassword.setOnClickListener(v -> resetPassword());
    }

    private void loginUser() {
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        if (TextUtils.isEmpty(emailText)) {
            email.setError("Email is required.");
            return;
        }
        if (TextUtils.isEmpty(passwordText)) {
            password.setError("Password is required.");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(emailText, passwordText)
                .addOnCompleteListener(task -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    if (task.isSuccessful()) {
                        Toast.makeText(loginregister.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginregister.this, homepage2.class));
                        finish();
                    } else {
                        Toast.makeText(loginregister.this, "Login Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void registerUser() {
        String emailText = email.getText().toString().trim();
        String passwordText = password.getText().toString().trim();

        if (TextUtils.isEmpty(emailText)) {
            email.setError("Email is required.");
            return;
        }
        if (TextUtils.isEmpty(passwordText)) {
            password.setError("Password is required.");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.createUserWithEmailAndPassword(emailText, passwordText)
                .addOnCompleteListener(task -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    if (task.isSuccessful()) {
                        Toast.makeText(loginregister.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(loginregister.this, homepage.class));
                        finish();
                    } else {
                        Toast.makeText(loginregister.this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void resetPassword() {
        String emailText = email.getText().toString().trim();

        if (TextUtils.isEmpty(emailText)) {
            email.setError("Enter your registered email.");
            return;
        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.sendPasswordResetEmail(emailText)
                .addOnCompleteListener(task -> {
                    progressBar.setVisibility(View.INVISIBLE);
                    if (task.isSuccessful()) {
                        Toast.makeText(loginregister.this, "Password reset email sent. Check your inbox.", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(loginregister.this, "Error: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(loginregister.this, homepage2.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}