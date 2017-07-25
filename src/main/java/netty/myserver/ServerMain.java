package netty.myserver;

/**
 * Created by liangyuyi on 2017/7/8.
 */
public class ServerMain {
    public static void main(String[] args) throws Exception{
        NettyServer server = new NettyServer();
        server.bind(6777);
    }
}
