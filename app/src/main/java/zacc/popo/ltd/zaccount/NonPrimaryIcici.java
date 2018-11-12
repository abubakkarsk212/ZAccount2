package zacc.popo.ltd.zaccount;

import android.content.DialogInterface;
import android.content.Intent;
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

public class NonPrimaryIcici extends AppCompatActivity {
    LinearLayout balI,miniSI,chequeStatusI,chequeReqI,chequeStopI,billsPI;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_non_primary_icici);
        adView = new com.facebook.ads.AdView(NonPrimaryIcici.this, getString(R.string.banner_FederalBC1), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_nonPicici1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(NonPrimaryIcici.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(NonPrimaryIcici.this,getString(R.string.interstitial_FederalC1));
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

        balI = findViewById(R.id.balNPI);
        miniSI = findViewById(R.id.miniStaNI);
        chequeStatusI = findViewById(R.id.chequeStaNPI);
        chequeReqI = findViewById(R.id.reqNPI);
        chequeStopI = findViewById(R.id.stopChequeNI);
        billsPI = findViewById(R.id.billNPI);
        balI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(NonPrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Check Bank Balance");
                LinearLayout linearLayout = new LinearLayout(NonPrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(NonPrimaryIcici.this);
                input.setHint("Enter Last 6 digits of Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IBAL "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(NonPrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        miniSI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(NonPrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Last 3 transaction");
                LinearLayout linearLayout = new LinearLayout(NonPrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(NonPrimaryIcici.this);
                input.setHint("Enter Last 6 digits of Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "ITRAN "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(NonPrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        chequeStatusI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(NonPrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Cheque Status");
                LinearLayout linearLayout = new LinearLayout(NonPrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(NonPrimaryIcici.this);
                input.setHint("Cheque No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                final EditText inputAcct = new EditText(NonPrimaryIcici.this);
                inputAcct.setHint("Last 6 digit of Account No");
                inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(inputAcct);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String acctNo =inputAcct.getText().toString();
                        String cardNo = input.getText().toString();
                        String msg = "ICSI "+cardNo+" "+acctNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(NonPrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
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
                final AlertDialog.Builder alert = new AlertDialog.Builder(NonPrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Stop Cheque Request");
                LinearLayout linearLayout = new LinearLayout(NonPrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(NonPrimaryIcici.this);
                input.setHint("Cheque No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                final EditText inputAcct = new EditText(NonPrimaryIcici.this);
                inputAcct.setHint("Last 6 digit of Account No");
                inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(inputAcct);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String acctNo =inputAcct.getText().toString();
                        String cardNo = input.getText().toString();
                        String msg = "ISCR "+cardNo+" "+acctNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(NonPrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
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
                final AlertDialog.Builder alert = new AlertDialog.Builder(NonPrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Cheque Book Request");
                LinearLayout linearLayout = new LinearLayout(NonPrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(NonPrimaryIcici.this);
                input.setHint("Enter Last 6 digits of Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Request", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "ICBR "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(NonPrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        billsPI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(NonPrimaryIcici.this);
                alert.setCancelable(false);
                alert.setTitle("View Presented Bills");
                LinearLayout linearLayout = new LinearLayout(NonPrimaryIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(NonPrimaryIcici.this);
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
                            Toast.makeText(NonPrimaryIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });

        mNativeBannerAxis1= new NativeBannerAd(NonPrimaryIcici.this, getString(R.string.nativebannerFederalC1));
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
                View adView1 = NativeBannerAdView.render(NonPrimaryIcici.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksiciciNP1);
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

        mNativeBannerAxis2= new NativeBannerAd(NonPrimaryIcici.this, getString(R.string.nativebannerFederalC1));
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
                View adView1 = NativeBannerAdView.render(NonPrimaryIcici.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksiciciNP2);
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
