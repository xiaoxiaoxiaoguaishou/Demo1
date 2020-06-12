package com.zjw.demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AIChatActivity extends AppCompatActivity {
    EditText send_msg;
    Button send;
    ListView listView;
    MyAdapter myAdapter;
    List<MyMessage> messageList;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            myAdapter.notifyDataSetChanged();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aichat);

        send_msg = findViewById(R.id.et_send_msg1);
        send = findViewById(R.id.bu_send);
        listView = findViewById(R.id.lv_msgs);
        messageList = new ArrayList<>();
        myAdapter = new MyAdapter(messageList,this);
        listView.setAdapter(myAdapter);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyMessage myMessage = new MyMessage(1,send_msg.getText().toString());
                messageList.add(myMessage);
                myAdapter.notifyDataSetChanged();
                String url = "http://api.qingyunke.com/api.php?key=free&appid=0&msg="+send_msg.getText().toString();
                send_msg.setText("");
                getMsgByOkHttp(url);
            }
        });


    }

    /**
     * 通过okhttp框架请求服务器信息
     * @param url
     */
    public void getMsgByOkHttp(String url){
        OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder().url(url).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if(response.isSuccessful()){
                    String result = response.body().string();
                    //解析json
                    try {
                        JSONObject jsonObject = new JSONObject(result);
                        String cont = jsonObject.getString("content");
                        MyMessage myMessage = new MyMessage(2,cont);
                        messageList.add(myMessage);
                        handler.sendEmptyMessage(123);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }
        });
    }
}
