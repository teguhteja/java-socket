/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ttm.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author palgunadi
 */
public class B_ChatClient {
    public static void main(String[] xx) throws Exception {
		// 1. Input Konfigurasi
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Masukkan nama : ");
		String nama = input.readLine();
		System.out.println("Halo "+nama);

		System.out.println("Masukkan alamat IP tujuan : ");
		String ipTujuan = input.readLine();

		System.out.println("Masukkan port tujuan : ");
		Integer portTujuan = Integer.parseInt(input.readLine());

		// 2. Buka koneksi
		Socket s = new Socket(ipTujuan, portTujuan);
		System.out.println("Berhasil connect ke "+ipTujuan+":"+portTujuan);

		// 3. Kirim data
		BufferedReader chat = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter output= new PrintWriter(s.getOutputStream(), true);

		String msg = chat.readLine();
		while(msg != null && !"bye".equalsIgnoreCase(msg)){
			output.println(nama+"> "+msg);
			msg = chat.readLine();
		}
		chat.close();
		output.close();
		s.close();
	}
}
