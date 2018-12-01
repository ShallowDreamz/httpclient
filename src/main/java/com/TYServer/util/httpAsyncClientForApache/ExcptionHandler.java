package com.TYServer.util.httpAsyncClientForApache;

public interface ExcptionHandler {
    /**
     * 处理异常时，执行该方法
     * @return
     */
    Object failed(Exception e);

    /**
     * 处理正常时，执行该方法
     * @return
     */
    Object completed(String respBody);

    /**
     * 处理取消时，执行该方法
     * @return
     */
    Object cancelled();
}
