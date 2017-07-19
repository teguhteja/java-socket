/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttm.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author palgunadi
 */
public class B_ChatServer {
    public static void main(String[] xx) throws Exception {
		// 1. Input Konfigurasi
		BufferedReader input= new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Masukkan nama : ");
		String nama = input.readLine();
		System.out.println("Halo "+nama);

		System.out.println("Masukkan port Anda : ");
		Integer port = Integer.parseInt(input.readLine());

		// 2. Start socket server
		ServerSocket server = new ServerSocket(port);
		System.out.println("Menunggu koneksi di port "+port);

		// 3. Terima koneksi
		Socket koneksi = server.accept();
		System.out.print("Terima koneksi dari alamat IP ");
		System.out.println(((InetSocketAddress)koneksi.getRemoteSocketAddress()).getAddress());		

		// 4. Tampilkan data selama belum bye
		BufferedReader chatIncoming 
			= new BufferedReader(new InputStreamReader(koneksi.getInputStream()));

		String msg  = chatIncoming.readLine();
		while(msg != null && !"bye".equalsIgnoreCase(msg)){
			System.out.println(msg);
			msg = chatIncoming.readLine();
		}

		chatIncoming.close();
		koneksi.close();
	}
}
