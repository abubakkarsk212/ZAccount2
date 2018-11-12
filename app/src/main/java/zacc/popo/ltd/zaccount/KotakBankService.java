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

public class KotakBankService extends AppCompatActivity {
LinearLayout balC,ussdB,rechargeKo,miniSta,eState,eStateAny,activateDebit,activateDebitPos,chequeSta,chequeReq,mmidK,crnK,cancelMmid,regenInB,regenPh,regenDebit,enbleIn,dematA,investA,loanAc,emi,fixedDe,loanColl,vehicleLoan,internetB;
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2,mNativeBannerAxis3;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kotak_bank_service);
        adView = new com.facebook.ads.AdView(KotakBankService.this, getString(R.string.banner_KotakBS), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_kotak1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(KotakBankService.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(KotakBankService.this,getString(R.string.interstitial_KotakBS));
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

        balC = findViewById(R.id.balKo);
        ussdB = findViewById(R.id.ussdBankingKo);
        rechargeKo = findViewById(R.id.rechargeKo);
        miniSta = findViewById(R.id.miniStaKo);
        eState =findViewById(R.id.eStatementKo);
        eStateAny = findViewById(R.id.eStateAnyKo);
        activateDebit = findViewById(R.id.activateDebitKo);
        activateDebitPos = findViewById(R.id.activateDebitPosKo);
        chequeSta = findViewById(R.id.chequeStaKo);
        chequeReq = findViewById(R.id.reqKo);
        mmidK = findViewById(R.id.mmidKo);
        crnK = findViewById(R.id.crnKo);
        cancelMmid = findViewById(R.id.cancelMMidKo);
        regenInB = findViewById(R.id.regenNetPinKo);
        regenPh = findViewById(R.id.regenPhoneKo);
        regenDebit = findViewById(R.id.regenDebitPonKo);
        enbleIn = findViewById(R.id.enableInterKo);
        dematA = findViewById(R.id.dematAccKo);
        investA = findViewById(R.id.investmentNoKo);
        loanAc = findViewById(R.id.loanAccKo);
        emi = findViewById(R.id.emiKo);
        fixedDe = findViewById(R.id.fixedKo);
        loanColl = findViewById(R.id.loanPayKo);
        internetB = findViewById(R.id.internetBKo);

        balC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "18002740110";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        miniSta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
                alert.setCancelable(false);
                alert.setTitle("Mini Statement");
                LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(KotakBankService.this);
                input.setHint("Last 4 digit of Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="5676788";
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
                            Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        eState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
                alert.setCancelable(false);
                alert.setTitle("Last 3 Month Statement");
                LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(KotakBankService.this);
                input.setHint("Last 4 digit of Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="5676788";
                        String cardNo = input.getText().toString();
                        String msg = "STMT "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        eStateAny.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
                alert.setCancelable(false);
                alert.setTitle("Any period Statement");
                LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(KotakBankService.this);
                input.setHint("Last 4 digit of Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                final EditText startDate = new EditText(KotakBankService.this);
                startDate.setHint("Start Date(First 3 letters of month followed by last 2 digits of the year)");
                startDate.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(startDate);

                final EditText endDate = new EditText(KotakBankService.this);
                endDate.setHint("End Date(First 3 letters of month followed by last 2 digits of the year)");
                endDate.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(endDate);
                alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="5676788";
                        String cardNo = input.getText().toString();
                        String start = startDate.getText().toString();
                        String end = endDate.getText().toString();
                        String msg = "STMT "+cardNo+" "+start+" "+end;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
activateDebit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Activate Debit Card");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of Debit Card Number");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Activate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "DCUNBLOCK "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
activateDebitPos.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Activate Debit Card For Use at Merchant Establishments (POS)");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of Debit Card No");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Activate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "POSACT "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
chequeSta.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Cheque Status Enquiry");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of Account No");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        final EditText startDate = new EditText(KotakBankService.this);
        startDate.setHint("6 Digit Cheque No");
        startDate.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(startDate);

        alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String start = startDate.getText().toString();

                String msg = "CHQSTATUS "+cardNo+" "+start;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
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
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Request New Cheque Book");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of Account No");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Request", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "CHQBOOK "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
mmidK.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Generate MMID");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of Account No");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Generate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "MMID "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
crnK.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String phNo ="5676788";
        String msg = "CRN";
        Intent intentSms = new Intent(Intent.ACTION_VIEW);
        intentSms.setType("vnd.android-dir/mms-sms");
        intentSms.putExtra("sms_body", msg);
        intentSms.putExtra("address",phNo);
        if (intentSms.resolveActivity(getPackageManager()) != null) {
            startActivity(intentSms);
        }
        else{
            Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
        }
    }
});
cancelMmid.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Cancel MMID for An Account");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Enter 7 digit MMID No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Do", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "MMIDREVOKE "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
regenInB.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Re-Generate Net Banking Pin");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of CRN No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Generate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "NETPIN "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
regenPh.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Re-Generate Phone Banking Pin");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of CRN No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Generate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "PHONEPIN "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
regenDebit.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Re-Generate Debit Card Pin");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of Debit Card No");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Generate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "DEBITPIN "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
enbleIn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Enable International Usage on Debit Card");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of Debit Card No");
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout.addView(input);
        alert.setPositiveButton("Enable", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "DCENB "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
dematA.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Know Your Demat Account Number");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of CRN No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "DPACCT "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
investA.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Know Your Investment Account Number");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of CRN No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "MFACCT "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
loanAc.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Loan A/C No");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Application APAC No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "LOANBAL "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
emi.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("EMI Details");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Application APAC No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "LOANEMI "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
fixedDe.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Term Deposit/Fixed Deposit Renewal");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Last 4 digit of Fixed Deposit No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "TDREN "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert.setNegativeButton("Cancel",null);
        alert.setView(linearLayout);
        alert.show();
    }
});
loanColl.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(KotakBankService.this);
        alert.setCancelable(false);
        alert.setTitle("Request for Loan Payment Collection");
        LinearLayout linearLayout = new LinearLayout(KotakBankService.this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final EditText input = new EditText(KotakBankService.this);
        input.setHint("Application APAC No");
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        linearLayout.addView(input);
        alert.setPositiveButton("Request", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676788";
                String cardNo = input.getText().toString();
                String msg = "LOANPAY "+cardNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(KotakBankService.this, "Application not found", Toast.LENGTH_SHORT).show();
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
        String url = "https://www.kotak.com/j1001mp/netapp/MainPage.jsp";
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
        Intent i = new Intent(KotakBankService.this,UssdKotak.class);
        startActivity(i);
    }
});
    rechargeKo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i = new Intent(KotakBankService.this,RechargeKotak.class);
            startActivity(i);
        }
    });
        mNativeBannerAxis1= new NativeBannerAd(KotakBankService.this, getString(R.string.nativebannerKotakBS1));
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
                View adView1 = NativeBannerAdView.render(KotakBankService.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankskotak1);
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

        mNativeBannerAxis2= new NativeBannerAd(KotakBankService.this, getString(R.string.nativebannerKotakBS2));
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
                View adView1 = NativeBannerAdView.render(KotakBankService.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankskotak2);
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

        mNativeBannerAxis3= new NativeBannerAd(KotakBankService.this, getString(R.string.nativebannerKotakBS3));
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
                View adView1 = NativeBannerAdView.render(KotakBankService.this, mNativeBannerAxis3, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_bankskotak3);
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
