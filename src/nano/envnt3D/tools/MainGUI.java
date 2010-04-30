package nano.envnt3D.tools;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.media.j3d.Canvas3D;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.j3d.utils.universe.SimpleUniverse;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;

import nano.envnt3D.Interface3D;
import nano.envnt3D.tools.swnt.LoadModule;


public class MainGUI {
	JPanel panelFrame=new JPanel();
	Panel panel3D=new Panel();
	JPanel panelButton=new JPanel();
	JPanel panelFunction=new JPanel();
	JPanel panelLoadButton=new JPanel();
	JFrame frame;
	Canvas3D canvas3D;
	SimpleUniverse su;
	int guiwidth,guiheight;
        NanoGUI nanogui=new NanoGUI();
	
	public void setGUI(){
            
        
        frame=new JFrame();
        panelFrame.setLayout(new BorderLayout());
        
        addPanelstoPanelFrame();       
        
        frame.getContentPane().add(panelFrame);
          	
    	frame.setVisible(true);
    	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        guiheight=512;
        guiwidth=512;
    	
    	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
       
        int x = (d.width / 2) - (guiwidth / 2); //- GUI_WIDTH;
        int y = ( d.height / 2 ) - (guiheight / 2);
        frame.setSize(new Dimension(guiwidth, guiheight));
        frame.setLocation(x, y);
        
        

	}

	private void addPanelstoPanelFrame() {
		// TODO Auto-generated method stub
		
		drawPanelButton();
		
        panelFrame.add(panelButton,BorderLayout.SOUTH);
        panelFrame.add(panelLoadButton,BorderLayout.NORTH);
        panelFrame.add(panelFunction,BorderLayout.WEST);
        panelFrame.add(Interface3D.createPanel(),BorderLayout.CENTER);
	}

	private void drawPanelButton() {
		// TODO Auto-generated method stub
    	//SideView sideview=new SideView(center, points, confignano);  
		
		//SideView sideview=new SideView();
    	//panelButton=sideview.createButtons();
    	
    	   	
    	
    	
    	//panel3D.add(Interface3D.createPanel());
    	
    	panelFunction.add(new JLabel("----------------"));
    	//LoadModule module=new LoadModule(panelFunction);
    	//panelLoadButton=module.createButtons();
    	
    	
    	
		//panelFunction=gui.createPanel();
	}
	
	
	
}
