package nano.envnt3D.tools.fullerine;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.Arrays;
import java.util.Arrays.*;

public class FileAccess implements FilenameFilter {

    String pattern;
    int asteriskIndex, percentIndex;
    private String _namePortion = "";

    @Override
    public boolean accept(File dir, String name) {

        //return (name.startsWith(_namePortion));
        return (name.contains(_namePortion));
    }

    public void setNamePortion(String value) {
        _namePortion = value;
    }

    public String getFileName(int NoOfAtoms, int Gno) {
        URL myurl = this.getClass().getResource("FullereneLib");
        // File directory = new File(myurl.toString().substring(5) + "/C" + NoOfAtoms);
        File directory = new File("resources/FullereneLib" + "/C" + NoOfAtoms);
        setNamePortion("No." + Gno + "-");
        File fileList[] = directory.listFiles(this);

        for (int i = 0; i < fileList.length; i++) {
            // System.out.println(fileList[i]);
        }
        if (fileList.length != 0) {
            return fileList[0].toString();
        } else {
            return "No";
        }
    }

    // @SuppressWarnings("unchecked")
    public int[] getGeometries(int NoOfAtoms) {
        URL myurl = this.getClass().getResource("FullereneLib");
        //File directory = new File(myurl.toString().substring(5) + "/C" + NoOfAtoms);
        File directory = new File("resources/FullereneLib" + "/C" + NoOfAtoms);
        // System.out.print(directory);
        int[] glist1 = new int[500];
        int count = 0;

        for (int i = 0; i < 500; i++) {
            setNamePortion("No." + i + "-");
            File fileList[] = directory.listFiles(this);
            if (fileList.length == 1) {
                glist1[count] = i;
                count++;
            }
        }
        int[] glist = new int[count];
        for (int j = 0; j < count; j++) {
            glist[j] = glist1[j];
        }
        return glist;
    }

    public int[] getFullerines() {

        //URL myurl = this.getClass().getResource("FullereneLib");



        //   this.getClass().getClassLoader().getResources(pattern)
        File directory = null;
        int[] fullerineAtoms;

        // directory = new File(myurl.toString().substring(9));
        //  directory = new File(myurl.getPath());
        directory = new File("resources/FullereneLib");


        //   System.out.print(directory);
        setNamePortion("C");


        File[] fileList = directory.listFiles(this);
        // String[] fileList = directory.list(this);

        String[] fullerines = new String[fileList.length];

        fullerineAtoms = new int[fileList.length];

        String[] rowi;
        for (int i = 0; i < fileList.length; i++) {

            fullerines[i] = fileList[i].toString();

            rowi = fullerines[i].split("C");

            fullerines[i] = rowi[rowi.length-1];
            fullerineAtoms[i] = Integer.parseInt(rowi[1]);

        }
        Arrays.sort(fullerineAtoms);

        return fullerineAtoms;
    }
}
