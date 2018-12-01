package com.TYServer.util.httpAsyncClientForApache;

public class ExceptionHandlerImpl implements ExcptionHandler {
    @Override
    public Object failed(Exception e) {
        System.out.println(Thread.currentThread().getName() + ":请求失败！！");
        e.printStackTrace();
        return null;
    }

    @Override
    public Object completed(String respBody) {
        System.out.println(Thread.currentThread().getName() + "请求成功:" + respBody);
        return null;
    }

    @Override
    public Object cancelled() {
        System.out.println(Thread.currentThread().getName() + ":请求被取消！！");
        return null;
    }
}
