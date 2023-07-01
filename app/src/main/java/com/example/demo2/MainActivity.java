package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private List<Products> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.textView = findViewById(R.id.tv01);
        System.out.println("Hello");
            Gson gson = new Gson();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://192.168.1.9:3000/")
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            ApiService service = retrofit.create(ApiService.class);
            Call<List<Products>> call = service.getListProducts();
            call.enqueue(new Callback<List<Products>>() {
                @Override
                public void onResponse(Call<List<Products>> call, Response<List<Products>> response) {
                    if (response.isSuccessful()) {
                        list = (List<Products>) call.request().body();
                        // Xử lý dữ liệu trả về
                    } else {
                        // Xử lý lỗi
                    }

                }

                @Override
                public void onFailure(Call<List<Products>> call, Throwable t) {

                }

            });

        for (Products item : list){
            Log.e("Name : ",item.getName());
        }

        //Trường hợp 1 : Chạy công việc trên 1 luồng chính
        //in 1 dãy số ra log
//        for(int i =0;i<=10;i++){
//            Log.e("Number : ",String.valueOf(i));
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        Toast.makeText(this, "Demo Thread", Toast.LENGTH_SHORT).show();
        //chạy 2 luồng
//        Thread thread1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i =0;i<=10;i++){
//                    Log.e("Number 1: ",String.valueOf(i));
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        });
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i =0;i<=10;i++){
//                    Log.e("Number 2: ",String.valueOf(i));
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                        //không hộ trợ giao diện
//                    }
//                }
//            }
//        });
//        Thread thread3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.e("Log 3: ","NGU");
//            }
//        });
//        thread1.start();
//        thread2.start();
//        thread3.start();
//        //trường hợp 3 cập nhật giao diện
//        Ui ui = new Ui(textView);
//        Thread uiTH = new Thread(ui);
//        uiTH.start();
    }
}