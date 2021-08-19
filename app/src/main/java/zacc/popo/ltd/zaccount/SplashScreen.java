package zacc.popo.ltd.zaccount;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.adcolony.sdk.AdColony;
import com.adcolony.sdk.AdColonyAppOptions;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks;
import com.google.firebase.dynamiclinks.PendingDynamicLinkData;
import java.util.UUID;


public class SplashScreen extends AppCompatActivity {
    Uri deepLink;
    String adIdss;
    int flagAd;
    Dialog errorDialog;
    String channelId;
    String type;
    String title;
    private String uniqueID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        uniqueID = UUID.randomUUID().toString();
        AdColonyAppOptions appOptions = new AdColonyAppOptions()
                .setUserID(uniqueID)
                .setKeepScreenOn(true)
                .setPrivacyFrameworkRequired(AdColonyAppOptions.GDPR, true)
                .setPrivacyConsentString(AdColonyAppOptions.GDPR, "1");



        AdColony.configure(this,appOptions, "app9cb7c36dfb16449291", "vzfb252ff6604a4966a0","vzf6668899a72f4188ab","vzd552037d46f4489697","vz6d3b758402324199a5","vz1f934303b71742e689","vzc4ccf5385467492e84","vz81899a837c744aa782","vz63e818dfae9a4df8a0");

        if(getIntent().getExtras() != null){
        for (String key : getIntent().getExtras().keySet()) {
            channelId = getIntent().getExtras().getString("channelid");
            adIdss = getIntent().getExtras().getString("bankid");
            type = getIntent().getExtras().getString("type");
            title = getIntent().getExtras().getString("title");
            if(getIntent().getExtras().getString("flag") != null) {
                flagAd = Integer.parseInt(getIntent().getExtras().getString("flag"));
            }
        }
        }

        FirebaseDynamicLinks.getInstance()
                .getDynamicLink(getIntent())
                .addOnSuccessListener(SplashScreen.this, new OnSuccessListener<PendingDynamicLinkData>() {
                    @Override
                    public void onSuccess(PendingDynamicLinkData pendingDynamicLinkData) {
                        // Get deep link from result (may be null if no link is found)
                        deepLink = null;
                        if (pendingDynamicLinkData != null) {
                            deepLink = pendingDynamicLinkData.getLink();
                            int len = deepLink.toString().length();
                            if(deepLink != null){
                                adIdss =deepLink.toString().replace("https://zaccount.page/","");
                                flagAd = Integer.parseInt(deepLink.toString().charAt(len-1)+"");
                                adIdss = adIdss.replace(flagAd+"","");
                                Log.d("Splash Screen","Deeplink-"+adIdss);
                                Log.d("Splash Screen","Deeplink-"+flagAd);

                            }


                        }


                        // Handle the deep link. For example, open the linked
                        // content, or apply promotional credit to the user's
                        // account.
                        // ...

                        // ...
                    }
                })
                .addOnFailureListener(SplashScreen.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(5000);
                    //is it first time sharedpref for language selector
                    SharedPreferences sharedPref = getSharedPreferences(getString(R.string.shared_pref), Context.MODE_PRIVATE);
                    int r = sharedPref.getInt("isFirst",-1);
                    if(r == -1){
                        Intent i = new Intent(SplashScreen.this, ChooseLanguage.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        i.putExtra("isMain","0");
                        startActivity(i);
                        finish();
                    }else {
                        Intent i = new Intent(SplashScreen.this, MainActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        if (deepLink != null) {
                            i.putExtra("keydeep", adIdss);
                            i.putExtra("flagdeep", flagAd);
                        }

                        if (getIntent().getExtras() != null) {
                            i.putExtra("key", adIdss);
                            i.putExtra("flag", flagAd);
                            i.putExtra("channel", channelId);
                            i.putExtra("type", type);
                            i.putExtra("title", title);

                        }

                        //Do the task, pending
                        if (checkPlayServices()) {
                            startActivity(i);
                            finish();
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        };
        t.start();
    }
    @Override
    protected void onResume() {


            super.onResume();
    }
    private boolean checkPlayServices() {

        GoogleApiAvailability googleApiAvailability = GoogleApiAvailability.getInstance();

        int resultCode = googleApiAvailability.isGooglePlayServicesAvailable(this);

        if (resultCode != ConnectionResult.SUCCESS) {
            if (googleApiAvailability.isUserResolvableError(resultCode)) {

                if (errorDialog == null) {
                    errorDialog = googleApiAvailability.getErrorDialog(this, resultCode, 2404);
                    errorDialog.setCancelable(false);
                }

                if (!errorDialog.isShowing())
                    errorDialog.show();

            }
        }

        return resultCode == ConnectionResult.SUCCESS;
    }
}
