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

public class MyChildChooseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_child_choose_activity);

        //TODO: amennyi adat tartozik a felhasználóhoz, annyi gyereket renderel ki

        final ArrayList<String> names = new ArrayList<>();
        names.add("Bélácska");
        names.add("Andriska");


        for (int i = 0; i < names.size(); i++) {
            LayoutInflater layoutInflater =(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final Button myButton = (Button) layoutInflater.inflate(R.layout.my_child_choose_btn, null);
            myButton.setText(names.get(i));
            myButton.setId(i);
            final int id_ = myButton.getId();

            LinearLayout layout = findViewById(R.id.myChildLayoutBtn);
            layout.addView(myButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent;

                    final String childName = names.get(id_);

                    intent = new Intent(getBaseContext(), MyChildActivity.class);
                    intent.putExtra("child_name", childName);

                    startActivity(intent);
                }
            });
        }
    }
}