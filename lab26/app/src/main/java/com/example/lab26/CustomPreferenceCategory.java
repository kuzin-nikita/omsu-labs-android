package com.example.lab26;

import android.content.Context;
import android.graphics.Color;
import android.preference.PreferenceCategory;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CustomPreferenceCategory extends PreferenceCategory {

    public CustomPreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public CustomPreferenceCategory(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomPreferenceCategory(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomPreferenceCategory(Context context) {
        super(context);
    }

    @Override
    protected View onCreateView(ViewGroup parent) {
        TextView categoryTitle =  (TextView)super.onCreateView(parent);
        categoryTitle.setBackgroundColor(Color.WHITE);
        categoryTitle.setTextColor(Color.RED);

        return categoryTitle;
    }
}
