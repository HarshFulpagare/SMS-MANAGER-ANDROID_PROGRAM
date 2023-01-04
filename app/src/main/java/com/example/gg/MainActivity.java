package com.example.gg;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gg.R;

public class MainActivity extends AppCompatActivity {
    EditText phone,msg;
    Button message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone = (EditText) findViewById(R.id.editTextPhone);
        msg = (EditText) findViewById(R.id.editTextTextMultiLine);
        message = (Button) findViewById(R.id.btnsms);
        Button btnmsg = (Button) findViewById(R.id.btnsms);
        final EditText mssget = (EditText) findViewById(R.id.editTextTextMultiLine);
        final EditText phonenoet = (EditText) findViewById(R.id.editTextPhone);
        btnmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgsms = mssget.getText().toString();
                String phoneno = phonenoet.getText().toString();
                if (!TextUtils.isEmpty(msgsms) && !TextUtils.isEmpty(phoneno)){
                    Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:-"+phoneno));
                    smsIntent.putExtra("sms_body",msgsms);
                    startActivity(smsIntent);
                }
                else
                    Toast.makeText(MainActivity.this, "flieds are required", Toast.LENGTH_SHORT).show();
            }
        });
    }
}