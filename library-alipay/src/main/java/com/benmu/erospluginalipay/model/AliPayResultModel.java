package com.benmu.erospluginalipay.model;

import android.text.TextUtils;

import java.util.Map;

/**
 * Created by haorui on 2018/6/6.
 * Des:
 */
public class AliPayResultModel {

    /**
     * 支付状态
     * 9000	订单支付成功
     * 8000	正在处理中，支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态
     * 4000	订单支付失败
     * 5000	重复请求
     * 6001	用户中途取消
     * 6002	网络连接出错
     * 6004	支付结果未知（有可能已经支付成功），请查询商户订单列表中订单的支付状态
     * 其它	其它支付错误
     */
    public String resCode;//结果码(类型为字符串)
    public String status;//处理结果(类型为json结构字符串)
    public String msg;//描述信息


    public AliPayResultModel(Map<String, String> rawResult) {
        if (rawResult == null) {
            return;
        }

        for (String key : rawResult.keySet()) {
            if (TextUtils.equals(key, "resultStatus")) {
                resCode = rawResult.get(key);
            } else if (TextUtils.equals(key, "result")) {
                status = rawResult.get(key);
            } else if (TextUtils.equals(key, "memo")) {
                msg = rawResult.get(key);
            }
        }
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AliPayResultModel{" + "resCode='" + resCode + '\'' + ", status='" + status + '\'' + ", msg='" + msg + '\'' + '}';
    }
}
