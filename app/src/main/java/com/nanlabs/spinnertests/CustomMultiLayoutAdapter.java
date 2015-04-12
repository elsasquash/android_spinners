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
 * Created by martin on 12/04/15.
 */
public class CustomMultiLayoutAdapter  extends ArrayAdapter<Person> {
    private ArrayList<Person> data;
    private int resource1Id, resource2Id;
    private Context context;

    public CustomMultiLayoutAdapter(Context context, int resource1, int resource2, ArrayList persons) {
        super(context, resource1, persons);
        this.data = persons;
        this.resource1Id = resource1;
        this.resource2Id = resource2;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        CustomHolder holder;
        if(row == null) {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            if (data.get(position).getGender() == Person.MALE) {
                row = inflater.inflate(resource1Id, parent, false);
            } else {
                row = inflater.inflate(resource2Id, parent, false);
            }

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
