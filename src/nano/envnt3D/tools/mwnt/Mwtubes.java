/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package nano.envnt3D.tools.mwnt;
//import envnt3D.atoms;
import java.util.LinkedList;
import nano.envnt3D.tools.swnt.swnt.nanotube;

/**
 *
 * @author chanaka
 */
public class Mwtubes {

    private int noOfTubes=0;
    private LinkedList<nanotube> tubes;
    private double[][] atomCoordinates,bondCoordinates;

    public Mwtubes(){
        tubes = new LinkedList<nanotube>();

    }
    public void addTube(nanotube tube){
        noOfTubes++;
        if(noOfTubes<2){
            atomCoordinates = tube.getCoordinates();
            bondCoordinates = tube.getBondCoordinates();
        }
        else{
            atomCoordinates= nano.envnt3D.tools.swnt.swnt.mathOps.combineArrayBelow(atomCoordinates, tube.getCoordinates());
            bondCoordinates= nano.envnt3D.tools.swnt.swnt.mathOps.combineArrayBelow(bondCoordinates, tube.getBondCoordinates());
        }
        tubes.add(tube);

    }
    public double[][] getAtomCoordinates(){
        return atomCoordinates;
    }
    public double[][] getBondCoordinates(){
        return bondCoordinates;
    }
    public int getNumberOfTubes(){
        return noOfTubes;
    }

   
}
