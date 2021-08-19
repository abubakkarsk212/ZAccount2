package zacc.popo.ltd.zaccount;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;

public class SelectBank extends AppCompatActivity implements SelectBankAdapter.bankListClicked {
    RecyclerView recyclerView;
    SelectBankAdapter selectBankAdapter;
    DatabaseReference databaseReference;
    ArrayList<GridListObj> gridListObjs;
    ArrayList<GridNoDbListObj> gridListNoDbArr;
    ArrayList<String> key;

    String keys, type,titleA;
    RelativeLayout relativeLayout;
    EditText searchSuggestion;

    ReuseMethodClass cl;
    protected static final int REQUEST_CHECK_SETTINGS = 0x1;
    ProgressBar progressBar;
    LocationListener locationListener;
    LocationManager lm;
    String gId;
    String mId;
    String cId;
    SharedPreferences.Editor editor;
    SharedPreferences sharedPref;
    AdView mAdView;






    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0 && grantResults[0] == 0) {
            gId = null;
            cId = null;
            getSnackBar("Select again to continue");
        } else if (requestCode == 2 && grantResults[0] == 0) {
            getSnackBar("Select again to continue");
        }
        else {
            gId = null;
            cId = null;
            getSnackBar("Please allow permission to continue");

        }
    }
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        //grantResult returns permission
//        if(requestCode == 0 && grantResults[0] == 0){
//            getLocation();
//        }
//        else {
//            Toast.makeText(LocationActivity.this, "User denied the permission", Toast.LENGTH_SHORT).show();
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_bank);

        mAdView = findViewById(R.id.adViewSelect);
        recyclerView = findViewById(R.id.selectRec);
        progressBar = findViewById(R.id.progressSelect);
        cl = new ReuseMethodClass(SelectBank.this);
        gridListObjs = new ArrayList<>();
        gridListNoDbArr = new ArrayList<>();
        relativeLayout = findViewById(R.id.rl);
        searchSuggestion = findViewById(R.id.editTextSearch);
        keys = getIntent().getStringExtra("key");
        type = getIntent().getStringExtra("type");
        titleA = getIntent().getStringExtra("title");
        getSupportActionBar().setTitle(titleA);
        sharedPref = getSharedPreferences(getString(R.string.shared_pref),Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //banner ad
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        if (keys != null && type.equals("db")) {

            if(!cl.isConnected()){
                cl.showSnackBar("Oops! No internet connection",relativeLayout);
                progressBar.setVisibility(View.INVISIBLE);
            }
            key = new ArrayList<>();
            databaseReference = FirebaseDatabase.getInstance().getReference("CategoryItems").child(keys);
            databaseReference.child("banklist").addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    gridListObjs.add(dataSnapshot.getValue(GridListObj.class));
                    selectBankAdapter = new SelectBankAdapter(SelectBank.this, null, gridListObjs, SelectBank.this);
                    recyclerView.setLayoutManager(new LinearLayoutManager(SelectBank.this));
                    recyclerView.setAdapter(selectBankAdapter);
                    progressBar.setVisibility(View.GONE);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            //Text change according to language
           SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref),Context.MODE_PRIVATE);
           int sLann = sharedPref.getInt("selectedLan",2);
            //English
            if(sLann == 1){
                searchSuggestion.setHint("Search bank");
            }
            //Hindi
            else if(sLann == 2){
                searchSuggestion.setHint("बैंक ढूँढे");
            }
            //For bengali
            else if(sLann == 3){
                searchSuggestion.setHint("ব্যাংক সন্ধান করুন");
            }
            //Odia
            else if(sLann == 4){
                searchSuggestion.setHint("ସର୍ଚ୍ଚ ବ୍ୟାଙ୍କ");
            }
            //Marathi
            else if(sLann == 5){
                searchSuggestion.setHint("शोध बँक");
            }
            //Malayalam
            else if(sLann == 6){
                searchSuggestion.setHint("തിരയൽ ബാങ്ക്");
            }
            //Kannada
            else if(sLann == 7){
                searchSuggestion.setHint("ಹುಡುಕಾಟ ಬ್ಯಾಂಕ್");
            }
            //Tamil
            else if(sLann == 8){
                searchSuggestion.setHint("தேடல் வங்கி");
            }
            //Telugu
            else if(sLann == 9){
                searchSuggestion.setHint("సెర్చ్ బ్యాంక్");
            }
            //Gujarati
            else if(sLann == 10){
                searchSuggestion.setHint("શોધ બેંક");
            }
            //Punjabi
            else if(sLann == 11){
                searchSuggestion.setHint("ਸਰਚ ਬੈਂਕ");
            }


        } else if (keys != null && type.equals("hardcoded")) {
            progressBar.setVisibility(View.GONE);
            if (keys.equals("preAxis")) {
                gridListNoDbArr.add(new GridNoDbListObj("JIO", R.drawable.jio, "Jio"));
                gridListNoDbArr.add(new GridNoDbListObj("AIRTEL", R.drawable.airteldth, "Airtel"));
                gridListNoDbArr.add(new GridNoDbListObj("VODAFONE", R.drawable.vodafone, "Vodafone"));
                gridListNoDbArr.add(new GridNoDbListObj("IDEA", R.drawable.idea, "Idea"));
                gridListNoDbArr.add(new GridNoDbListObj("BSNL", R.drawable.bsnl, "BSNL"));
                gridListNoDbArr.add(new GridNoDbListObj("MTNL", R.drawable.mtnl, "MTNL"));
                setAdapter(gridListNoDbArr);
            } else if (keys.equals("prepost")) {
                gridListNoDbArr.add(new GridNoDbListObj("preAxis", R.drawable.axis, "AXIS Bank"));
                gridListNoDbArr.add(new GridNoDbListObj("preFed", R.drawable.federalnew, "Federal Bank"));
                gridListNoDbArr.add(new GridNoDbListObj("prepostIcici", R.drawable.icici, "ICICI Bank"));
                gridListNoDbArr.add(new GridNoDbListObj("preKotak", R.drawable.kotak, "Kotak Mahindra Bank"));
                setAdapter(gridListNoDbArr);
            }
            //For bank selection
            else if (keys.equals("dth")) {
                gridListNoDbArr.add(new GridNoDbListObj("dthAxis", R.drawable.axis, "AXIS Bank"));
                gridListNoDbArr.add(new GridNoDbListObj("dthFed", R.drawable.federalnew, "Federal Bank"));
                gridListNoDbArr.add(new GridNoDbListObj("dthIcici", R.drawable.icici, "ICICI Bank"));
                gridListNoDbArr.add(new GridNoDbListObj("dthKotak", R.drawable.kotak, "Kotak Mahindra Bank"));
                setAdapter(gridListNoDbArr);
            } else if (keys.equals("metro")) {
                gridListNoDbArr.add(new GridNoDbListObj("metroFed", R.drawable.federalnew, "Federal Bank"));
                setAdapter(gridListNoDbArr);
            }
            //For tv operator selection
            else if (keys.equals("dthAxis") || keys.equals("dthIcici") || keys.equals("dthKotak")) {
                gridListNoDbArr.add(new GridNoDbListObj("AIRTELTV", R.drawable.airteldth, "Airtel DTH"));
                gridListNoDbArr.add(new GridNoDbListObj("SUNTV", R.drawable.sundirect, "Sun Direct"));
                gridListNoDbArr.add(new GridNoDbListObj("DISHTV", R.drawable.dishtv, "Dish TV"));
                gridListNoDbArr.add(new GridNoDbListObj("TATASKY", R.drawable.tatasky, "Tata Sky"));
                gridListNoDbArr.add(new GridNoDbListObj("BIGTV", R.drawable.bigtv, "Big TV"));
                gridListNoDbArr.add(new GridNoDbListObj("VIDEOCOND2H", R.drawable.videocondth, "Videocon d2h"));
                setAdapter(gridListNoDbArr);
            } else if (keys.equals("dthFed")) {
                gridListNoDbArr.add(new GridNoDbListObj("A", R.drawable.airteldth, "Airtel DTH"));
                gridListNoDbArr.add(new GridNoDbListObj("S", R.drawable.sundirect, "Sun Direct"));
                gridListNoDbArr.add(new GridNoDbListObj("D", R.drawable.dishtv, "Dish TV"));
                gridListNoDbArr.add(new GridNoDbListObj("T", R.drawable.tatasky, "Tata Sky"));
                gridListNoDbArr.add(new GridNoDbListObj("B", R.drawable.bigtv, "Big TV"));
                gridListNoDbArr.add(new GridNoDbListObj("V", R.drawable.videocondth, "Videocon d2h"));
                setAdapter(gridListNoDbArr);
            } else if (keys.equals("metroFed")) {
                gridListNoDbArr.add(new GridNoDbListObj("Bangalore Metro", R.drawable.bangaloremetro, "Bangalore Metro"));
                setAdapter(gridListNoDbArr);
            }

        }
        searchSuggestion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                selectBankAdapter.getFilter().filter(charSequence);
//                    selectBankAdapter.notifyDataSetChanged();

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                selectBankAdapter.getFilter().filter(charSequence);
//                    selectBankAdapter.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    public void createDialog(final String no, final String msg, int flag) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater layoutInflater = getLayoutInflater();


        //this is custom dialog
        //custom_popup_dialog contains textview only
        View customView = layoutInflater.inflate(R.layout.custom_dialog_list, null);
        ImageView call = customView.findViewById(R.id.missed_call);
        final TextView title = customView.findViewById(R.id.titleDialogList);
        final TextView des = customView.findViewById(R.id.textBelowList);
        final TextView textBelow = customView.findViewById(R.id.notebelowList);
        // reference the textview of custom_popup_dialog
        final ImageView close = customView.findViewById(R.id.close_missedcall);
        Button btndone = customView.findViewById(R.id.balance_done);
        builder.setView(customView);
        builder.create();
        final AlertDialog d = builder.show();
        //For sms
        if(!msg.equals("")){
            title.setText("You are going to send a SMS to bank server, Click below icon to send");
            des.setText("You will recieve a confirmation SMS shorly..");
            call.setImageResource(R.drawable.ic_sms);
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int len = msg.length()-1;
                    if((msg.charAt(len)) == ' '){
                        d.dismiss();
                     cl.showInputDialog(no,relativeLayout,msg.substring(0,msg.length()-1),progressBar);
                    }else{
                        cl.sendSMS(relativeLayout,no,msg,progressBar);
                        d.dismiss();
                    }


                }
            });
        }
        else if(flag == 1){
//            des.setText("You are done! You will recieve a SMS with bank balance shortly..");
//            call.setImageResource(R.drawable.ic_done);
//            textBelow.setVisibility(View.GONE);
//            title.setVisibility(View.GONE);
//            btndone.setText("OK");
            d.dismiss();
            cl.showSuccessDialog(no);
        }
        //For call
        else {

            title.setText("Give a missed call by clicking below icon to check bank balance");
            des.setText("You will recieve a SMS with account balance shortly..");
            call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int noOfVisit = sharedPref.getInt("isRate",1);
                    if(noOfVisit!=-1){
                        noOfVisit++;
                        editor.putInt("isRate",noOfVisit);
                        editor.apply();
                    }
                    cl.callNo(no, 1,relativeLayout,progressBar);
                    d.dismiss();

                }
            });
        }

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                d.dismiss();
            }
        });

    }

    @Override
    public void onbankListClicked(final String id, String imgUrl, int a,String msg) {
//        int position = gridListObjs.indexOf(new GridListObj(id,imgUrl,name,msg));
        cl.hideKeyboard(SelectBank.this);
        if (keys.equals("netbanking")) {
            int noOfVisit = sharedPref.getInt("isRate",1);

            Intent i = new Intent(SelectBank.this, Web_Page.class);
            i.putExtra("key", id);
            i.putExtra("title", "Net Banking");
            if(noOfVisit!=-1){
                noOfVisit++;
                editor.putInt("isRate",noOfVisit);
                editor.apply();
            }
            startActivity(i);
        } else if (keys.equals("BankBalance")) {
            if(msg.equals("")){
                gId = id;
            }

            createDialog(id,msg,0);
        } else if (keys.equals("CustomerSupport")) {
            int noOfVisit = sharedPref.getInt("isRate",1);

            cl.callNo(id, 1,relativeLayout,progressBar);
            if(noOfVisit!=-1){
                noOfVisit++;
                editor.putInt("isRate",noOfVisit);
                editor.apply();
            }
        } else if (keys.equals("USSDBanking")) {
            Intent i = new Intent(SelectBank.this, UssdPage.class);
            i.putExtra("key", id);
            i.putExtra("imgUrl", imgUrl);
            i.putExtra("title", titleA);
            startActivity(i);
        } else if (keys.equals("ifscfinder")) {
            Intent i = new Intent(SelectBank.this, IFSCFinder.class);
            i.putExtra("key", id);
            i.putExtra("imgUrl", imgUrl);
            startActivity(i);
        } else if (keys.equals("prepost") || keys.equals("preAxis") || keys.equals("dth") || keys.equals("dthAxis") || keys.equals("dthIcici") || keys.equals("dthKotak") || keys.equals("dthFed") || keys.equals("metro") || keys.equals("metroFed")) {
            Intent i = new Intent(SelectBank.this, PrepostActivity.class);
            i.putExtra("key", id);
            i.putExtra("imgUrl", a);
            i.putExtra("type", keys);
            i.putExtra("title",titleA+" Recharge");
            startActivity(i);
        } else if (keys.equals("atmlocator") || keys.equals("branchlocator")) {
            ReuseMethodClass rm = new ReuseMethodClass(SelectBank.this);
            getLocPermission();
            if (ContextCompat.checkSelfPermission(SelectBank.this, Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                //Storing the id for the clicked position
                mId = id;
                LocationRequest locationRequest = LocationRequest.create();
                locationRequest.setInterval(10000);
                locationRequest.setFastestInterval(5000);
                locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
                LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                        .addLocationRequest(locationRequest);
                SettingsClient client = LocationServices.getSettingsClient(SelectBank.this);
                Task<LocationSettingsResponse> task = client.checkLocationSettings(builder.build());
                task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
                    @Override
                    public void onSuccess(LocationSettingsResponse locationSettingsResponse) {
                        // All location settings are satisfied. The client can initialize
                        // location requests here.
                        // ...
                        relativeLayout.setAlpha(0.3f);
                        progressBar.setVisibility(View.VISIBLE);
                      sendUriGmap(id);


                    }
                });


                task.addOnFailureListener(this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof ResolvableApiException) {
                            // Location settings are not satisfied, but this can be fixed
                            // by showing the user a dialog.
                            try {
                                // Show the dialog by calling startResolutionForResult(),
                                // and check the result in onActivityResult().
                                ResolvableApiException resolvable = (ResolvableApiException) e;
                                resolvable.startResolutionForResult(SelectBank.this,
                                        REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException sendEx) {
                                // Ignore the error.
                            }
                        }
                    }
                });

            }
        }
        else {
            if(msg.equals("")){
                cId = id;
            }
                createDialog(id,msg,0);
        }



    }
private void setAdapter(ArrayList<GridNoDbListObj> glist){
    selectBankAdapter = new SelectBankAdapter(SelectBank.this,glist,null,SelectBank.this);
    recyclerView.setLayoutManager(new LinearLayoutManager(SelectBank.this));
    recyclerView.setAdapter(selectBankAdapter);
}
    private void getLocPermission(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 2);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        final LocationSettingsStates states = LocationSettingsStates.fromIntent(data);
        switch (requestCode) {
            case REQUEST_CHECK_SETTINGS:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        // All required changes were successfully made
                        sendUriGmap(mId);
                        break;
                    case Activity.RESULT_CANCELED:
                        // The user was asked to change settings, but chose not to
                   getSnackBar("Please allow the gps service to continue");
                        break;
                    default:
                        break;
                }
                break;
        }
    }
    private void getSnackBar(String msg){
        Snackbar snackbar = Snackbar
                .make(relativeLayout, msg, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
    public void sendUriGmap(final String id){
        if (ContextCompat.checkSelfPermission(SelectBank.this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            int noOfVisit = sharedPref.getInt("isRate",1);

            if(noOfVisit!=-1){
                noOfVisit++;
                editor.putInt("isRate",noOfVisit);
                editor.apply();
            }
            cl.showSnackB(relativeLayout,"Please Wait...",progressBar,0.3f,View.VISIBLE);
            lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            String locationProvider = LocationManager.NETWORK_PROVIDER;
            locationListener = new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude = location.getLatitude();
                    double loni = location.getLongitude();
                    relativeLayout.setAlpha(1);
                    progressBar.setVisibility(View.GONE);
                    Uri gmmIntentUri = Uri.parse("geo:"+latitude+","+loni+"?q="+id);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    cl.showSnackB(relativeLayout,"Here you go!",progressBar,1,View.GONE);
                    startActivity(mapIntent);

                }

                @Override
                public void onStatusChanged(String s, int i, Bundle bundle) {

                }

                @Override
                public void onProviderEnabled(String s) {

                }

                @Override
                public void onProviderDisabled(String s) {

                }
            };
            lm.requestLocationUpdates(locationProvider, 0, 0, locationListener);
        }
    }
    @Override
    protected void onPause() {
        super.onPause();
        //when shift to another activity then it detach the location listener
        if(locationListener != null) {
            lm.removeUpdates(locationListener);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if(gId != null){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    createDialog("You are done! You will recieve a SMS with bank balance shortly..","",1);
                    gId = null;
                }
            }, 5000);

        }
        if(cId != null){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    createDialog("You are done! You will recieve a confirmation message shortly..","",1);
                    cId = null;
                }
            }, 5000);

        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    if(mAdView!=null){
        mAdView.destroy();
    }
    }

}
