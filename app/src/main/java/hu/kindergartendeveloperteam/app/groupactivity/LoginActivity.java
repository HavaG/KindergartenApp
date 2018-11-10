package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    TextView userName;
    TextView password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        userName = (TextView) findViewById(R.id.UsernameTextInputEditText);
        password = (TextView) findViewById(R.id.PasswordTextInputEditText);

        Button loginBtn = (Button) findViewById(R.id.LoginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                if (TextUtils.isEmpty(userName.getText())) {
                    userName.setError("Username is required!");
                } else if (TextUtils.isEmpty(password.getText())) {
                    password.setError("Password is required!");
                } else {
                    //TODO: azonosítás
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }*/

                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
