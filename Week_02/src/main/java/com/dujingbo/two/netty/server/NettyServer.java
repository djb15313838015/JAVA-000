package com.dujingbo.two.netty.server;

import com.dujingbo.two.netty.handler.HttpHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.DefaultThreadFactory;

/**
 * @package: com.dujingbo.two.netty
 * @program: JAVA-000
 * @description:
 * @author: <a href="dujingbo@jd.com">Mr.Du</a>
 * @create: 2020-10-26
 **/
public class NettyServer {

    private int port;

    public NettyServer(int port) {
        this.port = port;
    }

    public void run() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();

        EventLoopGroup boss = new NioEventLoopGroup(0, new DefaultThreadFactory("boss"));
        EventLoopGroup worker = new NioEventLoopGroup(0, new DefaultThreadFactory("worker"));
        final LoggingHandler loggingHandler = new LoggingHandler(LogLevel.INFO);
        try {
            bootstrap.group(boss, worker)
                    .channel(NioServerSocketChannel.class)
                    .handler(loggingHandler)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel channel) throws Exception {
                            final ChannelPipeline pipeline = channel.pipeline();
                            pipeline.addLast(loggingHandler);
                            pipeline.addLast("httpResponseEncoder", new HttpResponseEncoder());
                            pipeline.addLast("httpRequestDecoder", new HttpRequestDecoder());
                            pipeline.addLast("httpObjectAggregator", new HttpObjectAggregator(1024 * 64));
                            pipeline.addLast(new HttpHandler());
                        }
                    }).option(ChannelOption.SO_BACKLOG, 128)
                    .option(ChannelOption.SO_REUSEADDR, true)
                    .childOption(ChannelOption.SO_KEEPALIVE, true);

            final Channel channel = bootstrap.bind(port).sync().channel();
            channel.closeFuture().sync();
        } finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        NettyServer server = new NettyServer(8804);
        try {
            server.run();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
