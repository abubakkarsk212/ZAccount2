package zacc.popo.ltd.zaccount;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OfferNewDetails extends AppCompatActivity {
  TextView topic1,avail,availDetails1,pcode,pcodeDetails,things,thingsDetails,tnc,tncDetails,validity,validityDet;
  Button availNow1;
  DatabaseReference databaseReference;
  String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_new_details);
        databaseReference = FirebaseDatabase.getInstance().getReference("OffersList").child("newOffer").child("details");
        topic1 = findViewById(R.id.topic2);
        avail = findViewById(R.id.availPage);
        availDetails1 = findViewById(R.id.aboutDetailsold);
        pcode = findViewById(R.id.promoPage);
        pcodeDetails = findViewById(R.id.promoDetails);
        things = findViewById(R.id.thingPage);
        thingsDetails = findViewById(R.id.thingDetails);
        tnc = findViewById(R.id.tcPage1);
        tncDetails = findViewById(R.id.tcDetails);
        validity = findViewById(R.id.validityPage);
        validityDet = findViewById(R.id.validityDetails);
        availNow1 = findViewById(R.id.availnow);
        //To check internet connection
        final ProgressDialog pd = new ProgressDialog(OfferNewDetails.this);
        if(isConnected()){
            pd.setMessage("Loading...");
            pd.show();
            pd.setCancelable(false);
            databaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    NewOObj newOObj = dataSnapshot.getValue(NewOObj.class);
                    topic1.setText(newOObj.getTopics());
                    avail.setText(newOObj.getAvailS());
                    availDetails1.setText(newOObj.getAvailSd());
                    pcode.setText(newOObj.getpS());
                    pcodeDetails.setText(newOObj.getpSd());
                    things.setText(newOObj.getThingsS());
                    thingsDetails.setText(newOObj.getThingsSd());
                    tnc.setText(newOObj.getTc());
                    tncDetails.setText(newOObj.getTcd());
                    validity.setText(newOObj.getVal());
                    validityDet.setText(newOObj.getValD());
                    url = newOObj.getUrlB();
                    pd.dismiss();
                }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot){}
                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
                @Override
                public void onCancelled(DatabaseError databaseError) { }});
        }
                else{
        final AlertDialog.Builder builder = new AlertDialog.Builder(OfferNewDetails.this);
        builder.setTitle("No Internet Connection!");
        builder.setMessage("It seems that you have no internet connection.Please connect and try again");
        builder.setCancelable(false);
        builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(isConnected()){
                    pd.show();
                    databaseReference.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                            NewOObj newOObj = dataSnapshot.getValue(NewOObj.class);
                            topic1.setText(newOObj.getTopics());
                            avail.setText(newOObj.getAvailS());
                            availDetails1.setText(newOObj.getAvailSd());
                            pcode.setText(newOObj.getpS());
                            pcodeDetails.setText(newOObj.getpSd());
                            things.setText(newOObj.getThingsS());
                            thingsDetails.setText(newOObj.getThingsSd());
                            tnc.setText(newOObj.getTc());
                            tncDetails.setText(newOObj.getTcd());
                            validity.setText(newOObj.getVal());
                            validityDet.setText(newOObj.getValD());
                            url = newOObj.getUrlB();
                            pd.dismiss(); }
                        @Override
                        public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
                        @Override
                        public void onChildRemoved(DataSnapshot dataSnapshot) { }
                        @Override
                        public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
                        @Override
                        public void onCancelled(DatabaseError databaseError) { }}); }
                        else{
                    builder.show();
                }
            }
        });
        builder.show();
        }



        availNow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse("market://details?id="+url));
                    startActivity(i);
                }catch(Exception e){
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    //It will open a browser
                    i.setData(Uri.parse("https://play.google.com/store/apps/details?id="+url));
                    startActivity(i);
                }
            }
        });
    }
    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork !=null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
}
