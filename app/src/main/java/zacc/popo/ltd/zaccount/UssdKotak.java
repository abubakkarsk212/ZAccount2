package zacc.popo.ltd.zaccount;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
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

public class UssdKotak extends AppCompatActivity {
LinearLayout registerU,balC,sendM,miniS;
    String[] sendMethod = {"Mobile No","UPI Payment Address","IFSC,Account No"};
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussd_kotak);
        adView = new com.facebook.ads.AdView(UssdKotak.this, getString(R.string.banner_UssdSbi), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_kotakU1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(UssdKotak.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(UssdKotak.this,getString(R.string.interstitial_UssdSbi));
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

        registerU = findViewById(R.id.registerUKo);
        balC = findViewById(R.id.balUKo);
        sendM = findViewById(R.id.sendUKo);
        miniS = findViewById(R.id.miniSUKo);
        registerU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(UssdKotak.this);
                alert.setCancelable(false);
                alert.setTitle("Register for Ussd Banking");
                alert.setMessage("1) Select Language\n\n2)Type KKBK to fetch Kotak bank account details\n\n3)Set UPI Pin");
                alert.setPositiveButton("Do", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String ph0 = "*99"+ Uri.encode("#");
                        Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                        startActivity(i0);
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.show();
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
miniS.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String ph0 = "*99*6"+ Uri.encode("#");
        Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
        startActivity(i0);
    }
});
sendM.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(UssdKotak.this);
        alert.setTitle("Send Money Through");
        alert.setSingleChoiceItems(sendMethod, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i)
                {
                    case 0:
                        String ph0 = "*99*1*1"+ Uri.encode("#");
                        Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                        startActivity(i0);
                        break;
                    case 1:
                        // Your code when 2nd  option seletced
                        String ph6 = "*99*1*3"+Uri.encode("#");
                        Intent i6 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph6));
                        startActivity(i6);
                        break;
                    case 2:
                        // Your code when 2nd  option seletced
                        String ph2 = "*99*1*5"+Uri.encode("#");
                        Intent i2 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph2));
                        startActivity(i2);
                        break;


                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.show();
    }
});
        mNativeBannerAxis1= new NativeBannerAd(UssdKotak.this, getString(R.string.nativebannerUssdSbi1));
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
                View adView1 = NativeBannerAdView.render(UssdKotak.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankskotakU1);
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

        mNativeBannerAxis2= new NativeBannerAd(UssdKotak.this, getString(R.string.nativebannerUssdSbi2));
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
                View adView1 = NativeBannerAdView.render(UssdKotak.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankskotakU2);
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
