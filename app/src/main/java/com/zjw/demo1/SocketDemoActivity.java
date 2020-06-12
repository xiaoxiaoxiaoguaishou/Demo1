package com.zjw.demo1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketDemoActivity extends AppCompatActivity {
    private TextView chatMessage;
    private EditText sendMessage;
    private Button send;
    //服务器ip
    private final String HOST = "192.168.0.6";
    //服务器端口
    private final int PORT = 9898;
    //申明套接字
    private Socket socket = null;
    private BufferedReader bufferedReader=null;
    private PrintWriter printWriter = null;
    private String str="";

    public Handler message = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            chatMessage.setText(chatMessage.getText().toString()+"\n"
                    +"来自服务器的消息："+str);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_socket_demo);
        chatMessage = findViewById(R.id.tv_chat_message);
        sendMessage = findViewById(R.id.et_send_message);
        send = findViewById(R.id.bu_send);

        new Thread(){
            @Override
            public void run() {
                try {
                    socket = new Socket(HOST,PORT);
                    bufferedReader =
                            new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    printWriter = new PrintWriter(
                            new BufferedWriter(
                                    new OutputStreamWriter(socket.getOutputStream())),true
                    );

                    while(true){
                        //若保持连接
                        if(socket.isConnected()){
                            if((str = bufferedReader.readLine())!=null){
                                message.sendEmptyMessage(1);
                            }
                        }
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mess = sendMessage.getText().toString();
                if(socket.isConnected()){
                    printWriter.println(mess);
                    chatMessage.setText(chatMessage.getText().toString()+"\n"
                            +"发送："+mess);
                    sendMessage.setText("");
                }
            }
        });
    }
}

