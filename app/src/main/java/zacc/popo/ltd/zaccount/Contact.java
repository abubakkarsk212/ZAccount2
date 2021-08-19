package zacc.popo.ltd.zaccount;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.view.View;
import android.widget.Toast;
import com.adcolony.sdk.AdColonyInterstitial;
import com.adcolony.sdk.AdColonyInterstitialListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class Contact extends AppCompatActivity {
    AdView mAdView;
    InterstitialAd mInterstitialAd;
    private AdColonyInterstitial adInt;
    private AdColonyInterstitialListener listener;
    private String uniqueID;
//    RelativeLayout bannerRl;
//    private AdColonyAdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
//        bannerRl = findViewById(R.id.banner_contact);
//        uniqueID = UUID.randomUUID().toString();
//        AdColonyAppOptions appOptions = new AdColonyAppOptions()
//                .setUserID(uniqueID)
//                .setKeepScreenOn(true)
//                .setPrivacyFrameworkRequired(AdColonyAppOptions.GDPR, true)
//                .setPrivacyConsentString(AdColonyAppOptions.GDPR, "1");
//        AdColony.configure(this,appOptions, "app9cb7c36dfb16449291", "vz6d3b758402324199a5");
//        AdColony.configure(this, "app9cb7c36dfb16449291", "vz1f934303b71742e689");

        //banner
//        AdColonyAdViewListener bListener = new AdColonyAdViewListener() {
//            @Override
//            public void onRequestFilled(AdColonyAdView ad) {
//                /** Add this ad object to whatever layout you have set up for this placement */
//                bannerRl.addView(ad);
//                adView = ad;
//            }
//        };
//
//        AdColony.requestAdView("vz1f934303b71742e689", bListener, AdColonyAdSize.BANNER);

        //AdColony interstitial ads
//        listener = new AdColonyInterstitialListener() {
//            @Override
//            public void onRequestFilled(AdColonyInterstitial ad) {
//                adInt = ad;
//                // Ad passed back in request filled callback, ad can now be shown
//                Toast.makeText(Contact.this, "Ad Request Filled", Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onRequestNotFilled(AdColonyZone zone) {
//                // Ad request was not filled
//                Toast.makeText(Contact.this, zone.getZoneID(), Toast.LENGTH_SHORT).show();
//
//            }
//
//            @Override
//            public void onOpened(AdColonyInterstitial ad) {
//                // Ad opened, reset UI to reflect state change
//
//            }
//
//            @Override
//            public void onExpiring(AdColonyInterstitial ad) {
//                // Request a new ad if ad is expiring
//
//                AdColony.requestInterstitial("vz6d3b758402324199a5", this);
//
//            }
//        };
//        AdColony.requestInterstitial( "vz6d3b758402324199a5", listener );


        mAdView = findViewById(R.id.adViewContact);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId(getString(R.string.contactInt));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });




    }
    public void contmail(View view) {
        Intent intent1 = new Intent(Intent.ACTION_SENDTO);
        intent1.setData(Uri.parse("mailto:"));
        intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"helpybookapp@gmail.com"});
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        } }
    public void whatsapp(View view) {
        String smsNumber = "918700600109";
        boolean isWhatsAppInstalled =true;
        if(isWhatsAppInstalled){
            Intent intent1 = new Intent("android.intent.action.MAIN");
            intent1.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            intent1.putExtra("jid", PhoneNumberUtils.stripSeparators(smsNumber)+"@s.whatsapp.net");
            if (intent1.resolveActivity(getPackageManager()) != null) {
                startActivity(intent1); }
            else {
                Uri uri = Uri.parse("market://details?id=com.whatsapp");
                Intent goToMarket = new Intent(Intent.ACTION_VIEW,uri);
                Toast.makeText(this,"WhatsApp is not installed",Toast.LENGTH_SHORT).show();
                startActivity(goToMarket); } }
    }
    @Override
    public void onBackPressed() {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
            mInterstitialAd.setAdListener(new AdListener() {
                @Override
                public void onAdClosed() {
                    super.onAdClosed();
                    finish();
                }
            });
        }else{
            super.onBackPressed();
        }
}
    @Override
    protected void onDestroy() {
//        if (adInt != null || adView!= null) {
//            adInt.destroy();
//            adView.destroy();
//        }

        super.onDestroy();
    }
}
