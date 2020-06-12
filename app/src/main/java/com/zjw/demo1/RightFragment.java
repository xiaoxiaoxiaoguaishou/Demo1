package com.zjw.demo1;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;
import static android.widget.Toast.*;

public class RightFragment extends Fragment {

    //定义接口对象声明
    private  MyListener myListener;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myListener = (MyListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_right,null);
        Button button =view.findViewById(R.id.bu_frg);
        final EditText editText = view.findViewById(R.id.et_send_msg);
        //获取activity中传递的bundle对象
            Bundle bundle= getArguments();
            String arg1 = bundle.getString("hell");
            button.setText(arg1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myListener.sendMessage(editText.getText().toString());
                Toast.makeText(getActivity(),"我是Fragment", LENGTH_SHORT).show();

            }
        });
        return view;
    }

    //定义接口
    public interface MyListener{
        public void sendMessage(String msg);
    }
}
