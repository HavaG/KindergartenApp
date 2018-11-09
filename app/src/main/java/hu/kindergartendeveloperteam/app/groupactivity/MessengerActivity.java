package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

class MessengerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Button newMessageBtn = (Button) findViewById(R.id.newMessageBtn);

        newMessageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), GroupActivity.class);
                intent.putExtra("onlyMessage", true);
                startActivity(intent);
            }
        });
    }
}
