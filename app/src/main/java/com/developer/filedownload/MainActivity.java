package com.developer.filedownload;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
        Handler handler = new Handler();
        ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        final ImageDownload imageDownload = new ImageDownload();



        new Thread(new Runnable() {
            @Override
            public void run() {
                imageDownload.downloadImage(imageView);

                //Genelde Activity içinde kullanılır
             /*   runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                    }

                });*/


             //Genelde Class ta kullanılır
              /*  handler.post(new Runnable() {
                    @Override
                    public void run() {
                    }
                });*/


            }

        }).start();





    }

}
