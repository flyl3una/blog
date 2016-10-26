package com.blog.fastjson;

/**
 * Created by fly_l on 2016/10/25.
 */
public class UploadImgResult {
    private int success;
    private String message;
    private String url;

    public UploadImgResult(){};

    public int getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public String getUrl() {
        return url;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
