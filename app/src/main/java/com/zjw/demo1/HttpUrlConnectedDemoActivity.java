package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.UrlQuerySanitizer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpUrlConnectedDemoActivity extends AppCompatActivity {

    TextView show_mess;
    ImageView show_img;
    Button down_img;
    Button visit_baidu;
    String resultstr = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_url_connected_demo);
        show_mess = findViewById(R.id.tv_show);
        show_img = findViewById(R.id.iv_show);
        down_img = findViewById(R.id.bu_down1_img);
        visit_baidu = findViewById(R.id.bu_visit_baidu);
        visit_baidu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_img.setVisibility(View.GONE);
                show_mess.setVisibility(View.VISIBLE);
                Thread visitThread = new Thread(new VisitWebRunnable());
                visitThread.start();
                try {
                    visitThread.join();
                    if(resultstr != null){
                        show_mess.setText(resultstr);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        down_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_img.setVisibility(View.VISIBLE);
                show_mess.setVisibility(View.GONE);
                String url = "https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=3252521864,872614242&fm=26&gp=0.jpg";
                new DownImgAsyncTask().execute(url);
            }
        });
    }

    /**
     * 根据指定url获取响应字符串
     * @param urlstr
     * @return
     */
    private String getUrlResponse(String urlstr){
        String resutData = "";
        HttpURLConnection conn = null;
        InputStream is = null;
        try {
            //创建url对象
            URL url = new URL(urlstr);
            //使用url打开一个连接
            conn = (HttpURLConnection)url.openConnection();
            //允许输入流，即允许下载
            conn.setDoInput(true);
            conn.setDoOutput(true);
            //不使用缓存
            conn.setUseCaches(false);
            //设定请求方法
            conn.setRequestMethod("GET");
            //获取输入流
            is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader bufferedReader = new BufferedReader(isr);
            String inputLine = "";
            while ((inputLine = bufferedReader.readLine())!=null){
                resutData += inputLine + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
                conn.disconnect();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  resutData;

    }
    class VisitWebRunnable implements Runnable{
        @Override
        public void run() {
            String data = getUrlResponse("https://www.baidu.com/");
            resultstr = data;
        }
    }

    /**
     * 根据url下载图片
     * @param url
     * @return
     */
    private Bitmap getImg(String url){
        Bitmap bitmap = null;
        try {
            URL url1 = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
            conn.setDoInput(true);
            conn.connect();
            InputStream is = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(is);
            is.close();
            conn.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    class DownImgAsyncTask extends AsyncTask<String,Void,Bitmap>{

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = getImg(strings[0]);
            return bitmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            if(bitmap != null){
                show_img.setImageBitmap(bitmap);
            }
        }
    }
}
