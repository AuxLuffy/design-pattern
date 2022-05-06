package com.luffy.design_pattern.utils;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * 网络工具类
 *
 * @author sunzhangfei
 * @since 2022/5/6 4:13 下午
 */
public class NetUtil {
    private static final Logger L = LoggerFactory.getLogger(NetUtil.class.getSimpleName());

    /**
     * 获取本机ip
     *
     * @return 如果能获取到公网ip就返回公网ip，如果获取不到公网ip就返回本地ip
     * @throws SocketException
     */
    public static String getRealIp() throws SocketException {
        String localIp = null;
        String netIp = null;
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        boolean finded = false;//是否找到外网ip
        while (interfaces.hasMoreElements() && !finded) {
            NetworkInterface ni = interfaces.nextElement();
            Enumeration<InetAddress> addresses = ni.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress ip = addresses.nextElement();
                if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    netIp = ip.getHostAddress();
                    finded = true;
                    break;
                } else if (ip.isSiteLocalAddress() && !ip.isAnyLocalAddress() && ip.getHostAddress().indexOf(":") == -1) {
                    localIp = ip.getHostAddress();
                }
            }
        }
        if (StringUtils.isEmpty(netIp)) {
            L.debug("本地地址：" + localIp);
            return localIp;
        } else {
            L.debug("网络地址：" + netIp);
            return netIp;
        }
    }

    public static void main(String[] args) {
        try {
            getRealIp();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }
}