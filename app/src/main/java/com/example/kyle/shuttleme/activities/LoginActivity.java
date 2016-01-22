package com.example.kyle.shuttleme.activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kyle.shuttleme.R;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by Kyle on 31/03/2015.
 */
public class LoginActivity extends Activity {

    protected EditText Username;
    //protected EditText Email;
    protected EditText UserPassword;
    protected Button SignIn;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        //intialize
        Username = (EditText) findViewById(R.id.usernameEditText);
        //Email = (EditText)findViewById(R.id.emailEditText);
        UserPassword = (EditText) findViewById(R.id.passwordEditText);
        SignIn = (Button) findViewById(R.id.signInButton);

        UserPassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == R.id.edittext_action_login ||
                        actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
                    login();
                    return true;
                }
                return false;
            }
        });

        //set on click listener
        SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }

        });
    }


    private void login() {
        String username = Username.getText().toString().trim();
        String password = UserPassword.getText().toString().trim();

        // Validate the log in data
        boolean validationError = false;
        StringBuilder validationErrorMessage = new StringBuilder(getString(R.string.error_intro));
        if (username.length() == 0) {
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_blank_username));
        }
        if (password.length() == 0) {
            if (validationError) {
                validationErrorMessage.append(getString(R.string.error_join));
            }
            validationError = true;
            validationErrorMessage.append(getString(R.string.error_blank_password));
        }
        validationErrorMessage.append(getString(R.string.error_end));

        // If there is a validation error, display the error
        if (validationError) {
            Toast.makeText(LoginActivity.this, validationErrorMessage.toString(), Toast.LENGTH_LONG)
                    .show();
            return;
        }

        // Set up a progress dialog
        final ProgressDialog dialog = new ProgressDialog(LoginActivity.this);
        dialog.setMessage(getString(R.string.progress_login));
        dialog.show();
        // Call the Parse login method
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                dialog.dismiss();
                if (e != null) {
                    // Show the error message
                    Toast.makeText(LoginActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                } else {
                    // Start an intent for the dispatch activity
                    Intent intent = new Intent(LoginActivity.this, DispatchActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);

                    Toast.makeText(LoginActivity.this, "Login Successful! Welcome", Toast.LENGTH_LONG).show();
                }
            }

        });
    }
        /*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_other, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                Intent goToSetting = new Intent(LoginActivity.this, SettingsActivity.class);
                startActivity(goToSetting);
                //return true;
            }
            else if (id == R.id.action_AboutUs){
                Intent goToAbout = new Intent(LoginActivity.this, AboutActivity.class);
                startActivity(goToAbout);
                //return true;
            }
            else {
                if (id == R.id.action_Help) {
                    Intent goToHelp = new Intent(LoginActivity.this, HelpActivity.class);
                    startActivity(goToHelp);
                    //return true;
                }
            }

            return super.onOptionsItemSelected(item);
        } */

}