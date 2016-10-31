package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.imageViewphone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber("0341712500");
            }
        });

    }

    public void dialPhoneNumber(String phonenumber)//Belum DI tes
    {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("Tel   :" + phonenumber));

        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }
}
