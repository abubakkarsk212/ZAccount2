package zacc.popo.ltd.zaccount;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.facebook.ads.*;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,ContactAdapter.ListItemClicked,BankServicesAdapter.ListItemClickedBank{
    LinearLayout air, pay, poc, kot, fed, rb, db,ax,idb,customerGridV,bankSerV;
    public final String TAG = MainActivity.class.getSimpleName();
    private NativeAd nativeAd, nativeAd1,nativeAd2;
    private LinearLayout nativeAdContainer, nativeAdContainer1;
    private LinearLayout adView,adView1;
    private NativeBannerAd mNativeBannerAd,mNativeBannerbetween;
    private DatabaseReference databaseReference,databaseReference1;
    boolean doubleBackToExitPressedOnce = false;
    ImageView singleView;

//    Button offerZone;
    RecyclerView mRecyclerView,mRecyclerView1;
    RecyclerView.LayoutManager mLayoutManager,mLayoutManager1;
    RecyclerView.Adapter mAdapter,mAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<ContactCusHObj> contactCusHObjs = new ArrayList<>();
        contactCusHObjs.add(new ContactCusHObj(R.mipmap.sbi,"SBI"));
        contactCusHObjs.add(new ContactCusHObj(R.mipmap.icici,"Icici"));
        contactCusHObjs.add(new ContactCusHObj(R.mipmap.federal,"Federal"));
        contactCusHObjs.add(new ContactCusHObj(R.mipmap.kotak,"Kotak"));
        contactCusHObjs.add(new ContactCusHObj(R.mipmap.axis,"Axis"));
        contactCusHObjs.add(new ContactCusHObj(R.mipmap.idbi,"IDFC"));
        contactCusHObjs.add(new ContactCusHObj(R.mipmap.rbl,"RBL"));
        contactCusHObjs.add(new ContactCusHObj(R.mipmap.hdfc,"HDFC"));

        mRecyclerView = findViewById(R.id.recycler_view);

        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new ContactAdapter(MainActivity.this,contactCusHObjs,this);
        mRecyclerView.setAdapter(mAdapter);
//For Bank Services
        ArrayList<BankServicesHObj> contactCusHObjs1 = new ArrayList<>();
        contactCusHObjs1.add(new BankServicesHObj(R.mipmap.hdfc,"HDFC"));
        contactCusHObjs1.add(new BankServicesHObj(R.mipmap.kotak,"Kotak"));
        contactCusHObjs1.add(new BankServicesHObj(R.mipmap.rbl,"RBL"));
        contactCusHObjs1.add(new BankServicesHObj(R.mipmap.sbi,"SBI"));
        contactCusHObjs1.add(new BankServicesHObj(R.mipmap.icici,"Icici"));
        contactCusHObjs1.add(new BankServicesHObj(R.mipmap.federal,"Federal"));
        contactCusHObjs1.add(new BankServicesHObj(R.mipmap.axis,"Axis"));
        contactCusHObjs1.add(new BankServicesHObj(R.mipmap.idbi,"IDFC"));

        mRecyclerView1 = findViewById(R.id.recycler_view1);
        mLayoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView1.setLayoutManager(mLayoutManager1);
        mAdapter1 = new BankServicesAdapter(MainActivity.this,contactCusHObjs1,this);
        mRecyclerView1.setAdapter(mAdapter1);

        databaseReference = FirebaseDatabase.getInstance().getReference("SingleImage");
        databaseReference1 = FirebaseDatabase.getInstance().getReference("OffersList").child("ButtonProp");
        singleView = findViewById(R.id.imagePager);

//        offerZone.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//            Intent i =new Intent(MainActivity.this,OffersZone.class);
//            startActivity(i);
//            }
//        });
//        databaseReference1.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                OfferButtonColorObj offerButtonColorObj = dataSnapshot.getValue(OfferButtonColorObj.class);
//                int color =Color.parseColor(offerButtonColorObj.getColor());
//                offerZone.setBackgroundColor(color);
//                offerZone.setText(offerButtonColorObj.getName());
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(DatabaseError databaseError) {
//
//            }
//        });
        singleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,SingleViewDetails.class);
                startActivity(i);
            }
        });
        if(isConnected()){
            databaseReference.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    SingleImgObj singleImgObj = dataSnapshot.getValue(SingleImgObj.class);
                    Glide.with(singleView.getContext())
                            .load(singleImgObj.getPicsUrl())
                            .into(singleView);

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("No Internet Connection!");
            builder.setMessage("It seems that you have no internet connection.Please connect for better experience!\n\nYou can also continue offline viewing");

            builder.setCancelable(false);
            builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    if(isConnected()){
                        databaseReference.child("1").addListenerForSingleValueEvent(new ValueEventListener() {

                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                SingleImgObj singleImgObj = dataSnapshot.getValue(SingleImgObj.class);
                                Glide.with(singleView.getContext())
                                        .load(singleImgObj.getPicsUrl())
                                        .into(singleView);
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                                Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    else {
                        builder.show();
                    }

                }
            });
            builder.setNegativeButton("Dismiss",null);
            builder.show();



        }
        bankSerV = findViewById(R.id.bankGrid);
        customerGridV = findViewById(R.id.customerGrid);
        air = findViewById(R.id.apb);
        pay = findViewById(R.id.paytm);
        poc = findViewById(R.id.pocket);
        kot = findViewById(R.id.kotak);
        fed = findViewById(R.id.fedbook);
        rb = findViewById(R.id.rbl);
        db = findViewById(R.id.dbs);
        ax = findViewById(R.id.axis);
        idb = findViewById(R.id.idfc);
        bankSerV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,BankServiceGrid.class);
                startActivity(i);
            }
        });
        customerGridV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(MainActivity.this,CustomerGrid.class);
            startActivity(i);
            }
        });
        air.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Airtel.class);
                startActivity(i);
            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Paytm.class);
                startActivity(i);
            }
        });
        poc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Pocket.class);
                startActivity(i);
            }
        });
        kot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Kotak.class);
                startActivity(i);
            }
        });
        fed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Fedbook.class);
                startActivity(i);
            }
        });
        rb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Rbl.class);
                startActivity(i);
            }
        });
        db.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Dbs.class);
                startActivity(i);
            }
        });
        ax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Axis.class);
                startActivity(i);
            }
        });
       idb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,IDFC.class);
                startActivity(i);
            }
        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //--------------------------
        nativeAd2 = new NativeAd(this, getString(R.string.fb_native_large_2));
        //623848994653940_623855291319977
        nativeAd2.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                // Native ad finished downloading all assets
//                Log.e(TAG, "Native ad finished downloading all assets.");
            }
            @Override
            public void onError(Ad ad, AdError adError) {
                // Native ad failed to load
//                Log.e(TAG, "Native ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Native ad is loaded and ready to be displayed
                if (nativeAd2 == null || nativeAd2 != ad) {
                    return;
                }
                // Inflate Native Ad into Container
                inflateAd1(nativeAd2);
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Native ad clicked
//                Log.d(TAG, "Native ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Native ad impression
//                Log.d(TAG, "Native ad impression logged!");
            }
        });

//         Request an ad

        nativeAd2.loadAd();
        // Instantiate a NativeAd object.
        // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
        // now, while you are testing and replace it later when you have signed up.
        // While you are using this temporary code you will only get test ads and if you release
        // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
        nativeAd = new NativeAd(this, getString(R.string.fb_native1));
        //623848994653940_623855291319977
        nativeAd.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                // Native ad finished downloading all assets
//                Log.e(TAG, "Native ad finished downloading all assets.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Native ad failed to load
//                Log.e(TAG, "Native ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Native ad is loaded and ready to be displayed
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                // Inflate Native Ad into Container
                inflateAd(nativeAd);
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Native ad clicked
//                Log.d(TAG, "Native ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Native ad impression
//                Log.d(TAG, "Native ad impression logged!");
            }
        });

//         Request an ad
        nativeAd.loadAd();

//For native ad small 1
        nativeAd1 = new NativeAd(this, getString(R.string.fb_native2));
        //623848994653940_625304437841729
        nativeAd1.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                // Native ad finished downloading all assets
//                Log.e(TAG, "Native ad finished downloading all assets.");
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Native ad failed to load
//                Log.e(TAG, "Native ad failed to load: " + adError.getErrorMessage());
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Native ad is loaded and ready to be displayed
                View adView = NativeAdView.render(MainActivity.this, nativeAd1, NativeAdView.Type.HEIGHT_300);
                LinearLayout nativeAdContainer = (LinearLayout) findViewById(R.id.native_ad_container1);
                // Add the Native Ad View to your ad container
                nativeAdContainer.addView(adView);
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Native ad clicked
//                Log.d(TAG, "Native ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Native ad impression
//                Log.d(TAG, "Native ad impression logged!");
            }
        });

        // Request an ad
        nativeAd1.loadAd();
// Native ad banner 1

        mNativeBannerAd = new NativeBannerAd(MainActivity.this, getString(R.string.fb_native_banner));
        //623848994653940_626245771080929
        mNativeBannerAd.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
// Render the Native Banner Ad Template
                View adView1 = NativeBannerAdView.render(MainActivity.this, mNativeBannerAd, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banner_ad_container);
                // Add the Native Banner Ad View to your ad container
                nativeBannerAdContainer1.addView(adView1);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });
        // Initiate a request to load an ad.
        mNativeBannerAd.loadAd();

       //-------native banner ad between--------------
        mNativeBannerbetween= new NativeBannerAd(MainActivity.this, getString(R.string.fb_native_banner_between));
        //623848994653940_626245771080929
        mNativeBannerbetween.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
// Render the Native Banner Ad Template
                View adView1 = NativeBannerAdView.render(MainActivity.this, mNativeBannerbetween, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bannerbetween);
                // Add the Native Banner Ad View to your ad container
                nativeBannerAdContainer1.addView(adView1);
            }

            @Override
            public void onAdClicked(Ad ad) {

            }

            @Override
            public void onLoggingImpression(Ad ad) {

            }
        });
                mNativeBannerbetween.loadAd();
    }
    public boolean isConnected(){
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork !=null && activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
    private void inflateAd(NativeAd nativeAd) {

        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdContainer = findViewById(R.id.native_ad_container);
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView = (LinearLayout) inflater.inflate(R.layout.native_ad_fb, nativeAdContainer, false);
        nativeAdContainer.addView(adView);

        // Add the AdChoices icon
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container);
        AdChoicesView adChoicesView = new AdChoicesView(MainActivity.this, nativeAd, true);
        adChoicesContainer.addView(adChoicesView, 0);

        // Create native UI using the ad metadata.
        AdIconView nativeAdIcon = adView.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
        MediaView nativeAdMedia = adView.findViewById(R.id.native_ad_media);
        TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = adView.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
        Button nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        // Create a list of clickable views
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        clickableViews.add(nativeAdMedia);

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(
                adView,
                nativeAdMedia,
                nativeAdIcon,
                clickableViews);

    }
    private void inflateAd1(NativeAd nativeAd) {

        nativeAd.unregisterView();

        // Add the Ad view into the ad container.
        nativeAdContainer1 = findViewById(R.id.native_ad_containernew);
        LayoutInflater inflater = LayoutInflater.from(MainActivity.this);
        // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
        adView1 = (LinearLayout) inflater.inflate(R.layout.nativead2, nativeAdContainer1, false);
        nativeAdContainer1.addView(adView1);

        // Add the AdChoices icon
        LinearLayout adChoicesContainer = findViewById(R.id.ad_choices_container0);
        AdChoicesView adChoicesView = new AdChoicesView(MainActivity.this, nativeAd, true);
        adChoicesContainer.addView(adChoicesView, 0);

        // Create native UI using the ad metadata.
        AdIconView nativeAdIcon = adView1.findViewById(R.id.native_ad_icon0);
        TextView nativeAdTitle = adView1.findViewById(R.id.native_ad_title0);
        MediaView nativeAdMedia = adView1.findViewById(R.id.native_ad_media0);
        TextView nativeAdSocialContext = adView1.findViewById(R.id.native_ad_social_context0);
        TextView nativeAdBody = adView1.findViewById(R.id.native_ad_body0);
        TextView sponsoredLabel = adView1.findViewById(R.id.native_ad_sponsored_label0);
        Button nativeAdCallToAction = adView1.findViewById(R.id.native_ad_call_to_action0);

        // Set the Text.
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        // Create a list of clickable views
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        clickableViews.add(nativeAdMedia);

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(
                adView1,
                nativeAdMedia,
                nativeAdIcon,
                clickableViews);

    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this, "Press again to close ZAccount", Toast.LENGTH_SHORT).show();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 5000);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate menu resource file.
//        getMenuInflater().inflate(R.menu.main, menu);
//
//        // Locate MenuItem with ShareActionProvider
//        MenuItem item = menu.findItem(R.id.menu_item_share);
        menu.add("Share").setIcon(R.drawable.ic_action_name).setShowAsAction(1);
//
//        // Fetch and store ShareActionProvider
//        mShareActionProvider = (ShareActionProvider) item.getActionProvider();
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.


        //noinspection SimplifiableIfStatement

        if (item.getTitle().equals("Share")) {
            Intent i = new Intent(MainActivity.this, Invite.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.air) {
            Intent i = new Intent(MainActivity.this, Airtel.class);
            startActivity(i);
        } else if (id == R.id.paytm) {
            Intent i = new Intent(MainActivity.this, Paytm.class);
            startActivity(i);
        } else if (id == R.id.dbs) {
            Intent i = new Intent(MainActivity.this, Dbs.class);
            startActivity(i);
        } else if (id == R.id.rbl) {
            Intent i = new Intent(MainActivity.this, Rbl.class);
            startActivity(i);
        } else if (id == R.id.fedbook) {
            Intent i = new Intent(MainActivity.this, Fedbook.class);
            startActivity(i);
        } else if (id == R.id.kotak) {
            Intent i = new Intent(MainActivity.this, Kotak.class);
            startActivity(i);
        } else if (id == R.id.pocket) {
            Intent i = new Intent(MainActivity.this, Pocket.class);
            startActivity(i);
        }else if (id == R.id.axi) {
            Intent i = new Intent(MainActivity.this, Axis.class);
            startActivity(i);
        }
        else if (id == R.id.idfcb) {
            Intent i = new Intent(MainActivity.this, IDFC.class);
            startActivity(i);
        }
        else if (id == R.id.rate) {
            try {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("market://details?id=zacc.popo.ltd.zaccount"));
                startActivity(i);
            } catch (Exception e) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                //It will open a browser
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=zacc.popo.ltd.zaccount"));
                startActivity(i);
            }
        } else if (id == R.id.contact) {
            Intent i = new Intent(MainActivity.this, Contact.class);
            startActivity(i);
        } else if (id == R.id.about) {
            Intent i = new Intent(MainActivity.this, About.class);
            startActivity(i);
        }
        else if (id == R.id.privacy) {
            Intent i = new Intent(MainActivity.this, PrivacyPoliciesZ.class);
            startActivity(i);
        }else {
            Intent intent1 = new Intent(Intent.ACTION_SENDTO);
            intent1.setData(Uri.parse("mailto:"));
            intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"helpybookapp@gmail.com"});
            if (intent1.resolveActivity(getPackageManager()) != null) {
                startActivity(intent1);
            }
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onListItemClicked(int itemClickedPos) {
        if(itemClickedPos == 1){
            Intent i1 = new Intent(MainActivity.this,IciciC.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 4){
            Intent i1 = new Intent(MainActivity.this,AxisC.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 7){
            Intent i1 = new Intent(MainActivity.this,HdfcC.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 2){
            Intent i1 = new Intent(MainActivity.this,FederalC.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 3){
            Intent i1 = new Intent(MainActivity.this,KotakC.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 6){
            Intent i1 = new Intent(MainActivity.this,RblC.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 0){
            Intent i1 = new Intent(MainActivity.this,SbiC.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 5){
            Intent i1 = new Intent(MainActivity.this,IdfcC.class);
            startActivity(i1);
        }

    }

    @Override
    public void onListItemClicked1(int itemClickedPos) {
        if(itemClickedPos == 1){
            Intent i1 = new Intent(MainActivity.this,KotakBankService.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 4){
            Intent i1 = new Intent(MainActivity.this,IciciBankService.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 7){
            Intent i1 = new Intent(MainActivity.this,IdfcBankingService.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 2){
            Intent i1 = new Intent(MainActivity.this,RblBankingServices.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 3){
            Intent i1 = new Intent(MainActivity.this,SbiBankServices.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 6){
            Intent i1 = new Intent(MainActivity.this,AxisBankServices.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 0){
            Intent i1 = new Intent(MainActivity.this,HdfcBankServices.class);
            startActivity(i1);
        }
        else if(itemClickedPos == 5){
            Intent i1 = new Intent(MainActivity.this,FederalBankService.class);
            startActivity(i1);
        }

    }
}