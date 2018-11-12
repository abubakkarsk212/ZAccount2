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

public class PrimaryIcici extends AppCompatActivity {
LinearLayout balI,miniSI,chequeStatusI,chequeReqI,chequeStopI,billsPI;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primary_icici);
        adView = new com.facebook.ads.AdView(PrimaryIcici.this, getString(R.string.banner_CCIcici), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_iciciPr1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(PrimaryIcici.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(PrimaryIcici.this,getString(R.string.interstitial_CCIcici));
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
        balI = findViewById(R.id.balSI);
        miniSI = findViewById(R.id.miniStaI);
        chequeStatusI = findViewById(R.id.chequeStaI);
        chequeReqI = findViewById(R.id.reqIciciC);
        chequeStopI = findViewById(R.id.stopChequeI);
        billsPI = findViewById(R.id.billI);
        balI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "9594612612";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        miniSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "9594613613";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        chequeStatusI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(PrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Check Cheque Status");
                LinearLayout linearLayout = new LinearLayout(PrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(PrimaryIcici.this);
                input.setHint("Enter Cheque No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "ICSI "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(PrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        chequeStopI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(PrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Stop Cheque Request");
                LinearLayout linearLayout = new LinearLayout(PrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(PrimaryIcici.this);
                input.setHint("Enter Cheque No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Stop", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "ISCR "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(PrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        chequeReqI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phNo ="9215676766";
                String msg = "ICBR";
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(PrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        billsPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(PrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("View Presented Bills");
                LinearLayout linearLayout = new LinearLayout(PrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(PrimaryIcici.this);
                input.setHint("Enter Biller Nickname");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("View", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IVIEW "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(PrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });

        mNativeBannerAxis1= new NativeBannerAd(PrimaryIcici.this, getString(R.string.nativebannerIciciC1));
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
                View adView1 = NativeBannerAdView.render(PrimaryIcici.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksprimaryicici1);
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

        mNativeBannerAxis2= new NativeBannerAd(PrimaryIcici.this, getString(R.string.nativebannerIciciC2));
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
                View adView1 = NativeBannerAdView.render(PrimaryIcici.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksprimaryicici2);
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
