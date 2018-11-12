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

public class UssdBankingFederal extends AppCompatActivity {
    LinearLayout send,request,profile,pendingR,transaction,upiP;
    String[] sendMethod = {"Mobile No","Aadhar No","UPI Id","Saved Benificiary","IFSC,Account No"};
    String[] profileMethod = {"Change Bank Account","Change Language","My Details","UPI Id","Manage Beneficiary","I Am a Merchant","De-Register"};
    String[] upiMethod = {"Reset/Forget Upi Pin","Change Upi Pin"};
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussd_banking_federal);
        adView = new com.facebook.ads.AdView(UssdBankingFederal.this, getString(R.string.banner_UssdA), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_federalU1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(UssdBankingFederal.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(UssdBankingFederal.this,getString(R.string.interstitial_UssdA));
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

        send = findViewById(R.id.sendFederal);
        request = findViewById(R.id.reqF);
        profile = findViewById(R.id.profileF);
        pendingR = findViewById(R.id.pendingF);
        transaction = findViewById(R.id.transactionF);
        upiP = findViewById(R.id.upiF);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(UssdBankingFederal.this);
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
                                String ph6 = "*99*1*2"+Uri.encode("#");
                                Intent i6 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph6));
                                startActivity(i6);
                                break;
                            case 2:
                                // Your code when 2nd  option seletced
                                String ph1 = "*99*1*3"+Uri.encode("#");
                                Intent i1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph1));
                                startActivity(i1);
                                break;
                            case 3:
                                // Your code when 3rd option seletced
                                String ph3 = "*99*1*4"+Uri.encode("#");
                                Intent i3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph3));
                                startActivity(i3);
                                break;
                            case 4:
                                // Your code when 4th  option seletced
                                String ph4 = "*99*1*5"+Uri.encode("#");
                                Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph4));
                                startActivity(i4);
                                break;


                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.show();
            }
        });
        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph3 = "*99*2"+Uri.encode("#");
                Intent i3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph3));
                startActivity(i3);

            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(UssdBankingFederal.this);
                alert.setTitle("My Profile");
                alert.setSingleChoiceItems(profileMethod, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i)
                        {
                            case 0:
                                String ph0 = "*99*4*1"+Uri.encode("#");
                                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                                startActivity(i0);
                                break;
                            case 1:
                                // Your code when 2nd  option seletced
                                String ph1 = "*99*4*2"+Uri.encode("#");
                                Intent i1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph1));
                                startActivity(i1);
                                break;
                            case 2:
                                // Your code when 3rd option seletced
                                String ph3 = "*99*4*3"+Uri.encode("#");
                                Intent i3 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph3));
                                startActivity(i3);
                                break;
                            case 3:
                                // Your code when 4th  option seletced
                                String ph4 = "*99*4*4"+Uri.encode("#");
                                Intent i4 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph4));
                                startActivity(i4);
                                break;
                            case 4:
                                // Your code when 4th  option seletced
                                String ph5 = "*99*4*5"+Uri.encode("#");
                                Intent i5 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph5));
                                startActivity(i5);
                                break;
                            case 5:
                                // Your code when 4th  option seletced
                                String ph6 = "*99*4*6"+Uri.encode("#");
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
        pendingR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph5 = "*99*5"+Uri.encode("#");
                Intent i5 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph5));
                startActivity(i5);
            }
        });
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph5 = "*99*6"+Uri.encode("#");
                Intent i5 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph5));
                startActivity(i5);
            }
        });
        upiP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert = new AlertDialog.Builder(UssdBankingFederal.this);
                alert.setTitle("UPI Pin Setting");
                alert.setSingleChoiceItems(upiMethod, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i)
                        {
                            case 0:
                                String ph0 = "*99*7*1"+Uri.encode("#");
                                Intent i0 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph0));
                                startActivity(i0);
                                break;
                            case 1:
                                // Your code when 2nd  option seletced
                                String ph1 = "*99*7*2"+Uri.encode("#");
                                Intent i1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph1));
                                startActivity(i1);
                                break;


                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.show();
            }
        });
        mNativeBannerAxis1= new NativeBannerAd(UssdBankingFederal.this, getString(R.string.nativebannerUssdA1));
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
                View adView1 = NativeBannerAdView.render(UssdBankingFederal.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksfederalU1);
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

        mNativeBannerAxis2= new NativeBannerAd(UssdBankingFederal.this, getString(R.string.nativebannerUssdA2));
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
                View adView1 = NativeBannerAdView.render(UssdBankingFederal.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksfederalU2);
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
