package nano.envnt3D.tools.EnergyBands;
//

public class GrapheneDispersion {
	
	public double acc=1.42;          //in Angstroms
	public static double root3 = Math.sqrt(3);
	public double a= root3*acc;
	public double s = 0.129;
	public double eps = 0; 
	public double gamma = 3.013; // in ev
	public double[][] Bonding,AntiBonding;
	

	public GrapheneDispersion() {	
		
		
	}
	public void SetCCBondLength(double bondlength){
		acc = bondlength;
                a = root3*acc;
	}
	public void SetS(double sval){
		s = sval;
	}
	public void SetEpsilon(double epsilon){
		eps = epsilon;
	}
	public void SetBondEnergy(double gamma0){
		gamma = gamma0;
	}
	public void CalculateGraph(double[] x, double[] y){
		AntiBonding = new double[y.length][x.length];
		Bonding = new double[y.length][x.length];
		double w;
		for(int i=0;i<x.length;i++){
			for(int j=0;j<y.length;j++){
				
				w= 1+ 4*Math.cos(root3*x[i]*a/2)*Math.cos(a*y[j]/2)+4*(Math.cos(a*y[j]/2))*(Math.cos(a*y[j]/2));
				w= Math.sqrt(w);
				AntiBonding[i][j]= (eps+gamma*w)/(1-s*w);
				Bonding[i][j]=  (eps-gamma*w)/(1+s*w);
			}
		}
		
	}
	public double[][] getAntiBonding(){
		return AntiBonding;
	}
	public double[][] getBonding(){
		return Bonding;
	}
   
}
