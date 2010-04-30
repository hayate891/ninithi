package nano.envnt3D.tools.swnt.swnt;
import org.math.array.DoubleArray;

public class GrapheneLayer {
	
	private int m;
	nanoribbon armchairRibbon;
	double[][] atomcoords,bondcoords;
	
	public GrapheneLayer(double width, double length){
		
		m= (int)Math.ceil(width/3);
		armchairRibbon = new nanoribbon(m, m , length);
	}
	
	public double[][] getAtomCoordinates(){
		
		atomcoords = armchairRibbon.getAtomCoordinates();
		
		return atomcoords;
	}
	
	public double[][] getBondCoordinates(){
		
		bondcoords = armchairRibbon.getBondCoordinates();
		
		return bondcoords;
	}
	
	private double[][] normalizeAtoms(double[][] input){
		
		double max = DoubleArray.max(DoubleArray.max(input));
		double min = DoubleArray.min(DoubleArray.min(input));


		
		for(int i =0;i<input.length;i++){
			input[i] = mathOps.scaleAdd(input[i], (min-max)/2);
			input[i] = mathOps.scaleDev(input[i], (max-min)/2);
		}
		
		return input;
		
	}
        private double[][] normalizeBonds(double[][] input){

		double max = DoubleArray.max(DoubleArray.max(input));
		double min = DoubleArray.min(DoubleArray.min(input));



		for(int i =0;i<input.length;i++){
			input[i] = mathOps.scaleAdd(input[i], (min-max)/2);
			input[i] = mathOps.scaleDev(input[i], (max-min)/2);
		}

		return input;

	}
	

}
