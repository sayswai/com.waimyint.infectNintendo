import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;

import Text.Text;
import UI.*;
import Controllers.*;

public class main {

	private static boolean shouldExit;
	
	public static void main(String[] args)
	{
		Window.createWindow(800, 600, "Infect");
		
    	/*Initialize Keyboard*/
    	Keyboard.initializeKb();
    	
    	/*Initialize Objects*/
    	/*initialize Texts*/
    	/*Initialize UI*/
    	Footer footerUI = new Footer("uiBg.tga");
    	ArrowKeys arrows = new ArrowKeys();
    	/*Load Textures*/
    	/*Physics Implementation*/
    	int physicsDeltaMS = 10;
    	int lastPhysicsFrameMS = 0;
    	/*Extra*/
    	
    	
    	/*Game Loop*/
    	while(!shouldExit)
    	{
    		/*Copies the keystrokes to prev.keystroke array to compare*/
    		System.arraycopy(Keyboard.getKbState(), 0, Keyboard.getKbPrevState(), 0, Keyboard.getKbState().length);
    	
    		Window.window.display();
    		
    		
    		/*Pressing ESC will exit the game or closing the window*/
    		if(Keyboard.getKbState()[KeyEvent.VK_ESCAPE]){
    			shouldExit = true;
    		}
    		if(!Window.window.isVisible())
    		{
    			shouldExit = true;
    			break;
    		}
    		
    		arrows.update();
    		int curFrameMS = 100;
    		/*Physics Update
    		do{
    			
    		}while(lastPhysicsFrameMS + physicsDeltaMS < curFrameMS);
    		lastPhysicsFrameMS = 0;*/
    		
    		/*Clear Last Frame*/
    		Window.clearWindow();
    		
    		/*Draw*/
    		footerUI.draw();
    		arrows.draw();

    		arrows.updateLetters();
    	}
    	System.exit(0);
	}
}
