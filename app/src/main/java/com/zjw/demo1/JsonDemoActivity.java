package com.zjw.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class JsonDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_demo);

//        String result = "{\"student\":{\"name":\李四\",}";//

   // String result = "[{\"name\":\"张三\",\"age\":19}，”+"
   //         "{\"name\":}"]";

        String result = "[{\"name\":\"张三\",\"age\":18,\"hobby\":\"篮球\"},"+
                "{\"name\":\"李四\",\"age\":18,\"hobby\":\"篮球\"}]";

        Gson gson = new Gson();
        //User user = gson.fromJson(result,User.class);
        List<User> userList = gson.fromJson(result,new TypeToken<List<User>>(){}.getType());
        for(User user:userList) {
            Log.i("JsonDemoActivity", "姓名" + user.getName() + "年龄" + user.getAge()
                    + "兴趣" + user.getHobby());

            /**
             * json格式字符串
             */
//        String result = "{\"name\":\"张三\",\"age\":20,\"hobby\":\"打篮球\"}";
//        JSONObject jsonObject = null;
//
//        try {
//            jsonObject = new JSONObject(result);
//            String name = jsonObject.getString("name");
//            int age = jsonObject.getInt("age");
//            String hobby = jsonObject.getString("hobby");
//            Log.i("JsonDemoActivity","姓名:"+name+"年龄:"
//            +age+"兴趣爱好："+hobby);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


//            String result2 = "{\"student\":{\"name\":\"李四\",\"age\":18," +
//                    "\"hobby\":编程}}";
//            JSONObject jsonObject = null;
//            JSONObject jsonObject1 = null;
//        try {
//            jsonObject = new JSONObject(result2);
//            String student = jsonObject.getString("student");
//            jsonObject1 = new JSONObject(student);
//            String name = jsonObject1.getString("name");
//            int age = jsonObject1.getInt("age");
//            String hobby = jsonObject1.getString("hobby");
//            Log.i("JsonDemoActivity","\n学生姓名:"+name+"\n年龄："+age+"\n爱好："+hobby);
//
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        }
    }
}
