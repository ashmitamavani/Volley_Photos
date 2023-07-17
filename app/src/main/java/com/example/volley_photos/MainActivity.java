package com.example.volley_photos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.UrlRewriter;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<Model>list=new ArrayList<>();
    JSONArray jsonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        RequestQueue queue= Volley.newRequestQueue(this);
        String url="https://amiparaandroid.000webhostapp.com/Myapp/Register.php";

        StringRequest request=new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject mainobj = null;

                        try {
//                            //jsonArray = new JSONArray(response);
//
//                            for (int i = 0; i < jsonArray.length(); i++) {
//
//                                mainobj = jsonArray.getJSONObject(i);
//
//                                int id = mainobj.getInt("id");
//                                 String title=mainobj.getString("title");
//                                String url = mainobj.getString("url");
//                                String thumbnailUrl = mainobj.getString("thumbnailUrl");
//
//                                Model model = new Model(id, title, url, thumbnailUrl);
//                                list.add(model);
//                                Log.d("AAA", "onResponse: Object id=" + id);
//                                Log.d("AAA", "onResponse: Object name=" + title);
//                                Log.d("AAA", "onResponse: Object username=" + url);
//                                Log.d("AAA", "onResponse: Object= email=" + thumbnailUrl);
//                            }
//                            Recyclerview_Adapter adapter=new Recyclerview_Adapter(MainActivity.this,list);
//                            recyclerView.setAdapter(adapter);

                            JSONObject jsonObject=new JSONObject(response);
                            int connection=jsonObject.getInt("connection");
                            int result=jsonObject.getInt("result");
                            if(connection==1 && result==1)
                            {
                                Toast.makeText(MainActivity.this, "Successfully Registered", Toast.LENGTH_LONG).show();
                                Log.d("TTT", "onResponse: Connection="+connection+"\trrsult="+result);
                            }
                            else if(result==2)
                            {
                                Toast.makeText(MainActivity.this, "already Registered", Toast.LENGTH_LONG).show();
                                Log.d("TTT", "onResponse: Connection="+connection+"\trrsult="+result);
                            }
                        }
                        catch (JSONException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
            }
        })
        {
            @Override
            protected Map<String, String> getParams() {
                // below line we are creating a map for
                // storing our values in key and value pair.
                Map<String, String> params = new HashMap<String, String>();

                // on below line we are passing our key
                // and value pair to our parameters.
                params.put("name", "ddd");
                params.put("email", "ddd@gmail.com");
                params.put("password", "123456");

                // at last we are
                // returning our params.
                return params;
            }
            };
        queue.add(request);
    }
}