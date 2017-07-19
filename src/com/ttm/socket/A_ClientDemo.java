/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttm.socket;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 *
 * @author palgunadi
 */
public class A_ClientDemo {
    public static void main(String[] x) throws Exception {
		// 1. IP Address dan Port Server
		String ipServer = "127.0.0.1";
		Integer portServer = 10000;

		// 2. Connect menggunakan socket
		Socket s = new Socket(ipServer, portServer);

		// 3. Tampilkan informasi server
		InetSocketAddress server = (InetSocketAddress) s.getRemoteSocketAddress();
		System.out.println("IP server : "+server.getAddress());
		System.out.println("Port server : "+server.getPort());
		System.out.println("Hostname server : "+server.getHostName());

		// 4. Close koneksi
		s.close();
	}
}
