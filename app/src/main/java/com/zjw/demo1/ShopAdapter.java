package com.zjw.demo1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.zjw.demo1.R;

import java.util.List;

public class ShopAdapter extends BaseAdapter {

    List<String> mlist;
    Context mcontext;
    public ShopAdapter(List<String> list,Context context)
    {
        mlist =list;
        mcontext = context;
    }

    @Override
    public int getCount() {
        return 0;
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

        convertView = LayoutInflater.from(mcontext).inflate(R.layout.item_main_shoplist,null);
        //列表项页面值填充
        //列表项组件事件绑定
        return convertView;
    }
}
