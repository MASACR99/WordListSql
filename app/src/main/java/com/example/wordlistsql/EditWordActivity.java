
package com.example.wordlistsql;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class EditWordActivity extends AppCompatActivity {

    private static final String TAG = EditWordActivity.class.getSimpleName();

    private static final int NO_ID = -99;
    private static final String NO_WORD = "";

    private EditText mEditWordView;

    public static final String EXTRA_REPLY = "com.example.android.wordlistsql.REPLY";

    int mId = MainActivity.WORD_ADD;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_word);

        mEditWordView = (EditText) findViewById(R.id.edit_word);

        Bundle extras = getIntent().getExtras();

        if (extras != null) {
            int id = extras.getInt(WordListAdapter.EXTRA_ID, NO_ID);
            String word = extras.getString(WordListAdapter.EXTRA_WORD, NO_WORD);
            if ((id != NO_ID) && (word != NO_WORD)) {
                mId = id;
                mEditWordView.setText(word);
            }
        }
    }

    public void returnReply(View view) {
        String word = ((EditText) findViewById(R.id.edit_word)).getText().toString();

        Intent replyIntent = new Intent();
        replyIntent.putExtra(EXTRA_REPLY, word);
        replyIntent.putExtra(WordListAdapter.EXTRA_ID, mId);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}

