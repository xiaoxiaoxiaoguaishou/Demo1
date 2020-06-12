package com.zjw.demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BitMapDemoActivity extends AppCompatActivity {

    ImageView myImage;
    Bitmap myBitMap = null;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            myImage.setImageBitmap(myBitMap);
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bit_map_demo);

        myImage = findViewById(R.id.iv_bitmap);
//        new Thread() {
//            @Override
//            public void run() {
//                getBitMap("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1590395850778&di=e39bffd0c22e9e51a2bdc3be402265a6&imgtype=0&src=http%3A%2F%2Fa3.att.hudong.com%2F14%2F75%2F01300000164186121366756803686.jpg");
//
//            }
//        }.start();
        //getBitMap();
        getBitMapFromSdCard();
    }

    /**
     * 根据url加载网络图片
     * @param url
     */
    public void getBitMap(String url){

        try{
            URL imgUrl =new URL(url);
            HttpURLConnection conn = (HttpURLConnection) imgUrl.openConnection();
            conn.connect();
            InputStream is =conn.getInputStream();
            myBitMap = BitmapFactory.decodeStream(is);
            handler.sendEmptyMessage(1);
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    /**
     * j加载项目资源文件
     *
     */
    public void getBitMap(){
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.perfect);
        //设置在imageview中展示
        myImage.setImageBitmap(bitmap);
    }
    /**
     * 加载sdk卡资源文件
     */
    public void getBitMapFromSdCard(){
        Bitmap bitmap = null;
        String file_path = "/sdcard/Pictures/log.png";
        BitmapFactory.Options options = new BitmapFactory.Options();
        //只加载长宽尺寸 ，不加载完整资源
        options.inSampleSize = 2;
        options.inJustDecodeBounds =true;
        bitmap = BitmapFactory.decodeFile(file_path);
        myImage.setImageBitmap(bitmap);

    }
}
