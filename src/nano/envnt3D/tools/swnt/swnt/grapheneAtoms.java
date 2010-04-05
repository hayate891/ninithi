package nano.envnt3D.tools.swnt.swnt;

import static java.lang.Math.*;

public class grapheneAtoms {
	
	double xpoint,ypoint,zpoint;	
	grapheneAtoms upperNeighber,lowerNeighber,SameNeighber;
	boolean zerotype;
	int AtomNo=0;
	
	public grapheneAtoms(int AtomNumber,double xposition ,double yposition,double zposition){
		this.xpoint = xposition;
		this.ypoint = yposition;
		this.zpoint = zposition;
		this.AtomNo = AtomNumber;
		
		
		
	}

}
