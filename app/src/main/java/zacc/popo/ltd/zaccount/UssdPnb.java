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

public class UssdPnb extends AppCompatActivity {
    LinearLayout registerU,balC,sendM,changeP;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussd_pnb);
        adView = new com.facebook.ads.AdView(UssdPnb.this, getString(R.string.banner_UssdA), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_pnbU1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(UssdPnb.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(UssdPnb.this,getString(R.string.interstitial_UssdA));
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

        registerU = findViewById(R.id.registerUPn);
        balC = findViewById(R.id.balUPn);
        sendM = findViewById(R.id.sendUPn);
        changeP = findViewById(R.id.miniSUPn);
        registerU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph0 = "*99*4*1*42"+ Uri.encode("#");
                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                startActivity(i0);
            }
        });
        balC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph0 = "*99*3"+ Uri.encode("#");
                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                startActivity(i0);
            }
        });
        sendM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph0 = "*99*1"+ Uri.encode("#");
                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                startActivity(i0);
            }
        });
        changeP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph0 = "*99*7"+ Uri.encode("#");
                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                startActivity(i0);
            }
        });

        mNativeBannerAxis1= new NativeBannerAd(UssdPnb.this, getString(R.string.nativebannerUssdA1));
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
                View adView1 = NativeBannerAdView.render(UssdPnb.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankspnbU1);
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

        mNativeBannerAxis2= new NativeBannerAd(UssdPnb.this, getString(R.string.nativebannerUssdA2));
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
                View adView1 = NativeBannerAdView.render(UssdPnb.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankspnbU2);
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
