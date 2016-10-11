/**
 * 
 */
package com.wisn.backup;

/**
 * @author Wisn
 * 2016年10月10日   下午7:45:42
 * 
 */
public class IPTest {
    public static int ipToInt(String ip) {
        String[] ips = ip.split("\\.");
        return (Integer.parseInt(ips[0]) <<0) + (Integer.parseInt(ips[1]) << 8)
                + (Integer.parseInt(ips[2]) << 16) + Integer.parseInt(ips[3]) << 24;
    }
    public static String intToIp(int i) {
        return ((i >>0) & 0xFF) + "." + ((i >> 8) & 0xFF) + "."
                + ((i >> 16) & 0xFF) + "." + (i>>24 & 0xFF);
    }
    public static void main(String[] args) {
    	//int ipToInt = ipToInt("127.0.0.1");
    	System.out.println(intToIp(ipToInt("127.0.0.1")));
//    	System.out.println("a"==="b");
	}
}
