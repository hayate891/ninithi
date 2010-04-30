package nano.envnt3D.tools.swnt.swnt;

import org.math.array.DoubleArray;

public class nanotube {
	nanoribbon ribon;
	int m=5;
	int n=5;
	double length= 4;
	double radius;
	double[][] atomCoordinates,bondCoordinates;
	double pi = Math.PI;
	bonds[] cntbonds;
	
	public nanotube(int M,int N,double Length){
		
	    this.m = M;
	    this.n =N;
	    this.length =Length;
            try {
                this.ribon = new nanoribbon(m, n, Length);

                this.atomCoordinates = getCoordinates();
                generatebonds();
                this.bondCoordinates = getBondCoordinates();
            } catch (Exception e) {
                
            }
		
				
	}
	
	public double[][] getCoordinates(){
		radius = mathOps.norm(ribon.ch)/(2*pi);
		
		double[][] atomCoordinats= new double[ribon.NoOfAtoms][3];
	
		for(int k=0;k<ribon.NoOfAtoms;k++){                // k=1:no_of_atoms
	    atomCoordinats[k][0] = radius*Math.cos(2*pi*mathOps.dotProduct(ribon.cnt_2d[k], ribon.Uch)/(mathOps.norm(ribon.ch)));  // radius*cos(2*pi*dot(cnt_2d(k,:),Uch)/norm(ch));
	    atomCoordinats[k][1] = radius*Math.sin(2*pi*mathOps.dotProduct(ribon.cnt_2d[k], ribon.Uch)/(mathOps.norm(ribon.ch)));          //cnt_3d(k,2)= radius*sin(2*pi*dot(cnt_2d(k,:),Uch)/norm(ch));
	    atomCoordinats[k][2] = mathOps.dotProduct(ribon.cnt_2d[k], ribon.UT);  //  cnt_3d(k,3)= dot(cnt_2d(k,:),UT);
	    
		}	
		
		return atomCoordinats;
		
	}
	public void generatebonds(){
		bonds[] layerbonds = ribon.bonds;       // bonds from original graphene
		for(int i=0;i<layerbonds.length;i++){
			layerbonds[i].point1 = atomCoordinates[layerbonds[i].atom1];
			layerbonds[i].point2 = atomCoordinates[layerbonds[i].atom2];
		}
		
		bonds[] tubebonds1=new bonds[ribon.NoOfAtoms] ;
		int index =-1;
		for(int j=0;j<ribon.NoOfAtoms;j++){
			if(0< Math.abs(atomCoordinates[j][0]-radius)  && Math.abs(atomCoordinates[j][0]-radius)< 1 ){
				if(0<Math.abs(atomCoordinates[j][1]) && Math.abs(atomCoordinates[j][1])<1.2){
			
					for(int k=0;k<ribon.NoOfAtoms;k++){
						if(0< Math.abs(atomCoordinates[k][0]-radius)  && Math.abs(atomCoordinates[k][0]-radius)< 1 ){
							if(0<Math.abs(atomCoordinates[k][1]) && Math.abs(atomCoordinates[k][1])<1.2){
								
								if(mathOps.norm(mathOps.subs(atomCoordinates[k], atomCoordinates[j]))<1.05 && 0.95<mathOps.norm(mathOps.subs(atomCoordinates[k], atomCoordinates[j]))){
									index ++;
									tubebonds1[index]= new bonds(atomCoordinates[k],atomCoordinates[j],k,j);
								}
							}
							
						}
					}
				}
			}
		}
		bonds[] tubebonds = new bonds[index+1];
		for(int i=0;i<tubebonds.length;i++){
			tubebonds[i]=tubebonds1[i];
		}
		
		///cntbonds= layerbonds;
		cntbonds = combineArrays(layerbonds, tubebonds);
	}
	
	public double[][] getBondCoordinates(){
		
		double[][] bondCoords = new double[cntbonds.length][6];
		for(int i=0;i<cntbonds.length;i++){
			bondCoords[i][0]= cntbonds[i].point1[0];
			bondCoords[i][1]= cntbonds[i].point1[1];
			bondCoords[i][2]= cntbonds[i].point1[2];
			bondCoords[i][3]= cntbonds[i].point2[0];
			bondCoords[i][4]= cntbonds[i].point2[1];
			bondCoords[i][5]= cntbonds[i].point2[2];
		}
		
		return bondCoords;
	}
	public bonds[] combineArrays(bonds[] array1,bonds[] array2){
		bonds[] result = new bonds[array1.length+array2.length];
		for(int i=0;i<array1.length;i++){
			result[i]= array1[i];
		}
		for(int i=0;i<array2.length;i++){
			result[i+array1.length]=array2[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		//System.out.println(s);
		 double[][] a = {{1.234, 4.5, 6.78},{1.2, 3.45, 6.789}};
		 String  astr = new String();
		 String  astr1 = new String();
		 
		 
		 
		 nanotube tube1 = new nanotube(3,2,5);
		 
		/* double[][] neib = new double[plane1.NoOfAtoms][4];
		 for(int j=0;j<4;j++){
			 for(int i=0;i<plane1.NoOfAtoms;i++){
				 neib[i][j]=(double) plane1.neigbers[i][j];
			 }
		 }*/
		 
		astr = org.math.array.DoubleArray.toString(DoubleArray.transpose(tube1.getCoordinates()));
		System.out.println(astr);
		astr = org.math.array.DoubleArray.toString(tube1.getBondCoordinates());
		System.out.println(astr);
		// astr = org.math.array.DoubleArray.toString(plane1.mask);
		// System.out.println(astr);
		 //astr = org.math.array.DoubleArray.toString(plane1.getAtomCoordinates());
		// System.out.println(astr);
		// astr = org.math.array.DoubleArray.toString(neib);
		 //System.out.println(astr);
		 
		// astr1 = org.math.array.DoubleArray.toString(plane1.ch);		
		// astr = org.math.array.DoubleArray.toString(plane1.T);
		// System.out.println("T :" + astr +"ch" + astr1);
		//System.out.println("xmin "+plane1.x_min +" x_max "+plane1.x_max+" ymin "+plane1.y_min+" ymax "+plane1.y_max+"  no of atoms :"+plane1.NoOfAtoms);
	}


}
