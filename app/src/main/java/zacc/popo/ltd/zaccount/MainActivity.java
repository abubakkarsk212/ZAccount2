package zacc.popo.ltd.zaccount;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.material.navigation.NavigationView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,BankGridAdapter.pmjdyListClicked,DigitalBankGridAdapter.digitalListClicked,CategoryGridAdapter.categoryListClicked,RechargeGridAdapter.rechargeListClicked,ImpHorizontalRecyclerView.impListClicked,ZeroBankGridAdapter.zeroListClicked{
    public final String TAG = MainActivity.class.getSimpleName();
    AdLoader adLoaderSmall,adLoaderLarge;
    boolean doubleBackToExitPressedOnce = false;
    DatabaseReference viewPagerDb,cuelinkRef;
    ArrayList<ViewPagerUrlObj> urlArray;
    ViewPager vp;
    ViewPagerAdapter viewPagerAdapter;
    int HIGH_PRIORITY_UPDATE = 3;
    private static final String CHANNEL_ID = "savingaccount";
    private static final String CHANNEL_ID2 = "appupdate";
    private static final String CHANNEL_ID3 = "bankservice";
    private static final String CHANNEL_ID4 = "feedback";
    private static final String CHANNEL_ID5 = "newsletter";
    private static final String CHANNEL_ID6 = "promotion";
    //For deeplink
    String deepLinkurl;
    int deepLinkflag;
    //For background firebase notification
    String notKey;
    int notFlag;
    String notType;
    String notChannel;
    String title;
    //For dots in viewpager
    WormDotsIndicator wormDotsIndicator;

    //For New UI
    //For PMYOJNA banks
    RecyclerView pmzeroRec;
    BankGridAdapter bankGridAdapter;
    ArrayList<GridListObj> pmjdyArray;
    DatabaseReference pmbankRefPrimary,pmbankRefSecondary;
    TextView pmYojT;

    //For zero accounts
    RecyclerView zeroRec;
    ZeroBankGridAdapter zeroAdapter;
    ArrayList<GridListObj> zeroArray;
    TextView zeroT;

    //For digital balance
    RecyclerView digitalRec;
    DigitalBankGridAdapter digitalAdapter;
    ArrayList<GridListObj> digitalArray;
    TextView digitalT;

    //For category grid
    RecyclerView categoryRec;
    CategoryGridAdapter categoryGridAdapter;
    ArrayList<GridListObj> categoryArray;
    TextView categoryText;

    //For recharge grid
    TextView rechargeText;
    RecyclerView rechargeRec;
    RechargeGridAdapter rechargeGridAdapter;
    ArrayList<GridListObj> rechargeArray;

    //For Imp horizontal recycler
    RecyclerView impRec;
    ImpHorizontalRecyclerView impHoridAdapter;
    ArrayList<GridListObj> impArray;
    TextView impTitle;

    //DB refernce for Navigation category
    DatabaseReference navCategoryRef;
    RecyclerView navCatRec;
    ArrayList<GridListObj> navCatArray;
    SavingAccountNavRecAdapter savingAccountNavRecAdapter;
    //For Bank Service
    RecyclerView navBSRec;
    ArrayList<GridListObj> navBSArrayList;

    //For see all
    TextView seeZero,seePmjdy,seeDigtal;

    ProgressBar progressBar;
    //For layouts of imp, category for hiding when no internet conection
    LinearLayout impLL,viewpagerLL,retryLL;
    CardView categoryCV,zeroCV,digCV,pmjdyCV;
    Button retryB;
    RelativeLayout rlMain;

    //For affliate
    RelativeLayout rlAd1,rlAd2,rlMainAd;
    ImageView imgAd1,fullImgAd1,imgAd2,fullImgAd2;
    TextView adTitle1,adDesc1,buttonAd1,adTitle2,adDesc2,buttonAd2;

    //Sharedpref
    SharedPreferences sharedPref;
    int sLann;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPref = getSharedPreferences(getString(R.string.shared_pref),Context.MODE_PRIVATE);
        sLann = sharedPref.getInt("selectedLan",2);
        vp = findViewById(R.id.topViewpager);
        wormDotsIndicator =  findViewById(R.id.worm_dots_indicator);
        pmzeroRec = findViewById(R.id.recycler_view_pmdjy);
        pmYojT = findViewById(R.id.pmyojnaText);
        urlArray = new ArrayList<>();
        pmjdyArray = new ArrayList<>();

        //For zero accounts
        zeroRec = findViewById(R.id.recycler_view_zerobank);
        zeroT = findViewById(R.id.zeroBankText);
        zeroArray = new ArrayList<>();

        //For digital accounts
        digitalRec = findViewById(R.id.recycler_view_digital);
        digitalT = findViewById(R.id.digitalText);
        digitalArray = new ArrayList<>();

        //For category
        categoryRec = findViewById(R.id.recycler_view_category);
        categoryArray = new ArrayList<>();
        categoryText = findViewById(R.id.categoryText);

        //For recharge category
        rechargeText = findViewById(R.id.rechargeText);
        rechargeRec = findViewById(R.id.recycler_view_recharge);
        rechargeArray = new ArrayList<>();

        //For imp horizontal rec
        impRec = findViewById(R.id.recycler_view_imp);
        impArray = new ArrayList<>();
        impTitle = findViewById(R.id.impTitle);
        //For see all ref
        seeZero = findViewById(R.id.seeAllzero);
        seePmjdy = findViewById(R.id.seeAllpmjdy);
        seeDigtal = findViewById(R.id.seeAllDigtal);

        //For layouts
        impLL = findViewById(R.id.impLL);
        categoryCV = findViewById(R.id.categoryCV);
        viewpagerLL = findViewById(R.id.viewPagerll);
        zeroCV = findViewById(R.id.card2);
        digCV = findViewById(R.id.card3);
        pmjdyCV = findViewById(R.id.card1);
        retryLL = findViewById(R.id.retryLL);
        retryB = findViewById(R.id.retryC);
        rlMain = findViewById(R.id.mainRL);



        //For nav
//        navCatArray = new ArrayList<>();
//        navCatRec = findViewById(R.id.savingAccount_rec);
//        navBSRec = findViewById(R.id.bankservice_rec);
//        navBSArrayList = new ArrayList<>();
//        navRechargeRec = findViewById(R.id.rechargenav_rec);
//        navRechargeArrayL = new ArrayList<>();
        progressBar = findViewById(R.id.progressMain);
        //For cuelink affliate
        //For cuelink ad
        rlAd1 = findViewById(R.id.rlCueAd3);
        imgAd1 = findViewById(R.id.imgAd3);
        adTitle1 = findViewById(R.id.titleAd3);
        adDesc1 = findViewById(R.id.descAds3);
        buttonAd1 = findViewById(R.id.buttonAd3);
        fullImgAd1 = findViewById(R.id.imageAd3);
        rlMainAd = findViewById(R.id.rlMainAd);
        //for 2
        rlAd2 = findViewById(R.id.rlCueAd4);
        imgAd2 = findViewById(R.id.imgAd4);
        adTitle2 = findViewById(R.id.titleAd4);
        adDesc2 = findViewById(R.id.descAds4);
        buttonAd2 = findViewById(R.id.buttonAd4);
        fullImgAd2 = findViewById(R.id.imageAd4);



        //getting deepurl
        deepLinkurl = getIntent().getStringExtra("keydeep");
        deepLinkflag = getIntent().getIntExtra("flagdeep",0);
        //Getting background notification data
        notChannel = getIntent().getStringExtra("channel");
        notKey = getIntent().getStringExtra("key");
        notType = getIntent().getStringExtra("type");
        notFlag =getIntent().getIntExtra("flag",0);
        title =getIntent().getStringExtra("title");
//Splash ad
        getRegToken();

         // Setting up toolbar
        Toolbar toolbar = findViewById(R.id.toolbar); // get the reference of Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // hide the current title from the Toolbar
        toolbar.setLogo(getResources().getDrawable(R.mipmap.zaccounticon));



//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                // This is used to get the current item position which is visible
//                nextPage= vp.getCurrentItem()+1;
//                if (nextPage == NUM_PAGES-1) {
//                    nextPage = 0;
//                }
//                vp.setCurrentItem(nextPage++, true);
//            }
//        };

//        timer = new Timer(); // This will create a new Thread
//        timer .schedule(new TimerTask() { // task to be scheduled
//
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, 500, 5000);





            createNotificationChannel();








        if(isConnected()){
            loadViews();
            loadAds();
        }
        else {
            showSnackBar("Oops! No internet connection available");
            progressBar.setVisibility(View.INVISIBLE);
            retryLL.setVisibility(View.VISIBLE);
            impLL.setVisibility(View.GONE);
            categoryCV.setVisibility(View.GONE);
            viewpagerLL.setVisibility(View.GONE);
            zeroCV.setVisibility(View.GONE);
            digCV.setVisibility(View.GONE);
            pmjdyCV.setVisibility(View.GONE);
            rlAd1.setVisibility(View.GONE);
            rlAd2.setVisibility(View.GONE);
            fullImgAd1.setVisibility(View.GONE);
            fullImgAd2.setVisibility(View.GONE);

        }

        retryB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isConnected()){
                    progressBar.setVisibility(View.VISIBLE);
                    retryLL.setVisibility(View.GONE);
                    impLL.setVisibility(View.VISIBLE);
                    categoryCV.setVisibility(View.VISIBLE);
                    viewpagerLL.setVisibility(View.VISIBLE);
                    zeroCV.setVisibility(View.VISIBLE);
                    digCV.setVisibility(View.VISIBLE);
                    pmjdyCV.setVisibility(View.VISIBLE);
                    rlAd1.setVisibility(View.VISIBLE);
                    rlAd2.setVisibility(View.VISIBLE);
                    fullImgAd1.setVisibility(View.VISIBLE);
                    fullImgAd2.setVisibility(View.VISIBLE);
                    loadViews();
                    loadAds();
                }
                else{
                    showSnackBar("Oops! No internet connection available");
                }

            }
        });


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setItemIconTintList(null);


        //Db ref for nav category
//        navCategoryRef = FirebaseDatabase.getInstance().getReference("NavCategory");
//        navCategoryRef.child("SavingAcct").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                navCatArray.add(dataSnapshot.getValue(GridListObj.class));
//                savingAccountNavRecAdapter = new SavingAccountNavRecAdapter(MainActivity.this,navCatArray,MainActivity.this);
//                navCatRec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                navCatRec.setAdapter(savingAccountNavRecAdapter);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
//        navCategoryRef.child("BankServ").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                navBSArrayList.add(dataSnapshot.getValue(GridListObj.class));
//                savingAccountNavRecAdapter = new SavingAccountNavRecAdapter(MainActivity.this,navBSArrayList,MainActivity.this,"bankseradapter");
//                navBSRec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                navBSRec.setAdapter(savingAccountNavRecAdapter);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });
        //Nav category for recharge
//        navCategoryRef.child("RechargeNav").addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                navRechargeArrayL.add(dataSnapshot.getValue(GridListObj.class));
//                savingAccountNavRecAdapter = new SavingAccountNavRecAdapter(MainActivity.this,navRechargeArrayL,MainActivity.this,"rechargeadapter");
//                navRechargeRec.setLayoutManager(new LinearLayoutManager(MainActivity.this));
//                navRechargeRec.setAdapter(savingAccountNavRecAdapter);
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

//        getRegToken();

    }
    public void loadAds(){
        //-------------------------
// Native ad banner 1
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.white));
        //native banner
        adLoaderSmall = new AdLoader.Builder(this, getString(R.string.nativemainsmall))
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        if (isDestroyed()) {
                            unifiedNativeAd.destroy();
                            return;
                        }
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().withMainBackgroundColor(colorDrawable).build();

                        TemplateView template = findViewById(R.id.template_small_contentmain);
                        template.setStyles(styles);
                        template.setNativeAd(unifiedNativeAd);

                    }
                })
                .build();

        adLoaderSmall.loadAd(new AdRequest.Builder().build());


        //-------native banner large--------------
        VideoOptions videoOptions = new VideoOptions.Builder()
                .setStartMuted(false)
                .build();
        adLoaderLarge = new AdLoader.Builder(this, getString(R.string.nativemainlarge))
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        if (isDestroyed()) {
                            unifiedNativeAd.destroy();
                            return;
                        }
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().withMainBackgroundColor(colorDrawable).build();

                        TemplateView template = findViewById(R.id.template_medium_main);
                        template.setStyles(styles);
                        template.setNativeAd(unifiedNativeAd);

                    }
                }).withNativeAdOptions(new NativeAdOptions.Builder()
                        // Methods in the NativeAdOptions.Builder class can be
                        // used here to specify individual options settings.
                        .setRequestMultipleImages(true)
                        .setVideoOptions(videoOptions)
                        .build())
                .build();

        adLoaderLarge.loadAd(new AdRequest.Builder().build());

        //Afliate cuelink
        cuelinkRef = FirebaseDatabase.getInstance().getReference("CuelinkAd");
        cuelinkRef.child("3").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("enable").getValue().equals("0")){
                    rlMainAd.setVisibility(View.GONE);

                }else{
                    //1 means it has image then show image and hide rl
                    if(dataSnapshot.child("isImage").getValue().equals("1")){
                        rlAd1.setVisibility(View.GONE);
                        Glide.with(MainActivity.this)
                                .load(dataSnapshot.child("fullImgAdUrl").getValue())
                                .into(fullImgAd1);
                        fullImgAd1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataSnapshot.child("link").getValue().toString()));
                                startActivity(browserIntent);
                            }
                        });
                    }else{
                        fullImgAd1.setVisibility(View.GONE);
                        int colorB = Color.parseColor(dataSnapshot.child("adBgr").getValue().toString());
                        int colorT = Color.parseColor(dataSnapshot.child("buttonColor").getValue().toString());
                        rlAd1.setBackgroundColor(colorB);
                        buttonAd1.setBackgroundColor(colorT);
                        buttonAd1.setText(dataSnapshot.child("buttonText").getValue().toString());
                        Glide.with(MainActivity.this)
                                .load(dataSnapshot.child("adImageUrl").getValue())
                                .into(imgAd1);

                        adTitle1.setText(dataSnapshot.child("title").getValue().toString());
                        adDesc1.setText(dataSnapshot.child("desc").getValue().toString());
                        buttonAd1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataSnapshot.child("link").getValue().toString()));
                                startActivity(browserIntent);
                            }
                        });




                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //For 2
        cuelinkRef.child("4").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("enable").getValue().equals("0")){
                    rlAd2.setVisibility(View.GONE);
                    fullImgAd2.setVisibility(View.GONE);

                }else{
                    //1 means it has image then show image and hide rl
                    if(dataSnapshot.child("isImage").getValue().equals("1")){
                        rlAd2.setVisibility(View.GONE);
                        Glide.with(MainActivity.this)
                                .load(dataSnapshot.child("fullImgAdUrl").getValue())
                                .into(fullImgAd2);
                        fullImgAd1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataSnapshot.child("link").getValue().toString()));
                                startActivity(browserIntent);
                            }
                        });
                    }else{
                        fullImgAd2.setVisibility(View.GONE);
                        int colorB = Color.parseColor(dataSnapshot.child("adBgr").getValue().toString());
                        int colorT = Color.parseColor(dataSnapshot.child("buttonColor").getValue().toString());
                        rlAd2.setBackgroundColor(colorB);
                        buttonAd2.setBackgroundColor(colorT);
                        buttonAd2.setText(dataSnapshot.child("buttonText").getValue().toString());
                        Glide.with(MainActivity.this)
                                .load(dataSnapshot.child("adImageUrl").getValue())
                                .into(imgAd2);

                        adTitle2.setText(dataSnapshot.child("title").getValue().toString());
                        adDesc2.setText(dataSnapshot.child("desc").getValue().toString());
                        buttonAd2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(dataSnapshot.child("link").getValue().toString()));
                                startActivity(browserIntent);
                            }
                        });




                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void loadViews(){
        //Db initialization
        viewPagerDb = FirebaseDatabase.getInstance().getReference("ViewPagerUpdate");
        viewPagerDb.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                ViewPagerUrlObj url = dataSnapshot.getValue(ViewPagerUrlObj.class);
                urlArray.add(url);
                viewPagerAdapter = new ViewPagerAdapter(MainActivity.this,urlArray);
                vp.setAdapter(viewPagerAdapter);
                wormDotsIndicator.setViewPager(vp);
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

        //For PMJDY grid db initialization
        pmbankRefPrimary = FirebaseDatabase.getInstance().getReference("FrontUiList");
        //For hindi language only title is changed
        //English default
        if(sLann == 1){
            pmbankRefPrimary.child("pmjdy").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    pmYojT.setText(dataSnapshot.child("title").getValue(String.class));

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pmbankRefPrimary.child("zerobank").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    zeroT.setText(dataSnapshot.child("title").getValue(String.class));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            pmbankRefPrimary.child("digitalbanks").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    digitalT.setText(dataSnapshot.child("title").getValue(String.class));
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            //For important category
            pmbankRefPrimary.child("impcategory").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String title = dataSnapshot.child("title").getValue(String.class);
                    if(!title.equals("")){
                        impTitle.setVisibility(View.VISIBLE);
                        impTitle.setText(title);
                    }
                    String isRev = dataSnapshot.child("isReverse").getValue(String.class);

                    for(DataSnapshot apps : dataSnapshot.child("groups").getChildren()) {

                        GridListObj gridListObj = apps.getValue(GridListObj.class);
                        impArray.add(gridListObj);
                        impHoridAdapter = new ImpHorizontalRecyclerView(MainActivity.this, impArray, MainActivity.this);
                        LinearLayoutManager lm1 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
                        if(isRev.equals("1      ")){
                            lm1.setReverseLayout(true);
                            lm1.setStackFromEnd(true);
                        }
                        impRec.setLayoutManager(lm1);
                        impRec.setAdapter(impHoridAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            //For category
            pmbankRefPrimary.child("category").addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    categoryText.setText(dataSnapshot.child("title").getValue(String.class));
                    String isRev = dataSnapshot.child("isReverse").getValue(String.class);
                    for(DataSnapshot apps : dataSnapshot.child("groups").getChildren()) {

                        GridListObj gridListObj = apps.getValue(GridListObj.class);
                        categoryArray.add(gridListObj);
                        categoryGridAdapter = new CategoryGridAdapter(MainActivity.this, categoryArray, MainActivity.this);
                        GridLayoutManager lm1 = new GridLayoutManager(MainActivity.this,3);
                        if(isRev.equals("1")){
                            lm1.setReverseLayout(true);

                        }
                        categoryRec.setLayoutManager(lm1);
                        categoryRec.setAdapter(categoryGridAdapter);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            //For recharge(Offline content)
            setTextForRecharge("Recharge/Pay bill without internet","Prepaid/Postpaid","DTH","Metro");

        }
        //Hindi
       else if(sLann == 2){
            dbRefSecondary("https://mysecondproject-hindi.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
       //For bengali
        else if(sLann == 3){
            dbRefSecondary("https://mysecondproject-bengali.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("ইন্টারনেট ব্যতীত রিচার্জ / বিল পরিশোধ","প্রিপেইড/পোস্টপেইড","ডিটিএইচ","মেট্রো");

        }
        //Odia
        else if(sLann == 4){
            dbRefSecondary("https://mysecondproject-odia.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
        //Marathi
        else if(sLann == 5){
            dbRefSecondary("https://mysecondproject-marathi.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
        //Malayalam
        else if(sLann == 6){
            dbRefSecondary("https://mysecondproject-malayalam.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
        //Kannada
        else if(sLann == 7){
            dbRefSecondary("https://mysecondproject-kannada.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
        //Tamil
        else if(sLann == 8){
            dbRefSecondary("https://mysecondproject-tamil.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
        //Telugu
        else if(sLann == 9){
            dbRefSecondary("https://mysecondproject-telugu.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
        //Gujarati
        else if(sLann == 10){
            dbRefSecondary("https://mysecondproject-gujarati.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
        //Punjabi
        else if(sLann == 11){
            dbRefSecondary("https://mysecondproject-punjabi.firebaseio.com/");
            //For recharge(Offline content)
            setTextForRecharge("इंटरनेट के बिना रिचार्ज / बिलों का भुगतान","प्रीपेड/पोस्टपेड","डीटीएच","मेट्रो");

        }
       //For PMJDY accounts
        pmbankRefPrimary.child("pmjdy").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String isRev = dataSnapshot.child("isReverse").getValue(String.class);
                for(DataSnapshot apps : dataSnapshot.child("banks").getChildren()) {
                    GridListObj gridListObj = apps.getValue(GridListObj.class);
                    pmjdyArray.add(gridListObj);
                    bankGridAdapter = new BankGridAdapter(MainActivity.this, pmjdyArray, MainActivity.this);
                    GridLayoutManager lm1 = new GridLayoutManager(MainActivity.this,3);
                    if(isRev.equals("1")){
                        lm1.setReverseLayout(true);
                    }
                    pmzeroRec.setLayoutManager(lm1);
                    pmzeroRec.setAdapter(bankGridAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        seePmjdy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BankListOpen.class);
                i.putExtra("flag",2);
                i.putExtra("title","PMJDY Saving Account");
                startActivity(i);
            }
        });

        //Db initialzation for zero accouts
        pmbankRefPrimary.child("zerobank").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String isRev = dataSnapshot.child("isReverse").getValue(String.class);
                for(DataSnapshot apps : dataSnapshot.child("banks").getChildren()) {

                    GridListObj gridListObj = apps.getValue(GridListObj.class);
                    zeroArray.add(gridListObj);
                    zeroAdapter = new ZeroBankGridAdapter(MainActivity.this, zeroArray, MainActivity.this);
                    GridLayoutManager lm1 = new GridLayoutManager(MainActivity.this,3);
                    if(isRev.equals("1")){
                        lm1.setReverseLayout(true);
                    }
                    zeroRec.setLayoutManager(lm1);
                    zeroRec.setAdapter(zeroAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        seeZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BankListOpen.class);
                i.putExtra("flag",1);
                i.putExtra("title","Zero Balance Saving Account");
                startActivity(i);
            }
        });

        //Db initialzation for digital accouts
        pmbankRefPrimary.child("digitalbanks").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                digitalT.setText(dataSnapshot.child("title").getValue(String.class));
                String isRev = dataSnapshot.child("isReverse").getValue(String.class);
                for(DataSnapshot apps : dataSnapshot.child("banks").getChildren()) {

                    GridListObj gridListObj = apps.getValue(GridListObj.class);
                    digitalArray.add(gridListObj);
                    digitalAdapter = new DigitalBankGridAdapter(MainActivity.this, digitalArray, MainActivity.this);
                    GridLayoutManager lm1 = new GridLayoutManager(MainActivity.this,3);
                    if(isRev.equals("1")){
                        lm1.setReverseLayout(true);

                    }
                    digitalRec.setLayoutManager(lm1);
                    digitalRec.setAdapter(digitalAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        seeDigtal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, BankListOpen.class);
                i.putExtra("flag",3);
                i.putExtra("title","Digital Saving Account");
                startActivity(i);
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
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            this.doubleBackToExitPressedOnce = true;
            showSnackBar("Press again to close ZAccount");
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 5000);
        }



    }
private void showSnackBar(String msg){
    Snackbar snackbar = Snackbar
            .make(rlMain, msg, Snackbar.LENGTH_LONG);
    snackbar.show();
}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Share").setIcon(R.drawable.ic_share).setShowAsAction(1);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().equals("Share")) {
            Intent sendIntent = new Intent();
            String msg = "Hey!" +
                    "\n I got a new awesome app called ZAccount that lets you find all information on Zero balance, Digital and PMJDY saving  account and its opening procedures. Check balance, Recharge, USSD Banking and much more\n Try out now at: " + "https://zaccount.page.link/installref";
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.zerobank) {
            Intent i = new Intent(MainActivity.this, BankListOpen.class);
            i.putExtra("flag",1);
            i.putExtra("title","Zero Balance Saving Account");
            startActivity(i);
        } else if (id == R.id.digitalbank) {
            Intent i = new Intent(MainActivity.this, BankListOpen.class);
            i.putExtra("flag",3);
            i.putExtra("title","Digital Saving Account");
            startActivity(i);
        } else if (id == R.id.pmjdybank) {
            Intent i = new Intent(MainActivity.this, BankListOpen.class);
            i.putExtra("flag",2);
            i.putExtra("title","PMJDY Saving Account");
            startActivity(i);
        } else if (id == R.id.bankbal) {
            Intent i = new Intent(MainActivity.this,SelectBank.class);
            i.putExtra("key","BankBalance");
            i.putExtra("type","db");
            i.putExtra("title","Check Bank Balance");
            startActivity(i);
        } else if (id == R.id.intbanking) {
            Intent i = new Intent(MainActivity.this,SelectBank.class);
            i.putExtra("key","netbanking");
            i.putExtra("type","db");
            i.putExtra("title","Internet Banking");
            startActivity(i);
        }
//        else if (id == R.id.unblockdebit) {
//            Intent i = new Intent(MainActivity.this,SelectBank.class);
//            i.putExtra("key","unblockdebit");
//            i.putExtra("type","db");
//            i.putExtra("title","Unblock Deit Card");
//            startActivity(i);
//        }else if (id == R.id.genpin) {
//            Intent i = new Intent(MainActivity.this,SelectBank.class);
//            i.putExtra("key","genpin");
//            i.putExtra("type","db");
//            i.putExtra("title","Generate PIN");
//            startActivity(i);
//        }
//        else if (id == R.id.ministate) {
//            Intent i = new Intent(MainActivity.this,SelectBank.class);
//            i.putExtra("key","ministatement");
//            i.putExtra("type","db");
//            i.putExtra("title","Mini Statement");
//            startActivity(i);
//        }
//        else if (id == R.id.ccbal) {
//            Intent i = new Intent(MainActivity.this,SelectBank.class);
//            i.putExtra("key","ccbal");
//            i.putExtra("type","db");
//            i.putExtra("title","Credit Card Balance");
//            startActivity(i);
//        }
        else if (id == R.id.prepost) {
            Intent i = new Intent(MainActivity.this,SelectBank.class);
            i.putExtra("key","prepost");
            i.putExtra("type","hardcoded");
            i.putExtra("title","Prepaid/Postpaid");
            startActivity(i);
        }else if (id == R.id.dth) {
            Intent i = new Intent(MainActivity.this,SelectBank.class);
            i.putExtra("key","dth");
            i.putExtra("type","hardcoded");
            i.putExtra("title","DTH");
            startActivity(i);
        }else if (id == R.id.metro) {
            Intent i = new Intent(MainActivity.this,SelectBank.class);
            i.putExtra("key","metro");
            i.putExtra("type","hardcoded");
            i.putExtra("title","Metro");
            startActivity(i);
        }else if (id == R.id.feedback) {
            try{
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("market://details?id=zacc.popo.ltd.zaccount"));
                startActivity(i);
            }catch(Exception e){
                Intent i = new Intent(Intent.ACTION_VIEW);
                //It will open a browser
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=zacc.popo.ltd.zaccount"));
                startActivity(i); }
        }else if (id == R.id.rate) {
            try{
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse("market://details?id=zacc.popo.ltd.zaccount"));
                startActivity(i);
            }catch(Exception e){
                Intent i = new Intent(Intent.ACTION_VIEW);
                //It will open a browser
                i.setData(Uri.parse("https://play.google.com/store/apps/details?id=zacc.popo.ltd.zaccount"));
                startActivity(i); }
        }else if (id == R.id.contact) {
            Intent i = new Intent(MainActivity.this, Contact.class);
            startActivity(i);
        } else if (id == R.id.about) {
            Intent i = new Intent(MainActivity.this, Web_Page.class);
            i.putExtra("key","https://abubakkarsk212.wixsite.com/zaccount");
            i.putExtra("title","About");
            startActivity(i);
        }
        else if (id == R.id.language) {
            Intent i = new Intent(MainActivity.this, ChooseLanguage.class);
            i.putExtra("isMain","1");
            startActivity(i);
        }
        else if (id == R.id.privacy) {
            Intent i = new Intent(MainActivity.this, Web_Page.class);
            i.putExtra("key","https://abubakkarsk212.wixsite.com/zaccprivacypolicies");
            i.putExtra("title","Privacy Policy");
            startActivity(i);
        }
        else if (id == R.id.businessEn) {
            Intent i = new Intent(MainActivity.this, Web_Page.class);
            i.putExtra("key","https://abubakkarsk212.wixsite.com/zaccount/business-with-us");
            i.putExtra("title","Business With Us");
            startActivity(i);
        }
        else if (id == R.id.shareApp) {
            Intent sendIntent = new Intent();
            String msg = "Hey!" +
                    "\n I got a new awesome app called ZAccount that lets you find all information on Zero balance, Digital and PMJDY saving  account and its opening procedures. Check balance, Recharge, USSD Banking and much more\n Try out now at: " + "https://zaccount.page.link/installref";
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG,"flag is"+deepLinkflag+deepLinkurl);
        if(deepLinkurl != null){
            Intent i = new Intent(MainActivity.this,BankPage.class);
            i.putExtra("key",deepLinkurl);
            i.putExtra("flag", deepLinkflag);
            deepLinkurl = null;
            deepLinkflag = 0;
            startActivity(i);
        }
        if( notChannel != null){
            if((notChannel.equals("savingaccount") || notChannel.equals("promotion")) && notKey != null) {

                Intent i = new Intent(MainActivity.this, BankPage.class);
                i.putExtra("key", notKey);
                i.putExtra("flag", notFlag);
                i.putExtra("title", title);
                notChannel = null;
                startActivity(i);
            }
            else if(notChannel.equals("appupdate") || notChannel.equals("feedback")){

                try {
                   Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + "zacc.popo.ltd.zaccount"));
                    notChannel = null;
                   startActivity(i);
                } catch (android.content.ActivityNotFoundException anfe) {
                   Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + "zacc.popo.ltd.zaccount"));
                    notChannel = null;
                   startActivity(i);
                }
            }
            else if(notChannel.equals("bankservice") && notKey != null){
                Intent i = new Intent(MainActivity.this, SelectBank.class);
                i.putExtra("key", notKey);
                i.putExtra("type", notType);
                i.putExtra("title", title);
                notChannel = null;
                startActivity(i);
            }
            else if(notChannel.equals("newsletter") && notKey != null){
                Intent i = new Intent(MainActivity.this, Web_Page.class);
                i.putExtra("key",notKey);
                i.putExtra("title",title);
                notChannel = null;
                startActivity(i);
            }
        }

        int r = sharedPref.getInt("isRate",1);

        if(r % 3 ==0){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AppRater.app_launched(MainActivity.this);
                }
            }, 3000);
        }

    }




    @Override
    public void onzeroListClicked(int itemClickedPos) {
        //Here flag 0 means zero balance
        Intent i = new Intent(MainActivity.this, BankPage.class);
        i.putExtra("key",zeroArray.get(itemClickedPos).getId());
        i.putExtra("flag",1);
        i.putExtra("title",zeroArray.get(itemClickedPos).getName());
        startActivity(i);
    }
    @Override
    public void onpmjdyListClicked(int itemClickedPos) {
        Intent i = new Intent(MainActivity.this, BankPage.class);
        i.putExtra("key",pmjdyArray.get(itemClickedPos).getId());
        i.putExtra("flag",2);
        i.putExtra("title",pmjdyArray.get(itemClickedPos).getName());
        startActivity(i);
    }
    @Override
    public void ondigitalListClicked(int itemClickedPos) {
        Intent i = new Intent(MainActivity.this, BankPage.class);
        i.putExtra("key",digitalArray.get(itemClickedPos).getId());
        i.putExtra("flag",3);
        i.putExtra("title",digitalArray.get(itemClickedPos).getName());
        startActivity(i);
    }

    @Override
    public void oncategoryListClicked(int itemClickedPos) {
        String id = categoryArray.get(itemClickedPos).getId();
    Intent i;

    if(id.equals("zeroacct")){
        i= new Intent(MainActivity.this,BankListOpen.class);
        i.putExtra("flag",1);
        i.putExtra("title",categoryArray.get(itemClickedPos).getName());
    }else if(id.equals("pmjdyacct")){
        i= new Intent(MainActivity.this,BankListOpen.class);
        i.putExtra("flag",2);
        i.putExtra("title",categoryArray.get(itemClickedPos).getName());
    }else if(id.equals("digitalacct")){
        i= new Intent(MainActivity.this,BankListOpen.class);
        i.putExtra("flag",3);
        i.putExtra("title",categoryArray.get(itemClickedPos).getName());
    }
    else{
        i= new Intent(MainActivity.this,SelectBank.class);
        i.putExtra("key",id);
        i.putExtra("type","db");
        i.putExtra("title",categoryArray.get(itemClickedPos).getName());
    }

    startActivity(i);
    }

    @Override
    public void onrechargeListClicked(int itemClickedPos) {
        Intent i = new Intent(MainActivity.this,SelectBank.class);
        i.putExtra("key",rechargeArray.get(itemClickedPos).getId());
        i.putExtra("type","hardcoded");
        i.putExtra("title",rechargeArray.get(itemClickedPos).getName());
        startActivity(i);
    }

    @Override
    public void onimpListClicked(int itemClickedPos) {
        Intent i = new Intent(MainActivity.this,SelectBank.class);
        i.putExtra("key",impArray.get(itemClickedPos).getId());
        i.putExtra("type","db");
        i.putExtra("title",impArray.get(itemClickedPos).getName());
        startActivity(i);
    }


//    private void checkForUpdate(){
//        // Creates instance of the manager.
//        AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(MainActivity.this);
//
//// Returns an intent object that you use to check for an update.
//        Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
//
//// Checks that the platform will allow the specified type of update.
//        appUpdateInfoTask.addOnSuccessListener(appUpdateInfo -> {
//            if (appUpdateInfo.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
//                    && appUpdateInfo.updatePriority() >= HIGH_PRIORITY_UPDATE
//                    && appUpdateInfo.isUpdateTypeAllowed(AppUpdateType.FLEXIBLE)) {
//                // Request the update.
//                try {
//                    appUpdateManager.startUpdateFlowForResult(
//                            // Pass the intent that is returned by 'getAppUpdateInfo()'.
//                            appUpdateInfo,
//                            // Or 'AppUpdateType.FLEXIBLE' for flexible updates.
//                            AppUpdateType.IMMEDIATE,
//                            // The current activity making the update request.
//                            this,
//                            // Include a request code to later monitor this update request.
//                            5);
//                } catch (IntentSender.SendIntentException e) {
//                    e.printStackTrace();
//                }
//            }
//
//        });
//
//    }
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == 5) {
//            if (resultCode != RESULT_OK) {
//                Toast.makeText(this, "\"Update flow failed! Result code: \"", Toast.LENGTH_SHORT).show();
//
//                // If the update is cancelled or fails,
//                // you can request to start the update again.
//            }
//        }
//    }
private void createNotificationChannel() {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is new and not in the support library
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        int importance = NotificationManager.IMPORTANCE_DEFAULT;
        int importanceHigh = NotificationManager.IMPORTANCE_HIGH;
        NotificationChannel savingC = new NotificationChannel(CHANNEL_ID, getString(R.string.channel1), importance);
        savingC.setDescription(getString(R.string.channel1des));
        NotificationChannel appuc = new NotificationChannel(CHANNEL_ID2, getString(R.string.channel2), importanceHigh);
        appuc.setDescription(getString(R.string.channel2des));
        NotificationChannel bankSC = new NotificationChannel(CHANNEL_ID3, getString(R.string.channel3), importance);
        bankSC.setDescription(getString(R.string.channel3des));
        NotificationChannel feedbackC = new NotificationChannel(CHANNEL_ID4, getString(R.string.channel4), importance);
        feedbackC.setDescription(getString(R.string.channel4des));
        NotificationChannel newsletterC = new NotificationChannel(CHANNEL_ID5, getString(R.string.channel5), importance);
        newsletterC.setDescription(getString(R.string.channel5des));
        NotificationChannel promotionC = new NotificationChannel(CHANNEL_ID6, getString(R.string.channel6), importance);
        promotionC.setDescription(getString(R.string.channel6des));
        // Register the channel with the system; you can't change the importance
        // or other notification behaviors after this
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        List<NotificationChannel> notificationChannelList = new ArrayList<>();
        notificationChannelList.add(savingC);
        notificationChannelList.add(appuc);
        notificationChannelList.add(bankSC);
        notificationChannelList.add(feedbackC);
        notificationChannelList.add(newsletterC);
        notificationChannelList.add(promotionC);
        notificationManager.createNotificationChannels(notificationChannelList);
    }
}
private void getRegToken(){
    FirebaseInstanceId.getInstance().getInstanceId()
            .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                @Override
                public void onComplete(@NonNull com.google.android.gms.tasks.Task<InstanceIdResult> task) {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "getInstanceId failed", task.getException());
                        return;
                    }

                    // Get new Instance ID token
                    String token = task.getResult().getToken();

                    // Log and toast

                    Log.d(TAG, "token from main"+token);
                    Toast.makeText(MainActivity.this,"token from main"+ token, Toast.LENGTH_SHORT).show();
                }


            });

}
public  void setTextForRecharge(String title,String prepost, String dth, String metro){
    rechargeText.setText(title);
    rechargeArray.add(new GridListObj("prepost","https://firebasestorage.googleapis.com/v0/b/mysecondproject-3f437.appspot.com/o/Category%20Icons%2Fsmartphone.png?alt=media&token=b9b89869-1934-42be-870f-00a74edffcf7",prepost,"",""));
    rechargeArray.add(new GridListObj("dth","https://firebasestorage.googleapis.com/v0/b/mysecondproject-3f437.appspot.com/o/Category%20Icons%2Fantenna.png?alt=media&token=1db9e7f4-18ab-4868-8886-ead2946bcc78",dth,"",""));
    rechargeArray.add(new GridListObj("metro","https://firebasestorage.googleapis.com/v0/b/mysecondproject-3f437.appspot.com/o/Category%20Icons%2Ftrain.png?alt=media&token=43469e34-b475-4e42-8f5f-5081ddbf5723",metro,"","'"));
    rechargeGridAdapter = new RechargeGridAdapter(MainActivity.this,rechargeArray,MainActivity.this);
    GridLayoutManager lm2 = new GridLayoutManager(MainActivity.this,3);
    rechargeRec.setLayoutManager(lm2);
    rechargeRec.setAdapter(rechargeGridAdapter);
}

public void dbRefSecondary(String instance){
    pmbankRefSecondary = FirebaseDatabase.getInstance(instance).getReference("FrontUiList");
    pmbankRefSecondary.child("pmjdy").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            pmYojT.setText(dataSnapshot.child("title").getValue(String.class));

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    pmbankRefSecondary.child("zerobank").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            zeroT.setText(dataSnapshot.child("title").getValue(String.class));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    pmbankRefSecondary.child("digitalbanks").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            digitalT.setText(dataSnapshot.child("title").getValue(String.class));
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    //For important category
    pmbankRefSecondary.child("impcategory").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            String title = dataSnapshot.child("title").getValue(String.class);
            if(!title.equals("")){
                impTitle.setVisibility(View.VISIBLE);
                impTitle.setText(title);
            }
            String isRev = dataSnapshot.child("isReverse").getValue(String.class);

            for(DataSnapshot apps : dataSnapshot.child("groups").getChildren()) {

                GridListObj gridListObj = apps.getValue(GridListObj.class);
                impArray.add(gridListObj);
                impHoridAdapter = new ImpHorizontalRecyclerView(MainActivity.this, impArray, MainActivity.this);
                LinearLayoutManager lm1 = new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
                if(isRev.equals("1      ")){
                    lm1.setReverseLayout(true);
                    lm1.setStackFromEnd(true);
                }
                impRec.setLayoutManager(lm1);
                impRec.setAdapter(impHoridAdapter);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
    //For category
    pmbankRefSecondary.child("category").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            categoryText.setText(dataSnapshot.child("title").getValue(String.class));
            String isRev = dataSnapshot.child("isReverse").getValue(String.class);
            for(DataSnapshot apps : dataSnapshot.child("groups").getChildren()) {

                GridListObj gridListObj = apps.getValue(GridListObj.class);
                categoryArray.add(gridListObj);
                categoryGridAdapter = new CategoryGridAdapter(MainActivity.this, categoryArray, MainActivity.this);
                GridLayoutManager lm1 = new GridLayoutManager(MainActivity.this,3);
                if(isRev.equals("1")){
                    lm1.setReverseLayout(true);

                }
                categoryRec.setLayoutManager(lm1);
                categoryRec.setAdapter(categoryGridAdapter);
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });
}



//    @Override
//    public void onnavItemListClicked(int itemClickedPos, String mTag) {
////        switch (mTag){
////            case "savingadapter":
////                 break;
////            case "bankseradapter":
////                Toast.makeText(this, itemClickedPos, Toast.LENGTH_SHORT).show();
////                break;
////            case "rechargeadapter":
////                Intent i1 = new Intent(MainActivity.this,SelectBank.class);
////                i1.putExtra("key",navRechargeArrayL.get(itemClickedPos).getId());
////                i1.putExtra("type","hardcoded");
////                startActivity(i1);
////                break;
////        }
//        Toast.makeText(this, itemClickedPos+"", Toast.LENGTH_SHORT).show();
//    }
}