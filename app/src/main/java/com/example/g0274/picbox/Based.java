package com.example.g0274.picbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.InputStream;

/**
 * Created by g0274 on 2015/12/21.
 */
public class Based extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.based);
        GridView gv = (GridView) this.findViewById(R.id.gridView);
        ImageView iv=(ImageView)this.findViewById(R.id.imageView);

        for (int i = 0; i < 3; i++) {
            //int id = this.getResources().getIdentifier("pic_" + i, "drawable", this.getPackageName());
           // Bitmap src = BitmapFactory.decodeResource(getResources(), id);
            //ImageView iv = new ImageView(this);
            //  iv.setId(i);
            //Bitmap bm = Bitmap.createBitmap(src, j * (src.getWidth() / 2), j * (src.getHeight() / 3), src.getWidth() / 3, src.getHeight() / 3);
            int id =  this.getResources().getIdentifier("pic_"+i , "drawable", this.getPackageName());
            InputStream is = this.getResources().openRawResource(id);
            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 10; //width，hight設為原來的十分一
            Bitmap btp =BitmapFactory.decodeStream(is, null, options);
            iv.setImageBitmap(btp);
            gv.addView(iv);
        }
    }
}
