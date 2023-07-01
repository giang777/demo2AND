package com.example.demo2;

import android.widget.TextView;

public class Ui implements Runnable{
    private TextView textView;

    public Ui(TextView textView){
        this.textView = textView;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            int finalI = i;
            textView.post(new Runnable() {
                @Override
                public void run() {
                    textView.setText(String.valueOf(finalI));
                }
            });
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            i++;
        }
    }
}
