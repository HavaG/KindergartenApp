package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.appcompat.app.AppCompatActivity;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Group;

public class GroupChooseActivity extends AppCompatActivity {

    DefaultApi db = new DefaultApi();
    public static String GROUP_ID = "group_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_choose_activity);

        List<Group> groups = new ArrayList<>();

        try {
            groups = db.getGroups();

        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ApiException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < groups.size(); i++) {
            LayoutInflater layoutInflater =(LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final Button myButton = (Button) layoutInflater.inflate(R.layout.group_choose_btn, null);
            myButton.setText(groups.get(i).getName());
            myButton.setId(i);
            final int id_ = myButton.getId();

            LinearLayout layout = findViewById(R.id.groupLayoutBtn);
            layout.addView(myButton);

            final List<Group> finalGroups = groups;
            myButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);

                    String groupName = finalGroups.get(id_).getName();
                    intent.putExtra("group_name", groupName);
                    intent.putExtra(GROUP_ID, finalGroups.get(id_).getId());

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