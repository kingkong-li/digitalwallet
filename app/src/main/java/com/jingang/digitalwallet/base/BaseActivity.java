package com.jingang.digitalwallet.base;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;


/**
 * @author jingang
 */
public abstract class BaseActivity<P extends IPresenter> extends AppCompatActivity
        implements IView{
    // Activity需要强引用一个presenter，然后所有业务逻辑交给它
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (getSupportActionBar()!=null){
            getSupportActionBar().hide();
        }
        super.onCreate(savedInstanceState);
        Log.v(getTag(),"onCreate");
        mPresenter =createPresenter();
        if(mPresenter !=null){
            mPresenter.attachView(this);
            mPresenter.onCreate();
        }
        setContentView(getLayoutId());
    }

    /**
     * 获取布局
     *
     * @return 布局文件id
     */
    protected abstract int getLayoutId();
    /**
     * 创建Presenter（如果没有Presenter层返回NULL即可）
     */
    protected abstract P createPresenter();

    protected String getTag() {
        return this.getClass().getSimpleName();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mPresenter!=null){
            mPresenter.onStart();
        }
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
        if(mPresenter!=null){
            mPresenter.onResume();
        }
        Log.v(getTag(),"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(mPresenter!=null){
            mPresenter.onPause();
        }
        Log.v(getTag(),"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mPresenter!=null){
            mPresenter.onStop();
        }
        Log.v(getTag(),"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter!=null){
            mPresenter.detachView();
            mPresenter.onDestroy();
        }

        Log.v(getTag(),"onDestroy");
    }

    @Override
    public void showLoading() {
        Log.v(getTag(),"showLoading");
    }
}
