package com.example.test_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mdata;
    Button on1, off1, on2, off2, onall, offall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        on1 =(Button) findViewById(R.id.button_On_1);
        off1 =(Button) findViewById(R.id.button_Off_1);
        SeekBar Brightness1 = (SeekBar) findViewById(R.id.seekBar1);
        on2 =(Button) findViewById(R.id.button_On_2);
        off2 =(Button) findViewById(R.id.button_Off_2);
        SeekBar Brightness2 = (SeekBar) findViewById(R.id.seekBar2);
        onall =(Button) findViewById(R.id.button_on_all);
        offall =(Button) findViewById(R.id.button_off_all);
        mdata = FirebaseDatabase.getInstance().getReference();
        mdata.child("DEN1").setValue("0");
        mdata.child("DEN2").setValue("0");
        Brightness1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                mdata.child("Brightness1").setValue(progressChangedValue);
                mdata.child("DEN1").setValue("2");
                Toast.makeText(MainActivity.this, "Seek bar progress is :" + progressChangedValue,
                        Toast.LENGTH_SHORT).show();
            }
        });
    on1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mdata.child("DEN1").setValue("1");
            Brightness1.setProgress(100);
            mdata.child("Brightness1").setValue(100);
        }
    });
    off1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mdata.child("DEN1").setValue("0");
            Brightness1.setProgress(0);
            mdata.child("Brightness1").setValue(0);
        }
    });

    on2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mdata.child("DEN2").setValue("1");
            Brightness2.setProgress(100);
            mdata.child("Brightness2").setValue(100);
        }
    });
    off2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mdata.child("DEN2").setValue("0");
            Brightness2.setProgress(0);
            mdata.child("Brightness2").setValue(0);
        }
    });
        Brightness2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue_2 = 0;

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progressChangedValue_2 = progress;
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                // TODO Auto-generated method stub
            }

            public void onStopTrackingTouch(SeekBar seekBar) {
                mdata.child("Brightness2").setValue(progressChangedValue_2);
                mdata.child("DEN2").setValue("2");
                Toast.makeText(MainActivity.this, "Seek bar 2 progress is :" + progressChangedValue_2,
                        Toast.LENGTH_SHORT).show();
            }
        });
    onall.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mdata.child("DEN1").setValue("1");
            mdata.child("DEN2").setValue("1");
            Brightness1.setProgress(100);
            Brightness2.setProgress(100);
            mdata.child("Brightness1").setValue(100);
            mdata.child("Brightness2").setValue(100);
        }
    });
    offall.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mdata.child("DEN1").setValue("0");
            mdata.child("DEN2").setValue("0");
            Brightness1.setProgress(0);
            Brightness2.setProgress(0);
            mdata.child("Brightness1").setValue(0);
            mdata.child("Brightness2").setValue(0);
        }
    });
}
}