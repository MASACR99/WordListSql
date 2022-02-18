
package com.example.wordlistsql;

import android.view.View;

public class MyButtonOnClickListener implements View.OnClickListener {
    private static final String TAG = View.OnClickListener.class.getSimpleName();

    int id;
    String word;

    public MyButtonOnClickListener(int id, String word) {
        this.id = id;
        this.word = word;
    }

    public void onClick(View v) {}
}
