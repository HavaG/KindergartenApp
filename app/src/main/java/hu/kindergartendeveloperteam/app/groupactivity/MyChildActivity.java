package hu.kindergartendeveloperteam.app.groupactivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.MyChildFragment.NotesRecyclerViewAdapter;
import io.swagger.client.model.Note;

public class MyChildActivity extends AppCompatActivity {

    CompactCalendarView compactCalendar;
    private SimpleDateFormat dateFormatMonth = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_child_activity);


        compactCalendar = findViewById(R.id.compactcalendar_view);
        compactCalendar.setUseThreeLetterAbbreviation(true);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String firstMonth = dateFormatMonth.format(compactCalendar.getFirstDayOfCurrentMonth());
        toolbar.setTitle(firstMonth.substring(0,1).toUpperCase() + firstMonth.substring(1).toLowerCase());



        setNotesAdapter();
        fillCalendarPresences();

        compactCalendar.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                Context context = getApplicationContext();


                if (dateClicked.toString().compareTo("Fri Oct 21 00:00:00 AST 2016") == 0) {
                    Toast.makeText(context, "Your children was not in Kindergarten", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(context, "No Events Planned for that day", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                String month = dateFormatMonth.format(firstDayOfNewMonth);
                toolbar.setTitle(month.substring(0,1).toUpperCase() + month.substring(1).toLowerCase());
            }
        });

    }

    private long dateToMillis(int y, int m, int d){
        long year = y-1970;
        long month = m-1;
        long day = d-1;
        return (long) ((3155.6926 * 10000000 * year) + (2.62974383 * 1000000000 * month) + (86400000 * day));
    }

    private void fillCalendarPresences() {
        //get the presences from database, create events, safe events for compare?





        Event ev1 = new Event(Color.RED, 1542668400000L, "Teachers' Professional Day");
        compactCalendar.addEvent(ev1);
    }

    private void setNotesAdapter() {
        // Lookup the recyclerview in activity layout
        RecyclerView rvNotes = findViewById(R.id.notes_container);


        List<Note> Notes = new ArrayList<>();

        Note n = new Note();
        n.setContent("Elemer ma nagyon rossz volt");
        Notes.add(n);

        //TODO:valós adatokkal feltöltött Notes database
        /**
         try {

         Notes = db.getChild(51).getNotes();

         } catch (TimeoutException e) {
         e.printStackTrace();
         } catch (ExecutionException e) {
         e.printStackTrace();
         } catch (InterruptedException e) {
         e.printStackTrace();
         } catch (ApiException e) {
         e.printStackTrace();
         }
         */

        // Create adapter passing in the sample user data
        NotesRecyclerViewAdapter adapter = new NotesRecyclerViewAdapter(Notes);

        // Attach the adapter to the recyclerview to populate items
        rvNotes.setAdapter(adapter);

        // Set layout manager to position the items
        rvNotes.setLayoutManager(new LinearLayoutManager(this));
        // That's all!
    }
}
