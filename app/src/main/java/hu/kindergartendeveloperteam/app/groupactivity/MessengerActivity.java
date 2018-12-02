package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MessengerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_activity);


        //TODO: create a chat --> ez még messze van, majd a socket dolog


        Button newMessageBtn = (Button) findViewById(R.id.newMessageBtn);

        newMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), GroupChooseActivity.class);
                intent.putExtra("only_message", true).putExtra("open", "group");
                startActivity(intent);
            }
        });
    }
}