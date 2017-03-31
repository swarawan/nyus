package com.swarawan.nyus.view.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.swarawan.nyus.R;
import com.swarawan.nyus.view.main.MainActivity;

/**
 * Created by rioswarawan on 3/29/17.
 */

public class LoginActivity extends Activity {

    private Button buttonLogin;
    private EditText formUsername, formPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        formUsername = (EditText) findViewById(R.id.form_username);
        formPassword = (EditText) findViewById(R.id.form_password);
        buttonLogin = (Button) findViewById(R.id.button_login);

        buttonLogin.setOnClickListener(onLoginClicked);
    }

    /**
     * Finish activity when click back to prevent coming back to main activity
     */
    @Override
    public void onBackPressed() {
        finish();
    }

    /**
     * Do this action when login button clicked.
     */
    private View.OnClickListener onLoginClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (isFormValid())
                login();
            else
                Toast.makeText(LoginActivity.this, "Form tidak boleh kosong", Toast.LENGTH_SHORT).show();
        }
    };

    /**
     * @return true if username and password has no empty field
     */
    private boolean isFormValid() {
        String username = formUsername.getText().toString();
        String password = formPassword.getText().toString();

        return !(username.equals("") && password.equals(""));
    }

    /**
     * User exist has credentials:
     * username --> rioswarawan
     * passowrd --> 12345678
     * <p>
     * Check form with existing credentials, will change page if user is exist.
     */
    private void login() {
        String username = formUsername.getText().toString();
        String password = formPassword.getText().toString();

        if (username.equals("rioswarawan") && password.equals("12345678"))
            goToMainMenu();
        else
            Toast.makeText(this, "Username dan password tidak dikenal.", Toast.LENGTH_SHORT).show();
    }

    /**
     * Intent declaration to change page from this page to MainActivity.
     * use startIntent(...) to start changing page.
     */
    private void goToMainMenu() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
