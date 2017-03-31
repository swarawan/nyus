package com.swarawan.nyus.view.main;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.swarawan.nyus.R;
import com.swarawan.nyus.view.login.LoginActivity;
import com.swarawan.nyus.view.profile.ProfileActivity;

public class MainActivity extends AppCompatActivity {

    private TextView buttonNews;
    private TextView buttonProfile;
    private TextView buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNews = (TextView) findViewById(R.id.button_news);
        buttonProfile = (TextView) findViewById(R.id.button_profile);
        buttonLogout = (TextView) findViewById(R.id.button_logout);

        buttonNews.setOnClickListener(onNewsClicked);
        buttonProfile.setOnClickListener(onProfileClicked);
        buttonLogout.setOnClickListener(onLogoutClicked);
    }

    private View.OnClickListener onNewsClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToNews();
        }
    };

    private View.OnClickListener onProfileClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            goToProfile();
        }
    };

    private View.OnClickListener onLogoutClicked = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            logout();
        }
    };

    private DialogInterface.OnClickListener onOkDialogClicked = new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.dismiss();
        }
    };

    /**
     * Will continue to Pertemuan 2, we will discuss about list and get data from API
     */
    private void goToNews() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Halaman ini akan dibahas dipertemuan selanjutnya, kita akan membahas mengenai List dan mengambil data via API. Jangan lupa untuk hadir di pertemuan berikutnya :v");
        builder.setCancelable(false);
        builder.setPositiveButton("OK", onOkDialogClicked);
        builder.create();
        builder.show();
    }

    /**
     * Open Profile page
     */
    private void goToProfile() {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }

    /**
     * Logout will bring you to login page.
     */
    private void logout() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
