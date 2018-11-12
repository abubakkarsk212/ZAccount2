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

public class UnionBankService extends AppCompatActivity {
LinearLayout activate1,balP,balS1,ussdB,miniP,miniS,blockAtm,chequeS,internetB;
    String[] chequeStatus ={"Primary Account","Secondary Account"};
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2,mNativeBannerAxis3;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_union_bank_service);
        adView = new com.facebook.ads.AdView(UnionBankService.this, getString(R.string.banner_UcoC), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_union1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(UnionBankService.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(UnionBankService.this,getString(R.string.interstitial_UcoC));
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

        activate1 = findViewById(R.id.registerUn);
        balP = findViewById(R.id.balUn);
        balS1 = findViewById(R.id.balUnS);
        ussdB = findViewById(R.id.ussdBankingUn);
        miniP = findViewById(R.id.miniStaUn);
        miniS = findViewById(R.id.miniStaUnS);
        blockAtm = findViewById(R.id.blockATMUn);
        chequeS = findViewById(R.id.chequeStatusUn);
        internetB = findViewById(R.id.internetBUn);

        activate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertD = new AlertDialog.Builder(UnionBankService.this);
                alertD.setTitle("Register");
                alertD.setMessage("You need to call Union 24X7 Call Center or Contact Branch. Please keep your Account Number or Debit Card number readily available when calling us\n\nRs 15 per quarter charges");
                alertD.setCancelable(false);
                alertD.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String ph = "1800222244";
                        Intent i1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                        startActivity(i1);
                    }
                });
                alertD.show();
            }
        });
        balP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "09223008586";
                Intent i1 = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i1);
            }
        });
        balS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(UnionBankService.this);
                alert.setCancelable(false);
                alert.setTitle("Check Balance for Secondary Account");
                LinearLayout linearLayout = new LinearLayout(UnionBankService.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(UnionBankService.this);
                input.setHint("Enter Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9223008486";
                        String cardNo = input.getText().toString();
                        String msg = "UBAL "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(UnionBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        miniP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phNo ="9223008486";
                String msg = "UMNS";
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(UnionBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        miniS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(UnionBankService.this);
                alert.setCancelable(false);
                alert.setTitle("Mini Statement For Secondary Account");
                LinearLayout linearLayout = new LinearLayout(UnionBankService.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(UnionBankService.this);
                input.setHint("Enter Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9223008486";
                        String cardNo = input.getText().toString();
                        String msg = "UMNS "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(UnionBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        blockAtm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(UnionBankService.this);
                alert.setCancelable(false);
                alert.setTitle("Block ATM Card");
                LinearLayout linearLayout = new LinearLayout(UnionBankService.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(UnionBankService.this);
                input.setHint("Last 4 digit of debit card no");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Block", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9223008486";
                        String cardNo = input.getText().toString();
                        String msg = "UBLOCK "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(UnionBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
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
                String url = "https://www.unionbankonline.co.in/corp/AuthenticationController?__START_TRAN_FLAG__=Y&FORMSGROUP_ID__=AuthenticationFG&__EVENT_ID__=LOAD&FG_BUTTONS__=LOAD&ACTION.LOAD=Y&AuthenticationFG.LOGIN_FLAG=1&BANK_ID=026&LANGUAGE_ID=001";
                Intent intent1 = new Intent(Intent.ACTION_VIEW);
                intent1.setData(Uri.parse(url));
                if (intent1.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent1);
                }
            }
        });
        chequeS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(UnionBankService.this);
                alert.setTitle("Cheque status for");

                alert.setSingleChoiceItems(chequeStatus, -1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch(i)
                        {
                            case 0:
                                final AlertDialog.Builder alert1 = new AlertDialog.Builder(UnionBankService.this);
                                alert1.setCancelable(false);
                                alert1.setTitle("For Primary Account");
                                LinearLayout linearLayout = new LinearLayout(UnionBankService.this);
                                linearLayout.setOrientation(LinearLayout.VERTICAL);

                                final EditText input = new EditText(UnionBankService.this);
                                input.setHint("Enter Cheque No");
                                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout.addView(input);
                                alert1.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String phNo ="9223008486";
                                        String cardNo = input.getText().toString();
                                        String msg = "UCSR "+cardNo;
                                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                        intentSms.setType("vnd.android-dir/mms-sms");
                                        intentSms.putExtra("sms_body", msg);
                                        intentSms.putExtra("address",phNo);
                                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                                            startActivity(intentSms);
                                        }
                                        else{
                                            Toast.makeText(UnionBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                alert1.setNegativeButton("Cancel",null);
                                alert1.setView(linearLayout);
                                alert1.show();
                                break;
                            case 1:
                                // Your code when 2nd  option seletced
                                final AlertDialog.Builder alert2 = new AlertDialog.Builder(UnionBankService.this);
                                alert2.setCancelable(false);
                                alert2.setTitle("For Secondary Account");
                                LinearLayout linearLayout1 = new LinearLayout(UnionBankService.this);
                                linearLayout1.setOrientation(LinearLayout.VERTICAL);

                                final EditText input1 = new EditText(UnionBankService.this);
                                input1.setHint("Enter Cheque No");
                                input1.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout1.addView(input1);

                                final EditText acc = new EditText(UnionBankService.this);
                                acc.setHint("Enter Account No");
                                acc.setInputType(InputType.TYPE_CLASS_NUMBER);
                                linearLayout1.addView(acc);
                                alert2.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        String phNo1 ="9223008486";
                                        String cardNo1 = input1.getText().toString();
                                        String acctNo1 =acc.getText().toString();
                                        String msg1 = "UCSR "+cardNo1+" "+acctNo1;
                                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                        intentSms.setType("vnd.android-dir/mms-sms");
                                        intentSms.putExtra("sms_body", msg1);
                                        intentSms.putExtra("address",phNo1);
                                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                                            startActivity(intentSms);
                                        }
                                        else{
                                            Toast.makeText(UnionBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                                alert2.setNegativeButton("Cancel",null);
                                alert2.setView(linearLayout1);
                                alert2.show();
                                break;


                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.show();
            }
        });
        ussdB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent i = new Intent(UnionBankService.this,UssdUnion.class);
            startActivity(i);
            }
        });

        mNativeBannerAxis1= new NativeBannerAd(UnionBankService.this, getString(R.string.nativebannerUco1));
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
                View adView1 = NativeBannerAdView.render(UnionBankService.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksunion1);
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

        mNativeBannerAxis2= new NativeBannerAd(UnionBankService.this, getString(R.string.nativebannerUco2));
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
                View adView1 = NativeBannerAdView.render(UnionBankService.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksunion2);
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

        mNativeBannerAxis3= new NativeBannerAd(UnionBankService.this, getString(R.string.nativebannerUco3));
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
                View adView1 = NativeBannerAdView.render(UnionBankService.this, mNativeBannerAxis3, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksunion3);
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
