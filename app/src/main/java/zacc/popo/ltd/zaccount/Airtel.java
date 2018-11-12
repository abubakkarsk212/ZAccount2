package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.Snackbar;
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

public class Airtel extends AppCompatActivity {
    private static final String TAG = "Airtel";
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airtel);
        adView = new com.facebook.ads.AdView(Airtel.this, getString(R.string.airtel_banner_fb), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_container);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(Airtel.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show();
            }



        });
        adView.loadAd();
interstitialAd =new com.facebook.ads.InterstitialAd(Airtel.this,getString(R.string.airtel_int_fb));
interstitialAd.setAdListener(new InterstitialAdListener() {
    @Override
    public void onInterstitialDisplayed(Ad ad) {
    }
    @Override
    public void onInterstitialDismissed(Ad ad) {
    }
    @Override
    public void onError(Ad ad, AdError adError) {
    }
    @Override
    public void onAdLoaded(Ad ad) {
    }
    @Override
    public void onAdClicked(Ad ad) {
    }
    @Override
    public void onLoggingImpression(Ad ad) {
    }
});
interstitialAd.loadAd();

        mNativeBannerAxis1= new NativeBannerAd(Airtel.this, getString(R.string.nativebannerAirtelB1));
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
                View adView1 = NativeBannerAdView.render(Airtel.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksairtelB1);
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
        mNativeBannerAxis2= new NativeBannerAd(Airtel.this, getString(R.string.nativebannerAirtelB2));
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
                View adView1 = NativeBannerAdView.render(Airtel.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksairtelB2);
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
    public void airtel_install(View view){
        try{
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse("market://details?id=com.myairtelapp"));
            startActivity(i);
        }catch(Exception e){
            Intent i = new Intent(Intent.ACTION_VIEW);
            //It will open a browser
            i.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.myairtelapp"));
            startActivity(i); }
    }
    public void airtel_open(View view){
        Intent i =getPackageManager().getLaunchIntentForPackage("com.myairtelapp");
        if(i !=null){
            startActivity(i);
        }
        else{
            Snackbar.make(view, "Application not found", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
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
                }
    });
        }
    else { super.onBackPressed();}
    }
    @Override
    protected void onDestroy() {
        if (adView != null) {
            adView.destroy();
        }
        if (interstitialAd != null) {
            interstitialAd.destroy();
        }
        super.onDestroy(); }
}
