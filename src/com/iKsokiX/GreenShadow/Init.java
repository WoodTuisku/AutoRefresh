package com.iKsokiX.GreenShadow;

import com.iKsokiX.GreenShadow.Util.ChangeJsonPassWord;
import com.iKsokiX.GreenShadow.Util.CreatePassWord;
import com.iKsokiX.GreenShadow.Util.PaintTextCodeImg;
import com.iKsokiX.GreenShadow.Util.ShadowService;

public class Init {
	public static void main(String[] args) {
		while(true){
			try {
				String NewPass = new CreatePassWord().getRandomString(8);
				new ChangeJsonPassWord().Change(NewPass);
				new PaintTextCodeImg().graphicsGeneration(NewPass);
				new ChangeJsonPassWord().SetJsonText(NewPass);
				
				new ShadowService().ShadowSocks("restart");
				
				Thread.sleep(10800000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
