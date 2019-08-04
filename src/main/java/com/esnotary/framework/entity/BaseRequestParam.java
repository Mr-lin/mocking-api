package com.esnotary.framework.entity;

public abstract class BaseRequestParam {

    private String token;
    private String userId;
    private String signTime;
    private String signType;
    private String sign;
    private String format;
    private String charset;
    private String version;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "BaseRequestParam{" +
                "token='" + token + '\'' +
                ", signTime='" + signTime + '\'' +
                ", signType='" + signType + '\'' +
                ", sign='" + sign + '\'' +
                ", format='" + format + '\'' +
                ", charset='" + charset + '\'' +
                ", version='" + version + '\'' +
                '}';
    }
}
