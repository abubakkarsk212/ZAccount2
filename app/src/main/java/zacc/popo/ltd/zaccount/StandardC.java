package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;

public class StandardC extends AppCompatActivity {
Spinner spinner,spinnerPre,spinnerPri;
//    String[] stateWise ={"Select State","Ahmedabad","Allahabad"2, "Amritsar"3, "Bangalore"4, "Bhopal"5, "Bhubaneswar"6, "Chandigarh"7, "Cochin / Ernakulam"8, "Coimbatore"9, "Chennai"10, "Cuttack"11, "Delhi"12, "Dehradun"13, "Guwahati"14,"Gurgaon"15, "Hyderabad"16, "Indore"17, "Jaipur"18, "Jalandhar"19,"Jalgaon"20, "Kolkata"21,"Kanpur"22,"Lucknow"23,"Ludhiana"24, "Mumbai"25,"Mathura"26,"Mysore"27,"Nagpur"28,"Noida"29, "Pune"30, "Patna"31,"Proddatur"32,"Rajkot"33,"Surat"34,"Saharanpur"35,"Siliguri"36,"Thiruvananthpuram"37,"Vadodara"38,"Vishakhapatnam"39};
String[] premiumCus ={"Select State","Ahmedabad","Allahabad", "Amritsar", "Bengaluru", "Bhopal", "Bhubaneswar", "Chandigarh", "Coimbatore", "Chennai", "Cuttack", "Dehradun", "Ernakulam", "Guwahati","Gurgaon", "Hyderabad", "Indore", "Jaipur", "Jalandhar","Jalgaon", "Kolkata","Kanpur","Lucknow","Ludhiana", "Mumbai","Mathura","Mysore","Nagpur", "New Delhi","Noida", "Pune", "Patna","Proddatur","Rajkot","Surat","Saharanpur","Thane","Siliguri","Thiruvananthpuram","Vadodara","Vishakhapatnam"};
String[] priorityCus ={"Select State","Ahmedabad","Allahabad", "Amritsar", "Bengaluru", "Bhopal", "Bhubaneswar", "Chandigarh", "Coimbatore", "Chennai", "Dehradun", "Ernakulam", "Guwahati","Gurgaon", "Hyderabad","Howrah", "Indore", "Jaipur", "Jalandhar","Jalgaon", "Kolkata","Kanpur","Lucknow","Ludhiana", "Mumbai","Mathura","Nagpur", "New Delhi","Noida", "Pune", "Patna","Proddatur","Rajkot","Surat","Saharanpur","Thane","Siliguri","Vadodara"};




//String[] priorityCus ={"Select State","Ahmedabad"1,"Allahabad"2, "Amritsar"3, "Bengaluru"4, "Bhopal"5, "Bhubaneswar"6, "Chandigarh"7, "Coimbatore"8, "Chennai"9, "Dehradun"10, "Ernakulam"11, "Guwahati"12,"Gurgaon"13, "Hyderabad"14,"Howrah"15, "Indore"16, "Jaipur"17, "Jalandhar"18,"Jalgaon",19 "Kolkata"20,"Kanpur"21,"Lucknow"22,"Ludhiana"23, "Mumbai"24,"Mathura"25,"Nagpur"26, "New Delhi"27,"Noida"28, "Pune"29, "Patna"30,"Proddatur"31,"Rajkot"32,"Surat"33,"Saharanpur"34,"Thane"35,"Siliguri"36,"Vadodara"37};


    String[] stateWise ={"Select State","Ahmedabad","Allahabad", "Amritsar", "Bangalore", "Bhopal", "Bhubaneswar", "Chandigarh", "Cochin / Ernakulam", "Coimbatore", "Chennai", "Cuttack", "Delhi", "Dehradun", "Guwahati","Gurgaon", "Hyderabad", "Indore", "Jaipur", "Jalandhar","Jalgaon", "Kolkata","Kanpur","Lucknow","Ludhiana", "Mumbai","Mathura","Mysore","Nagpur","Noida", "Pune", "Patna","Proddatur","Rajkot","Surat","Saharanpur","Siliguri","Thiruvananthpuram","Vadodara","Vishakhapatnam"};
    TextView stPTitle,stPremiumTitle,stPriorityTitle,stNo1Personal,sNo1Premim,sNo1Priority,sNo2Personal,sNo2Premium,sNo2Priority,orPersonal,orPremium,orPriority;
    ImageView stImagePersonal,stImagePremim,stImagePriority;
    LinearLayout lPresonal1,lPremium1,lPriority1,lPersonal2,lPremium2,lPriority2;
    int personalIndex;
    int premiumIndex;
    int priorityIndex;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_c);
        adView = new com.facebook.ads.AdView(StandardC.this, getString(R.string.banner_StandC), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_standardC1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(StandardC.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(StandardC.this,getString(R.string.interstitial_StandC));
        interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) { }
            @Override
            public void onInterstitialDismissed(Ad ad) { }
            @Override
            public void onError(Ad ad, AdError adError) { }
            @Override
            public void onAdLoaded(Ad ad) { }
            @Override
            public void onAdClicked(Ad ad) { }
            @Override
            public void onLoggingImpression(Ad ad) { }});
        interstitialAd.loadAd();
        spinnerPri = findViewById(R.id.prioritySpinner);
        ArrayAdapter arrayAdapterPri = new ArrayAdapter(StandardC.this,android.R.layout.simple_spinner_dropdown_item,priorityCus);
        spinnerPri.setAdapter(arrayAdapterPri);

        spinner = findViewById(R.id.standardS);
        ArrayAdapter arrayAdapter = new ArrayAdapter(StandardC.this,android.R.layout.simple_spinner_dropdown_item,stateWise);
        spinner.setAdapter(arrayAdapter);
        spinnerPre = findViewById(R.id.premiumSpinner);
        ArrayAdapter arrayAdapterPre = new ArrayAdapter(StandardC.this,android.R.layout.simple_spinner_dropdown_item,premiumCus);
        spinnerPre.setAdapter(arrayAdapterPre);
        stPTitle = findViewById(R.id.standardTitle);
        stNo1Personal = findViewById(R.id.StandardNo1);
        sNo2Personal = findViewById(R.id.citySc2);
        orPersonal = findViewById(R.id.orSC);
        lPresonal1 = findViewById(R.id.linearForS);
        lPersonal2 = findViewById(R.id.linearForS2);
        stImagePersonal = findViewById(R.id.cityStandard2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                personalIndex = i;

                if(i ==1){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);

                }
                else  if(i ==2){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==3){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==4){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==5){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==6){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==7){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==8){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==9){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==10){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==11){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==12){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==13){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==14){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==15){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 3940 4444");
                    sNo2Personal.setText("011 6601 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);

                }
                else  if(i ==16){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==17){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==18){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==19){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==20){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==21){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==22){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==23){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==24){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==25){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==26){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==27){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==28){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==29){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 3940 4444");
                    sNo2Personal.setText("011 6601 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==30){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==31){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==32){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==33){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==34){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==35){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==36){
                    stPTitle.setText("For "+stateWise[i]);
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                    stNo1Personal.setText("1800 345 5000");
                }
                else  if(i ==37){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else  if(i ==38){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("011 6601 4444");
                    sNo2Personal.setText("011 3940 4444");
                    orPersonal.setText("Or");
                    stImagePersonal.setImageResource(R.mipmap.call);
                }
                else  if(i ==39){
                    stPTitle.setText("For "+stateWise[i]);
                    stNo1Personal.setText("1800 345 1000 ");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }
                else{
                    stPTitle.setText("");
                    stNo1Personal.setText("");
                    sNo2Personal.setText("");
                    orPersonal.setText("");
                    stImagePersonal.setImageResource(0);
                }



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
lPresonal1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if((stPTitle.getText().toString().equals("For "+stateWise[personalIndex]))){
            String ph = stNo1Personal.getText().toString();
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
            startActivity(i);
        }
    }
});
lPersonal2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if((stPTitle.getText().toString().equals("For "+stateWise[personalIndex]))){
            String ph = stNo1Personal.getText().toString();
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
            startActivity(i);
        }
    }
});
        stPremiumTitle = findViewById(R.id.preTitle);
        sNo1Premim = findViewById(R.id.preNo1);
        sNo2Premium = findViewById(R.id.PreNo2);
        orPremium = findViewById(R.id.orPre) ;
        stImagePremim = findViewById(R.id.preImage2);
        lPremium1 = findViewById(R.id.linearForpre);
        lPremium2 = findViewById(R.id.linearpre2);

//        {"Select State","Ahmedabad"1,"Allahabad"2, "Amritsar"3, "Bengaluru"4, "Bhopal"5, "Bhubaneswar"6, "Chandigarh"7, "Coimbatore"8, "Chennai"9, "Cuttack"10, "Dehradun"11, "Ernakulam"12, "Guwahati"13,"Gurgaon"14, "Hyderabad"15, "Indore"16, "Jaipur"17, "Jalandhar"18,"Jalgaon"19, "Kolkata"20,"Kanpur"21,"Lucknow"22,"Ludhiana"23, "Mumbai"24,"Mathura"25,"Mysore"26,"Nagpur"27, "New Delhi"28,"Noida"29, "Pune"30, "Patna"31,"Proddatur"32,"Rajkot"33,"Surat"34,"Saharanpur"35,"Thane"36,"Siliguri"37,"Thiruvananthpuram"38,"Vadodara"39,"Vishakhapatnam"40};

        spinnerPre.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 premiumIndex = i;
                if(i ==1){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);

                }
                else  if(i ==2){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==3){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==4){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==5){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==6){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==7){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==8){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==9){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==10){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==11){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==12){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==13){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==14){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==15){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);

                }
                else  if(i ==16){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==17){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==18){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==19){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==20){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==21){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==22){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==23){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==24){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==25){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==26){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==27){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==28){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==29){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==30){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==31){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==32){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==33){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==34){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==35){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==36){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==37){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 345 5000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==38){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else  if(i ==39){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("011 6601 1500");
                    sNo2Premium.setText("011 3940 1500");
                    orPremium.setText("Or");
                    stImagePremim.setImageResource(R.mipmap.call);
                }
                else  if(i ==40){
                    stPremiumTitle.setText("For "+premiumCus[i]);
                    sNo1Premim.setText("1800 425 1000");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
                else{
                    stPremiumTitle.setText("");
                    sNo1Premim.setText("");
                    sNo2Premium.setText("");
                    orPremium.setText("");
                    stImagePremim.setImageResource(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lPremium1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((stPremiumTitle.getText().toString().equals("For "+premiumCus[premiumIndex]))){
                    String ph = sNo1Premim.getText().toString();
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                    startActivity(i);
                }
            }
        });
        lPremium2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((stPremiumTitle.getText().toString().equals("For "+premiumCus[premiumIndex]))){
                    String ph = sNo2Premium.getText().toString();
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                    startActivity(i);
                }
            }
        });
        stPriorityTitle = findViewById(R.id.priTitle);
        sNo1Priority = findViewById(R.id.priNo1);
        sNo2Priority = findViewById(R.id.PriNo2);
        orPriority = findViewById(R.id.orPri);
        stImagePriority = findViewById(R.id.priImage2);
        lPriority1 = findViewById(R.id.linearForpri);
        lPriority2 = findViewById(R.id.linearpri2);
        spinnerPri.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                priorityIndex = i;
                if(i ==1){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);

                }
                else  if(i ==2){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==3){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==4){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==5){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==6){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==7){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==8){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==9){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==10){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==11){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==12){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==13){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==14){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==15){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==16){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==17){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==18){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==19){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==20){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==21){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==22){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==23){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==24){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==25){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==26){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==27){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==28){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==29){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==30){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==31){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==32){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==33){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else  if(i ==34){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==35){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==36){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("1800 525 8390");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
                else  if(i ==37){
                    stPriorityTitle.setText("For "+priorityCus[i]);
                    sNo1Priority.setText("011 6601 2424");
                    sNo2Priority.setText("011 3940 2424");
                    orPriority.setText("Or");
                    stImagePriority.setImageResource(R.mipmap.call);
                }
                else{
                    stPriorityTitle.setText("");
                    sNo1Priority.setText("");
                    sNo2Priority.setText("");
                    orPriority.setText("");
                    stImagePriority.setImageResource(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lPriority1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((stPriorityTitle.getText().toString().equals("For "+priorityCus[priorityIndex]))) {
                    String ph = sNo1Priority.getText().toString();
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ph));
                    startActivity(i);
                }
            }
        });
        lPriority2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((stPriorityTitle.getText().toString().equals("For "+priorityCus[priorityIndex]))) {
                    String ph = sNo2Priority.getText().toString();
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + ph));
                    startActivity(i);
                }
            }
        });

        mNativeBannerAxis1= new NativeBannerAd(StandardC.this, getString(R.string.nativebannerStandC1));
        //623848994653940_626245771080929
        mNativeBannerAxis1.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
// Render the Native Banner Ad Template
                View adView1 = NativeBannerAdView.render(StandardC.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksstandardC1);
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
        mNativeBannerAxis1.loadAd();
        mNativeBannerAxis2= new NativeBannerAd(StandardC.this, getString(R.string.nativebannerStandC2));
        //623848994653940_626245771080929
        mNativeBannerAxis2.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
// Render the Native Banner Ad Template
                View adView1 = NativeBannerAdView.render(StandardC.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksstandardC2);
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
        mNativeBannerAxis2.loadAd();
    }

    public void webs(View view) {
        String url = "https://www.sc.com/in/";
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse(url));
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        }
    }

    public void contmail(View view) {
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);
        intent1.setData(Uri.parse("mailto:"));
        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"customer.care@sc.com"});
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        }
    }

    public void contmail1(View view) {
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);
        intent1.setData(Uri.parse("mailto:"));
        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"Priority.Banking@sc.com"});
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        }
    }
    @Override
    public void onBackPressed() {
        if (interstitialAd.isAdLoaded()) {
            interstitialAd.show();
            interstitialAd.setAdListener(new AbstractAdListener() {
                @Override
                public void onInterstitialDismissed(Ad ad) {
                    super.onInterstitialDismissed(ad);
                    finish();
                }}); }
        else {
            super.onBackPressed(); } }
    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy(); }
        if (interstitialAd != null) {
            interstitialAd.destroy(); }
        super.onDestroy();
    }
}
