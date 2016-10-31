package id.sch.smktelkom_mlg.learn.intent3;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

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


        findViewById(R.id.imageViewmessage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                composesmsmessage("Pesan dari SMK Telkom Malang");

            }
        });


        findViewById(R.id.imageViewlanguage).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebPage("http://www.smktelkom-mlg.sch.id/");

            }
        });


        findViewById(R.id.imageViewcamera).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                capturephoto();

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

    public void composesmsmessage(String message)//Belum di tes
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra("sms_body", message);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);

    }

    public void openWebPage(String url)//belum di tes
    {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivity(intent);
    }

    public void capturephoto()//belum di tes
    {

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null)
            startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, requestCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap bitmap = data.getParcelableExtra("data");
            ImageView iv = (ImageView) findViewById(R.id.imageViewcamera);
            iv.setImageBitmap(bitmap);
        }
    }




}
