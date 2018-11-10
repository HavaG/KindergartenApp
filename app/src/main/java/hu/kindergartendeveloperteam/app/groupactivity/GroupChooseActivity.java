package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Intent;
import android.os.Bundle;
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
            Button myButton = new Button(this);
            myButton.setText(names.get(i));
            myButton.setId(i);
            final int id_ = myButton.getId();

            LinearLayout layout = (LinearLayout) findViewById(R.id.groupLayoutBtn);
            layout.addView(myButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    //TODO: group activiy megnyitása (extra infó, hogy melyik csoportot kell renderelni?)
                    Intent intent = new Intent(getBaseContext(), GroupActivity.class);
                    final String groupName = names.get(id_);
                    intent.putExtra("group_name", groupName);
                    intent.putExtra("only_message", getIntent().getBooleanExtra("only_message", false));
                    startActivity(intent);
                }
            });
        }
    }
}