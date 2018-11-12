package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ProgressDetails extends AppCompatActivity {
    TextView topic1,avail,availDetails1,pcode,pcodeDetails,things,thingsDetails,tnc,tncDetails,validity,validityDet;
    Button availNow1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_details);
        Intent i =getIntent();

        String page = i.getStringExtra("pageNo");

        topic1 = findViewById(R.id.topic28);
        avail = findViewById(R.id.availPage8);
        availDetails1 = findViewById(R.id.aboutDetailsold8);
        pcode = findViewById(R.id.promoPage8);
        pcodeDetails = findViewById(R.id.promoDetails8);
        things = findViewById(R.id.thingPage8);
        thingsDetails = findViewById(R.id.thingDetails8);
        tnc = findViewById(R.id.tcPage18);
        tncDetails = findViewById(R.id.tcDetails8);
        validity = findViewById(R.id.validityPage8);
        validityDet = findViewById(R.id.validityDetails8);
        availNow1 = findViewById(R.id.availnow8);
        topic1.setText(page);
    }
}
