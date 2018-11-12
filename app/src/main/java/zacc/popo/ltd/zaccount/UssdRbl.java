package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;

public class UssdRbl extends AppCompatActivity {
LinearLayout checkB,miniS,transfer,changePin;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussd_rbl);
        adView = new com.facebook.ads.AdView(UssdRbl.this, getString(R.string.banner_UssdRbl), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_rblU1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(UssdRbl.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(UssdRbl.this,getString(R.string.interstitial_UssdRbl));
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
        checkB = findViewById(R.id.balRblU);
        miniS = findViewById(R.id.miniRlU);
        transfer = findViewById(R.id.sendRblU);
        changePin = findViewById(R.id.changeRblU);

        checkB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph0 = "*99*79*1"+ Uri.encode("#");
                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                startActivity(i0);
            }
        });
        miniS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph0 = "*99*79*2"+ Uri.encode("#");
                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                startActivity(i0);
            }
        });
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph0 = "*99*79*4"+ Uri.encode("#");
                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                startActivity(i0);
            }
        });
        changePin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph0 = "*99*79*7"+ Uri.encode("#");
                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                startActivity(i0);
            }
        });
        mNativeBannerAxis1= new NativeBannerAd(UssdRbl.this, getString(R.string.nativebannerUssdRbl1));
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
                View adView1 = NativeBannerAdView.render(UssdRbl.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksrblU1);
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

        mNativeBannerAxis2= new NativeBannerAd(UssdRbl.this, getString(R.string.nativebannerUssdRbl2));
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
                View adView1 = NativeBannerAdView.render(UssdRbl.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksrblU2);
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
