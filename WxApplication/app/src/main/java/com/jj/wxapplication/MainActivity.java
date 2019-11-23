package com.jj.wxapplication;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView mWx;
    private TextView mTxl;
    private TextView mFx;
    private TextView mMe;
    private LinearLayout mLlWx;
    private ImageView mIvWx;
    private LinearLayout mWxLlContent;
    private LinearLayout mTxlLlContent;
    private LinearLayout mFxLlContent;
    private LinearLayout mMeLlContent;


    private MyNetReceiver myNetReceiver;
    private TextView mNetWorkCheck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myNetReceiver = new MyNetReceiver(new NetCall() {
            @Override
            public void isNetworkAvailable(boolean call) {
                //网络变化状态
                mNetWorkCheck.setVisibility(call ? View.VISIBLE : View.GONE);
            }
        });
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(myNetReceiver, intentFilter);

        mWx = findViewById(R.id.wx);
        mTxl = findViewById(R.id.txl);
        mFx = findViewById(R.id.fx);
        mMe = findViewById(R.id.me);
        mLlWx = findViewById(R.id.llWx);
        mIvWx = findViewById(R.id.ivWx);

        mLlWx.performClick();


        mWxLlContent = findViewById(R.id.wx_llContent);
        mTxlLlContent = findViewById(R.id.txl_llContent);
        mFxLlContent = findViewById(R.id.fx_llContent);
        mMeLlContent = findViewById(R.id.me_llContent);
        mNetWorkCheck = findViewById(R.id.netWorkCheck);

        mNetWorkCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "跳设置打开网络!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myNetReceiver);
    }
}
