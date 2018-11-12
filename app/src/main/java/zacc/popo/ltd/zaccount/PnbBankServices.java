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

public class PnbBankServices extends AppCompatActivity {
LinearLayout balPP,ussdB,miniS1,chequeS,stopPC,disableIb,disableMb,internetB,debitPin1,eStatement,chequeReq,genMMid,cancelMMid;
TextView knowIb,knowMb;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2,mNativeBannerAxis3;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pnb_bank_services);
        adView = new com.facebook.ads.AdView(PnbBankServices.this, getString(R.string.banner_DthSbi), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_pnb1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(PnbBankServices.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(PnbBankServices.this,getString(R.string.interstitial_DthSbi));
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

        balPP = findViewById(R.id.balPnb);
        ussdB = findViewById(R.id.ussdBankingPnb);
        miniS1 = findViewById(R.id.miniStaPnb);
        chequeS = findViewById(R.id.chequeStaPnb);
        stopPC = findViewById(R.id.stopChequePnb);
        disableIb = findViewById(R.id.disableIBPnb);
        disableMb = findViewById(R.id.disableMBPnb);
        internetB = findViewById(R.id.internetBPnb);
        debitPin1 = findViewById(R.id.debitPin);
        knowIb = findViewById(R.id.knowIB);
        knowMb = findViewById(R.id.knowMB);
        eStatement = findViewById(R.id.eStaPnb);
        chequeReq = findViewById(R.id.reqPnb);
        genMMid = findViewById(R.id.mmidPnb);
        cancelMMid = findViewById(R.id.cancelMMPnb);
        balPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "18001802223";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        miniS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(PnbBankServices.this);
                alert.setCancelable(false);
                alert.setTitle("Mini Statement");
                LinearLayout linearLayout = new LinearLayout(PnbBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(PnbBankServices.this);
                input.setHint("Enter 16 digit Account Number");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="5607040";
                        String cardNo = input.getText().toString();
                        String msg = "MINSTMT "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        chequeS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(PnbBankServices.this);
                alert.setCancelable(false);
                alert.setTitle("Cheque Status");
                LinearLayout linearLayout = new LinearLayout(PnbBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(PnbBankServices.this);
                input.setHint("Enter Cheque Number");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                final EditText acctN = new EditText(PnbBankServices.this);
                acctN.setHint("Enter 16 digit Account No");
                acctN.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(acctN);
                alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="5607040";
                        String cardNo = input.getText().toString();
                        String acctNo = acctN.getText().toString();
                        String msg = "CHQINQ "+cardNo+" "+acctNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        stopPC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(PnbBankServices.this);
                alert.setCancelable(false);
                alert.setTitle("Stop Payment Cheque");
                LinearLayout linearLayout = new LinearLayout(PnbBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(PnbBankServices.this);
                input.setHint("Enter Cheque Number");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                final EditText acctN = new EditText(PnbBankServices.this);
                acctN.setHint("Enter 16 digit Account No");
                acctN.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(acctN);
                alert.setPositiveButton("Stop", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="5607040";
                        String cardNo = input.getText().toString();
                        String acctNo = acctN.getText().toString();
                        String msg = "STPCHQ "+cardNo+" "+acctNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        disableIb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phNo ="5607040";

                String msg = "BLOCK IBS";
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
       disableMb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phNo ="5607040";
                String msg = "BLOCK MBS";
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
       internetB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String url = "https://netpnb.com/";
               Intent intent1 = new Intent(Intent.ACTION_VIEW);
               intent1.setData(Uri.parse(url));
               if (intent1.resolveActivity(getPackageManager()) != null) {
                   startActivity(intent1);
               }
           }
       });
       debitPin1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final AlertDialog.Builder alert = new AlertDialog.Builder(PnbBankServices.this);
               alert.setCancelable(false);
               alert.setTitle("Procedureto set Debit Card Pin");
               alert.setMessage("1) You need to generate a 6 digit OTP which is valid for 72 hours\n\n2) Go to nearest PNB Atm and swipe your debit card\n\n3) Under Banking on language selection screen select GREEN PIN and Enter the OTP\n\n4) ATM screen will prompt you to enter 4 digits number of your choice as PIN of debit card and press OK");
               alert.setPositiveButton("Generate", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       final AlertDialog.Builder alert1 = new AlertDialog.Builder(PnbBankServices.this);
                       alert1.setCancelable(false);
                       alert1.setTitle("Generate OTP");
                       LinearLayout linearLayout = new LinearLayout(PnbBankServices.this);
                       linearLayout.setOrientation(LinearLayout.VERTICAL);

                       final EditText input = new EditText(PnbBankServices.this);
                       input.setHint("Enter Card No");
                       input.setInputType(InputType.TYPE_CLASS_NUMBER);
                       linearLayout.addView(input);
                       alert1.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                           @Override
                           public void onClick(DialogInterface dialogInterface, int i) {
                               String phNo ="5607040";
                               String cardNo = input.getText().toString();
                               String msg = "DCPIN "+cardNo;
                               Intent intentSms = new Intent(Intent.ACTION_VIEW);
                               intentSms.setType("vnd.android-dir/mms-sms");
                               intentSms.putExtra("sms_body", msg);
                               intentSms.putExtra("address",phNo);
                               if (intentSms.resolveActivity(getPackageManager()) != null) {
                                   startActivity(intentSms);
                               }
                               else{
                                   Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                               }
                           }
                       });
                       alert1.setNegativeButton("Cancel",null);
                       alert1.setView(linearLayout);
                       alert1.show();
                   }
               });
               alert.setNegativeButton("Cancel",null);
               alert.show();
           }
       });
       knowIb.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final AlertDialog.Builder alert = new AlertDialog.Builder(PnbBankServices.this);
               alert.setCancelable(false);
               alert.setMessage("Disable your Internet Banking password when not in use");
               alert.setPositiveButton("Ok", null );
               alert.show();
           }
       });
       knowMb.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final AlertDialog.Builder alert = new AlertDialog.Builder(PnbBankServices.this);
               alert.setCancelable(false);
               alert.setMessage("Disable your Mobile Banking password when not in use");
               alert.setPositiveButton("Ok", null );
               alert.show();
           }
       });
       eStatement.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final AlertDialog.Builder alert = new AlertDialog.Builder(PnbBankServices.this);
               alert.setCancelable(false);
               alert.setTitle("Get E-Statement through Email");
               LinearLayout linearLayout = new LinearLayout(PnbBankServices.this);
               linearLayout.setOrientation(LinearLayout.VERTICAL);

               final EditText input = new EditText(PnbBankServices.this);
               input.setHint("Enter last 4 digit of A/C No");
               input.setInputType(InputType.TYPE_CLASS_NUMBER);
               linearLayout.addView(input);
               final EditText acctN = new EditText(PnbBankServices.this);
               acctN.setHint("Enter Your Email Id");
               acctN.setInputType(InputType.TYPE_CLASS_TEXT);
               linearLayout.addView(acctN);
               alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       String phNo ="5607040";
                       String cardNo = input.getText().toString();
                       String acctNo = acctN.getText().toString();
                       String msg = "ESTMT "+cardNo+" "+acctNo;
                       Intent intentSms = new Intent(Intent.ACTION_VIEW);
                       intentSms.setType("vnd.android-dir/mms-sms");
                       intentSms.putExtra("sms_body", msg);
                       intentSms.putExtra("address",phNo);
                       if (intentSms.resolveActivity(getPackageManager()) != null) {
                           startActivity(intentSms);
                       }
                       else{
                           Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                       }
                   }
               });
               alert.setNegativeButton("Cancel",null);
               alert.setView(linearLayout);
               alert.show();
           }
       });
       chequeReq.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               final AlertDialog.Builder alert = new AlertDialog.Builder(PnbBankServices.this);
               alert.setCancelable(false);
               alert.setTitle("Cheque Book request");
               LinearLayout linearLayout = new LinearLayout(PnbBankServices.this);
               linearLayout.setOrientation(LinearLayout.VERTICAL);

               final EditText input = new EditText(PnbBankServices.this);
               input.setHint("Enter Account No");
               input.setInputType(InputType.TYPE_CLASS_NUMBER);
               linearLayout.addView(input);
               final EditText acctN = new EditText(PnbBankServices.this);
               acctN.setHint("Enter User Id of mBanking");
               acctN.setInputType(InputType.TYPE_CLASS_TEXT);
               linearLayout.addView(acctN);
               final EditText leaves = new EditText(PnbBankServices.this);
               leaves.setHint("Enter No of Cheque Book Leaves");
               leaves.setInputType(InputType.TYPE_CLASS_NUMBER);
               linearLayout.addView(leaves);
               alert.setPositiveButton("Request", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialogInterface, int i) {
                       String phNo ="5607040";
                       String cardNo = input.getText().toString();
                       String acctNo = acctN.getText().toString();
                       String leavesa = leaves.getText().toString();
                       String msg = "CHKBK "+cardNo+" "+acctNo+" "+leavesa;
                       Intent intentSms = new Intent(Intent.ACTION_VIEW);
                       intentSms.setType("vnd.android-dir/mms-sms");
                       intentSms.putExtra("sms_body", msg);
                       intentSms.putExtra("address",phNo);
                       if (intentSms.resolveActivity(getPackageManager()) != null) {
                           startActivity(intentSms);
                       }
                       else{
                           Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                       }
                   }
               });
               alert.setNegativeButton("Cancel",null);
               alert.setView(linearLayout);
               alert.show();
           }
       });
       genMMid.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String phNo ="5607040";
               String msg = "MMID";
               Intent intentSms = new Intent(Intent.ACTION_VIEW);
               intentSms.setType("vnd.android-dir/mms-sms");
               intentSms.putExtra("sms_body", msg);
               intentSms.putExtra("address",phNo);
               if (intentSms.resolveActivity(getPackageManager()) != null) {
                   startActivity(intentSms);
               }
               else{
                   Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
               }
           }
       });
       cancelMMid.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String phNo ="5607040";
               String msg = "MMIDCANCEL";
               Intent intentSms = new Intent(Intent.ACTION_VIEW);
               intentSms.setType("vnd.android-dir/mms-sms");
               intentSms.putExtra("sms_body", msg);
               intentSms.putExtra("address",phNo);
               if (intentSms.resolveActivity(getPackageManager()) != null) {
                   startActivity(intentSms);
               }
               else{
                   Toast.makeText(PnbBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
               }
           }
       });
       ussdB.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i = new Intent(PnbBankServices.this,UssdPnb.class);
               startActivity(i);
           }
       });

        mNativeBannerAxis1= new NativeBannerAd(PnbBankServices.this, getString(R.string.nativebannerAxisC1));
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
                View adView1 = NativeBannerAdView.render(PnbBankServices.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankspnb1);
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

        mNativeBannerAxis2= new NativeBannerAd(PnbBankServices.this, getString(R.string.nativebannerAxisC2));
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
                View adView1 = NativeBannerAdView.render(PnbBankServices.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankspnb2);
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

        mNativeBannerAxis3= new NativeBannerAd(PnbBankServices.this, getString(R.string.nativebannerAxisC3));
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
                View adView1 = NativeBannerAdView.render(PnbBankServices.this, mNativeBannerAxis3, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankspnb3);
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
