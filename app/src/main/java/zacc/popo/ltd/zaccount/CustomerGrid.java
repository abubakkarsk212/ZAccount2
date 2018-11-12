package zacc.popo.ltd.zaccount;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class CustomerGrid extends AppCompatActivity {
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_grid);
        gridView = findViewById(R.id.customerG);
        List<CustomerObj> customerObjs = new ArrayList<>();
        customerObjs.add(new CustomerObj(R.mipmap.sbi,"Sbi"));
        customerObjs.add(new CustomerObj(R.mipmap.icici,"Icici"));
        customerObjs.add(new CustomerObj(R.mipmap.federal,"Federal"));
        customerObjs.add(new CustomerObj(R.mipmap.kotak,"Kotak"));
        customerObjs.add(new CustomerObj(R.mipmap.pnb,"PNB"));
        customerObjs.add(new CustomerObj(R.mipmap.indian,"Indian Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.paytm,"Paytm"));
        customerObjs.add(new CustomerObj(R.mipmap.hdfc,"HDFC"));
        customerObjs.add(new CustomerObj(R.mipmap.union,"Union"));
        customerObjs.add(new CustomerObj(R.mipmap.airtel,"Airtel"));
        customerObjs.add(new CustomerObj(R.mipmap.rbl,"Rbl"));
        customerObjs.add(new CustomerObj(R.mipmap.axis,"Axis"));
        customerObjs.add(new CustomerObj(R.mipmap.idbi,"IDFC Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.dbs,"DiGi Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.yesb,"Yes Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.allahabad,"Allahabad Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.andhra,"Andhra Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.baroda,"Bank Of Baroda"));
        customerObjs.add(new CustomerObj(R.mipmap.boi,"Bank Of India"));
        customerObjs.add(new CustomerObj(R.mipmap.canara,"Canara Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.hsbc,"HSBC"));
        customerObjs.add(new CustomerObj(R.mipmap.indianoverseas,"Indian Overseas"));
        customerObjs.add(new CustomerObj(R.mipmap.indusland,"Indusland Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.karnataka,"Karnataka Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.standardcarter,"Standard Chartered"));
        customerObjs.add(new CustomerObj(R.mipmap.syndicate,"Syndicate Bank"));
        customerObjs.add(new CustomerObj(R.mipmap.uco,"UCO"));
        customerObjs.add(new CustomerObj(R.mipmap.vijaya,"Vijaya Bank"));
        customerObjs.add(new CustomerObj(R.drawable.cantfind,"Can't Find Bank!"));

        CustomerGridAdapter customerGridAdapter = new CustomerGridAdapter(CustomerGrid.this,R.layout.customer_layout_grid,customerObjs);
        gridView.setAdapter(customerGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 11){
                    Intent i1 = new Intent(CustomerGrid.this,AxisC.class);
                    startActivity(i1);
                }
                else if(i == 1){
                    Intent i1 = new Intent(CustomerGrid.this,IciciC.class);
                    startActivity(i1);
                }
                else if(i == 7){
                    Intent i1 = new Intent(CustomerGrid.this,HdfcC.class);
                    startActivity(i1);
                }
                else if(i == 2){
                    Intent i1 = new Intent(CustomerGrid.this,FederalC.class);
                    startActivity(i1);
                }
                else if(i == 9){
                    Intent i1 = new Intent(CustomerGrid.this,AirtelBC.class);
                    startActivity(i1);
                }
                else if(i == 5){
                    Intent i1 = new Intent(CustomerGrid.this,IndianC.class);
                    startActivity(i1);
                }
                else if(i == 3){
                    Intent i1 = new Intent(CustomerGrid.this,KotakC.class);
                    startActivity(i1);
                }
                else if(i == 6){
                    Intent i1 = new Intent(CustomerGrid.this,PaytmC.class);
                    startActivity(i1);
                }
                else if(i == 4){
                    Intent i1 = new Intent(CustomerGrid.this,PnbC.class);
                    startActivity(i1);
                }
                else if(i == 10){
                    Intent i1 = new Intent(CustomerGrid.this,RblC.class);
                    startActivity(i1);
                }
                else if(i == 0){
                    Intent i1 = new Intent(CustomerGrid.this,SbiC.class);
                    startActivity(i1);
                }
                else if(i == 8){
                    Intent i1 = new Intent(CustomerGrid.this,UnionC.class);
                    startActivity(i1);
                }
                else if(i == 13){
                    Intent i1 = new Intent(CustomerGrid.this,DbsC.class);
                    startActivity(i1);
                }
                else if(i == 12){
                    Intent i1 = new Intent(CustomerGrid.this,IdfcC.class);
                    startActivity(i1);
                }
                else if(i == 14){
                    Intent i1 = new Intent(CustomerGrid.this,YesBC.class);
                    startActivity(i1);
                }
                else if(i == 15){
                    Intent i1 = new Intent(CustomerGrid.this,AllahabadC.class);
                    startActivity(i1);
                }
                else if(i == 16){
                    Intent i1 = new Intent(CustomerGrid.this,AndhraC.class);
                    startActivity(i1);
                }
                else if(i == 17){
                    Intent i1 = new Intent(CustomerGrid.this,BankOfBaroda.class);
                    startActivity(i1);
                }
                else if(i == 18){
                    Intent i1 = new Intent(CustomerGrid.this,BankOfIndia.class);
                    startActivity(i1);
                }
                else if(i == 19){
                    Intent i1 = new Intent(CustomerGrid.this,CanaraBank.class);
                    startActivity(i1);
                }
                else if(i == 20){
                    Intent i1 = new Intent(CustomerGrid.this,HsbcC.class);
                    startActivity(i1);
                }
                else if(i == 21){
                    Intent i1 = new Intent(CustomerGrid.this,IndianOverseasC.class);
                    startActivity(i1);
                }
                else if(i == 22){
                    Intent i1 = new Intent(CustomerGrid.this,InduslandC.class);
                    startActivity(i1);
                }
                else if(i == 23){
                    Intent i1 = new Intent(CustomerGrid.this,KarnatakaC.class);
                    startActivity(i1);
                }
                else if(i == 24){
                    Intent i1 = new Intent(CustomerGrid.this,StandardC.class);
                    startActivity(i1);
                }
                else if(i == 25){
                    Intent i1 = new Intent(CustomerGrid.this,SyndicateC.class);
                    startActivity(i1);
                }
                else if(i == 26){
                    Intent i1 = new Intent(CustomerGrid.this,UcoC.class);
                    startActivity(i1);
                }
                else if(i == 27){
                    Intent i1 = new Intent(CustomerGrid.this,VijayaC.class);
                    startActivity(i1);
                }
                else if(i == 28){
                    Intent intent1 = new Intent(Intent.ACTION_SENDTO);
                    intent1.setData(Uri.parse("mailto:"));
                    intent1.putExtra(Intent.EXTRA_SUBJECT,"Banks required for Customer Care");
                    intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"helpybookapp@gmail.com"});
                    if (intent1.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent1);
                    }
                }


            }
        });


    }
}
