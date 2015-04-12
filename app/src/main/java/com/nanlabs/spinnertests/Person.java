package com.nanlabs.spinnertests;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by martin on 11/04/15.
 */
public class Person {
    public final static int MALE = 0;
    public final static int FEMALE = 1;
    public final static int OTHER = 2;
    private String jsonString;

    public Person(String json) {
        this.jsonString = json;
    }

    public String toString() {
        JSONObject object = null;
        try {
            object = new JSONObject(jsonString);
            return object.getString("firstName") + object.getString("lastName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getFirstName() {
        try {
            return new JSONObject(jsonString).getString("firstName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public String getLastName() {
        try {
            return new JSONObject(jsonString).getString("lastName");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return "";
    }

    public int getGender() {
        try {
            switch(new JSONObject(jsonString).getString("gender")){
                case "male":
                    return this.MALE;
                case "female":
                    return this.FEMALE;
            };
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
