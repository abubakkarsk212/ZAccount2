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
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
public class SingleViewDetails extends AppCompatActivity {
TextView title1,aboutpage1,aboutdetails1,specialpage,specialdetails,promotionpage,promotiondetails1,extrapage,extradetail;
Button installAction;
private DatabaseReference databaseReference;
    String u = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_view_details);
        databaseReference = FirebaseDatabase.getInstance().getReference("SingleImage").child("contentDetails");
        title1 = findViewById(R.id.topic);
        aboutpage1 = findViewById(R.id.aboutPage);
        aboutdetails1 = findViewById(R.id.aboutDetails);
        specialpage = findViewById(R.id.featurePage1);
        specialdetails = findViewById(R.id.featuresDetails);
        promotionpage = findViewById(R.id.promotionPage1);
        promotiondetails1 = findViewById(R.id.promotionDetails);
        extrapage = findViewById(R.id.extras);
        extradetail = findViewById(R.id.extrasDetails);
        installAction = findViewById(R.id.installnow);
        if(isConnected()){
            databaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    ProgressDialog pd = new ProgressDialog(SingleViewDetails.this);
                    pd.setMessage("Loading...");
                    pd.show();
                    pd.setCancelable(false);
                    ContentSingleObj contentSingleObj = dataSnapshot.getValue(ContentSingleObj.class);
                    title1.setText(contentSingleObj.getTopic());
                    aboutpage1.setText(contentSingleObj.getAbout());
                    aboutdetails1.setText(contentSingleObj.getAboutDetails());
                    specialpage.setText(contentSingleObj.getFeature());
                    specialdetails.setText(contentSingleObj.getFeatureDetails());
                    promotionpage.setText(contentSingleObj.getPromotion());
                    promotiondetails1.setText(contentSingleObj.getPromotionDetails());
                    extrapage.setText(contentSingleObj.getExtra());
                    extradetail.setText(contentSingleObj.getExtraDetails());
                    installAction.setText(contentSingleObj.getButtonText());
                    pd.dismiss(); }
                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot){}
                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
                @Override
                public void onCancelled(DatabaseError databaseError) { }}); }else{
            final AlertDialog.Builder builder = new AlertDialog.Builder(SingleViewDetails.this);
            builder.setTitle("No Internet Connection!");
            builder.setMessage("It seems that you have no internet connection.Please connect and try again");
            builder.setCancelable(false);
            builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(isConnected()){
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                ProgressDialog pd = new ProgressDialog(SingleViewDetails.this);
                                pd.setMessage("Loading...");
                                pd.show();
                                pd.setCancelable(false);
                                ContentSingleObj contentSingleObj = dataSnapshot.getValue(ContentSingleObj.class);
                                title1.setText(contentSingleObj.getTopic());
                                aboutpage1.setText(contentSingleObj.getAbout());
                                aboutdetails1.setText(contentSingleObj.getAboutDetails());
                                specialpage.setText(contentSingleObj.getFeature());
                                specialdetails.setText(contentSingleObj.getFeatureDetails());
                                promotionpage.setText(contentSingleObj.getPromotion());
                                promotiondetails1.setText(contentSingleObj.getPromotionDetails());
                                extrapage.setText(contentSingleObj.getExtra());
                                extradetail.setText(contentSingleObj.getExtraDetails());
                                installAction.setText(contentSingleObj.getButtonText());
                                pd.dismiss(); }
                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) { }
                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
                            @Override
                            public void onCancelled(DatabaseError databaseError) { }}); } else{
                        builder.show(); } }});
            builder.show(); }
        installAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                        ContentSingleObj contentSingleObj = dataSnapshot.getValue(ContentSingleObj.class);
                        String urlApp = contentSingleObj.getUrlClick();
                           try {
                               Intent i = new Intent(Intent.ACTION_VIEW);
                               i.setData(Uri.parse(urlApp));
                               startActivity(i);
                           }catch(Exception e){

                           }
                         }
                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) { }
                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }}); }}); }

                    public boolean isConnected(){
                     ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                     NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                     boolean isConnected = activeNetwork !=null && activeNetwork.isConnectedOrConnecting();
                     return isConnected;
    }
}