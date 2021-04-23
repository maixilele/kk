package com.example.net;


import com.example.net.utils.GsonUtils;
import com.google.gson.internal.LinkedTreeMap;

import java.util.ArrayList;
import java.util.List;

public class BaseRespEntity<T> {
    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public T getData(Class<?> _type){
        if (data instanceof java.util.List){
            List<Object> targetList = new ArrayList<>();
            List<Object> tempList = (List<Object>) data;
            for (Object t :tempList ){
                if (t instanceof LinkedTreeMap){
                    String newJsonStr = GsonUtils.getInstance().getGson().toJson(t);
                    Object newInstance = GsonUtils.getInstance().getGson().fromJson(newJsonStr, _type);
                    targetList.add(newInstance);
                }
            }

            data = (T) targetList;
        }else{
            if (data instanceof Object){
                String newJsonStr = GsonUtils.getInstance().getGson().toJson(data);
                Object newInstance = GsonUtils.getInstance().getGson().fromJson(newJsonStr, _type);
                data= (T) newInstance;
            }

        }
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseRespEntity{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
