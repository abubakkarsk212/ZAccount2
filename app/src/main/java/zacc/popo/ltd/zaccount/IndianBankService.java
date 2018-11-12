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

public class IndianBankService extends AppCompatActivity {
    LinearLayout bal,ussdB,miniS,pinGen,internetB,chequeStatus,issuedC;
    String[] accts ={"Default Account","Secondary Account"};
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_bank_service);
        adView = new com.facebook.ads.AdView(IndianBankService.this, getString(R.string.banner_IndianBS), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_indian1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(IndianBankService.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(IndianBankService.this,getString(R.string.interstitial_IndianBS));
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

        bal = findViewById(R.id.balIn);
        ussdB = findViewById(R.id.ussdBankingIn);
        miniS = findViewById(R.id.miniStaIn);
        pinGen = findViewById(R.id.internetPinIn);
        internetB = findViewById(R.id.internetBIn);
        chequeStatus = findViewById(R.id.chequeStaIn);
        issuedC = findViewById(R.id.chequeIssuedIn);
        bal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(IndianBankService.this);
                alert.setCancelable(false);
                alert.setTitle("Check Bank Balance");
                LinearLayout linearLayout = new LinearLayout(IndianBankService.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(IndianBankService.this);
                input.setHint("Enter Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                final EditText inputAcct = new EditText(IndianBankService.this);
                inputAcct.setHint("Enter MPIN");
                inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(inputAcct);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9444394443";
                        String acctNo =inputAcct.getText().toString();
                        String cardNo = input.getText().toString();
                        String msg = "BALAVL "+cardNo+" "+acctNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(IndianBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        miniS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert1 = new AlertDialog.Builder(IndianBankService.this);
                alert1.setTitle("Check Last transaction For");
                alert1.setSingleChoiceItems(accts, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i)
                        {
                            case 0:

                                final AlertDialog.Builder alert = new AlertDialog.Builder(IndianBankService.this);
                                alert.setCancelable(false);
                                alert.setTitle("Check lat 3 transaction");
                                LinearLayout linearLayout = new LinearLayout(IndianBankService.this);
                                linearLayout.setOrientation(LinearLayout.VERTICAL);

                                final EditText input = new EditText(IndianBankService.this);
                                input.setHint("Enter MPIN");
                                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout.addView(input);
                                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String phNo ="9444394443";
                                        String cardNo = input.getText().toString();
                                        String msg = "LATRAN "+cardNo;
                                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                        intentSms.setType("vnd.android-dir/mms-sms");
                                        intentSms.putExtra("sms_body", msg);
                                        intentSms.putExtra("address",phNo);
                                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                                            startActivity(intentSms);
                                        }
                                        else{
                                            Toast.makeText(IndianBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                alert.setNegativeButton("Cancel",null);
                                alert.setView(linearLayout);
                                alert.show();
                                break;
                            case 1:
                                // Your code when 2nd  option seletced
                                final AlertDialog.Builder alert2 = new AlertDialog.Builder(IndianBankService.this);
                                alert2.setCancelable(false);
                                alert2.setTitle("Check Last 3 transaction");
                                LinearLayout linearLayout2 = new LinearLayout(IndianBankService.this);
                                linearLayout2.setOrientation(LinearLayout.VERTICAL);

                                final EditText input2 = new EditText(IndianBankService.this);
                                input2.setHint("Enter Account No");
                                input2.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout2.addView(input2);
                                final EditText inputAcct = new EditText(IndianBankService.this);
                                inputAcct.setHint("Enter MPIN");
                                inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout2.addView(inputAcct);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
                                alert2.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String phNo ="9444394443";
                                        String acctNo =inputAcct.getText().toString();
                                        String cardNo = input2.getText().toString();
                                        String msg = "BALAVL "+cardNo+" "+acctNo;
                                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                        intentSms.setType("vnd.android-dir/mms-sms");
                                        intentSms.putExtra("sms_body", msg);
                                        intentSms.putExtra("address",phNo);
                                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                                            startActivity(intentSms);
                                        }
                                        else{
                                            Toast.makeText(IndianBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                alert2.setNegativeButton("Cancel",null);
                                alert2.setView(linearLayout2);
                                alert2.show();
                                break;


                        }
                    }
                });
                alert1.setNegativeButton("Cancel",null);
                alert1.show();
            }
        });
        chequeStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert1 = new AlertDialog.Builder(IndianBankService.this);
                alert1.setTitle("Cheque Deposit Status");
                alert1.setSingleChoiceItems(accts, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i)
                        {
                            case 0:

                                final AlertDialog.Builder alert2 = new AlertDialog.Builder(IndianBankService.this);
                                alert2.setCancelable(false);
                                alert2.setTitle("Check Deposit Status");
                                LinearLayout linearLayout2 = new LinearLayout(IndianBankService.this);
                                linearLayout2.setOrientation(LinearLayout.VERTICAL);

                                final EditText input2 = new EditText(IndianBankService.this);
                                input2.setHint("Enter Cheque No");
                                input2.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout2.addView(input2);
                                final EditText inputAcct = new EditText(IndianBankService.this);
                                inputAcct.setHint("Enter MPIN");
                                inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout2.addView(inputAcct);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
                                alert2.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String phNo ="9444394443";
                                        String acctNo =inputAcct.getText().toString();
                                        String cardNo = input2.getText().toString();
                                        String msg = "DCHSTS "+cardNo+" "+acctNo;
                                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                        intentSms.setType("vnd.android-dir/mms-sms");
                                        intentSms.putExtra("sms_body", msg);
                                        intentSms.putExtra("address",phNo);
                                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                                            startActivity(intentSms);
                                        }
                                        else{
                                            Toast.makeText(IndianBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                alert2.setNegativeButton("Cancel",null);
                                alert2.setView(linearLayout2);
                                alert2.show();
                                break;
                            case 1:
                                // Your code when 2nd  option seletced
                                final AlertDialog.Builder alert3 = new AlertDialog.Builder(IndianBankService.this);
                                alert3.setCancelable(false);
                                alert3.setTitle("Check Deposit Status");
                                LinearLayout linearLayout3 = new LinearLayout(IndianBankService.this);
                                linearLayout3.setOrientation(LinearLayout.VERTICAL);

                                final EditText input3 = new EditText(IndianBankService.this);
                                input3.setHint("Enter Cheque No");
                                input3.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout3.addView(input3);
                                final EditText acctNo = new EditText(IndianBankService.this);
                                acctNo.setHint("Enter Account No");
                                acctNo.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout3.addView(acctNo);
                                final EditText inputAcct3 = new EditText(IndianBankService.this);
                                inputAcct3.setHint("Enter MPIN");
                                inputAcct3.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout3.addView(inputAcct3);

//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
                                alert3.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String phNo ="9444394443";
                                        String acctNo1 =inputAcct3.getText().toString();
                                        String cardNo = input3.getText().toString();
                                        String acctN = acctNo.getText().toString();
                                        String msg = "DCHSTS "+cardNo+" "+acctN+" "+acctNo1;
                                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                        intentSms.setType("vnd.android-dir/mms-sms");
                                        intentSms.putExtra("sms_body", msg);
                                        intentSms.putExtra("address",phNo);
                                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                                            startActivity(intentSms);
                                        }
                                        else{
                                            Toast.makeText(IndianBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                alert3.setNegativeButton("Cancel",null);
                                alert3.setView(linearLayout3);
                                alert3.show();
                                break;


                        }
                    }
                });
                alert1.setNegativeButton("Cancel",null);
                alert1.show();
            }
        });
        pinGen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(IndianBankService.this);
                alert.setCancelable(false);
                alert.setTitle("Change PIN");
                LinearLayout linearLayout = new LinearLayout(IndianBankService.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(IndianBankService.this);
                input.setHint("Enter Old MPin");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                final EditText inputAcct = new EditText(IndianBankService.this);
                inputAcct.setHint("Enter New MPIN");
                inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(inputAcct);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
                alert.setPositiveButton("Change", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9444394443";
                        String acctNo =inputAcct.getText().toString();
                        String cardNo = input.getText().toString();
                        String msg = "CHGPIN "+acctNo+" "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(IndianBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
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
                String url = "https://www.indianbank.net.in/";
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(url));
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }
            }
        });
        issuedC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert1 = new AlertDialog.Builder(IndianBankService.this);
                alert1.setTitle("Check Issued Cheque Status");
                alert1.setSingleChoiceItems(accts, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i)
                        {
                            case 0:

                                final AlertDialog.Builder alert2 = new AlertDialog.Builder(IndianBankService.this);
                                alert2.setCancelable(false);
                                alert2.setTitle("Check Issued Cheque Status");
                                LinearLayout linearLayout2 = new LinearLayout(IndianBankService.this);
                                linearLayout2.setOrientation(LinearLayout.VERTICAL);

                                final EditText input2 = new EditText(IndianBankService.this);
                                input2.setHint("Enter Cheque No");
                                input2.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout2.addView(input2);
                                final EditText inputAcct = new EditText(IndianBankService.this);
                                inputAcct.setHint("Enter MPIN");
                                inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout2.addView(inputAcct);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
                                alert2.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String phNo ="9444394443";
                                        String acctNo =inputAcct.getText().toString();
                                        String cardNo = input2.getText().toString();
                                        String msg = "CHQSTS "+cardNo+" "+acctNo;
                                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                        intentSms.setType("vnd.android-dir/mms-sms");
                                        intentSms.putExtra("sms_body", msg);
                                        intentSms.putExtra("address",phNo);
                                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                                            startActivity(intentSms);
                                        }
                                        else{
                                            Toast.makeText(IndianBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                alert2.setNegativeButton("Cancel",null);
                                alert2.setView(linearLayout2);
                                alert2.show();
                                break;
                            case 1:
                                // Your code when 2nd  option seletced
                                final AlertDialog.Builder alert3 = new AlertDialog.Builder(IndianBankService.this);
                                alert3.setCancelable(false);
                                alert3.setTitle("Check Issued Cheque Status");
                                LinearLayout linearLayout3 = new LinearLayout(IndianBankService.this);
                                linearLayout3.setOrientation(LinearLayout.VERTICAL);

                                final EditText input3 = new EditText(IndianBankService.this);
                                input3.setHint("Enter Cheque No");
                                input3.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout3.addView(input3);
                                final EditText acctNo = new EditText(IndianBankService.this);
                                acctNo.setHint("Enter Account No");
                                acctNo.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout3.addView(acctNo);
                                final EditText inputAcct3 = new EditText(IndianBankService.this);
                                inputAcct3.setHint("Enter MPIN");
                                inputAcct3.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout3.addView(inputAcct3);

//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
                                alert3.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String phNo ="9444394443";
                                        String acctNo1 =inputAcct3.getText().toString();
                                        String cardNo = input3.getText().toString();
                                        String acctN = acctNo.getText().toString();
                                        String msg = "CHQSTS "+cardNo+" "+acctN+" "+acctNo1;
                                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                        intentSms.setType("vnd.android-dir/mms-sms");
                                        intentSms.putExtra("sms_body", msg);
                                        intentSms.putExtra("address",phNo);
                                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                                            startActivity(intentSms);
                                        }
                                        else{
                                            Toast.makeText(IndianBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                alert3.setNegativeButton("Cancel",null);
                                alert3.setView(linearLayout3);
                                alert3.show();
                                break;


                        }
                    }
                });
                alert1.setNegativeButton("Cancel",null);
                alert1.show();
            }
        });
        ussdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(IndianBankService.this,UsssdBankingIndian.class);
            startActivity(i);
            }
        });
        mNativeBannerAxis1= new NativeBannerAd(IndianBankService.this, getString(R.string.nativebannerIndianBS1));
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
                View adView1 = NativeBannerAdView.render(IndianBankService.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksindian1);
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

        mNativeBannerAxis2= new NativeBannerAd(IndianBankService.this, getString(R.string.nativebannerIndianBS2));
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
                View adView1 = NativeBannerAdView.render(IndianBankService.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksindian2);
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
