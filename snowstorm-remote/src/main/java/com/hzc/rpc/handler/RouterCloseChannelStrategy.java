package com.hzc.rpc.handler;

import com.hzc.rpc.core.ChannelHolderForRouter;
import io.netty.channel.ChannelHandlerContext;

/**
 * @author: hzc
 * @Date: 2020/03/26  11:51
 * @Description:
 */
public class RouterCloseChannelStrategy implements CloseChannelStrategy {
    /**
     * 优雅关闭Channel
     *
     * @param context
     */
    @Override
    public void closeChannelGraceFully(ChannelHandlerContext context) {
        ChannelHolderForRouter.getInstance().connectionDown(context);
    }
}
