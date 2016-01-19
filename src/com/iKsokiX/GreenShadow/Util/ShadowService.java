package com.iKsokiX.GreenShadow.Util;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

public class ShadowService {
	static final String SHELL = "/etc/init.d/shadowsocks";
	public void ShadowSocks(String Status){
		System.err.println("SSS Run");
		ProcessBuilder pb = new ProcessBuilder(SHELL, Status);
		try {
			Process p = pb.start();
			BufferedReader out = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getInputStream()), Charset.forName("GB2312")));
			BufferedReader err = new BufferedReader(new InputStreamReader(new BufferedInputStream(p.getErrorStream())));
			String ostr;
			//char c[];
			while ((ostr = out.readLine()) != null){
				System.out.println("[SSS Info] " + ostr);
			}
			String estr = err.readLine();
			if (estr != null) {
			System.out.println("\nError Info");
			System.out.println(estr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
