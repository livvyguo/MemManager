package org.lvy.mem.manager.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Created by livvy on 15/8/25.
 * memcache client 连接参数
 */
public class MemCli {

    private String name;
    private String host;
    private int port;

    public MemCli(String name, String host, int port) {
        this.name = name;
        this.host = host;
        this.port = port;
    }

    public MemCli() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Override
    public String toString() {
        return name;
    }
}
