package zacc.popo.ltd.zaccount;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
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

public class UssdAxis extends AppCompatActivity {
LinearLayout checkBal,miniS,sendU,mmidA,genMpin,changeMpin,genOtp;
    String[] sendMethod = {"MMID and Mobile Number","Account Number and IFSC"};
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussd_axis);
        adView = new com.facebook.ads.AdView(UssdAxis.this, getString(R.string.banner_UssdA), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_axisU);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(UssdAxis.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(UssdAxis.this,getString(R.string.interstitial_UssdA));
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

        checkBal = findViewById(R.id.balAxU);
        miniS = findViewById(R.id.miniAxU);
        sendU = findViewById(R.id.sendAx);
        mmidA = findViewById(R.id.mmidAxU);
        genMpin = findViewById(R.id.genMpinAxU);
        changeMpin = findViewById(R.id.changeAxU);
        genOtp = findViewById(R.id.generateAxU);
        checkBal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph4 = " *99*45*1"+ Uri.encode("#");
                Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph4));
                startActivity(i4);
            }
        });
        miniS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph4 = " *99*45*2"+ Uri.encode("#");
                Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph4));
                startActivity(i4);
            }
        });
        sendU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(UssdAxis.this);
                alert.setTitle("Send Money Through");
                alert.setSingleChoiceItems(sendMethod, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i)
                        {
                            case 0:
                                String ph0 = "*99*45*3"+ Uri.encode("#");
                                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                                startActivity(i0);
                                break;
                            case 1:
                                // Your code when 2nd  option seletced
                                String ph6 = "*99*45*4"+Uri.encode("#");
                                Intent i6 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph6));
                                startActivity(i6);
                                break;



                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.show();
            }
        });
        mmidA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph4 = " *99*45*6"+ Uri.encode("#");
                Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph4));
                startActivity(i4);
            }
        });
        genMpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph4 = " *99*45*7*1"+ Uri.encode("#");
                Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph4));
                startActivity(i4);
            }
        });
       changeMpin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph4 = " *99*45*7*2"+ Uri.encode("#");
                Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph4));
                startActivity(i4);
            }
        });
       genOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph4 = " *99*45*8"+ Uri.encode("#");
                Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph4));
                startActivity(i4);
            }
        });
        mNativeBannerAxis1= new NativeBannerAd(UssdAxis.this, getString(R.string.nativebannerUssdA1));
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
                View adView1 = NativeBannerAdView.render(UssdAxis.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksaxisU1);
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

        mNativeBannerAxis2= new NativeBannerAd(UssdAxis.this, getString(R.string.nativebannerUssdA2));
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
                View adView1 = NativeBannerAdView.render(UssdAxis.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksaxisU2);
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
