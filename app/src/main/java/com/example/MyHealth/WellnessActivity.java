package com.example.MyHealth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.MyHealth.fitnessbands.scan.ScanActivity;

public class WellnessActivity extends AppCompatActivity {
    private RelativeLayout physwellnesscard;
    private RelativeLayout intellectualcard;
    private RelativeLayout spiritualwellness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellness2);

        physwellnesscard = findViewById(R.id.physwellnesscard);
        intellectualcard = findViewById(R.id.intellectualcard);
      //  spiritualwellness = findViewById(R.id.spiritualcard);


        physwellnesscard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPhysWellness();
            }
        });

        intellectualcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openintellectual();
            }
        });

        intellectualcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
     //           openspiritual();
            }
        });
    }

   // private void openspiritual() {
  //      Intent intent = new Intent(WellnessActivity.this, SpiritWellness.class);
  //      startActivity(intent);
  //  }

    private void openintellectual() {
        Intent intent = new Intent(WellnessActivity.this, IntWellness.class);
        startActivity(intent);
    }

    private void openPhysWellness() {
        Intent intent = new Intent(WellnessActivity.this, PhysWellness.class);
        startActivity(intent);
    }
}