package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class PollActivity extends AppCompatActivity {
    AutoCompleteTextView textIn;
    LinearLayout container;
    Button buttonAdd;
    Button buttonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.poll_create_activity);


        textIn = (AutoCompleteTextView)findViewById(R.id.textin);

        buttonAdd = (Button)findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);

        buttonOk = (Button) findViewById(R.id.okBtn);

        buttonOk.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //TODO: create poll type post and add . Goes to the created post

                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        } );


        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(textIn != null && !textIn.getText().toString().equals("")) {
                    LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    final View addView = layoutInflater.inflate(R.layout.poll_option_item, null);
                    AutoCompleteTextView textOut = addView.findViewById(R.id.textout);
                    textOut.setText(textIn.getText().toString());
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