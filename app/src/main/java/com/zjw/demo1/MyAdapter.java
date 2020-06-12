package com.zjw.demo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    /**
     * 连接下层数据
     * @return
     */
    List<MyMessage> messageList;
    Context mcontext;

    public MyAdapter(List<MyMessage> list,Context context){
        messageList = list;
        mcontext = context;
    }
    @Override
    public int getCount() {
        return messageList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view =
                LayoutInflater.from(mcontext).inflate(R.layout.my_item,null);
        LinearLayout left = view.findViewById(R.id.ll_left);
        RelativeLayout right = view.findViewById(R.id.rl_right);
        TextView left_text = view.findViewById(R.id.tv_left_msg);
        TextView right_text = view.findViewById(R.id.tv_right_msg);

        MyMessage myMessage = messageList.get(position);
        //判断是展示左侧消息（1）或者右侧消息（2）
        if(myMessage.getFlag() ==1){
            left.setVisibility(View.VISIBLE);
            right.setVisibility(View.GONE);
            left_text.setText(myMessage.getMsg());
        }else if(myMessage.getFlag()==2){
            left.setVisibility(View.GONE);
            right.setVisibility(View.VISIBLE);
            right_text.setText(myMessage.getMsg());
        }

        return view;
    }
}
