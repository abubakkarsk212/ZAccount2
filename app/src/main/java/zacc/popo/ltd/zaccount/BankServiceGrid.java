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

public class BankServiceGrid extends AppCompatActivity {
GridView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_service_grid);
        gridView = findViewById(R.id.customerG1);
        List<BankServicesGridObj> customerObjs = new ArrayList<>();
        customerObjs.add(new BankServicesGridObj(R.mipmap.sbi,"Sbi"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.icici,"Icici"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.federal,"Federal"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.kotak,"Kotak"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.pnb,"PNB"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.indian,"Indian Bank"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.hdfc,"HDFC"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.union,"Union"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.rbl,"Rbl"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.axis,"Axis"));
        customerObjs.add(new BankServicesGridObj(R.mipmap.idbi,"IDFC Bank"));
        customerObjs.add(new BankServicesGridObj(R.drawable.cantfind,"Can't Find Bank!"));

        BankServiceGridAdapter customerGridAdapter = new BankServiceGridAdapter(BankServiceGrid.this,R.layout.bankservice_layout_grid,customerObjs);
        gridView.setAdapter(customerGridAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i == 0){
                    Intent i1 = new Intent(BankServiceGrid.this,SbiBankServices.class);
                    startActivity(i1);
                }
                if(i == 1){
                    Intent i1 = new Intent(BankServiceGrid.this,IciciBankService.class);
                    startActivity(i1);
                }
                if(i == 2){
                    Intent i1 = new Intent(BankServiceGrid.this,FederalBankService.class);
                    startActivity(i1);
                }
                if(i == 6){
                    Intent i1 = new Intent(BankServiceGrid.this,HdfcBankServices.class);
                    startActivity(i1);
                }
                if(i == 5){
                    Intent i1 = new Intent(BankServiceGrid.this,IndianBankService.class);
                    startActivity(i1);
                }
                if(i == 9){
                    Intent i1 = new Intent(BankServiceGrid.this,AxisBankServices.class);
                    startActivity(i1);
                }
                if(i == 8){
                    Intent i1 = new Intent(BankServiceGrid.this,RblBankingServices.class);
                    startActivity(i1);
                }
                if(i == 7){
                    Intent i1 = new Intent(BankServiceGrid.this,UnionBankService.class);
                    startActivity(i1);
                }
                if(i == 10){
                    Intent i1 = new Intent(BankServiceGrid.this,IdfcBankingService.class);
                    startActivity(i1);
                }
                if(i == 3){
                    Intent i1 = new Intent(BankServiceGrid.this,KotakBankService.class);
                    startActivity(i1);
                }
                if(i == 4){
                    Intent i1 = new Intent(BankServiceGrid.this,PnbBankServices.class);
                    startActivity(i1);
                }
                if(i == 11){
                    Intent intent1 = new Intent(Intent.ACTION_SENDTO);
                    intent1.setData(Uri.parse("mailto:"));
                    intent1.putExtra(Intent.EXTRA_SUBJECT,"Banks required for Bank Services");
                    intent1.putExtra(Intent.EXTRA_EMAIL, new String[]{"helpybookapp@gmail.com"});
                    if (intent1.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent1);
                    }
                }


            }
        });
    }
}
