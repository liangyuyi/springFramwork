package netty.myClient;

import code.messagePack.MsgpackDecode;
import code.messagePack.MsgpackEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * 客户端代码
 * Created by liangyuyi on 2017/7/6.
 */
public class NettyClient {

    public void connect(String serverIp, int port)throws Exception{
        EventLoopGroup group = new NioEventLoopGroup();

        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group);
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.TCP_NODELAY, true);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel)throws Exception{
                ChannelPipeline channelPipeline = socketChannel.pipeline();
                //.....这里可以添加上自己的编码和解码规则
                //根据后缀名编码解码
//                ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
//                channelPipeline.addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
//                channelPipeline.addLast(new StringDecoder());

                //messagePack编码和解码
                channelPipeline.addLast("msgpack decode", new MsgpackDecode());
                channelPipeline.addLast("msgpack encode",new MsgpackEncoder());

                channelPipeline.addLast(new ClientHandler());
            }
        });

        ChannelFuture future = bootstrap.connect(serverIp, port).sync();
        future.channel().closeFuture().sync();
    }
}
