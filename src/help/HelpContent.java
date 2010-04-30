package help;

import java.awt.Dimension;
import java.net.URL;

import javax.help.CSH;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class HelpContent {

    public HelpBroker hb;

    public HelpContent() {
        try {

            //startJavaHelp();

            URL url = this.getClass().getResource("Sample.hs");
            HelpSet hs = new HelpSet(null, url);

            hb = hs.createHelpBroker();
            hb.setSize(new Dimension(900,600));
         //   CSH.setHelpIDString(menuitem, "top");
            new CSH.DisplayHelpFromSource(hb);





        } catch (HelpSetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        JFrame f = new JFrame("Menu Example");
        JMenuBar mbar = new JMenuBar();

        // a file menu
        JMenu file = new JMenu("File");
        JMenu help = new JMenu("Help");
        final JMenuItem topics;
        // add an item to the help menu


        // add the menu items to the menu bar
        mbar.add(file);
        mbar.add(help);

        f.setJMenuBar(mbar);
        f.setSize(500, 300);


        help.add(topics = new JMenuItem("Help Topics"));

        //--------------to add-----------------------
        HelpContent content = new HelpContent();
        topics.addActionListener(new CSH.DisplayHelpFromSource(content.hb));


        f.setVisible(true);

    }
}
