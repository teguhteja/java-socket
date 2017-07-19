/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttm.socket;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author palgunadi
 */
public class A_ServerDemo {
    	public static void main(String[] x) throws Exception {
		// 1. Buka server socket di port 10000
		ServerSocket ss = new ServerSocket(10000);

		// 2. Kalau ada client yang connect, terima
		Socket s = ss.accept();

		// 3. Tampilkan informasi client
		InetSocketAddress client = (InetSocketAddress) s.getRemoteSocketAddress();
		System.out.println("IP Client : "+client.getAddress());
		System.out.println("Port Client : "+client.getPort());
		System.out.println("Hostname Client : "+client.getHostName());

		// 4. Terima data

		// 5. Tutup koneksi
		s.close();
	}
}
