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

public class KotakC extends AppCompatActivity {

    Spinner spinner;
    TextView no1,kotaktitle;
    LinearLayout lineraLay;
    String[] states ={"Select State","Ahmedabad","Bangalore","Chennai","Hyderabad","Mumbai","New Delhi","Pune"};
    int indexK;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak_c);
        adView = new com.facebook.ads.AdView(KotakC.this, getString(R.string.banner_KotakBS), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_kotakC1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(KotakC.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(KotakC.this,getString(R.string.interstitial_KotakBS));
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

        spinner = findViewById(R.id.kotakStateWise);
        ArrayAdapter arrayAdapter = new ArrayAdapter(KotakC.this,android.R.layout.simple_spinner_dropdown_item,states);
        spinner.setAdapter(arrayAdapter);

        no1 = findViewById(R.id.kotakNo);
        kotaktitle = findViewById(R.id.kotakTitle);
        lineraLay = findViewById(R.id.kotakLinear);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                indexK = i;
                if(i ==1){
                    kotaktitle.setText("For "+states[i]);
                    no1.setText("07966006022");

                }
                else  if(i ==2){
                    kotaktitle.setText("For "+states[i]);
                    no1.setText("08066006022");
                }
                else  if(i ==3){
                    kotaktitle.setText("For "+states[i]);
                    no1.setText("04466006022");
                }
                else  if(i ==4){
                    kotaktitle.setText("For "+states[i]);
                    no1.setText("04066006022");
                }
                else  if(i ==5){
                    kotaktitle.setText("For "+states[i]);
                    no1.setText("02266006022");
                }
                else  if(i ==6){
                    kotaktitle.setText("For "+states[i]);
                    no1.setText("01166006022");
                }
                else  if(i ==7){
                    kotaktitle.setText("For "+states[i]);
                    no1.setText("02066006022");
                }
                else {
                    no1.setText("");
                    kotaktitle.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lineraLay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((kotaktitle.getText().toString().equals("For "+states[indexK]))){
                    String ph = no1.getText().toString();
                    Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                    startActivity(i);
                }
            }
        });

        LinearLayout l1 = (LinearLayout)findViewById(R.id.c1);
        l1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "18602662666";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        LinearLayout l2 = findViewById(R.id.cnew);
        l2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "18602660811";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        mNativeBannerAxis1= new NativeBannerAd(KotakC.this, getString(R.string.nativebannerKotakBS1));
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
                View adView1 = NativeBannerAdView.render(KotakC.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankskotakC1);
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
        mNativeBannerAxis2= new NativeBannerAd(KotakC.this, getString(R.string.nativebannerKotakBS2));
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
                View adView1 = NativeBannerAdView.render(KotakC.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankskotakC2);
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
        String url = "http://www.kotak.com/";
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse(url));
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        }
    }
    public void contmail(View view) {
        String url = "https://www.kotak.com/en/customer-service/contact-us/email-us/kotak-mahindra-bank/other.html";
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
