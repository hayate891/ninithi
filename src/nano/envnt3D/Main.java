package nano.envnt3D;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import nano.envnt3D.tools.NanoGUI;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


            try {
	    // Set cross-platform Java L&F (also called "Metal")

            


            UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
    }
    catch (UnsupportedLookAndFeelException e) {
       // handle exception
    }
    catch (ClassNotFoundException e) {
       // handle exception
    }
    catch (InstantiationException e) {
       // handle exception
    }
    catch (IllegalAccessException e) {
       // handle exception
    }

        
           NanoGUI gui=new NanoGUI();

		gui.setGUI();
	}

}
