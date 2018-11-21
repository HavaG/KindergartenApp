package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class GroupChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_choose_activity);

        //TODO: amennyi adat tartozik a felhasználóhoz, annyi gonbor renderel ki a csoportok nevével

        final ArrayList<String> names = new ArrayList<>();
        names.add("Kiskacsa");
        names.add("Gőzmozdony");
        names.add("Szivárvány");


        for (int i = 0; i < names.size(); i++) {
            LayoutInflater layoutInflater =(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final Button myButton = (Button) layoutInflater.inflate(R.layout.group_choose_btn, null);
            myButton.setText(names.get(i));
            myButton.setId(i);
            final int id_ = myButton.getId();

            LinearLayout layout = findViewById(R.id.groupLayoutBtn);
            layout.addView(myButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);

                    final String groupName = names.get(id_);
                    intent.putExtra("group_name", groupName);

                    String open = getIntent().getStringExtra("open");
                    if(open.equals("group")){
                        intent = new Intent(getBaseContext(), GroupActivity.class);
                        intent.putExtra("only_message", getIntent().getBooleanExtra("only_message", false));
                    } else if(open.equals("maps")) {
                        intent = new Intent(getBaseContext(), MapsActivity.class);
                    } else if(open.equals("poll")) {
                        intent = new Intent(getBaseContext(), PollActivity.class);
                    } else if(open.equals("post")) {
                        intent = new Intent(getBaseContext(), PostActivity.class);
                    }
                    startActivity(intent);
                }
            });
        }
    }
}