package com.jingang.digitalwallet.base;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;


/**
 * @author jingang
 */
public abstract class BaseActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();;
        }
        super.onCreate(savedInstanceState);
        Log.v(getTag(),"onCreate");
        setContentView(getLayoutId());
    }

    /**
     * 获取布局
     *
     * @return 布局文件id
     */
    protected abstract int getLayoutId();

    protected String getTag() {
        return this.getClass().getSimpleName();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(getTag(),"onStart");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v(getTag(),"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(getTag(),"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(getTag(),"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v(getTag(),"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(getTag(),"onDestroy");
    }
}
