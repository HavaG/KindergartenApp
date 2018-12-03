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
import hu.kindergartendeveloperteam.app.groupactivity.async.Async;
import hu.kindergartendeveloperteam.app.groupactivity.async.OnResult;
import hu.kindergartendeveloperteam.app.groupactivity.async.Task;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.Group;
import io.swagger.client.model.KindergartenChild;
import io.swagger.client.model.KindergartenChild;
import io.swagger.client.model.KindergartenUser;

public class MyChildChooseActivity extends AppCompatActivity {

    DefaultApi db = new DefaultApi();
    List<KindergartenChild> child = new ArrayList<>();
    public static String CHILD_ID = "child_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_child_choose_activity);


        (new Async<List<KindergartenChild>>()).execute(new Task<List<KindergartenChild>>() {
            @Override
            public List<KindergartenChild> work() {
                List<KindergartenChild> children = new ArrayList<>();
                try {
                    List<Group> groups = db.getGroups();
                    for (int i = 0; i < groups.size(); i++) {
                        for(int j = 0; j < groups.get(i).getChildren().size(); j++) {
                            if(groups.get(i).getChildren().get(i).getParentId().equals(/*TODO: jelenleg bejelentkezett user*/ new KindergartenUser().getId())){
                                children.add(groups.get(i).getChildren().get(i));
                            }
                        }
                    }

                } catch (TimeoutException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ApiException e) {
                    e.printStackTrace();
                }

                return children;
            }
        }, new OnResult<List<KindergartenChild>>() {
            @Override
            public void onResult(final List<KindergartenChild> child) {
                for (int i = 0; i < child.size(); i++) {
                    LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
                            intent.putExtra(CHILD_ID, childId);

                            startActivity(intent);
                        }
                    });
                }
            }
        });
    }
}