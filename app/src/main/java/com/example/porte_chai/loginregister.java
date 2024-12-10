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
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class loginregister extends AppCompatActivity {
    TextInputEditText email, password;
    Button loginButton, registerButton;
    FirebaseAuth mAuth;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginregister);

        email = findViewById(R.id.editTextTextEmailAddress); // Change ID for email input
        password = findViewById(R.id.editTextTextPassword); // Change ID for password input
        loginButton = findViewById(R.id.buttonLogin); // Change ID for login button
        registerButton = findViewById(R.id.buttonRegister); // Change ID for register button
        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar111);
        Window window = this.getWindow();

        // Clear FLAG_TRANSLUCENT_STATUS flag and set status bar color
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(this.getResources().getColor(R.color.yellow));

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
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
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.INVISIBLE);
                        if (task.isSuccessful()) {
                            Toast.makeText(loginregister.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(loginregister.this, homepage2.class));
                            finish();
                        } else {
                            Toast.makeText(loginregister.this, "Login Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
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
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.INVISIBLE);
                        if (task.isSuccessful()) {
                            Toast.makeText(loginregister.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(loginregister.this, homepage.class));
                            finish();
                        } else {
                            Toast.makeText(loginregister.this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(loginregister.this, homepage2.class));
            finish();
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}




//package com.example.food_wastage_management;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AlertDialog;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.net.ConnectivityManager;
//import android.net.NetworkInfo;
//import android.os.Bundle;
//import android.text.TextUtils;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowManager;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.ProgressBar;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.FirebaseException;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.auth.PhoneAuthCredential;
//import com.google.firebase.auth.PhoneAuthOptions;
//import com.google.firebase.auth.PhoneAuthProvider;
//import com.google.firebase.database.FirebaseDatabase;
//
//import java.util.concurrent.TimeUnit;
//
//public class loginregister extends AppCompatActivity {
//    EditText phone, otp;
//    Button send_otp, verify_otp;
//    FirebaseAuth mAuth;
//    ProgressBar bar;
//    String verificationID;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_loginregister);
//        phone = findViewById(R.id.editTextTextPersonName);
//        otp = findViewById(R.id.editTextTextPersonName2);
//        send_otp = findViewById(R.id.button);
//        verify_otp = findViewById(R.id.button2);
//        mAuth = FirebaseAuth.getInstance();
//        bar = findViewById(R.id.progressBar111);
//        Window window = this.getWindow();
//
//// clear FLAG_TRANSLUCENT_STATUS flag:
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//
//// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
//
//// finally change the color
//        window.setStatusBarColor(this.getResources().getColor(R.color.yellow));
//
//        send_otp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//
//                    if(phone.length()<10  ||  phone.length()>10)
//                    {
//                        phone.setError("Enter Proper Mobile Number");
//                    }
//                    else {
//                        String number = phone.getText().toString();
//                        bar.setVisibility(View.VISIBLE);
//                        sendverificationcode(number);
//                    }
//
//
//
//            }
//        });
//        verify_otp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//            {
//                    if(otp.length()==0)
//                    {
//                        otp.setError("Enter Otp");
//                    }
//                    else
//                        verifycode(otp.getText().toString());
//                }
//
//        });
//    }
//    public void onBackPressed() {
//
//
//
//                Intent intent = new Intent(Intent.ACTION_MAIN);
//                intent.addCategory(Intent.CATEGORY_HOME);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(intent);
//
//
//
//    }
//    private void sendverificationcode(String phoneNumber)
//    {
//        PhoneAuthOptions options =
//                PhoneAuthOptions.newBuilder(mAuth)
//                        .setPhoneNumber("+91"+phoneNumber)  // Phone number to verify
//                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
//                        .setActivity(this)                 // Activity (for callback binding)
//                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
//                        .build();
//        PhoneAuthProvider.verifyPhoneNumber(options);
//    }
//
//    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
//            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//        @Override
//        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential)
//        {
//            final String code = credential.getSmsCode();
//            if(code!=null)
//            {
//                verifycode(code);
//            }
//        }
//        @Override
//        public void onVerificationFailed(@NonNull FirebaseException e) {
//            Toast.makeText(loginregister.this, "Verification Failed", Toast.LENGTH_SHORT).show();
//        }
//
//        @Override
//        public void onCodeSent(@NonNull String s,
//                               @NonNull PhoneAuthProvider.ForceResendingToken token)
//        {
//            super.onCodeSent(s, token);
//            verificationID = s;
//            Toast.makeText(loginregister.this, "Code sent", Toast.LENGTH_SHORT).show();
//            verify_otp.setEnabled(true);
//            bar.setVisibility(View.INVISIBLE);
//        }};
//    private void verifycode(String Code)
//    {
//        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID,Code);
//        signinbyCredentials(credential);
//    }
//
//    private void signinbyCredentials(PhoneAuthCredential credential)
//    {
//        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
//        firebaseAuth.signInWithCredential(credential)
//                .addOnCompleteListener(new OnCompleteListener() {
//                    @Override
//                    public void onComplete(@NonNull Task task)
//                    {
//                        if(task.isSuccessful())
//                        {
//                            Toast.makeText(loginregister.this, "Login Successfull", Toast.LENGTH_SHORT).show();
//                            startActivity(new Intent(loginregister.this, homepage.class));
//                        }
//
//                    }
//                });}
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
//        if(currentUser!=null)
//        {
//            startActivity(new Intent(loginregister.this, homepage.class));
//            finish();
//        }}}