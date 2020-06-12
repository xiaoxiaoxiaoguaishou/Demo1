package com.zjw.demo1;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import  androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {
    private final String TAG ="Life-Activity-Fragment";
    /**
     *当fragment对象关联到第一个activity的时候调用
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach=====Fragment1");
    }
    /***
     * 初始化Fragment对象时调用
     *
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate=====Fragment1");

    }

    /**
     * 当初始化fragment布局时调用
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView=====Fragment1");
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    /**
     * 当activity对象执行完自己的onCreate（）调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"onActivityCreated=====Fragment1");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart=====Fragment1");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume=====Fragment1");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"onPause=====Fragment1");

    }





    /**
     * 当fragment清理View资源时调用
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView=====Fragment1");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy=====Fragment1");

    }
}
