package com.example.prudhvi.broadacast;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Process;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button button1,button2;
EditText ed1;
PendingIntent pendingIntent;
AlarmManager alarmManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1=findViewById(R.id.start);
        button2=findViewById(R.id.stop);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startAlert();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @SuppressLint("ServiceCast")
    private void startAlert() {
        ed1=(EditText)findViewById(R.id.ed1);
        int i=Integer.parseInt(ed1.getText().toString());
        Intent intent=new Intent(this,MyReceiver.class);
        pendingIntent =PendingIntent.getBroadcast(this.getApplicationContext(),1,intent,0);
        alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(i*1000),pendingIntent);
        Toast.makeText(this, "Alarm After"+i+"Seconds", Toast.LENGTH_SHORT).show();

    }
    public  void onDestroy()
    {
        Process.killProcess(Process.myPid());
        super.onDestroy();
    }
}
