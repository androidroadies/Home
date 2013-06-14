package com.example.home;

import java.io.IOException;

import android.app.Activity;
import android.app.WallpaperManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

    int pos = 0;
    int amount = 10;
    int max = amount - 1;
    int min = 0;
    Button prev, next, set;
    ImageView image;
    Bitmap bitmap;
    final int[] imgs = new int[] { R.drawable.ic_launcher, R.drawable.tango, R.drawable.unnamed,
            };

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.imgview);
        prev = (Button) findViewById(R.id.pre);
        next = (Button) findViewById(R.id.next);
        set = (Button) findViewById(R.id.set);
        image.setImageResource(R.drawable.ic_launcher);
        prev.setOnClickListener(this);
        next.setOnClickListener(this);
        set.setOnClickListener(this);

    }

    public void onClick(View v) {

        switch (v.getId()) {
        case R.id.pre:
            if (pos > min) {
                pos--;
                image.setImageResource(imgs[pos]);
                ;
            } else {
            }
            break;
        case R.id.next:
            if (pos < max) {
                pos++;
                image.setImageResource(imgs[pos]);
                ;
            } else {
            }
            break;
        case R.id.set:

            // MAGIC GOES HERE ;)

//            bitmap = BitmapFactory.decodeResource(getResources(), 
//                    R.drawable.ic_launcher);    
            
            bitmap = BitmapFactory.decodeResource(getResources(), 
                    imgs[pos]);
            
            Toast.makeText(getApplicationContext(), "success", Toast.LENGTH_LONG).show();
            try {
                getApplicationContext().setWallpaper(bitmap);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            // --------------- //

            break;
        }

    }
}