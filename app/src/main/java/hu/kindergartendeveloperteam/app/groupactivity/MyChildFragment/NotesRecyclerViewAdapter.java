package hu.kindergartendeveloperteam.app.groupactivity.MyChildFragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;
import hu.kindergartendeveloperteam.app.groupactivity.R;
import io.swagger.client.model.Note;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class NotesRecyclerViewAdapter extends
    RecyclerView.Adapter<NotesRecyclerViewAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView contextTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            contextTextView = itemView.findViewById(R.id.note_context);
        }
    }

    // Store a member variable for the contacts
    private List<Note> Notes;

    // Pass in the contact array into the constructor
    public NotesRecyclerViewAdapter(List<Note> notes) {
        this.Notes = notes;
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public NotesRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.my_child_note_item, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(NotesRecyclerViewAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Note note = this.Notes.get(position);

        // Set item views based on your views and data model
        TextView textView = viewHolder.contextTextView;
        textView.setText(note.getContent());
    }

    // Returns the total count of items in the list
    @Override
    public int getItemCount() {
        return this.Notes.size();
    }
}