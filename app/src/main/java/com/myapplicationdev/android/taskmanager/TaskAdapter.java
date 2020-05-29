package com.myapplicationdev.android.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    private ArrayList<Task> tasks;
    private Context context;
    private TextView tv1, tv2, tv3;


    public TaskAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        tasks = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tv1 = (TextView) rowView.findViewById(R.id.tv1);
        tv2 = (TextView) rowView.findViewById(R.id.tv2);
        tv3 = (TextView) rowView.findViewById(R.id.tv3);
        // Get the ImageView object

        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Task currentTask = tasks.get(position);
        // Set the TextView to show the food

        tv3.setText(""+currentTask.getId());
        tv1.setText(currentTask.getDescription());
        tv2.setText(currentTask.getName());

        // Return the nicely done up View to the ListView
        return rowView;
    }

}
