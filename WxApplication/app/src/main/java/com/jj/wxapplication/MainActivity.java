package com.jj.wxapplication;

import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.jj.wxapplication.wx.WxAdapter;
import com.jj.wxapplication.wx.WxBean;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private TextView mNetWorkCheck;
    private RecyclerView mWxRX;
    private LinearLayout mWxLlContent;
    private LinearLayout mTxlLlContent;
    private LinearLayout mFxLlContent;
    private LinearLayout mMeLlContent;
    private ImageView mIvWx;
    private TextView mWx;
    private LinearLayout mLlWx;
    private ImageView mIvtxl;
    private TextView mTxl;
    private ImageView mIvfx;
    private TextView mFx;
    private ImageView mIvme;
    private TextView mMe;


    private WxAdapter wxAdapter;

    private MyNetReceiver myNetReceiver;

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

        mNetWorkCheck = findViewById(R.id.netWorkCheck);
        mWxRX = findViewById(R.id.wxRX);
        mWxLlContent = findViewById(R.id.wx_llContent);
        mTxlLlContent = findViewById(R.id.txl_llContent);
        mFxLlContent = findViewById(R.id.fx_llContent);
        mMeLlContent = findViewById(R.id.me_llContent);
        mIvWx = findViewById(R.id.ivWx);
        mWx = findViewById(R.id.wx);
        mLlWx = findViewById(R.id.llWx);
        mIvtxl = findViewById(R.id.ivtxl);
        mTxl = findViewById(R.id.txl);
        mIvfx = findViewById(R.id.ivfx);
        mFx = findViewById(R.id.fx);
        mIvme = findViewById(R.id.ivme);
        mMe = findViewById(R.id.me);


        mLlWx.performClick();

        mLlWx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        /**
         * 操作数据库的对象方法
         *
         * 读取 通讯录，短信。日历 系统自带的
         *
         * contentprovider 定义一个uri 协议给别人用
         */
//        getContentResolver().insert()
//        getContentResolver().update()
//        getContentResolver().delete()
        getContentResolver().query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);


        mNetWorkCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "跳设置打开网络!", Toast.LENGTH_SHORT).show();
            }
        });

        wxAdapter = new WxAdapter();

        wxAdapter.setWxBeans(Arrays.asList(
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人1").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人2").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人3").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人4").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人5").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人6").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人7").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人8").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人9").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人0").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人11").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人12").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人13").content("我来自中国").build(),
                new WxBean.Builder().resId(R.mipmap.ic_launcher).name("中国人14").content("我来自中国").build()

        ));

        mWxRX.setAdapter(wxAdapter);

        /**
         * 必须要设置，不设置，是没办法展示的
         */
//        mWxRX.setLayoutManager(new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false));
        /**
         * 网格布局
         */
        mWxRX.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myNetReceiver);
    }
}
