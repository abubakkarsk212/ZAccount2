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

public class RblBankingServices extends AppCompatActivity {
LinearLayout register1,deregister,balP,balSe,loanP,loanS,fdP,fdS,ussdB,miniP,miniS,genPin,reGenPin,custIdAll,cusId1,blockT,blockP,unblock,chequeSiBank,changeBank,interneB;
String[] blockAtm ={"Primary Account","Secondary Account"};
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2,mNativeBannerAxis3,mNativeBannerAxis4;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rbl_banking_services);
        adView = new com.facebook.ads.AdView(RblBankingServices.this, getString(R.string.banner_RblBS), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_rbl1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(RblBankingServices.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(RblBankingServices.this,getString(R.string.interstitial_RblBS));
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

        register1 = findViewById(R.id.registerRbl);
        deregister = findViewById(R.id.deactivateRegRbl);
        balP = findViewById(R.id.balRbl);
        balSe = findViewById(R.id.balRblS);
        loanP = findViewById(R.id.loanRbl);
        loanS = findViewById(R.id.loanRblS);
        fdP = findViewById(R.id.fdRbl);
        fdS = findViewById(R.id.fdRblS);
        ussdB = findViewById(R.id.ussdBankingRbl);
        miniP = findViewById(R.id.miniStaRbl);
        miniS = findViewById(R.id.miniStaRblS);
        genPin = findViewById(R.id.genAtmRbl);
        reGenPin = findViewById(R.id.regenAtmRbl);
        custIdAll = findViewById(R.id.getCusIdallRbl);
        cusId1 = findViewById(R.id.getCusIdRbl);
        blockT = findViewById(R.id.blockATMTRbl);
        blockP = findViewById(R.id.blockATMPRbl);
        unblock = findViewById(R.id.unblockATMRbl);
        chequeSiBank = findViewById(R.id.chequeStatusRbl);
        changeBank = findViewById(R.id.changePaRbl);
        interneB = findViewById(R.id.internetBRbl);
        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
                alert.setCancelable(false);
                alert.setTitle("Register For Bank Services");
                LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(RblBankingServices.this);
                input.setHint("Enter Customer Id");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Register", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9223366333";
                        String cardNo = input.getText().toString();
                        String msg = "REG "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        deregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
                alert.setCancelable(false);
                alert.setTitle("De-Register For Bank Services");
                LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(RblBankingServices.this);
                input.setHint("Enter Customer Id");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("De-Register", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="9223366333";
                        String cardNo = input.getText().toString();
                        String msg = "DEREG "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
balP.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String ph = "18004190610";
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
        startActivity(i);
    }
});
balSe.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Balance for Primary Account");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Enter Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);

        final EditText acc = new EditText(RblBankingServices.this);
        acc.setHint("Enter Account No");
        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(acc);
        alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String acctNo =acc.getText().toString();
                String msg = "BAL "+cardNo+" "+acctNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
loanP.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Loan balance for Primary Account");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Enter Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String msg = "LOANINQ "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
loanS.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Loan Balance for Secondary Account");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Enter Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);

        final EditText acc = new EditText(RblBankingServices.this);
        acc.setHint("Enter Loan/Acct No");
        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(acc);
        alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String acctNo =acc.getText().toString();
                String msg = "LOANINQ "+cardNo+" "+acctNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
fdP.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Fixed Deposit for Primary Account");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Enter Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String msg = "FDINQ "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
fdS.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Fixed Deposit for Secondary Account");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Enter Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);

        final EditText acc = new EditText(RblBankingServices.this);
        acc.setHint("Enter Fixed Deposit No");
        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(acc);
        alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String acctNo =acc.getText().toString();
                String msg = "FDINQ "+cardNo+" "+acctNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
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
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Mini Statement");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Enter Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String msg = "TXN "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
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
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Mini Statement For Secondary Account");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Enter Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);

        final EditText acc = new EditText(RblBankingServices.this);
        acc.setHint("Enter Account No");
        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(acc);
        alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String acctNo =acc.getText().toString();
                String msg = "TXN "+cardNo+" "+acctNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
genPin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Generate ATM Pin");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Last 4 digit of card number");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);

        final EditText acc = new EditText(RblBankingServices.this);
        acc.setHint("Enter Customer Id");
        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(acc);

        final EditText pin = new EditText(RblBankingServices.this);
        pin.setHint("Enter PIN");
        pin.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(pin);
        alert.setPositiveButton("Generate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String acctNo =acc.getText().toString();
                String pinA = pin.getText().toString();
                String msg = "PIN "+cardNo+" "+acctNo+" "+pinA;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
reGenPin.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Re-Generate ATM Pin");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Last 4 digit of card number");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);

        final EditText acc = new EditText(RblBankingServices.this);
        acc.setHint("Enter Customer Id");
        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(acc);

        final EditText pin = new EditText(RblBankingServices.this);
        pin.setHint("Enter PIN");
        pin.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(pin);
        alert.setPositiveButton("Generate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String acctNo =acc.getText().toString();
                String pinA = pin.getText().toString();
                String msg = "REPIN "+cardNo+" "+acctNo+" "+pinA;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
custIdAll.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String phNo ="9223366333";

        String msg = "CIF";
        Intent intentSms = new Intent(Intent.ACTION_VIEW);
        intentSms.setType("vnd.android-dir/mms-sms");
        intentSms.putExtra("sms_body", msg);
        intentSms.putExtra("address",phNo);
        if (intentSms.resolveActivity(getPackageManager()) != null) {
            startActivity(intentSms);
        }
        else{
            Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
        }
    }
});
cusId1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Get Customer ID for an account ");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Last 4 digit of Acct No");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String msg = "CIF "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
blockT.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setTitle("Block Temporary");

        alert.setSingleChoiceItems(blockAtm, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i)
                {
                    case 0:
                        final AlertDialog.Builder alert1 = new AlertDialog.Builder(RblBankingServices.this);
                        alert1.setCancelable(false);
                        alert1.setTitle("For Primary Account");
                        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
                        linearLayout.setOrientation(LinearLayout.VERTICAL);

                        final EditText input = new EditText(RblBankingServices.this);
                        input.setHint("Last 4 digit of card no");
                        input.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout.addView(input);
                        alert1.setPositiveButton("Block", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String phNo ="9223366333";
                                String cardNo = input.getText().toString();
                                String msg = "TBLOCK "+cardNo;
                                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                intentSms.setType("vnd.android-dir/mms-sms");
                                intentSms.putExtra("sms_body", msg);
                                intentSms.putExtra("address",phNo);
                                if (intentSms.resolveActivity(getPackageManager()) != null) {
                                    startActivity(intentSms);
                                }
                                else{
                                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        alert1.setNegativeButton("Cancel",null);
                        alert1.setView(linearLayout);
                        alert1.show();
                        break;
                    case 1:
                        // Your code when 2nd  option seletced
                        final AlertDialog.Builder alert2 = new AlertDialog.Builder(RblBankingServices.this);
                        alert2.setCancelable(false);
                        alert2.setTitle("For Secondary Account");
                        LinearLayout linearLayout1 = new LinearLayout(RblBankingServices.this);
                        linearLayout1.setOrientation(LinearLayout.VERTICAL);

                        final EditText input1 = new EditText(RblBankingServices.this);
                        input1.setHint("Enter Last 4 digit of Card No");
                        input1.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout1.addView(input1);

                        final EditText acc = new EditText(RblBankingServices.this);
                        acc.setHint("Enter Customer Id");
                        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout1.addView(acc);
                        alert2.setPositiveButton("Block", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String phNo1 ="9223366333";
                                String cardNo1 = input1.getText().toString();
                                String acctNo1 =acc.getText().toString();
                                String msg1 = "TBLOCK "+cardNo1+" "+acctNo1;
                                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                intentSms.setType("vnd.android-dir/mms-sms");
                                intentSms.putExtra("sms_body", msg1);
                                intentSms.putExtra("address",phNo1);
                                if (intentSms.resolveActivity(getPackageManager()) != null) {
                                    startActivity(intentSms);
                                }
                                else{
                                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
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
blockP.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setTitle("Block Permanently");

        alert.setSingleChoiceItems(blockAtm, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i)
                {
                    case 0:
                        final AlertDialog.Builder alert1 = new AlertDialog.Builder(RblBankingServices.this);
                        alert1.setCancelable(false);
                        alert1.setTitle("For Primary Account");
                        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
                        linearLayout.setOrientation(LinearLayout.VERTICAL);

                        final EditText input = new EditText(RblBankingServices.this);
                        input.setHint("Last 4 digit of card no");
                        input.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout.addView(input);
                        alert1.setPositiveButton("Block", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String phNo ="9223366333";
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
                                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        alert1.setNegativeButton("Cancel",null);
                        alert1.setView(linearLayout);
                        alert1.show();
                        break;
                    case 1:
                        // Your code when 2nd  option seletced
                        final AlertDialog.Builder alert2 = new AlertDialog.Builder(RblBankingServices.this);
                        alert2.setCancelable(false);
                        alert2.setTitle("For Secondary Account");
                        LinearLayout linearLayout1 = new LinearLayout(RblBankingServices.this);
                        linearLayout1.setOrientation(LinearLayout.VERTICAL);

                        final EditText input1 = new EditText(RblBankingServices.this);
                        input1.setHint("Enter Last 4 digit of Card No");
                        input1.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout1.addView(input1);

                        final EditText acc = new EditText(RblBankingServices.this);
                        acc.setHint("Enter Customer Id");
                        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout1.addView(acc);
                        alert2.setPositiveButton("Block", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String phNo1 ="9223366333";
                                String cardNo1 = input1.getText().toString();
                                String acctNo1 =acc.getText().toString();
                                String msg1 = "BLOCK "+cardNo1+" "+acctNo1;
                                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                intentSms.setType("vnd.android-dir/mms-sms");
                                intentSms.putExtra("sms_body", msg1);
                                intentSms.putExtra("address",phNo1);
                                if (intentSms.resolveActivity(getPackageManager()) != null) {
                                    startActivity(intentSms);
                                }
                                else{
                                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
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
unblock.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setTitle("UnBlock Card");

        alert.setSingleChoiceItems(blockAtm, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                switch(i)
                {
                    case 0:
                        final AlertDialog.Builder alert1 = new AlertDialog.Builder(RblBankingServices.this);
                        alert1.setCancelable(false);
                        alert1.setTitle("For Primary Account");
                        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
                        linearLayout.setOrientation(LinearLayout.VERTICAL);

                        final EditText input = new EditText(RblBankingServices.this);
                        input.setHint("Last 4 digit of card no");
                        input.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout.addView(input);
                        alert1.setPositiveButton("UnBlock", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String phNo ="9223366333";
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
                                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                        alert1.setNegativeButton("Cancel",null);
                        alert1.setView(linearLayout);
                        alert1.show();
                        break;
                    case 1:
                        // Your code when 2nd  option seletced
                        final AlertDialog.Builder alert2 = new AlertDialog.Builder(RblBankingServices.this);
                        alert2.setCancelable(false);
                        alert2.setTitle("For Secondary Account");
                        LinearLayout linearLayout1 = new LinearLayout(RblBankingServices.this);
                        linearLayout1.setOrientation(LinearLayout.VERTICAL);

                        final EditText input1 = new EditText(RblBankingServices.this);
                        input1.setHint("Enter Last 4 digit of Card No");
                        input1.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout1.addView(input1);

                        final EditText acc = new EditText(RblBankingServices.this);
                        acc.setHint("Enter Customer Id");
                        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
                        linearLayout1.addView(acc);
                        alert2.setPositiveButton("UnBlock", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String phNo1 ="9223366333";
                                String cardNo1 = input1.getText().toString();
                                String acctNo1 =acc.getText().toString();
                                String msg1 = "UBLOCK "+cardNo1+" "+acctNo1;
                                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                intentSms.setType("vnd.android-dir/mms-sms");
                                intentSms.putExtra("sms_body", msg1);
                                intentSms.putExtra("address",phNo1);
                                if (intentSms.resolveActivity(getPackageManager()) != null) {
                                    startActivity(intentSms);
                                }
                                else{
                                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
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
chequeSiBank.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Cheque Status");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);

        final EditText acc = new EditText(RblBankingServices.this);
        acc.setHint("Account No");
        acc.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(acc);

        final EditText pin = new EditText(RblBankingServices.this);
        pin.setHint("Cheque No");
        pin.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(pin);
        alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String acctNo =acc.getText().toString();
                String pinA = pin.getText().toString();
                String msg = "CHQSTA "+cardNo+" "+acctNo+" "+pinA;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
changeBank.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(RblBankingServices.this);
        alert.setCancelable(false);
        alert.setTitle("Change Of Primary Account");
        LinearLayout linearLayout = new LinearLayout(RblBankingServices.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(RblBankingServices.this);
        input.setHint("Enter Customer Id");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        final EditText input1 = new EditText(RblBankingServices.this);
        input1.setHint("Enter Account No");
        input1.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input1);
        alert.setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="9223366333";
                String cardNo = input.getText().toString();
                String acctNo = input1.getText().toString();
                String msg = "CIF "+cardNo+" "+acctNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(RblBankingServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
interneB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String url = "https://cards.rblbank.com/";
        Intent intent1 = new Intent(Intent.ACTION_VIEW);
        intent1.setData(Uri.parse(url));
        if (intent1.resolveActivity(getPackageManager()) != null) {
            startActivity(intent1);
        }
    }
});
ussdB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
   Intent i = new Intent(RblBankingServices.this,UssdRbl.class);
   startActivity(i);
    }
});

        mNativeBannerAxis1= new NativeBannerAd(RblBankingServices.this, getString(R.string.nativebannerRblB1));
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
                View adView1 = NativeBannerAdView.render(RblBankingServices.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksrbl1);
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

        mNativeBannerAxis2= new NativeBannerAd(RblBankingServices.this, getString(R.string.nativebannerRblB2));
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
                View adView1 = NativeBannerAdView.render(RblBankingServices.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksrbl2);
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

        mNativeBannerAxis3= new NativeBannerAd(RblBankingServices.this, getString(R.string.nativebannerHsbcC1));
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
                View adView1 = NativeBannerAdView.render(RblBankingServices.this, mNativeBannerAxis3, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksrbl3);
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

        mNativeBannerAxis4= new NativeBannerAd(RblBankingServices.this, getString(R.string.nativebannerHsbcC2));
        //623848994653940_626245771080929
        mNativeBannerAxis4.setAdListener(new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {

            }

            @Override
            public void onError(Ad ad, AdError adError) {

            }

            @Override
            public void onAdLoaded(Ad ad) {
// Render the Native Banner Ad Template
                View adView1 = NativeBannerAdView.render(RblBankingServices.this, mNativeBannerAxis4, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksrbl4);
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
        mNativeBannerAxis4.loadAd();

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
