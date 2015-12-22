package com.example.g0274.picbox;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private GridView picView;

    //int id =  this.getResources().getIdentifier("filename" , "drawable", this.getPackageName());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        picView = (GridView) findViewById(R.id.picView);
        List<Map<String, Object>> items = new ArrayList<>();
        //圖片塞入ArrayList
        for (int i = 1; i <= 2; i++) {
            Map<String, Object> item = new HashMap<>();
            int id = this.getResources().getIdentifier("pic_" + i, "drawable", this.getPackageName());
            /*InputStream is = this.getResources().openRawResource(id);
            BitmapFactory.Options options=new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = 10; //width，hight設為原來的十分一
            Bitmap btp =BitmapFactory.decodeStream(is, null, options);*/
            //Log.d("id~", String.valueOf(id));
            //item.put("image",id);
            // 取得 Resource 圖片的 Bitmap
            Bitmap vBitmap = BitmapFactory.decodeResource(this.getResources(), id);

            item.put("image", vBitmap);
            items.add(item);
        }
        //GridView加入imageView
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,
                items, R.layout.pic, new String[]{"image"},
                new int[]{R.id.country_pic});

        picView.setAdapter(simpleAdapter);
    }
}
