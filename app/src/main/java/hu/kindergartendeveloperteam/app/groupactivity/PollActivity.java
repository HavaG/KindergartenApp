package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import hu.kindergartendeveloperteam.app.groupactivity.async.Async;
import hu.kindergartendeveloperteam.app.groupactivity.async.OnResult;
import hu.kindergartendeveloperteam.app.groupactivity.async.Task;
import io.swagger.client.ApiException;
import io.swagger.client.api.DefaultApi;
import io.swagger.client.model.GroupgroupIdcreatePostPoll;
import io.swagger.client.model.KindergartenPoll;
import io.swagger.client.model.Path;
import io.swagger.client.model.Post;

public class PollActivity extends AppCompatActivity {
    AutoCompleteTextView textIn;
    LinearLayout container;
    Button buttonAdd;
    Button buttonOk;
    DefaultApi db = new DefaultApi();
    TextInputEditText question;
    ArrayList<String> answers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poll_create_activity);

        question = (TextInputEditText) findViewById(R.id.PollTextInputEditText);

        textIn = (AutoCompleteTextView) findViewById(R.id.textin);

        buttonAdd = (Button) findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);

        buttonOk = (Button) findViewById(R.id.okBtn);

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int group_id = getIntent().getIntExtra(GroupChooseActivity.GROUP_ID, 0);

                final Post newPost = new Post();
                GroupgroupIdcreatePostPoll pollWorkaround = new GroupgroupIdcreatePostPoll();
                pollWorkaround.setAnswers(answers);
                pollWorkaround.setQuestion(textIn.getText().toString());
                newPost.setPoll(pollWorkaround);
                newPost.setPath(new ArrayList<Path>());
                newPost.setContent("");
                newPost.setImage("");
                (new Async<Void>()).execute(new Task<Void>() {
                    @Override
                    public Void work() {
                        try {
                            db.createPost(group_id, newPost);
                        } catch (TimeoutException e) {
                            e.printStackTrace();
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } catch (ApiException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }
                }, new OnResult<Void>() {
                    @Override
                    public void onResult(Void data) {

                    }
                });

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });


        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textIn != null && !textIn.getText().toString().equals("")) {
                    LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View addView = layoutInflater.inflate(R.layout.poll_option_item, null);
                    AutoCompleteTextView textOut = addView.findViewById(R.id.textout);
                    textOut.setText(textIn.getText().toString());
                    answers.add(textIn.getText().toString());
                    Button buttonRemove = addView.findViewById(R.id.removeBtn);

                    buttonRemove.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ((LinearLayout) addView.getParent()).removeView(addView);
                        }
                    });
                    textIn.setText("");
                    container.addView(addView);
                }
            }
        });
    }
}