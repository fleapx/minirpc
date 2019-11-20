package io.github.zhenbianshu.minirpc.proxy;

import io.github.zhenbianshu.minirpc.core.Request;
import io.github.zhenbianshu.minirpc.core.Response;
import io.github.zhenbianshu.minirpc.ha.HaStrategy;

/**
 * @author zbs
 * @date 2019/11/20
 */
public abstract class Remote {
    protected HaStrategy haStrategy;

    /**
     * 请求 remote 服务端获取响应
     *
     * @param request
     * @return
     */
    abstract Response call(Request request);
}
