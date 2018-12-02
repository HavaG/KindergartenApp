package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.appcompat.app.AppCompatActivity;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Child;
import io.swagger.client.model.User;

public class MyChildChooseActivity extends AppCompatActivity {

    DefaultApi db;
    final ArrayList<Child> child = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_child_choose_activity);


        try {
            //TODO: azt kell lekérni aki be van jelentkezve
            User user = db.getUser(0);

            //TODO: a bejelentkezett user gyerekeit kell lekérni
            user.getChildren();
            child.add(gyerek1);
            child.add(gyerek2);

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }


        for (int i = 0; i < child.size(); i++) {
            LayoutInflater layoutInflater =(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final Button myButton = (Button) layoutInflater.inflate(R.layout.my_child_choose_btn, null);
            myButton.setText(child.get(i).getName());
            myButton.setId(i);
            final int id_ = myButton.getId();

            LinearLayout layout = findViewById(R.id.myChildLayoutBtn);
            layout.addView(myButton);

            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent;

                    final int childId = child.get(id_).getId();

                    intent = new Intent(getBaseContext(), MyChildActivity.class);
                    intent.putExtra("child_id", childId);

                    startActivity(intent);
                }
            });
        }
    }
}