package nano.envnt3D.tools.EnergyBands;

import nano.envnt3D.tools.swnt.swnt.graphene;
import nano.envnt3D.tools.swnt.swnt.mathOps;
import static org.math.array.DoubleArray.increment;



public class SwntEBands {
	public int m,n,d,dr,Nc;
	public double root3=Math.sqrt(3);
	public double curcum,T;
	public double acc = 1.42; //in angstrom
	public double a = root3*acc;
	public double[] a1= {a*root3/2 , a/2};
	public double[] a2= {a*root3/2 , -a/2};
	public double[] b1= {2*Math.PI/(root3*a),2*Math.PI/a};
	public double[] b2= {2*Math.PI/(root3*a),-2*Math.PI/a};
	public double[] k,K1,K2,p1,p2;
	public double[][] antiBondingBands;
	public double[][] BondingBands,wcnt;
	public static double s = 0;
	public static double eps = 0; 
	public static double gamma = 3.013;

	public SwntEBands(int Mval,int Nval) {
		
		this.m = Mval;
		this.n= Nval;
		CreateGraphPlots();
		
	}
	public void CreateGraphPlots(){

		this.d = mathOps.gcd(m, n);
		this.dr = mathOps.gcd(2*n+m, 2*m+n);
		this.Nc =2*(m*m+n*n+m*n)/dr;
		this.curcum = mathOps.norm(mathOps.add(mathOps.scaleMul(a1, n),mathOps.scaleMul(a2, m)));
		this.T= root3*curcum/dr;

		this.K1=mathOps.scaleDev((mathOps.add(mathOps.scaleMul(b1,(2*n+m)), mathOps.scaleMul(b2, 2*m+n))),(double)(Nc*dr));
		this.K2= mathOps.scaleDev(mathOps.subs(mathOps.scaleMul(b1, m), mathOps.scaleMul(b2, n)), (double)Nc);
		double roundval = Math.ceil(((Math.PI/T)*100))/100;
		double[] k1= increment(-roundval,0.01,roundval);
		k = k1;
		//double[] p1,p2;
		double[][] wcnt = new double[Nc][k.length];
	    this.BondingBands = new double[Nc][k.length];
		this.antiBondingBands = new double[Nc][k.length];
		double w;
		for (int mu=0;mu<Nc;mu++){
			
			p1 = mathOps.scaleAdd(mathOps.scaleMul(mathOps.scaleDev(k, mathOps.norm(K2)), K2[0]),mu*K1[0] );
			p2 = mathOps.scaleAdd(mathOps.scaleMul(mathOps.scaleDev(k,mathOps.norm(K2) ), K2[1]),mu*K1[1] );
			
			for(int j=0;j<k.length;j++){
				w = 1+ 4*Math.cos(root3*p1[j]*a/2)*Math.cos(p2[j]*a/2)+4*Math.cos(p2[j]*a/2)*Math.cos(p2[j]*a/2);
				wcnt[mu][j]= Math.sqrt(w);
				antiBondingBands[mu][j]= (eps+gamma*wcnt[mu][j])/(1-s*wcnt[mu][j]);
				BondingBands[mu][j]=  (eps-gamma*wcnt[mu][j])/(1+s*wcnt[mu][j]);
				
			}
			
		}
		
	}
        public void SetCCBondLength(double bondlength){
		acc = bondlength;
                 a = root3*acc;
                 a1[0]= a*root3/2 ;
                 a1[1]= a/2;
                 a2[0]= a*root3/2 ;
                 a2[1]=-a/2;
                 b1[0]= 2*Math.PI/(root3*a);
                 b1[1]=2*Math.PI/a;
                 b2[0]= 2*Math.PI/(root3*a);
                 b2[1]= -2*Math.PI/a;

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
	public static void main(String[] args) {
		//System.out.println(s);
		 double[][] a = {{1.234, 4.5, 6.78},{1.2, 3.45, 6.789}};
		 String  astr = new String();
		 
		 SwntEBands plane1 = new SwntEBands(5, 5);
		 plane1.CreateGraphPlots();
		astr = org.math.array.DoubleArray.toString(plane1.k);
		 System.out.println(astr);
		astr = org.math.array.DoubleArray.toString(plane1.p1);
		System.out.println(astr);
		// astr = org.math.array.DoubleArray.toString(plane1.x_even);
		// System.out.println(astr);
		// astr = org.math.array.DoubleArray.toString(plane1.x_atom);
		 //System.out.println(astr);
		// astr = org.math.array.DoubleArray.toString(plane1.y_atom);
		 //System.out.println(astr);
		System.out.println(plane1.k.length);
	}
	
	

}
