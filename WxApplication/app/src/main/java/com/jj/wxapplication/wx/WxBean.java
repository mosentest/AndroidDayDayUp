package com.jj.wxapplication.wx;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Copyright (C), 2018-2019
 * Author: ziqimo
 * Date: 2019-11-23 22:11
 * Description:
 * History:
 * <author> <time> <version> <desc>
 * 作者姓名 修改时间 版本号 描述
 */
public class WxBean implements Parcelable {

    public String url; //访问网络的

    public int resId;//本地资源id

    public String name;//名字

    public String content;//聊天内容

    private WxBean(Builder builder) {
        setUrl(builder.url);
        setResId(builder.resId);
        setName(builder.name);
        setContent(builder.content);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeInt(this.resId);
        dest.writeString(this.name);
        dest.writeString(this.content);
    }

    public WxBean() {
    }

    protected WxBean(Parcel in) {
        this.url = in.readString();
        this.resId = in.readInt();
        this.name = in.readString();
        this.content = in.readString();
    }

    public static final Creator<WxBean> CREATOR = new Creator<WxBean>() {
        @Override
        public WxBean createFromParcel(Parcel source) {
            return new WxBean(source);
        }

        @Override
        public WxBean[] newArray(int size) {
            return new WxBean[size];
        }
    };

    public static final class Builder {
        private String url;
        private int resId;
        private String name;
        private String content;

        public Builder() {
        }

        public Builder url(String val) {
            url = val;
            return this;
        }

        public Builder resId(int val) {
            resId = val;
            return this;
        }

        public Builder name(String val) {
            name = val;
            return this;
        }

        public Builder content(String val) {
            content = val;
            return this;
        }

        public WxBean build() {
            return new WxBean(this);
        }
    }
}
