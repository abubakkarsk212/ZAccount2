package zacc.popo.ltd.zaccount;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class CustomAlert extends Dialog implements View.OnClickListener{
    public Activity c;
    public Dialog d;
    public Button yes, no;
    public EditText editText;
    public CustomAlert(@NonNull Activity context) {
        super(context);
        this.c = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_alert_design);
        yes =  findViewById(R.id.yesB);
        no = (Button) findViewById(R.id.noB);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
        editText = findViewById(R.id.enterN);
        yes.setOnClickListener(this);
        no.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.yesB:
                String phNo = editText.getText().toString();
                yes.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                break;
            case R.id.noB:
                dismiss();
                break;
            default:
                break;
        }
        dismiss();

    }

}
