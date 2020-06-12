package com.zjw.demo1;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    private final String TAG ="Life-Activity";
    /**
     *
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG,"onAttach=====Fragment2");
    }
    /***
     * 初始化Fragment对象时调用
     *
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"onCreate=====Fragment2");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG,"onCreateView=====Fragment2");
        return super.onCreateView(inflater,container,savedInstanceState);
    }

    /**
     * 当activity对象执行完自己的onCreate（）调用
     * @param savedInstanceState
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"onActivityCreated=====Fragment2");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart=====Fragment2");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume=====Fragment2");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG,"onPause=====Fragment2");

    }

    /**
     * 当fragment清理View资源时调用
     */
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView=====Fragment2");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy=====Fragment2");

    }
}
