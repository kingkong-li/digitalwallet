package com.jingang.digitalwallet.base;

import androidx.annotation.UiThread;

/**
 * @Description:
 * @Author: jingang.Li
 * @CreateTime: 2021/7/11-9:57 AM
 */
public interface IView  {

    /**
     * 展示等待框
     */
    @UiThread
    void showLoading();
}
