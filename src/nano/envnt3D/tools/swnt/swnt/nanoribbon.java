package nano.envnt3D.tools.swnt.swnt;
import org.math.array.DoubleArray.*;
import org.math.array.*;
import nano.envnt3D.tools.swnt.swnt.mathOps;
public class nanoribbon {
	
	int m,n,NoOfAtoms,NoOfBonds;
	double length;
	double zplane=0;
	double x_min,x_max,y_min,y_max,x_atom,y_atom;
	double[] ch,T,Uch,UT,a1,a2,diagonal,mask;
	double[][] cnt_2d,cnt_2dt,atomCoordinates;
	int[][] neigbers;
    graphene layer;
	bonds[] bonds;
	grapheneAtoms[] atoms;
	
	public nanoribbon(int m,int n,double length) {
		// TODO Auto-generated constructor stub
		this.a1 = graphene.a1;
		this.a2 = graphene.a2;
		
		ch= new double[2];
		T = new double[2];
		ch =mathOps.add(mathOps.scaleMul(a1,m),mathOps.scaleMul(a2, n));
		T[0]= -ch[1];
		T[1]= ch[0];
		Uch = mathOps.scaleDev(ch,mathOps.norm(ch));
		UT = mathOps.scaleDev(T,mathOps.norm(T));
		T = mathOps.scaleMul(UT, length);
		diagonal = mathOps.add(ch, T);
		
		x_min = DoubleArray.min(ch[0],T[0],diagonal[0],0);
		x_max = DoubleArray.max(ch[0],T[0],diagonal[0],0);
		y_min = DoubleArray.min(ch[1],T[1],diagonal[1],0);
		y_max = DoubleArray.max(ch[1],T[1],diagonal[1],0);
		
		layer= new graphene(x_min,x_max,y_min,y_max);
		mask = mathOps.isInside(layer.x_atom, layer.y_atom, ch, T);
		NoOfAtoms = mathOps.noOfPointsInside(mask);
		cnt_2dt = new double[2][NoOfAtoms];
		
		// remove atoms not inside the ribbon
		int j =0; 
		for(int i=0;i<mask.length;i++){
			if(mask[i]==1){
				cnt_2dt[0][j]= layer.x_atom[i];
				cnt_2dt[1][j]= layer.y_atom[i];
				j++;
			}
		}
		cnt_2d = DoubleArray.transpose(cnt_2dt); 
		
		this.atomCoordinates = getAtomCoordinates();
		FindNeigbers();
		generateBonds();
						
		
	}
	
	public void FindNeigbers(){
		neigbers = new int[NoOfAtoms][4];
		
		for(int i=0;i<NoOfAtoms;i++){
			neigbers[i][0]=-1;
			neigbers[i][1]=-1;
			neigbers[i][2]=-1;
			neigbers[i][3]=i;
		}
		
		for(int k=1;k<NoOfAtoms;k++){    // k=2:no_of_atoms
	    
		    //to find the neigbers in the same line
		       // neigbers[k][3] = k;          //atom no                    
			    if(cnt_2d[k][1]==cnt_2d[k-1][1]){          // if in the same line as previous y_atom value is equal      cnt_2d(k,2)==cnt_2d(k-1,2)
				    if(cnt_2d[k][0]-cnt_2d[k-1][0]< 1.5){  //   cnt_2d(k,1)-cnt_2d(k-1,1)<1.5
				        neigbers[k][0]= k-1;
				    }
				    
			    }		    
		}
		
		
		for(int k=1;k<NoOfAtoms;k++){                  // k=1:no_of_atoms
		    if(neigbers[k][0] != -1) {                   // neigbers(k,1)~=0
		         neigbers[neigbers[k][0]][0]= neigbers[k][3]; //        neigbers(neigbers(k,1),1)=neigbers(k,4);
		    }
		}
		
		
		// to find neighbers in upper line

		for(int k=0;k<NoOfAtoms;k++){              // k=1:no_of_atoms
		    
			for(int j=0;j<NoOfAtoms;j++){           // j=1:no_of_atoms
		       
				if(0<cnt_2d[j][1]-cnt_2d[k][1] && cnt_2d[j][1]-cnt_2d[k][1] <1){        //          0<cnt_2d(j,2)-cnt_2d(k,2)&& cnt_2d(j,2)-cnt_2d(k,2)< 1
		           
					if(0< Math.abs(cnt_2d[j][0]-cnt_2d[k][0]) && Math.abs(cnt_2d[j][0]-cnt_2d[k][0])<1){  //  0< abs(cnt_2d(j,1)-cnt_2d(k,1)) && abs(cnt_2d(j,1)-cnt_2d(k,1))<1
		                
						   neigbers[k][1] = j;        //neigbers(k,2)=j;
					}
				}
			}
		}
		
		for(int k=0;k<NoOfAtoms;k++){            // k=1:no_of_atoms
		    if(neigbers[k][1] != -1)  {              //  neigbers(k,2)~=0
		        neigbers[neigbers[k][1]][2]= neigbers[k][3];     // neigbers(neigbers(k,2),3)=neigbers(k,4);
		    }
		}

				
	}
	
	public double[][] getAtomCoordinates(){
		double[][] points = new double[NoOfAtoms][3];
		for(int i=0;i<NoOfAtoms;i++){
			points[i][0]=cnt_2d[i][0];
			points[i][1]=cnt_2d[i][1];
			points[i][2]= zplane;
			
			}
		return points;
	}
	
	public void generateBonds(){
		
		int bondsc=0;
		boolean[][] bondmask=new boolean[NoOfAtoms][3];
		for(int i=0;i<NoOfAtoms;i++){
			
			bondmask[i][0]= false;
			bondmask[i][1]= false;
			bondmask[i][2]= false;
		}
		atoms= new grapheneAtoms[NoOfAtoms];
		/*for(int i=0;i<NoOfAtoms;i++){
			atoms[i].AtomNo = neigbers[i][3];
			
			if(neigbers[i][0]!= -1){
				atoms[i].SameNeighber = atoms[neigbers[i][0]];
			}
			else{
				atoms[i].SameNeighber = null;
			}
			if(neigbers[i][1]!= -1){
				atoms[i].upperNeighber = atoms[neigbers[i][1]];
			}
			else{
				atoms[i].upperNeighber = null;
			}	
			if(neigbers[i][2]!= -1){
				atoms[i].lowerNeighber = atoms[neigbers[i][2]];
			}
			else{
				atoms[i].lowerNeighber = null;
			}
			
			atoms[i].xpoint = cnt_2d[i][0];
			atoms[i].ypoint = cnt_2d[i][1];			
			
		}*/
		
		int bondcount =0;
        for(int i=0;i<NoOfAtoms;i++){
			
			if(neigbers[i][0]< i && neigbers[i][0]>=0){		
				
				bondcount++;
			}				
		}
		
		for(int i=0;i<NoOfAtoms;i++){
                
			if(neigbers[i][1]>=0){
				
				bondcount++;
			}		
						
		}	 
		
		NoOfBonds = bondcount;
		bonds = new bonds[bondcount];
		
		
		bondcount =0;
		
		for(int i=0;i<NoOfAtoms;i++){
			
			if(neigbers[i][0]< i && neigbers[i][0]>=0){
				
				bonds[bondcount]= new bonds(cnt_2d[neigbers[i][0]],cnt_2d[neigbers[i][3]],neigbers[i][0],neigbers[i][3]);
			/*	bonds[bondcount].atom1 = neigbers[i][0];
				bonds[bondcount].atom2 = neigbers[i][3];
				bonds[bondcount].point1= cnt_2d[neigbers[i][0]];
				bonds[bondcount].point2= cnt_2d[neigbers[i][3]]; */
				bondcount++;
			}		
			
		}
		
		for(int i=0;i<NoOfAtoms;i++){
                
			if(neigbers[i][1]>=0){
				
				bonds[bondcount]= new bonds(cnt_2d[neigbers[i][1]],cnt_2d[neigbers[i][3]],neigbers[i][1],neigbers[i][3]);
				/*bonds[bondcount].atom1 = neigbers[i][1];
				bonds[bondcount].atom2 = neigbers[i][3];
				bonds[bondcount].point1= cnt_2d[neigbers[i][1]];
				bonds[bondcount].point2= cnt_2d[neigbers[i][3]];*/
				bondcount++;
			}		
						
		}	    
		
		
	}
	
	public double[][] getBondCoordinates(){
		double[][] bondcoords = new double[bonds.length][6] ;
		for(int i=0; i<bonds.length;i++){
			bondcoords[i][0]= bonds[i].point1[0];
			bondcoords[i][1]= bonds[i].point1[1];
			bondcoords[i][2]= 0;
			bondcoords[i][3]= bonds[i].point2[0];
			bondcoords[i][4]= bonds[i].point2[1];
			bondcoords[i][5]= 0;
		}
		
		return bondcoords;
		
	}
	
	
	public static void main(String[] args) {
		//System.out.println(s);
		 double[][] a = {{1.234, 4.5, 6.78},{1.2, 3.45, 6.789}};
		 String  astr = new String();
		 String  astr1 = new String();
		 
		
		 
		 nanoribbon plane1 = new nanoribbon(5,0,5);
		 
		 double[][] neib = new double[plane1.NoOfAtoms][4];
		 for(int j=0;j<4;j++){
			 for(int i=0;i<plane1.NoOfAtoms;i++){
				 neib[i][j]=(double) plane1.neigbers[i][j];
			 }
		 }
		 
		astr = org.math.array.DoubleArray.toString(plane1.getBondCoordinates());
		System.out.println(astr);
		astr = org.math.array.DoubleArray.toString(plane1.layer.y_atom);
		//System.out.println(astr);
		 astr = org.math.array.DoubleArray.toString(plane1.mask);
		// System.out.println(astr);
		 astr = org.math.array.DoubleArray.toString(plane1.getAtomCoordinates());
		// System.out.println(astr);
		 astr = org.math.array.DoubleArray.toString(neib);
		// System.out.println(astr);
		 
		 astr1 = org.math.array.DoubleArray.toString(plane1.ch);		
		 astr = org.math.array.DoubleArray.toString(plane1.T);
		 System.out.println("T :" + astr +"ch" + astr1);
		System.out.println("xmin "+plane1.x_min +" x_max "+plane1.x_max+" ymin "+plane1.y_min+" ymax "+plane1.y_max+"  no of atoms :"+plane1.NoOfAtoms+" no of bonds :"+ plane1.NoOfBonds);
	}
	

}

