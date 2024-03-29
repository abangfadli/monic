package com.abangfadli.monic.repository.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.abangfadli.monic.common.Constant;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ahmadfadli on 7/7/15.
 */
public class StandardPrefManager {

    private static final String TAG = StandardPrefManager.class.getSimpleName();
    private static final String DEFAULT_PREF_FILE_NAME = Constant.APP_PACKAGE + "-" + "defaultPref";

    protected SharedPreferences preferences;

    /*---------------------------------------------------------------------
     |  Constructor
     *-------------------------------------------------------------------*/
    protected StandardPrefManager() {

    }

    public StandardPrefManager(Context context) {
        this(context, DEFAULT_PREF_FILE_NAME);
    }

    public StandardPrefManager(Context context, String fileName) {
        if(context == null) {
            throw new IllegalArgumentException("Context is Null");
        }

        preferences = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }


    /*---------------------------------------------------------------------
     |  Write
     *-------------------------------------------------------------------*/
    public boolean writeMany(Map<String, Object> values) {
        SharedPreferences.Editor editor = preferences.edit();

        for(Map.Entry<String, Object> entry : values.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            if(value instanceof String) editor.putString(key, String.valueOf(value));
            else if(value instanceof Boolean) editor.putBoolean(key, (boolean) value);
            else if(value instanceof Integer) editor.putInt(key, (int) value);
            else if(value instanceof Float) editor.putFloat(key, (float) value);
            else if(value instanceof Long) editor.putLong(key, (long) value);
            else return false;
        }

        return editor.commit();
    }

    public boolean writeString(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        return editor.commit();
    }

    public boolean writeInteger(String key, Integer value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, value);
        return editor.commit();
    }

    public boolean writeLong(String key, Long value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putLong(key, value);
        return editor.commit();
    }

    public boolean writeFloat(String key, Float value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putFloat(key, value);
        return editor.commit();
    }

    public boolean writeBoolean(String key, Boolean value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(key, value);
        return editor.commit();
    }

    /*---------------------------------------------------------------------
     |  Read
     *-------------------------------------------------------------------*/
    public Map<String, Object> getMany(Map<String, Object> keysAndDefaultValues) {
        Map<String, Object> result = new HashMap<String, Object>();
        for(Map.Entry<String, Object> entry : keysAndDefaultValues.entrySet()) {
            Object entryResult = null;
            Object defaultValue = entry.getValue();

            if(defaultValue instanceof String) entryResult = getString(entry.getKey(), (String)defaultValue);
            else if(defaultValue instanceof Boolean) entryResult = getBoolean(entry.getKey(), (Boolean)defaultValue);
            else if(defaultValue instanceof Integer) entryResult = getInteger(entry.getKey(), (Integer)defaultValue);
            else if(defaultValue instanceof Float) entryResult = getFloat(entry.getKey(), (Float)defaultValue);
            else if(defaultValue instanceof Long) entryResult = getLong(entry.getKey(), (Long)defaultValue);

            result.put(entry.getKey(), entryResult);
        }
        return result;
    }

    public String getString(String key, String defaultValue) {
        return preferences.getString(key, defaultValue);
    }

    public Integer getInteger(String key, Integer defaultValue) {
        return preferences.getInt(key, defaultValue);
    }

    public Long getLong(String key, Long defaultValue) {
        return preferences.getLong(key, defaultValue);
    }

    public Float getFloat(String key, Float defaultValue) {
        return preferences.getFloat(key, defaultValue);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        return preferences.getBoolean(key, defaultValue);
    }

    /*---------------------------------------------------------------------
     |  Delete
     *-------------------------------------------------------------------*/
    public boolean delete(String key) {
        SharedPreferences.Editor editor = preferences.edit();
        if(preferences.contains(key)) {
            editor.remove(key);
        }
        return editor.commit();
    }

    public boolean deleteAll() {
        return preferences.edit().clear().commit();
    }

    public boolean deleteMany(List<String> keys) {
        SharedPreferences.Editor editor = preferences.edit();
        for (String key : keys) {
            if(preferences.contains(key)) {
                editor.remove(key);
            }
        }

        return editor.commit();
    }
}
