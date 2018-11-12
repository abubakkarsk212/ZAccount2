package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class IciciC extends AppCompatActivity {
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2,mNativeBannerAxis3;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    Spinner spinner,spinnerPrivate,spinnerBusi;
    ImageView cityI2,cityBusi2;
    TextView no1,no2,orCity,cityT,noPr1,cityPT,noBusi1,noBusi2,orBusi,busiT;
    LinearLayout ll,ll1,lPri1,lBusi1,lBusi2;
    int indexp,indexPrivate,indexBusiness;
    String[] stateWise ={"Select State","Andhra Pradesh","Assam","Ahmedabad","Bihar","Bangalore","Bhopal","Bhubaneswar","Chandigarh","Chennai","Chattisgarh","Dehradun","Delhi","Ernakulam","Goa","Gujarat","Gurgaon","Haryana","Himachal Pradesh","Hyderabad","Jammu & Kashmir","Jharkhand","Jaipur","Karnataka","Kerala","Kolkata","Lucknow","Madhya Pradesh","Mumbai","Maharastra","Orissa","Punjab","Panaji","Patna","Rajasthan","Raipur","Ranchi","Shimla","Tamilnadu","Telangana","Uttarakhand","Uttar Pradesh","West Bengal"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icici_c);
        adView = new com.facebook.ads.AdView(IciciC.this, getString(R.string.banner_IciciC), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_iciciC1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(IciciC.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(IciciC.this,getString(R.string.interstitial_IciciC));
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

        spinner = findViewById(R.id.stateWiseS);
        spinnerPrivate = findViewById(R.id.stateWisePrivateS);
        spinnerBusi = findViewById(R.id.stateWiseBusiS);
        ArrayAdapter arrayAdapterBusiness = new ArrayAdapter(IciciC.this,android.R.layout.simple_spinner_dropdown_item,stateWise);
        ArrayAdapter arrayAdapterPrivate = new ArrayAdapter(IciciC.this,android.R.layout.simple_spinner_dropdown_item,stateWise);
        ArrayAdapter arrayAdapter = new ArrayAdapter(IciciC.this,android.R.layout.simple_spinner_dropdown_item,stateWise);
        spinner.setAdapter(arrayAdapter);
        spinnerPrivate.setAdapter(arrayAdapterPrivate);
        spinnerBusi.setAdapter(arrayAdapterBusiness);
//        mInterstitial = new InterstitialAd(this);
//        mInterstitial.setAdUnitId(getResources().getString((R.string.bankC_interstitial)));
//        AdRequest ad = new AdRequest.Builder().build();
//        mInterstitial.loadAd(ad);
//
//        mAdView = (AdView) findViewById(R.id.adViewcontact);
//        AdRequest adRequest1 = new AdRequest.Builder().build();
//        mAdView.loadAd(adRequest1);
//        mAdView.setAdListener(new AdListener() {
//            @Override
//            public void onAdFailedToLoad(int errorCode) {
//                Toast.makeText(getApplicationContext(), "No internet connection", Toast.LENGTH_SHORT).show();
//                super.onAdFailedToLoad(errorCode);
//            }
//        });
        cityI2 = findViewById(R.id.cityImage2);
        no1 = findViewById(R.id.cityNo1);
        no2 = findViewById(R.id.cityNo2);
        orCity = findViewById(R.id.orC);
        cityT = findViewById(R.id.cityTitle);
        ll =findViewById(R.id.linearForC);
        ll1 =findViewById(R.id.linearNo2);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexp = i;
                if(i ==1){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("7306667777");

                }
                else  if(i ==2){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9864667777");
                }
                else  if(i ==3){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("07933667777");
                    no2.setText("07944455000");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==4){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("8102667777");
                }
                else  if(i ==5){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("08033667777");
                    no2.setText("08044455000");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==6){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("07553366777");
                }
                else  if(i ==7){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("06743366777");
                }
                else  if(i ==8){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("01723366777");
                    no2.setText("01724445500");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==9){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("04433667777");
                    no2.setText(" 04444455000");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==10){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9098667777");
                }
                else  if(i ==11){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("01353366777");
                }
                else  if(i ==12){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("01133667777");
                    no2.setText("01144455000");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==13){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("04843366777");
                }
                else  if(i ==14){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9021667777");
                }
                else  if(i ==15){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("8000667777");
                }
                else  if(i ==16){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("01243366777");
                    no2.setText("01244445500");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==17){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9017667777");
                }
                else  if(i ==18){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9817667777");
                }
                else  if(i ==19){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("04033667777");
                    no2.setText("04044455000");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==20){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9018667777");
                }
                else  if(i ==21){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("8102667777");
                }
                else  if(i ==22){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("01413366777");
                    no2.setText("01414445500");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==23){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("8088667777");
                }
                else  if(i ==24){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9020667777");
                }
                else  if(i ==25){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("03333667777");
                    no2.setText("03344455000");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==26){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("05223366777");
                    no2.setText("05224445500");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==27){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9098667777");
                }
                else  if(i ==28){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("02233667777");
                    no2.setText("02244455000");
                    orCity.setText("OR");
                    cityI2.setImageResource(R.mipmap.call);
                }
                else  if(i ==29){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9021667777");
                }
                else  if(i ==30){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("9692667777");
                }
                else  if(i ==31){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("7307667777");
                }
                else  if(i ==32){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("08323366777");
                }
                else  if(i ==33){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("06123366777");
                }
                else  if(i ==34){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("7877667777");
                }
                else  if(i ==35){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("07713366777");
                }
                else  if(i ==36){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("06513344339");
                }
                else  if(i ==37){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("01773366777");
                }
                else  if(i ==38){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("7305667777");
                }
                else  if(i ==39){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("7306667777");
                }
                else  if(i ==40){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("8081667777");
                }
                else  if(i ==41){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("8081667777");
                }
                else  if(i ==42){
                    cityT.setText("For "+stateWise[i]);
                    no1.setText("8101667777");
                }
                else{
                    cityT.setText("");
                    no2.setText("");
                    no1.setText("");
                    orCity.setText("");
                    cityI2.setImageResource(0);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    ll.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if((cityT.getText().toString().equals("For "+stateWise[indexp]))){
                String ph = no1.getText().toString();
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        }
    });
    ll1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if((cityT.getText().toString().equals("For "+stateWise[indexp]))){
                String ph = no2.getText().toString();
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        }
    });
        noPr1 = findViewById(R.id.privatecityNo1);
        cityPT = findViewById(R.id.privateTitle);
        lPri1 = findViewById(R.id.linearForPrivate1);
        spinnerPrivate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexPrivate = i;
                if(i ==1){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("7306443399");

                }
                else  if(i ==2){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("9864443399");
                }
                else  if(i ==3){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("07933443399");
                }
                else  if(i ==4){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8102443399");
                }
                else  if(i ==5){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("08033443399");
                }
                else  if(i ==6){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("07553344339");
                }
                else  if(i ==7){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("06743344339");
                }
                else  if(i ==8){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("01723344339");
                }
                else  if(i ==9){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("04433443399");
                }
                else  if(i ==10){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8103443399");
                }
                else  if(i ==11){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("01353344339");
                }
                else  if(i ==12){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("01133443399");
                }
                else  if(i ==13){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("04843344339");
                }
                else  if(i ==14){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("7304443399");
                }
                else  if(i ==15){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8306443399");
                }
                else  if(i ==16){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("01243344339");
                }
                else  if(i ==17){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("9017443399");
                }
                else  if(i ==18){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("9817443399");
                }
                else  if(i ==19){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("04033443399");
                }
                else  if(i ==20){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("9018443399");
                }
                else  if(i ==21){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8102443399");
                }
                else  if(i ==22){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("01413344339");
                }
                else  if(i ==23){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8088443399");
                }
                else  if(i ==24){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("9020443399");
                }
                else  if(i ==25){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("03333443399");
                }
                else  if(i ==26){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("05223344339");
                }
                else  if(i ==27){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8103443399");
                }
                else  if(i ==28){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("02233443399");
                }
                else  if(i ==29){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("7304443399");
                }
                else  if(i ==30){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("7735443399");
                }
                else  if(i ==31){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("7307443399");
                }
                else  if(i ==32){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("08323344339");
                }
                else  if(i ==33){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("06123344339");
                }
                else  if(i ==34){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8955443399");
                }
                else  if(i ==35){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("07713344339");
                }
                else  if(i ==36){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("06513344339");
                }
                else  if(i ==37){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("01773344339");
                }
                else  if(i ==38){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("9025443399");
                }
                else  if(i ==39){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("7306443399");
                }
                else  if(i ==40){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8303443399");
                }
                else  if(i ==41){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("8303443399");
                }
                else  if(i ==42){
                    cityPT.setText("For "+stateWise[i]);
                    noPr1.setText("9832443399");
                }
                else{
                    cityPT.setText("");
                   noPr1.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
lPri1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        if((cityPT.getText().toString().equals("For "+stateWise[indexPrivate]))){
            String ph = noPr1.getText().toString();
            Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
            startActivity(i);
        }
    }
});

        noBusi1 = findViewById(R.id.cityBusiNo1);
        noBusi2 = findViewById(R.id.cityNoBusi2);
        orBusi = findViewById(R.id.orBusiC);
        busiT = findViewById(R.id.cityBusiTitle);
        lBusi1 = findViewById(R.id.linearBusiC);
        lBusi2 = findViewById(R.id.linearBusiNo2);
        cityBusi2 = findViewById(R.id.cityImageBusi2);
        spinnerBusi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexBusiness = i;
                if(i ==1){
                 busiT.setText("For "+stateWise[i]);
                 noBusi1.setText("7306446699");
                }
                else  if(i ==2){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("8822446699");
                }
                else  if(i ==3){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("07933446699");
                }
                else  if(i ==4){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("8102446699");
                }
                else  if(i ==5){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("08033446699");
                    noBusi2.setText("08044456000");
                    cityBusi2.setImageResource(R.mipmap.call);
                }
                else  if(i ==6){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("07553344669");
                    noBusi2.setText("07554445600");
                    cityBusi2.setImageResource(R.mipmap.call);
                }
                else  if(i ==7){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("06743344669");
                }
                else  if(i ==8){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("01723344669");
                    noBusi2.setText("01724445600");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==9){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("04433446699");
                    noBusi2.setText("04444456000");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==10){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("7879446699");
                }
                else  if(i ==11){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("01353344669");
                }
                else  if(i ==12){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("01133446699");
                    noBusi2.setText("01144456000");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==13){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("04843344669");
                }
                else  if(i ==14){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("7304446699");
                }
                else  if(i ==15){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("8690446699");

                }
                else  if(i ==16){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("01243344669");
                    noBusi2.setText("01244445600");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==17){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("9541446699");
                }
                else  if(i ==18){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("9625446699");
                }
                else  if(i ==19){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("04033446699");
                    noBusi2.setText("04044456000");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==20){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("9018446699");
                }
                else  if(i ==21){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("8102446699");
                }
                else  if(i ==22){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("01413344669");
                    noBusi2.setText("01414445600");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==23){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("9019446699");
                }
                else  if(i ==24){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("8590446699");
                }
                else  if(i ==25){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("03333446699");
                    noBusi2.setText("03344456000");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==26){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("05223344669");
                }
                else  if(i ==27){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("7879446699");
                }
                else  if(i ==28){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("02233446699");
                    noBusi2.setText("02244456000");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==29){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("7304446699");
                }
                else  if(i ==30){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("9778446699");
                }
                else  if(i ==31){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("9023446699");
                }
                else  if(i ==32){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("08323344669");
                }
                else  if(i ==33){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("06123344669");
                }
                else  if(i ==34){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("9529446699");
                }
                else  if(i ==35){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("07713344669");
                    noBusi2.setText("07714445600");
                    cityBusi2.setImageResource(R.mipmap.call);

                }
                else  if(i ==36){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("06513344669");
                }
                else  if(i ==37){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("01773344669");
                }
                else  if(i ==38) {
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("8695446699");
                }
                else  if(i ==39){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("7306446699");
                }
                else  if(i ==40){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("8303446699");
                }
                else  if(i ==41){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("8303446699");
                }
                else  if(i ==42){
                    busiT.setText("For "+stateWise[i]);
                    noBusi1.setText("9641446699");
                }
                else{
                    busiT.setText("");
                    noBusi1.setText("");
                    noBusi2.setText("");
                    cityBusi2.setImageResource(0);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lBusi1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((busiT.getText().toString().equals("For "+stateWise[indexBusiness]))){
                    String ph = noBusi1.getText().toString();
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                    startActivity(i);
                }
            }
        });
        lBusi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((busiT.getText().toString().equals("For "+stateWise[indexBusiness]))){
                    String ph = noBusi2.getText().toString();
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                    startActivity(i);
                }
            }
        });


        LinearLayout l1 =findViewById(R.id.c1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "18002003344";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        LinearLayout l2 =findViewById(R.id.c2);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "18001038181";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });

        mNativeBannerAxis1= new NativeBannerAd(IciciC.this, getString(R.string.nativebannerIciciC1));
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
                View adView1 = NativeBannerAdView.render(IciciC.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksiciciC1);
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
        mNativeBannerAxis2= new NativeBannerAd(IciciC.this, getString(R.string.nativebannerIciciC2));
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
                View adView1 = NativeBannerAdView.render(IciciC.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksiciciC2);
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
        mNativeBannerAxis3= new NativeBannerAd(IciciC.this, getString(R.string.nativebannerIciciC3));
        //623848994653940_626245771080929
        mNativeBannerAxis3.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
// Render the Native Banner Ad Template
                View adView1 = NativeBannerAdView.render(IciciC.this, mNativeBannerAxis3, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksiciciC3);
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
        mNativeBannerAxis3.loadAd();
    }
    public void contmail(View view) {
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);
        intent1.setData(Uri.parse("mailto:"));
        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"care@icicibank.com"});
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        }
    }
    public void webs(View view) {
        String url = "https://www.icicibank.com/";
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse(url));
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
        super.onDestroy(); }
}
