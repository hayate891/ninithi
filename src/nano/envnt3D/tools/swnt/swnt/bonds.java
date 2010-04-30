package nano.envnt3D.tools.swnt.swnt;

public class bonds {
	
	public int atom1;
	public int atom2;
	public double[] point1,point2;
	

	public bonds(double[] points1, double[] points2,int atoms1,int atoms2) {
		// TODO Auto-generated constructor stub
		this.point1=points1;
		this.point2=points2;		
		this.atom1 = atoms1;
		this.atom2 = atoms2;
	}
	
	

}
