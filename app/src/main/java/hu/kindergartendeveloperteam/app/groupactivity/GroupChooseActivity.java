package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.appcompat.app.AppCompatActivity;
import hu.kindergartendeveloperteam.app.groupactivity.async.Async;
import hu.kindergartendeveloperteam.app.groupactivity.async.OnResult;
import hu.kindergartendeveloperteam.app.groupactivity.async.Task;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Group;

public class GroupChooseActivity extends AppCompatActivity {

    DefaultApi db = new DefaultApi();
    public static String GROUP_ID = "group_id";
    public static String ONLY_MESSAGE = "only_message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_choose_activity);

        final List<Group> groups = new ArrayList<>();

        Async<List<Group>> async = new Async<>();
        async.execute(new Task<List<Group>>() {
            @Override
            public List<Group> work() {
                try {
                    groups.clear();
                    groups.addAll(db.getGroups());
                } catch (TimeoutException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                }
                return groups;
            }
        }, new OnResult<List<Group>>() {
            @Override
            public void onResult(List<Group> data) {
                for (int i = 0; i < groups.size(); i++) {
                    LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final Button myButton = (Button) layoutInflater.inflate(R.layout.group_choose_btn, null);
                    myButton.setText(groups.get(i).getName());
                    myButton.setId(i);
                    final int id_ = groups.get(i).getId();

                    LinearLayout layout = findViewById(R.id.groupLayoutBtn);
                    layout.addView(myButton);

                    final List<Group> finalGroups = groups;
                    myButton.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Intent intent = new Intent(getBaseContext(), MainActivity.class);

                            Log.d("clicked", "" + id_);

                            String open = getIntent().getStringExtra("open");
                            if (open.equals("group")) {
                                intent = new Intent(getBaseContext(), GroupActivity.class);
                                intent.putExtra(ONLY_MESSAGE, getIntent().getBooleanExtra("only_message", false));
                            } else if (open.equals("maps")) {
                                intent = new Intent(getBaseContext(), MapsActivity.class);
                            } else if (open.equals("poll")) {
                                intent = new Intent(getBaseContext(), PollActivity.class);
                            } else if (open.equals("post")) {
                                intent = new Intent(getBaseContext(), PostActivity.class);
                            }

                            intent.putExtra(GroupChooseActivity.GROUP_ID, id_);

                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}