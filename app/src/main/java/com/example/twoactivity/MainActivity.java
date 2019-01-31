package com.example.twoactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    private EditText mMessageEditText;
    public static final int TEXT_REQUEST = 1;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    public static final String EXTRA_MESSAGE="com.example.twoActivity.extra.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText = findViewById(R.id.editText_main);
        mReplyHeadTextView= findViewById(R.id.text_header_reply);
        mReplyTextView = findViewById(R.id.text_message_reply);

    }
    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==TEXT_REQUEST){
            if(resultCode==RESULT_OK){
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);

            }
        }
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        String message = mMessageEditText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE,message);
        Log.d(LOG_TAG, "button is Clicked");
        startActivityForResult(intent,TEXT_REQUEST);
    }
}
