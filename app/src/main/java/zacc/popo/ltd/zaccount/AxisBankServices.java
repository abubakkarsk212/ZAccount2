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

public class AxisBankServices extends AppCompatActivity {
LinearLayout balP,balS1,avgB,rechargeA,ussdB,miniStatement,eStat,chequeSt,chequeReq,stopCheq,updateE,updateP,internetB,mmidA,cusId;
TextView knowM;
String[] averageM = {"Monthly Basis","Quarterly Basis","Half Yearly Basis"};
    private NativeBannerAd mNativeBannerAxis1,mNativeBannerAxis2,mNativeBannerAxis3;
    private com.facebook.ads.InterstitialAd interstitialAd;
    private com.facebook.ads.AdView adView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_axis_bank_services);
        adView = new com.facebook.ads.AdView(AxisBankServices.this, getString(R.string.banner_AxisBS1), AdSize.BANNER_HEIGHT_50);
        LinearLayout adContainer =findViewById(R.id.banner_axis1);
        adContainer.addView(adView);
        adView.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Toast.makeText(AxisBankServices.this, "Connection issue" + adError.getErrorMessage(),
                        Toast.LENGTH_LONG).show(); }});
        adView.loadAd();
        interstitialAd =new com.facebook.ads.InterstitialAd(AxisBankServices.this,getString(R.string.interstitial_AxisBS1));
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

        balP = findViewById(R.id.balPAx);
        balS1 = findViewById(R.id.balSecondaryAx);
        avgB = findViewById(R.id.AvgAx);
        rechargeA = findViewById(R.id.rechargeAx);
        ussdB = findViewById(R.id.ussdBankingAx);
        miniStatement = findViewById(R.id.miniStaAx);
        eStat = findViewById(R.id.eStatementAx);
        chequeReq = findViewById(R.id.reqAx);
        chequeSt = findViewById(R.id.chequeStaAx);
        stopCheq = findViewById(R.id.stopChequeAx);
        updateE = findViewById(R.id.updateEmailAx);
        updateP = findViewById(R.id.updatePanAx);
        internetB = findViewById(R.id.internetBAx);
        mmidA = findViewById(R.id.mmidAx);
        cusId = findViewById(R.id.getCusIdA);
        knowM = findViewById(R.id.knowAxis);
        balP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ph = "18004195959";
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" +ph));
                startActivity(i);
            }
        });
        balS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(AxisBankServices.this);
                alert.setCancelable(false);
                alert.setTitle("Check Secondary Account Balance");
                LinearLayout linearLayout = new LinearLayout(AxisBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(AxisBankServices.this);
                input.setHint("Enter Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="5676782";
                        String cardNo = input.getText().toString();
                        String msg = "BAL "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                        Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                    }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        avgB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder alert = new AlertDialog.Builder(AxisBankServices.this);
                alert.setCancelable(false);
                alert.setTitle("Check Projected Average Balance");
                LinearLayout linearLayout = new LinearLayout(AxisBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(AxisBankServices.this);
                input.setHint("Last 6 digit of account no");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);


//                alert.setPositiveButton("Check", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        String phNo ="5676782";
//                        String cardNo = input.getText().toString();
//                        String msg = "BAL "+cardNo;
//                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
//                        intentSms.setType("vnd.android-dir/mms-sms");
//                        intentSms.putExtra("sms_body", msg);
//                        intentSms.putExtra("address",phNo);
//                        if (intentSms.resolveActivity(getPackageManager()) != null) {
//                            startActivity(intentSms);
//                        }
//                        else{
//                            Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
                    alert.setSingleChoiceItems(averageM, -1, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            switch (i) {
                                case 0:
                                    String phNo = "5676782";
                                    final String cardNo = input.getText().toString();
                                    String msg = "PAMB " + cardNo;
                                    Intent intentSms = new Intent(Intent.ACTION_VIEW);
                                    intentSms.setType("vnd.android-dir/mms-sms");
                                    intentSms.putExtra("sms_body", msg);
                                    intentSms.putExtra("address", phNo);
                                    if (intentSms.resolveActivity(getPackageManager()) != null) {
                                        if(cardNo.length()>0) {
                                            startActivity(intentSms);
                                        }
                                        else {
                                            input.setError("Field Cannot be empty");
                                        }
                                    } else {
                                        Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case 1:
                                    // Your code when 2nd  option seletced
                                    final String cardNo1 = input.getText().toString();
                                    String phNo1 = "5676782";
                                    String msg1 = "PAQB " + cardNo1;
                                    Intent intentSms1 = new Intent(Intent.ACTION_VIEW);
                                    intentSms1.setType("vnd.android-dir/mms-sms");
                                    intentSms1.putExtra("sms_body", msg1);
                                    intentSms1.putExtra("address", phNo1);
                                    if (intentSms1.resolveActivity(getPackageManager()) != null) {

                                        if(cardNo1.length()>0) {
                                            startActivity(intentSms1);
                                        }
                                        else {
                                            input.setError("Field Cannot be empty");
                                        }
                                    } else {
                                        Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                                    }
                                    break;
                                case 2:
                                    // Your code when 3rd option seletced
                                    final String cardNo3 = input.getText().toString();
                                    String phNo3 = "5676782";
                                    String msg3 = "PHAB " + cardNo3;
                                    Intent intentSms3 = new Intent(Intent.ACTION_VIEW);
                                    intentSms3.setType("vnd.android-dir/mms-sms");
                                    intentSms3.putExtra("sms_body", msg3);
                                    intentSms3.putExtra("address", phNo3);
                                    if (intentSms3.resolveActivity(getPackageManager()) != null) {
                                        if(cardNo3.length()>0) {
                                            startActivity(intentSms3);
                                        }
                                        else {
                                            input.setError("Field Cannot be empty");
                                        }
                                    } else {
                                        Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                                    }
                                    break;

                            }
                        }
                    });


                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
        miniStatement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder alert = new AlertDialog.Builder(AxisBankServices.this);
                alert.setCancelable(false);
                alert.setTitle("Mini Statement");
                LinearLayout linearLayout = new LinearLayout(AxisBankServices.this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                final EditText input = new EditText(AxisBankServices.this);
                input.setHint("Enter Account No");
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                linearLayout.addView(input);
                alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String phNo ="5676782";
                        String cardNo = input.getText().toString();
                        String msg = "MINI "+cardNo;
                        Intent intentSms = new Intent(Intent.ACTION_VIEW);
                        intentSms.setType("vnd.android-dir/mms-sms");
                        intentSms.putExtra("sms_body", msg);
                        intentSms.putExtra("address",phNo);
                        if (intentSms.resolveActivity(getPackageManager()) != null) {
                            startActivity(intentSms);
                        }
                        else{
                            Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.setNegativeButton("Cancel",null);
                alert.setView(linearLayout);
                alert.show();
            }
        });
chequeSt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        final AlertDialog.Builder alert2 = new AlertDialog.Builder(AxisBankServices.this);
        alert2.setCancelable(false);
        alert2.setTitle("Cheque Status");
        LinearLayout linearLayout2 = new LinearLayout(AxisBankServices.this);
        linearLayout2.setOrientation(LinearLayout.VERTICAL);

        final EditText input2 = new EditText(AxisBankServices.this);
        input2.setHint("Enter 6 digit Cheque No");
        input2.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout2.addView(input2);
        final EditText inputAcct = new EditText(AxisBankServices.this);
        inputAcct.setHint("Last 6 digit of account no");
        inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
        linearLayout2.addView(inputAcct);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
        alert2.setPositiveButton("Check", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String phNo ="5676782";
                String acctNo =inputAcct.getText().toString();
                String cardNo = input2.getText().toString();
                String msg = "CHQST "+cardNo+" "+acctNo;
                Intent intentSms = new Intent(Intent.ACTION_VIEW);
                intentSms.setType("vnd.android-dir/mms-sms");
                intentSms.putExtra("sms_body", msg);
                intentSms.putExtra("address",phNo);
                if (intentSms.resolveActivity(getPackageManager()) != null) {
                    startActivity(intentSms);
                }
                else{
                    Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        alert2.setNegativeButton("Cancel",null);
        alert2.setView(linearLayout2);
        alert2.show();
    }
});
      chequeReq.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final AlertDialog.Builder alert = new AlertDialog.Builder(AxisBankServices.this);
              alert.setCancelable(false);
              alert.setTitle("Cheque Book Request");
              LinearLayout linearLayout = new LinearLayout(AxisBankServices.this);
              linearLayout.setOrientation(LinearLayout.VERTICAL);

              final EditText input = new EditText(AxisBankServices.this);
              input.setHint("Last 6 digit of Account No");
              input.setInputType(InputType.TYPE_CLASS_NUMBER);
              linearLayout.addView(input);
              alert.setPositiveButton("Request", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      String phNo ="5676782";
                      String cardNo = input.getText().toString();
                      String msg = "CHQBK "+cardNo;
                      Intent intentSms = new Intent(Intent.ACTION_VIEW);
                      intentSms.setType("vnd.android-dir/mms-sms");
                      intentSms.putExtra("sms_body", msg);
                      intentSms.putExtra("address",phNo);
                      if (intentSms.resolveActivity(getPackageManager()) != null) {
                          startActivity(intentSms);
                      }
                      else{
                          Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
              alert.setNegativeButton("Cancel",null);
              alert.setView(linearLayout);
              alert.show();
          }
      });
      stopCheq.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final AlertDialog.Builder alert2 = new AlertDialog.Builder(AxisBankServices.this);
              alert2.setCancelable(false);
              alert2.setTitle("Stop Cheque Request");
              LinearLayout linearLayout2 = new LinearLayout(AxisBankServices.this);
              linearLayout2.setOrientation(LinearLayout.VERTICAL);
               alert2.setMessage("Reason Code:-\n 019 - Cheque Book lost\n" + " 020 - Cheque Book mutilated\n" +
                       " 021 - Cheque Book stolen\n" +
                       " 022 - Cheque forged\n" +
                       " 023 - Cheque lost\n" +
                       " 018 - Cheque Book not received\n" +
                       " 016 - Others\n" +
                       " 017 - Wrong amount spelt");
              final EditText input2 = new EditText(AxisBankServices.this);
              input2.setHint("Enter 6 digit Cheque No");
              input2.setInputType(InputType.TYPE_CLASS_NUMBER);
              linearLayout2.addView(input2);
              final EditText inputAcct = new EditText(AxisBankServices.this);
              inputAcct.setHint("Last 6 digit of account no");
              inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
              linearLayout2.addView(inputAcct);
              final EditText reasonCode = new EditText(AxisBankServices.this);
              reasonCode.setHint("Enter 3 digit reason code");
              reasonCode.setInputType(InputType.TYPE_CLASS_NUMBER);
              linearLayout2.addView(reasonCode);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
              alert2.setPositiveButton("Stop", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      String phNo ="5676782";
                      String acctNo =inputAcct.getText().toString();
                      String cardNo = input2.getText().toString();
                      String reason = reasonCode.getText().toString();
                      String msg = "STOPCHQ "+cardNo+" "+acctNo+" "+reason;
                      Intent intentSms = new Intent(Intent.ACTION_VIEW);
                      intentSms.setType("vnd.android-dir/mms-sms");
                      intentSms.putExtra("sms_body", msg);
                      intentSms.putExtra("address",phNo);
                      if (intentSms.resolveActivity(getPackageManager()) != null) {
                          startActivity(intentSms);
                      }
                      else{
                          Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
              alert2.setNegativeButton("Cancel",null);
              alert2.setView(linearLayout2);
              alert2.show();
          }
      });
      updateE.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final AlertDialog.Builder alert = new AlertDialog.Builder(AxisBankServices.this);
              alert.setCancelable(false);
              alert.setTitle("Update Email Id");
              LinearLayout linearLayout = new LinearLayout(AxisBankServices.this);
              linearLayout.setOrientation(LinearLayout.VERTICAL);

              final EditText input = new EditText(AxisBankServices.this);
              input.setHint("Enter Valid Email Id");
              input.setInputType(InputType.TYPE_CLASS_TEXT);
              linearLayout.addView(input);
              alert.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      String phNo ="5676782";
                      String cardNo = input.getText().toString();
                      String msg = "UPDATEM "+cardNo;
                      Intent intentSms = new Intent(Intent.ACTION_VIEW);
                      intentSms.setType("vnd.android-dir/mms-sms");
                      intentSms.putExtra("sms_body", msg);
                      intentSms.putExtra("address",phNo);
                      if (intentSms.resolveActivity(getPackageManager()) != null) {
                          startActivity(intentSms);
                      }
                      else{
                          Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
              alert.setNegativeButton("Cancel",null);
              alert.setView(linearLayout);
              alert.show();
          }
      });
      updateP.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final AlertDialog.Builder alert2 = new AlertDialog.Builder(AxisBankServices.this);
              alert2.setCancelable(false);
              alert2.setTitle("Update PAN No");
              LinearLayout linearLayout2 = new LinearLayout(AxisBankServices.this);
              linearLayout2.setOrientation(LinearLayout.VERTICAL);

              final EditText input2 = new EditText(AxisBankServices.this);
              input2.setHint("Enter PAN No");
              input2.setInputType(InputType.TYPE_CLASS_NUMBER);
              linearLayout2.addView(input2);
              final EditText inputAcct = new EditText(AxisBankServices.this);
              inputAcct.setHint("Enter Customer Id");
              inputAcct.setInputType(InputType.TYPE_CLASS_NUMBER);
              linearLayout2.addView(inputAcct);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
              alert2.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      String phNo ="5676782";
                      String acctNo =inputAcct.getText().toString();
                      String cardNo = input2.getText().toString();
                      String msg = " "+cardNo+" "+acctNo;
                      Intent intentSms = new Intent(Intent.ACTION_VIEW);
                      intentSms.setType("vnd.android-dir/mms-sms");
                      intentSms.putExtra("sms_body", msg);
                      intentSms.putExtra("address",phNo);
                      if (intentSms.resolveActivity(getPackageManager()) != null) {
                          startActivity(intentSms);
                      }
                      else{
                          Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
              alert2.setNegativeButton("Cancel",null);
              alert2.setView(linearLayout2);
              alert2.show();
          }
      });
      internetB.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String url = "";
              Intent intent1 = new Intent(Intent.ACTION_VIEW);
              intent1.setData(Uri.parse(url));
              if (intent1.resolveActivity(getPackageManager()) != null) {
                  startActivity(intent1);
              }
          }
      });
      cusId.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final AlertDialog.Builder alert = new AlertDialog.Builder(AxisBankServices.this);
              alert.setCancelable(false);
              alert.setTitle("Get Customer Id");
              LinearLayout linearLayout = new LinearLayout(AxisBankServices.this);
              linearLayout.setOrientation(LinearLayout.VERTICAL);

              final EditText input = new EditText(AxisBankServices.this);
              input.setHint("Enter Account No");
              input.setInputType(InputType.TYPE_CLASS_TEXT);
              linearLayout.addView(input);
              alert.setPositiveButton("Get", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      String phNo ="5676782";
                      String cardNo = input.getText().toString();
                      String msg = "CUSTID "+cardNo;
                      Intent intentSms = new Intent(Intent.ACTION_VIEW);
                      intentSms.setType("vnd.android-dir/mms-sms");
                      intentSms.putExtra("sms_body", msg);
                      intentSms.putExtra("address",phNo);
                      if (intentSms.resolveActivity(getPackageManager()) != null) {
                          startActivity(intentSms);
                      }
                      else{
                          Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
              alert.setNegativeButton("Cancel",null);
              alert.setView(linearLayout);
              alert.show();
          }
      });
      mmidA.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              String phNo ="5676782";
              String msg = "MMID";
              Intent intentSms = new Intent(Intent.ACTION_VIEW);
              intentSms.setType("vnd.android-dir/mms-sms");
              intentSms.putExtra("sms_body", msg);
              intentSms.putExtra("address",phNo);
              if (intentSms.resolveActivity(getPackageManager()) != null) {
                  startActivity(intentSms);
              }
              else{
                  Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
              }
          }
      });
      eStat.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              final AlertDialog.Builder alert2 = new AlertDialog.Builder(AxisBankServices.this);
              alert2.setCancelable(false);
              alert2.setTitle("Get E-Statement");
              LinearLayout linearLayout2 = new LinearLayout(AxisBankServices.this);
              linearLayout2.setOrientation(LinearLayout.VERTICAL);
              final EditText input2 = new EditText(AxisBankServices.this);
              input2.setHint("Lst 5 digit Account No");
              input2.setInputType(InputType.TYPE_CLASS_NUMBER);
              linearLayout2.addView(input2);
              final EditText inputAcct = new EditText(AxisBankServices.this);
              inputAcct.setHint("From(dd-mm-yy)");
              inputAcct.setInputType(InputType.TYPE_CLASS_TEXT);
              linearLayout2.addView(inputAcct);
              final EditText reasonCode = new EditText(AxisBankServices.this);
              reasonCode.setHint("To(dd-mm-yyyy)");
              reasonCode.setInputType(InputType.TYPE_CLASS_TEXT);
              linearLayout2.addView(reasonCode);
//                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
//                        LinearLayout.LayoutParams.MATCH_PARENT,
//                        LinearLayout.LayoutParams.MATCH_PARENT);
              alert2.setPositiveButton("Stop", new DialogInterface.OnClickListener() {
                  @Override
                  public void onClick(DialogInterface dialogInterface, int i) {
                      String phNo ="5676782";
                      String acctNo =inputAcct.getText().toString();
                      String cardNo = input2.getText().toString();
                      String reason = reasonCode.getText().toString();
                      String msg = "ESTMT "+cardNo+" "+acctNo+" "+reason;
                      Intent intentSms = new Intent(Intent.ACTION_VIEW);
                      intentSms.setType("vnd.android-dir/mms-sms");
                      intentSms.putExtra("sms_body", msg);
                      intentSms.putExtra("address",phNo);
                      if (intentSms.resolveActivity(getPackageManager()) != null) {
                          startActivity(intentSms);
                      }
                      else{
                          Toast.makeText(AxisBankServices.this, "Application not found", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
              alert2.setNegativeButton("Cancel",null);
              alert2.setView(linearLayout2);
              alert2.show();
          }
      });
      knowM.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              AlertDialog.Builder alertD = new AlertDialog.Builder(AxisBankServices.this);
              alertD.setTitle("Projected Average Balance");
              alertD.setMessage("Projected Average Balance are calculated based on your yesterday's balance. It is assumed in calculations that you will maintain the same level of balance till the end of the period.");
              alertD.setCancelable(false);
              alertD.setPositiveButton("Ok", null);
              alertD.show();
          }
      });
      rechargeA.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
           Intent i = new Intent(AxisBankServices.this,RechargeAxis.class);
           startActivity(i);
          }
      });
      ussdB.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
         Intent i = new Intent(AxisBankServices.this,UssdAxis.class);
         startActivity(i);
          }
      });
        mNativeBannerAxis1= new NativeBannerAd(AxisBankServices.this, getString(R.string.nativebannerAxisBS1));
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
                View adView1 = NativeBannerAdView.render(AxisBankServices.this, mNativeBannerAxis1, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksaxis1);
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

        mNativeBannerAxis2= new NativeBannerAd(AxisBankServices.this, getString(R.string.nativebannerAxisBS2));
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
                View adView1 = NativeBannerAdView.render(AxisBankServices.this, mNativeBannerAxis2, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksaxis2);
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

        mNativeBannerAxis3= new NativeBannerAd(AxisBankServices.this, getString(R.string.nativebannerAxisBS3));
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
                View adView1 = NativeBannerAdView.render(AxisBankServices.this, mNativeBannerAxis3, NativeBannerAdView.Type.HEIGHT_100);
                LinearLayout nativeBannerAdContainer1 = findViewById(R.id.native_banksaxis3);
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
