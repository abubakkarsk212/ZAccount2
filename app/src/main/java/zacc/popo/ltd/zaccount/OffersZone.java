package zacc.popo.ltd.zaccount;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OffersZone extends AppCompatActivity {
ListView listOfImages;
ImageView largeImg;
private DatabaseReference databaseReference,databaseReference1;
    OfferListAdapter offerListAdapter;
    List<OfferProgressObj> offerListObjs;
    String pageNo ="";
    int noOfitems1;
    int noOfitems ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offers_zone);
        databaseReference = FirebaseDatabase.getInstance().getReference("OffersList").child("ProgressOffer");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("OffersList").child("newOffer");
        listOfImages = findViewById(R.id.offersList1);
        largeImg = findViewById(R.id.largeImage);
        offerListObjs = new ArrayList<>();

        offerListAdapter = new OfferListAdapter(OffersZone.this,R.layout.offer_list,offerListObjs);
        listOfImages.setAdapter(offerListAdapter);
        final ProgressDialog progressDialog = new ProgressDialog(OffersZone.this);
        progressDialog.setMessage("Loading...");
        progressDialog.setCancelable(false);
        if(isConnected()) {
            progressDialog.show();

            databaseReference1.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    OfferNewImageObj offerNewImageObj = dataSnapshot.getValue(OfferNewImageObj.class);
                    Glide.with(largeImg.getContext())
                            .load(offerNewImageObj.getPhotoUrl())
                            .into(largeImg);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            databaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    OfferProgressObj offerProgressObj = dataSnapshot.getValue(OfferProgressObj.class);
                    //This reverse the list item
                   pageNo =  offerProgressObj.getPageNo();
//                    offerListObjs.add(0, offerProgressObj);
//
//                    offerListAdapter.notifyDataSetChanged();
                   offerListAdapter.add(offerProgressObj);
                    progressDialog.dismiss();
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }else {
            final AlertDialog.Builder builder = new AlertDialog.Builder(OffersZone.this);
            builder.setTitle("No Internet Connection!");
            builder.setMessage("It seems that you have no internet connection.Please connect and try again");
            builder.setCancelable(false);
            builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(isConnected()){
                        progressDialog.show();
                        databaseReference1.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                OfferNewImageObj offerNewImageObj = dataSnapshot.getValue(OfferNewImageObj.class);
                                Glide.with(largeImg.getContext())
                                        .load(offerNewImageObj.getPhotoUrl())
                                        .into(largeImg);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                        databaseReference.addChildEventListener(new ChildEventListener() {
                            @Override
                            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                OfferProgressObj offerProgressObj = dataSnapshot.getValue(OfferProgressObj.class);
                                //This reverse the list item
                                offerListAdapter.add(offerProgressObj);
                                progressDialog.dismiss();}
                            @Override
                            public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
                            @Override
                            public void onChildRemoved(DataSnapshot dataSnapshot) { }
                            @Override
                            public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
                            @Override
                            public void onCancelled(DatabaseError databaseError) { }});

                    }
                    else{
                        builder.show();
                    }
                }
            });
            builder.show();
        }

        largeImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(OffersZone.this,OfferNewDetails.class);
                startActivity(i);
            }
        });
        listOfImages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//               int realPos;
//                if(i==0) {
//                    realPos = i + noOfitems+1;
//                }else{
//                    noOfitems-=2;
//                    realPos = i + noOfitems+1;
//                }

            Intent i1 = new Intent(OffersZone.this,ProgressDetails.class);

            String no = i+1+"";
            i1.putExtra("pageNo",no);
            startActivity(i1);
            }
        });
    }
    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork !=null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Refresh").setIcon(R.drawable.ic_refresh_black_24dp).setShowAsAction(2);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getTitle().toString().equals("Refresh")){
            offerListObjs.clear();
            listOfImages.setAdapter(null);
            offerListAdapter.notifyDataSetChanged();


            final ProgressDialog progressDialog = new ProgressDialog(OffersZone.this);
            if(isConnected()) {
                progressDialog.show();

                databaseReference1.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        OfferNewImageObj offerNewImageObj = dataSnapshot.getValue(OfferNewImageObj.class);
                        Glide.with(largeImg.getContext())
                                .load(offerNewImageObj.getPhotoUrl())
                                .into(largeImg);
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
                databaseReference.addChildEventListener(new ChildEventListener() {
                    @Override
                    public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                        OfferProgressObj offerProgressObj = dataSnapshot.getValue(OfferProgressObj.class);
                        //This reverse the list item
                        listOfImages.setAdapter(offerListAdapter);
                        offerListAdapter.add(offerProgressObj);
                        progressDialog.dismiss();
                    }

                    @Override
                    public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onChildRemoved(DataSnapshot dataSnapshot) {

                    }

                    @Override
                    public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }else {
                final AlertDialog.Builder builder = new AlertDialog.Builder(OffersZone.this);
                builder.setTitle("No Internet Connection!");
                builder.setMessage("It seems that you have no internet connection.Please connect and try again");
                builder.setCancelable(false);
                builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(isConnected()){
                            progressDialog.show();
                            databaseReference1.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    OfferNewImageObj offerNewImageObj = dataSnapshot.getValue(OfferNewImageObj.class);
                                    Glide.with(largeImg.getContext())
                                            .load(offerNewImageObj.getPhotoUrl())
                                            .into(largeImg);
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });
                            databaseReference.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                                    OfferProgressObj offerProgressObj = dataSnapshot.getValue(OfferProgressObj.class);
                                    //This reverse the list item
                                    offerListAdapter.add(offerProgressObj);
                                    progressDialog.dismiss();}
                                @Override
                                public void onChildChanged(DataSnapshot dataSnapshot, String s) { }
                                @Override
                                public void onChildRemoved(DataSnapshot dataSnapshot) { }
                                @Override
                                public void onChildMoved(DataSnapshot dataSnapshot, String s) { }
                                @Override
                                public void onCancelled(DatabaseError databaseError) { }});

                        }
                        else{
                            builder.show();
                        }
                    }
                });
                builder.show();
            }

        }

        return true;
    }
}
