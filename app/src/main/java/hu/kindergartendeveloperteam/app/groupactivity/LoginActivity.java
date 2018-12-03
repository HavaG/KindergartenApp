package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
                 * mező kitöltésének ellenőrzése
                 */
                if (TextUtils.isEmpty(userName.getText())) {
                    userName.setError("Username is required!");
                } else if (TextUtils.isEmpty(password.getText())) {
                    password.setError("Password is required!");
                } else {
                    //TODO: azonosítás
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();
                }

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
    }
}
