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

public class LoanIcici extends AppCompatActivity {
LinearLayout schedule,income,finalTax,reschedule,resetL,agreementL,intrestC,welcomeL;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_icici);
        adView = new com.facebook.ads.AdView(LoanIcici.this, getString(R.string.banner_KarnatakaC), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_loanicici1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(LoanIcici.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(LoanIcici.this,getString(R.string.interstitial_KarnatakaC));
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
        schedule = findViewById(R.id.scheduleLI);
        income = findViewById(R.id.taxLI);
        finalTax = findViewById(R.id.finalLI);
        reschedule = findViewById(R.id.rescheduleLI);
        resetL = findViewById(R.id.resetLI);
        agreementL = findViewById(R.id.agreementLI);
        intrestC = findViewById(R.id.intrestLI);
        welcomeL = findViewById(R.id.welcomeLI);
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(LoanIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Amortisation Schedule");
                LinearLayout linearLayout = new LinearLayout(LoanIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(LoanIcici.this);
                input.setHint("Last 16 digits of Loan Acct No");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IAMT "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(LoanIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        income.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(LoanIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Income Tax Certificate Provisional");
                LinearLayout linearLayout = new LinearLayout(LoanIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(LoanIcici.this);
                input.setHint("Last 16 digits of Loan Acct No");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IITP "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(LoanIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        finalTax.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(LoanIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Income Tax Certificate Final");
                LinearLayout linearLayout = new LinearLayout(LoanIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(LoanIcici.this);
                input.setHint("Last 16 digits of Loan Acct No");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IITF "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(LoanIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        reschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(LoanIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Reschedulement Letter");
                LinearLayout linearLayout = new LinearLayout(LoanIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(LoanIcici.this);
                input.setHint("Last 16 digits of Loan Acct No");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IRSL "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(LoanIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        resetL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(LoanIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Reset Letter");
                LinearLayout linearLayout = new LinearLayout(LoanIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(LoanIcici.this);
                input.setHint("Last 16 digits of Loan Acct No");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IRTL "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(LoanIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        agreementL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(LoanIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Loan Agreement Copy");
                LinearLayout linearLayout = new LinearLayout(LoanIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(LoanIcici.this);
                input.setHint("Last 16 digits of Loan Acct No");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "ILAC "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(LoanIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        intrestC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(LoanIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Intrest Certificate");
                LinearLayout linearLayout = new LinearLayout(LoanIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(LoanIcici.this);
                input.setHint("Last 16 digits of Loan Acct No");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IINT "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(LoanIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        welcomeL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(LoanIcici.this);
                alert.setCancelable(false);
                alert.setTitle("Welcome Letter");
                LinearLayout linearLayout = new LinearLayout(LoanIcici.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(LoanIcici.this);
                input.setHint("Last 16 digits of Loan Acct No");
                input.setInputType(InputType.TYPE_CLASS_TEXT);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9215676766";
                        String cardNo = input.getText().toString();
                        String msg = "IWEL "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(LoanIcici.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        mNativeBannerAxis1= new NativeBannerAd(LoanIcici.this, getString(R.string.nativebannerKarnatakaC));
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
                View adView1 = NativeBannerAdView.render(LoanIcici.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksiciciloan1);
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

        mNativeBannerAxis2= new NativeBannerAd(LoanIcici.this, getString(R.string.nativebannerRechIcici2));
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
                View adView1 = NativeBannerAdView.render(LoanIcici.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksiciciloan2);
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
