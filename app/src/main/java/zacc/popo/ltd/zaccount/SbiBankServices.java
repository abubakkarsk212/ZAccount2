package zacc.popo.ltd.zaccount;

import android.Manifest;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.ads.AbstractAdListener;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdSize;
import com.facebook.ads.InterstitialAdListener;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.NativeBannerAdView;

public class SbiBankServices extends AppCompatActivity {
LinearLayout registerS,balanceE,miniS,eStat,atmPin,blockA,internetB,phoneB,deRegister,getUserId,recharge,ussdB;
RadioButton atmR,posR,eCommR,intR,domR;
Button activate,deactivate;
TextView knowMore;
    String msseg ="";
    String mes = "";
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2,mNativeBannerAxis3;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sbi_bank_services);
        adView = new com.facebook.ads.AdView(SbiBankServices.this, getString(R.string.banner_InduslndC), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_sbi1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(SbiBankServices.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(SbiBankServices.this,getString(R.string.interstitial_InduslndC));
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
        registerS = findViewById(R.id.registerSbi);
        balanceE = findViewById(R.id.balS);
        miniS = findViewById(R.id.miniStaS);
        eStat = findViewById(R.id.eStatementS);
        atmPin = findViewById(R.id.genAtm);
        blockA = findViewById(R.id.blockATM);
        atmR = findViewById(R.id.atm);
        posR = findViewById(R.id.pos);
        eCommR = findViewById(R.id.ecomm);
        intR = findViewById(R.id.international);
        domR = findViewById(R.id.domestic);
        activate = findViewById(R.id.activaTe);
        deactivate = findViewById(R.id.deActiv);
        internetB =findViewById(R.id.internetBS);
        phoneB = findViewById(R.id.phoneBS);
        knowMore = findViewById(R.id.knowSbi);
        deRegister = findViewById(R.id.deactivateRegS);
        getUserId = findViewById(R.id.getUserIdS);
        recharge = findViewById(R.id.rechargeS);
        ussdB = findViewById(R.id.ussdBanking);
        registerS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(SbiBankServices.this);
                alert.setCancelable(false);
                alert.setMessage("Register For Bank Service");
                final EditText input = new EditText(SbiBankServices.this);
               input.setHint("Enter 12 digit Account No");
               input.setInputType(InputType.TYPE_CLASS_NUMBER);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alert.setView(input);
                alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                     String acctNo = input.getText().toString();
                     final String phNo ="09223488888";
                     final String msg ="REG "+acctNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }


                        }

                });
                alert.setNegativeButton("Cancel", null);


                alert.show();

                //onclick
            }



            // final bracket onClick
        });
        balanceE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = " 09223766666";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        miniS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phNo ="09223866666";
                final String msg ="MSTMT";
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        eStat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String phNo ="";
                final String msg ="MSTMT";
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        atmPin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(SbiBankServices.this);
                alert.setCancelable(false);
                alert.setTitle("Generate ATM PIN");
                LinearLayout linearLayout = new LinearLayout(SbiBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(SbiBankServices.this);
                input.setHint("Last 4 digit of ATM Card");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                final EditText inputAcct = new EditText(SbiBankServices.this);
                inputAcct.setHint("Last 4 digit of Account No");
                inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(inputAcct);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
                alert.setPositiveButton("Generate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="567676";
                        String acctNo =inputAcct.getText().toString();
                        String cardNo = input.getText().toString();
                        String msg = "PIN "+cardNo+" "+acctNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.setMessage("You will recieve an OTP which is valid for 2 days and should be used to generate debit card PIN by visiting any of SBI ATMs");

                alert.show();
            }
        });
        blockA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(SbiBankServices.this);
                alert.setCancelable(false);
                alert.setTitle("Block ATM Card");
                LinearLayout linearLayout = new LinearLayout(SbiBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(SbiBankServices.this);
                input.setHint("Last 4 digit of ATM Card");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Block", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="567676";
                        String cardNo = input.getText().toString();
                        String msg = "BLOCK "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();

            }
        });
        activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(SbiBankServices.this);
                alert.setCancelable(false);

                if(atmR.isChecked()){
                    msseg = "ATM";
                    mes = atmR.getText().toString();
                }else if(posR.isChecked()){
                    msseg = "POS";
                    mes = posR.getText().toString();
                }
                else if(eCommR.isChecked()){
                    msseg = "ECOM";
                    mes = eCommR.getText().toString();
                }
                else if(intR.isChecked()){
                    msseg = "INTL";
                    mes = intR.getText().toString();
                }
                else if(domR.isChecked()){
                    msseg = "DOM";
                    mes = domR.getText().toString();
                }
                alert.setTitle("Activate "+mes);
                LinearLayout linearLayout = new LinearLayout(SbiBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(SbiBankServices.this);
                input.setHint("Last 4 digit of ATM Card");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Activate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="09223966666";
                        String cardNo = input.getText().toString();
                        String msg = "SWON "+msseg+" "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();



            }
        });
        deactivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(SbiBankServices.this);
                alert.setCancelable(false);

                if(atmR.isChecked()){
                    msseg = "ATM";
                    mes = atmR.getText().toString();
                }else if(posR.isChecked()){
                    msseg = "POS";
                    mes = posR.getText().toString();
                }
                else if(eCommR.isChecked()){
                    msseg = "ECOM";
                    mes = eCommR.getText().toString();
                }
                else if(intR.isChecked()){
                    msseg = "INTL";
                    mes = intR.getText().toString();
                }
                else if(domR.isChecked()){
                    msseg = "DOM";
                    mes = domR.getText().toString();
                }
                alert.setTitle("De-Activate "+mes);
                LinearLayout linearLayout = new LinearLayout(SbiBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(SbiBankServices.this);
                input.setHint("Last 4 digit of ATM Card");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("De-Activate", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="09223966666";
                        String cardNo = input.getText().toString();
                        String msg = "SWOFF "+msseg+" "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();

            }
        });
        internetB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.onlinesbi.com/";
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(url));
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }
            }
        });
        phoneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertD = new AlertDialog.Builder(SbiBankServices.this);
                alertD.setTitle("Connect IVR Call");
                alertD.setMessage("1) Select Language\n\n2) Press 1\n\n3) Again press 1");
                alertD.setCancelable(false);
                alertD.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String ph = "1800112211";
                        Intent i1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                        startActivity(i1);
                    }
                });
                alertD.setNegativeButton("Cancel",null);
                alertD.show();
            }
        });
        knowMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertD = new AlertDialog.Builder(SbiBankServices.this);
                alertD.setTitle("ATM Card Switch On/Off");
                alertD.setMessage("You can now control your ATM Card channel of usage by sending an SMS from your registered mobile number. You can choose to activate/deactivate usage at ATM, POS, E-Commerce, International and Domestic\n\nNow Activate card whenever required, It saves you from fraud");
                alertD.setCancelable(false);
                alertD.setPositiveButton("Ok", null);
                alertD.show();
            }
        });
        deRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phNo ="9223488888";
                String msg = "DREG";
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }

            }
        });
        getUserId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phNo ="9223440000";
                String msg = "MBSREG";
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(SbiBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SbiBankServices.this,RechargeActivitySbi.class);
                startActivity(i);
            }
        });
        ussdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(SbiBankServices.this,UssdBankingSbi.class);
            startActivity(i);
            }
        });

        mNativeBannerAxis1= new NativeBannerAd(SbiBankServices.this, getString(R.string.nativebannerIndus1));
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
                View adView1 = NativeBannerAdView.render(SbiBankServices.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankssbi1);
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

        mNativeBannerAxis2= new NativeBannerAd(SbiBankServices.this, getString(R.string.nativebannerIndus2));
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
                View adView1 = NativeBannerAdView.render(SbiBankServices.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankssbi2);
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

        mNativeBannerAxis3= new NativeBannerAd(SbiBankServices.this, getString(R.string.nativebannerIndus3));
        //623848994653940_626245771080929
        mNativeBannerAxis3.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
// Render the Native Banner Ad Template
                View adView1 = NativeBannerAdView.render(SbiBankServices.this, mNativeBannerAxis3, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankssbi3);
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
        mNativeBannerAxis3.loadAd();


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
