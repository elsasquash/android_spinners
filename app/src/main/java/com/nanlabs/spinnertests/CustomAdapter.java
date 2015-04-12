package com.nanlabs.spinnertests;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by martin on 11/04/15.
 */
public class CustomAdapter extends ArrayAdapter<Person> {
    private ArrayList<Person> data;
    private int resourceId;
    private Context context;

    public CustomAdapter(Context context, int resource, ArrayList persons) {
        super(context, resource, persons);
        this.data = persons;
        this.resourceId = resource;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CustomHolder holder;
        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(resourceId, parent, false);

            holder = new CustomHolder();
            holder.firstName = (TextView)row.findViewById(R.id.textViewFirstName);
            holder.lastName = (TextView)row.findViewById(R.id.textViewLastName);

            row.setTag(holder);
        } else {
            holder = (CustomHolder) row.getTag();
        }
        holder.firstName.setText(data.get(position).getFirstName());
        holder.lastName.setText(data.get(position).getLastName());
        return row;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }

    static class CustomHolder {
        TextView firstName, lastName;
    }
}
