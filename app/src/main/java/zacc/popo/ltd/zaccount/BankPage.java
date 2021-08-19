package zacc.popo.ltd.zaccount;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ToggleButton;
import com.bumptech.glide.Glide;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.dynamiclinks.DynamicLink;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.ArrayList;

public class BankPage extends AppCompatActivity {
ToggleButton like;
TextView likeCounter,aboutTitle,bankNameT,aboutContent,benifitTitlet,clickHereLink,feesChargeT,eligiblityT,eligiblityCont,docsTi,processTi;
SharedPreferences.Editor editor;
ImageView firstP,updateImage;
//For banner
    LinearLayout interestL,mabL,debitL,chequeL,customerSLL,shareBnk,mobileBankingL,netBankingL,noticeLL;
    TextView interestT,mabT,subTitleNotice,titleNotice;
//For benifits
RecyclerView benifitRecy,docsRe,processRec,chargesRec;
NoteAdapterSingle noteAdapterSingle;
ArrayList<String> benifitPointA;
ArrayList<String> chargesArray;
DatabaseReference benifitRef,cuelinkRef,secondaryRef;
String id,titleA;
int flag;
String linkForFees,customerNo,bankName,netBank,mobileBank;
int noOfLikes;
String childOfNodes;
String imgurl;
RelativeLayout relativeLayout;
    ReuseMethodClass reuseMethodClass;
    int a;
    String lanDbRef;

//For About

//For docs req
NoteAdapterSingle noteAdapterDocs;
    ArrayList<String> docsArr;
//For process steps
ProcessAdapter processAdapter;
ArrayList<ProcessObj> processObjs;
LinearLayout feesLL,openedLL;
ProgressBar progressBar;
String bankType;

//For views to be display or not
    LinearLayout llBankD,shareDetailsLl,retryLL;
    CardView aboutCV,benifitsCV,feesCV,eligiblityCV,docsReqCV,processCV,accessCV;
    Button retryB;

    //bannerads
    AdLoader adLoaderSmall,adLoaderLarge;

    TextView issueClick;

    InterstitialAd mInterstitialAd;
    //For custom own banner cuelink
    RelativeLayout rlAd1,rlAd2;
    ImageView imgAd1,fullImgAd1,imgAd2,fullImgAd2;
    TextView adTitle1,adDesc1,buttonAd1,adTitle2,adDesc2,buttonAd2;
    boolean inApp = true;

    //Custom tab imp
    CustomTabsIntent customTabsIntent;
    String packageName;

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0 && grantResults[0] == 0) {
            getSnackBar("Click again to continue");
        }else {
            getSnackBar("Please allow permission to continue");

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_page);
        relativeLayout = findViewById(R.id.rlbankpage);
        like = findViewById(R.id.like);
        likeCounter = findViewById(R.id.likecount);
        firstP = findViewById(R.id.firstPic);
        customerSLL = findViewById(R.id.customerSupportLL);
        shareBnk = findViewById(R.id.shareBank);
        mobileBankingL = findViewById(R.id.mobileBankLL);
        netBankingL = findViewById(R.id.netbankingLL);
        //For banner
        interestL = findViewById(R.id.interestLL);
        mabL = findViewById(R.id.mabLL);
        debitL = findViewById(R.id.debitLL);
        chequeL = findViewById(R.id.chequeLL);
        mabT = findViewById(R.id.mabText);
        interestT = findViewById(R.id.interestText);
        benifitPointA = new ArrayList<>();
        //For about
        aboutTitle = findViewById(R.id.aboutTitleT);
        bankNameT = findViewById(R.id.bankNameT);
        aboutContent = findViewById(R.id.aboutContentT);
        //For benifit
        benifitTitlet = findViewById(R.id.benifitTitleT);
        benifitRecy = findViewById(R.id.benifitRec);
        //For Eligiblity
        eligiblityCont = findViewById(R.id.eligiblityContent);
        eligiblityT = findViewById(R.id.eligiblityTiT);
        //For document required
        docsTi = findViewById(R.id.docsTitle);
        docsRe = findViewById(R.id.docsRec);
        docsArr = new ArrayList<>();
        //For process steps
        processTi = findViewById(R.id.processTitle);
        processRec = findViewById(R.id.processRec);
        processObjs = new ArrayList<>();
        //Fees and chages text
        feesChargeT = findViewById(R.id.feeschargesText);
        clickHereLink = findViewById(R.id.clickHere);
        chargesRec = findViewById(R.id.chargesRec);
        chargesArray = new ArrayList<>();
        feesLL = findViewById(R.id.feesLL);
        openedLL = findViewById(R.id.openedLL);

        progressBar = findViewById(R.id.progressMBankPage);

        //For update part
        noticeLL = findViewById(R.id.noticeLL);
        titleNotice = findViewById(R.id.textNoticeTitle);
        subTitleNotice = findViewById(R.id.textNoticeSubtitle);
        updateImage = findViewById(R.id.imageUpdate);

        //views to show or not
        llBankD = findViewById(R.id.llBankDetails);
        shareDetailsLl = findViewById(R.id.shareDetailsLL);
        aboutCV = findViewById(R.id.cardAbout);
        benifitsCV = findViewById(R.id.cardBenifir);
        feesCV = findViewById(R.id.cardFees);
        eligiblityCV = findViewById(R.id.cardEligiblity);
        docsReqCV = findViewById(R.id.cardDocsReq);
        processCV = findViewById(R.id.cardProcess);
        accessCV = findViewById(R.id.cardAccess);
        retryLL = findViewById(R.id.retryLLBP);
        retryB = findViewById(R.id.retryCBP);
        issueClick = findViewById(R.id.clickHereIssue);

        //For cuelink ad
        rlAd1 = findViewById(R.id.rlCueAd1);
        imgAd1 = findViewById(R.id.imgAd1);
        adTitle1 = findViewById(R.id.titleAd1);
        adDesc1 = findViewById(R.id.descAds1);
        buttonAd1 = findViewById(R.id.buttonAd1);
        fullImgAd1 = findViewById(R.id.imageAd1);
        //for 2
        rlAd2 = findViewById(R.id.rlCueAd2);
        imgAd2 = findViewById(R.id.imgAd2);
        adTitle2 = findViewById(R.id.titleAd2);
        adDesc2 = findViewById(R.id.descAds2);
        buttonAd2 = findViewById(R.id.buttonAd2);
        fullImgAd2 = findViewById(R.id.imageAd2);



        reuseMethodClass = new ReuseMethodClass(BankPage.this);

        //Getting id from intent
        id = getIntent().getStringExtra("key");
        flag = getIntent().getIntExtra("flag",0);
        titleA = getIntent().getStringExtra("title");
        getSupportActionBar().setTitle(titleA);

      //Custom tab fallback
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
      customTabsIntent = builder.build();

//      packageName = getPackageNameToUse(this);




//        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));
        SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref),Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        a = sharedPref.getInt(id, 0);
        if(id != null){


            if(flag == 1){
                childOfNodes = "zerobank";
                bankType = "zero balance";
            }else if(flag == 2){
                childOfNodes = "pmjdy";
                bankType = "zero balance";
            }
            else {
                childOfNodes = "digitalbanks";
                bankType = "digital";
            }
            benifitRef = FirebaseDatabase.getInstance().getReference("InsideContent").child(childOfNodes);
            int sLann = sharedPref.getInt("selectedLan",2);
            switch (sLann){
                //Hindi
                case 2: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-hindi.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;

                //Bengali
                case 3: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-bengali.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                //Odia
                case 4: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-odia.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                    //Marathi
                case 5: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-marathi.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                    // Malayalam
                case 6: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-malayalam.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                    //Kannananda
                case 7: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-kannada.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                    //Tamil
                case 8: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-tamil.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                    // Telegu
                case 9: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-telugu.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                    //Gujarati
                case 10: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-gujarati.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                    //Punjabi
                case 11: secondaryRef = FirebaseDatabase.getInstance("https://mysecondproject-punjabi.firebaseio.com/").getReference("InsideContent").child(childOfNodes);
                    break;
                    //For english
                default: secondaryRef = benifitRef;


            }

            if(reuseMethodClass.isConnected()){
               loadViews();
               loadAds();
            }else{
             reuseMethodClass.showSnackBar("Oops! No internet connection",relativeLayout);
             progressBar.setVisibility(View.INVISIBLE);
             retryLL.setVisibility(View.VISIBLE);
            }

        issueClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setType("text/plain");
                intent.setData(Uri.parse("mailto:"));
                intent.putExtra(Intent.EXTRA_EMAIL, "helpybookapp@gmail.com");
                intent.putExtra(Intent.EXTRA_SUBJECT, "There is some issue in "+childOfNodes+" "+titleA);
                intent.putExtra(Intent.EXTRA_TEXT, "Please describe the issue you are facing:");
                startActivity(Intent.createChooser(intent, "Send Email"));
            }
        });
        like.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    noOfLikes++;
                    benifitRef.child(id).child("nooflikes").setValue(noOfLikes + "");
                    likeCounter.setText(noOfLikes+"");
                    like.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_likered));
                    editor.putInt(id, 1);
                    editor.commit();

                }
                else{
                    noOfLikes--;
                    benifitRef.child(id).child("nooflikes").setValue(noOfLikes + "");
                    likeCounter.setText(noOfLikes+"");
                    like.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_likeblack));
                    editor.putInt(id, 0);
                    editor.commit();
                }
            }
        });
            retryB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(reuseMethodClass.isConnected()){
                        progressBar.setVisibility(View.VISIBLE);
                        retryLL.setVisibility(View.GONE);
                        loadViews();
                        loadAds();
                    }else{
                        reuseMethodClass.showSnackBar("Oops! No internet connection",relativeLayout);
                    }
                }
            });
        clickHereLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BankPage.this, Web_Page.class);
                i.putExtra("key",linkForFees);
                i.putExtra("title","Fees and Charges");
                startActivity(i);
            }
        });
        customerSLL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int len = customerNo.length();
                reuseMethodClass.callNo(customerNo.substring(0,len-2),1,relativeLayout,progressBar);
            }
        });
        shareBnk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent sendIntent = new Intent();

                Task<ShortDynamicLink> shortLinkTask = FirebaseDynamicLinks.getInstance().createDynamicLink()
                        .setLink(Uri.parse("https://zaccount.page/"+id+flag))
                        .setDomainUriPrefix("https://zaccount.page.link").setAndroidParameters( new DynamicLink.AndroidParameters.Builder("zacc.popo.ltd.zaccount").setMinimumVersion(10).build())
                        // Set parameters
                        // ...
                        .setSocialMetaTagParameters(new DynamicLink.SocialMetaTagParameters.Builder()
                                .setImageUrl(Uri.parse(imgurl))
                                .build())
                        .buildShortDynamicLink()
                        .addOnCompleteListener(BankPage.this, new OnCompleteListener<ShortDynamicLink>() {
                            @Override
                            public void onComplete(@NonNull Task<ShortDynamicLink> task) {
                                if (task.isSuccessful()) {
                                    // Short link created
                                    Uri shortLink = task.getResult().getShortLink();
                                    String msg = "Hey, Check out the opening procedure of "+bankName+","+bankType+" saving account on ZAccount android app available in play store\n"+"Checkout now at: " + shortLink;
                                    sendIntent.setAction(Intent.ACTION_SEND);
                                    sendIntent.putExtra(Intent.EXTRA_TEXT, msg);
                                    sendIntent.setType("text/plain");
                                    startActivity(sendIntent);
                                } else {
                                    // Error
                                    // ...
                                    Snackbar snackbar = Snackbar
                                            .make(relativeLayout, "Something went wrong! Please try again", Snackbar.LENGTH_LONG);
                                    snackbar.show();

                                }
                            }
                        });
            }
        });
        mobileBankingL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isAppInstalled = appInstalledOrNot(mobileBank);
                if(isAppInstalled){
                    Intent LaunchIntent = getPackageManager()
                            .getLaunchIntentForPackage(mobileBank);
                    startActivity(LaunchIntent);
                }
                else{
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + mobileBank)));
                    } catch (android.content.ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + mobileBank)));
                    }
                }

            }
        });
        netBankingL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(BankPage.this, Web_Page.class);
                i.putExtra("key",netBank);
                i.putExtra("title","Net Banking");
                startActivity(i);
            }
        });

        }


    }
    public void loadViews(){
        if(a ==1){
            like.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_likered));
            like.setChecked(true);
        }else{
            like.setBackgroundDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.ic_likeblack));
        }
//Database reference for whole page

        secondaryRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.hasChild(id)){
                    secondaryRef.child(id).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            imgurl = dataSnapshot.child("imgUrl").getValue()+"";
                            Glide.with(BankPage.this)
                                    .load(imgurl)
                                    .into(firstP);
                            if((dataSnapshot.child("bannerdetail").child("interest").child("isHave").getValue()).equals("1")){
                                interestL.setVisibility(View.VISIBLE);
                                interestT.setText(dataSnapshot.child("bannerdetail").child("interest").child("value").getValue(String.class));
                            }
                            else {
                                interestL.setVisibility(View.GONE);
                            }


                            if((dataSnapshot.child("bannerdetail").child("mab").child("isHave").getValue()).equals("1")){
                                mabL.setVisibility(View.VISIBLE);
                                mabT.setText(dataSnapshot.child("bannerdetail").child("mab").child("value").getValue(String.class));
                            }
                            else {
                                mabL.setVisibility(View.GONE);
                            }

                            if((dataSnapshot.child("bannerdetail").child("debitcard").child("isHave").getValue()).equals("1")){
                                debitL.setVisibility(View.VISIBLE);
                            }
                            else {
                                debitL.setVisibility(View.GONE);
                            }
                            if((dataSnapshot.child("bannerdetail").child("cheque").child("isHave").getValue()).equals("1")){
                                chequeL.setVisibility(View.VISIBLE);
                            }
                            else {
                                chequeL.setVisibility(View.GONE);
                            }
                            //For About
                            aboutTitle.setText(dataSnapshot.child("about").child("title").getValue(String.class));
                            bankName = dataSnapshot.child("about").child("bankname").getValue(String.class);
                            bankNameT.setText(bankName);
                            aboutContent.setText(dataSnapshot.child("about").child("details").getValue(String.class));
                            //For benifit
                            DataSnapshot benifitS = dataSnapshot.child("benifits");
                            benifitTitlet.setText(benifitS.child("title").getValue(String.class));
                            for(DataSnapshot ds : benifitS.child("details").getChildren()){
                                benifitPointA.add(ds.getValue(String.class));
                            }
                            noteAdapterSingle = new NoteAdapterSingle(BankPage.this,benifitPointA);
                            benifitRecy.setLayoutManager(new LinearLayoutManager(BankPage.this));
                            benifitRecy.setAdapter(noteAdapterSingle);
                            //For eligiblity
                            DataSnapshot eligiblityS = dataSnapshot.child("eligiblity");
                            eligiblityT.setText(eligiblityS.child("title").getValue(String.class));
                            eligiblityCont.setText(eligiblityS.child("content").getValue(String.class));
                            //For docs req
                            DataSnapshot docsS = dataSnapshot.child("docrequired");
                            docsTi.setText(docsS.child("title").getValue(String.class));
                            for(DataSnapshot dd : docsS.child("doccontent").getChildren()){
                                docsArr.add(dd.getValue(String.class));
                            }
                            noteAdapterSingle = new NoteAdapterSingle(BankPage.this,docsArr);
                            docsRe.setLayoutManager(new LinearLayoutManager(BankPage.this));
                            docsRe.setAdapter(noteAdapterSingle);
                            //For charges
                            DataSnapshot chargesS = dataSnapshot.child("feescharges");
                            for(DataSnapshot ds : chargesS.child("details").getChildren()){
                                chargesArray.add(ds.getValue(String.class));
                            }
                            noteAdapterSingle = new NoteAdapterSingle(BankPage.this,chargesArray);
                            chargesRec.setLayoutManager(new LinearLayoutManager(BankPage.this));
                            chargesRec.setAdapter(noteAdapterSingle);
                            //For steps
                            DataSnapshot dstep = dataSnapshot.child("stepprocess");
                            processTi.setText(dstep.child("title").getValue(String.class));
                            for(DataSnapshot ds : dstep.child("steps").getChildren()){
                                processObjs.add(ds.getValue(ProcessObj.class));
                            }
                            processAdapter = new ProcessAdapter(BankPage.this,processObjs);
                            processRec.setLayoutManager(new LinearLayoutManager(BankPage.this));
                            processRec.setAdapter(processAdapter);

                            //For fees and charges
                            DataSnapshot dfee = dataSnapshot.child("feescharges");
                            feesChargeT.setText(dfee.child("title").getValue(String.class));
                            linkForFees = dfee.child("link").getValue(String.class);
                            //For like
                            noOfLikes = Integer.parseInt(dataSnapshot.child("nooflikes").getValue(String.class));
                            likeCounter.setText(noOfLikes+"");
                            customerNo = dataSnapshot.child("customerNo").getValue(String.class);
                            int length = customerNo.length();
                            if(customerNo.charAt(length-2) == 'n'){
                                feesLL.setVisibility(View.GONE);
                            }
                            if(customerNo.charAt(length-1) == 'a'){
                                openedLL.setVisibility(View.GONE);
                            }

                            DataSnapshot acessSnap = dataSnapshot.child("accessbank");
                            netBank = acessSnap.child("netbank").getValue(String.class);
                            mobileBank = acessSnap.child("mobbank").getValue(String.class);

                            //For update
                            DataSnapshot updateS = dataSnapshot.child("updates");
                            if(updateS.child("isNoticeLL").getValue(String.class).equals("1")){
                                noticeLL.setVisibility(View.VISIBLE);
                                titleNotice.setText(updateS.child("title").getValue(String.class));
                                subTitleNotice.setText(updateS.child("subTitle").getValue(String.class));
                            }
                            if(updateS.child("isImg").getValue(String.class).equals("1")){
                                updateImage.setVisibility(View.VISIBLE);
                                Glide.with(BankPage.this)
                                        .load(updateS.child("imgUpdateUrl").getValue())
                                        .into(updateImage);
                            }

                            progressBar.setVisibility(View.GONE);
                            firstP.setVisibility(View.VISIBLE);
                            llBankD.setVisibility(View.VISIBLE);
                            shareDetailsLl.setVisibility(View.VISIBLE);
                            aboutCV.setVisibility(View.VISIBLE);
                            benifitsCV.setVisibility(View.VISIBLE);
                            feesCV.setVisibility(View.VISIBLE);
                            eligiblityCV.setVisibility(View.VISIBLE);
                            docsReqCV.setVisibility(View.VISIBLE);
                            processCV.setVisibility(View.VISIBLE);
                            accessCV.setVisibility(View.VISIBLE);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });

                }else{
                    progressBar.setVisibility(View.GONE);
                    reuseMethodClass.showSnackBar("Sorry! Content not found",relativeLayout);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
    public void loadAds(){
        //Load ads
        // Native ad banner 1
        ColorDrawable colorDrawable = new ColorDrawable(getResources().getColor(R.color.white));
        //native banner
        adLoaderSmall = new AdLoader.Builder(this, getString(R.string.nativebankpagesmall))
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        if (isDestroyed()) {
                            unifiedNativeAd.destroy();
                            return;
                        }
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().withMainBackgroundColor(colorDrawable).build();

                        TemplateView template = findViewById(R.id.template_small_bankpage);
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
        adLoaderLarge = new AdLoader.Builder(this, getString(R.string.nativebankpagelarge))
                .forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
                    @Override
                    public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                        if (isDestroyed()) {
                            unifiedNativeAd.destroy();
                            return;
                        }
                        NativeTemplateStyle styles = new
                                NativeTemplateStyle.Builder().withMainBackgroundColor(colorDrawable).build();

                        TemplateView template = findViewById(R.id.template_medium_bankpage);
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


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.bankpageInt));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });

        new Handler().postDelayed(new Runnable() {
            public void run() {
//                        adInt.show();
                if(inApp)
                    mInterstitialAd.show();
            }
        }, 10000);

//Cuelink ads implementation
        cuelinkRef = FirebaseDatabase.getInstance().getReference("CuelinkAd");
        cuelinkRef.child("1").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("enable").getValue().equals("0")){
                    rlAd1.setVisibility(View.GONE);
                    fullImgAd1.setVisibility(View.GONE);

                }else{
                    //1 means it has image then show image and hide rl
                    if(dataSnapshot.child("isImage").getValue().equals("1")){
                        rlAd1.setVisibility(View.GONE);
                        Glide.with(BankPage.this)
                                .load(dataSnapshot.child("fullImgAdUrl").getValue())
                                .into(fullImgAd1);
                        fullImgAd1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String url = dataSnapshot.child("link").getValue().toString();
                                String isCtab = dataSnapshot.child("isCtabOrBrow").getValue().toString();
                                if(reuseMethodClass.isBrowserInstalled(url)){
                                    if(isCtab.equals("1")){
                                        reuseMethodClass.openCustomTab(url);
                                    }
                                    else{
                                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                        startActivity(browserIntent);
                                    }
                                }
                                else{
                                    reuseMethodClass.showSnackBar("No browser app present to open this page",relativeLayout);
                                }



                            }
                        });
                    }else{
                        fullImgAd1.setVisibility(View.GONE);
                        int colorB = Color.parseColor(dataSnapshot.child("adBgr").getValue().toString());
                        int colorT = Color.parseColor(dataSnapshot.child("buttonColor").getValue().toString());
                        rlAd1.setBackgroundColor(colorB);
                        buttonAd1.setBackgroundColor(colorT);
                        buttonAd1.setText(dataSnapshot.child("buttonText").getValue().toString());
                        Glide.with(BankPage.this)
                                .load(dataSnapshot.child("adImageUrl").getValue())
                                .into(imgAd1);

                        adTitle1.setText(dataSnapshot.child("title").getValue().toString());
                        adDesc1.setText(dataSnapshot.child("desc").getValue().toString());
                        buttonAd1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String url = dataSnapshot.child("link").getValue().toString();
                                String isCtab = dataSnapshot.child("isCtabOrBrow").getValue().toString();
                                if(reuseMethodClass.isBrowserInstalled(url)){
                                    if(isCtab.equals("1")){
                                        reuseMethodClass.openCustomTab(url);
                                    }
                                    else{
                                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                        startActivity(browserIntent);
                                    }
                                }
                                else{
                                    reuseMethodClass.showSnackBar("No browser app present to open this page",relativeLayout);
                                }
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
        cuelinkRef.child("2").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.child("enable").getValue().equals("0")){
                    rlAd2.setVisibility(View.GONE);
                    fullImgAd2.setVisibility(View.GONE);

                }else{
                    //1 means it has image then show image and hide rl
                    if(dataSnapshot.child("isImage").getValue().equals("1")){
                        rlAd2.setVisibility(View.GONE);
                        Glide.with(BankPage.this)
                                .load(dataSnapshot.child("fullImgAdUrl").getValue())
                                .into(fullImgAd2);
                        fullImgAd2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String url = dataSnapshot.child("link").getValue().toString();
                                String isCtab = dataSnapshot.child("isCtabOrBrow").getValue().toString();
                                if(reuseMethodClass.isBrowserInstalled(url)){
                                    if(isCtab.equals("1")){
                                        reuseMethodClass.openCustomTab(url);
                                    }
                                    else{
                                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                        startActivity(browserIntent);
                                    }
                                }
                                else{
                                    reuseMethodClass.showSnackBar("No browser app present to open this page",relativeLayout);
                                }
                            }
                        });
                    }else{
                        fullImgAd2.setVisibility(View.GONE);
                        int colorB = Color.parseColor(dataSnapshot.child("adBgr").getValue().toString());
                        int colorT = Color.parseColor(dataSnapshot.child("buttonColor").getValue().toString());
                        rlAd2.setBackgroundColor(colorB);
                        buttonAd2.setBackgroundColor(colorT);
                        buttonAd2.setText(dataSnapshot.child("buttonText").getValue().toString());
                        Glide.with(BankPage.this)
                                .load(dataSnapshot.child("adImageUrl").getValue())
                                .into(imgAd2);

                        adTitle2.setText(dataSnapshot.child("title").getValue().toString());
                        adDesc2.setText(dataSnapshot.child("desc").getValue().toString());
                        buttonAd2.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String url = dataSnapshot.child("link").getValue().toString();
                                String isCtab = dataSnapshot.child("isCtabOrBrow").getValue().toString();
                                if(reuseMethodClass.isBrowserInstalled(url)){
                                    if(isCtab.equals("1")){
                                        reuseMethodClass.openCustomTab(url);
                                    }
                                    else{
                                        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                                        startActivity(browserIntent);
                                    }
                                }
                                else{
                                    reuseMethodClass.showSnackBar("No browser app present to open this page",relativeLayout);
                                }
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




    @Override
    protected void onDestroy() {
        super.onDestroy();
       if(mInterstitialAd!= null){
           inApp = false;
       }


    }


    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
        }

        return false;
    }
    private void getSnackBar(String msg){
        Snackbar snackbar = Snackbar
                .make(relativeLayout, msg, Snackbar.LENGTH_LONG);
        snackbar.show();
    }
}
