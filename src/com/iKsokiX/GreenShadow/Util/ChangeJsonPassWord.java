package com.iKsokiX.GreenShadow.Util;

import java.io.File;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ChangeJsonPassWord {
	private final static String Path = "/etc/shadowsocks.json";
	public void Change(String PassStr){
		String JsonText = GetJsonText(),
				  localPass = JsonText.substring((JsonText.indexOf("25571")+8)),
				  realPass = localPass.substring(0,localPass.indexOf('"'));
		JsonText = JsonText.replaceAll(realPass, PassStr);
		System.out.println(JsonText);
	}
	
	@SuppressWarnings("resource")
	public void SetJsonText(String PassStr){
		try {
			RandomAccessFile r = new RandomAccessFile(Path, "rw");
			r.seek(183L);
			r.writeBytes(PassStr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String GetJsonText(){
		File file = new File(Path);
        Scanner scanner = null;
        StringBuilder buffer = new StringBuilder();
        try {
            scanner = new Scanner(file, "utf-8");
            while (scanner.hasNextLine()) {
                buffer.append(scanner.nextLine());
            }
            return buffer.toString();
        } catch (Exception e) {
            System.err.println("ERROR: " + e.toString());
            return "ERROR";
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
	}
}
