package code.messagePack;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.msgpack.MessagePack;

/**
 * Created by liangyuyi on 2017/7/25.
 */
public class MsgpackEncoder extends MessageToByteEncoder<Object> {
    @Override
    protected void encode(ChannelHandlerContext ctx, Object arg1, ByteBuf arg2) throws Exception{
        //将对象编码为byte，然后写进ByteBuf中
        MessagePack msgPack = new MessagePack();
        byte [] raw = msgPack.write(arg1);
        arg2.writeBytes(raw);
    }
}
