package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class CreatePollActivity extends AppCompatActivity {
    AutoCompleteTextView textIn;
    Button buttonAdd;
    LinearLayout container;

    private static final String[] NUMBER = new String[] {
            "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten"
};
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_poll);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, (List<String>) null);

        textIn = (AutoCompleteTextView)findViewById(R.id.textin);
        textIn.setAdapter(adapter);

        buttonAdd = (Button)findViewById(R.id.add);
        container = (LinearLayout) findViewById(R.id.container);

        buttonAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.poll_option, null);
                AutoCompleteTextView textOut = (AutoCompleteTextView)addView.findViewById(R.id.textout);
                textOut.setAdapter(adapter);
                textOut.setText(textIn.getText().toString());
                Button buttonRemove = (Button)addView.findViewById(R.id.removeBtn);

                buttonRemove.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }
                });
                textIn.setText("");
                container.addView(addView);
            }
        });
    }
}
