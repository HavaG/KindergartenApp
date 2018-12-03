package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import hu.kindergartendeveloperteam.app.groupactivity.async.Async;
import hu.kindergartendeveloperteam.app.groupactivity.async.OnResult;
import hu.kindergartendeveloperteam.app.groupactivity.async.Task;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.User;

public class MessengerActivity extends AppCompatActivity {


    DefaultApi db = new DefaultApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.messenger_activity);

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