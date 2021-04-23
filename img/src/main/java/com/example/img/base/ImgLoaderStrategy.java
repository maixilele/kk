package com.example.img.base;

import android.content.Context;

public interface ImgLoaderStrategy<Setting extends ImageSetting> {
    /**
     * 加载图片
     * @param context
     * @param setting
     */
    void loadImage(Context context,Setting setting);
}
