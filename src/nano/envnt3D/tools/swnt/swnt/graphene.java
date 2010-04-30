package nano.envnt3D.tools.swnt.swnt;
import static java.lang.Math.*;
import static org.math.array.DoubleArray.*;


public class graphene {
	
	double Xmax, Xmin, Ymax, Ymin;	
	double[] xEvenP,yP,yN;
    double[] xEvenN, xOddP, xOddN, yEvenP, yEvenN, yOddP, yOddN,x_even,x_odd,x_upper,x_lower,y_upper,y_lower,x_atom,y_atom;
	int xEvenPSize,xEvenNSize,yEvenPSize,yEvenNSize,x_size,yPSize,yNSize,y_size,xUpperSize,xLowerSize,AtomsCount;
	public static double s= sqrt(3)/2;
	public static double[] a1 = {1.5,s};
	public static double[] a2 = {1.5,-s};
	
	public graphene(double x_min, double x_max,double y_min,double y_max){
		
		xEvenPSize= (int) (ceil(x_max/3*2)+2) ;
		xEvenNSize= (int) (ceil(abs(x_min)/3*2)+2);
		yEvenPSize = (int) (ceil(y_max/(s*2))+2) ; 
		yEvenNSize = (int) (ceil(abs(y_min/(s*2)))+2);
		
		xEvenP = new double[xEvenPSize];
		xEvenN = new double[xEvenNSize];
		yEvenP = new double[yEvenPSize];
		yEvenN = new double[yEvenNSize];
		
		xOddP= xEvenP;
		xOddN= xEvenN;
		yOddP= yEvenP;
		yOddN= yEvenN;
		
		xEvenP[0]=0;
		xEvenP[1]=1;
		
		for(int i=2;i<xEvenPSize;i++)
		{
			xEvenP[i]=xEvenP[i-1]+2/( xEvenP[i-1]-xEvenP[i-2]);
			
		}
		
		xEvenN[0]= -2;
		xEvenN[1]= -3;
		
		for(int i=2;i<xEvenNSize;i++){
			xEvenN[i]=xEvenN[i-1]+2/( xEvenN[i-1]-xEvenN[i-2]);
		}
		
		x_size = xEvenPSize + xEvenNSize;
		x_even = new double[x_size];          // x coordinates in even lines
		
		for (int i= 0;i<xEvenNSize;i++){			
			x_even[i]= xEvenN[xEvenNSize-i-1];
		}
		for (int i= 0;i<xEvenPSize;i++){
			x_even[i+xEvenNSize]= xEvenP[i];
		}
		
		x_odd = new double[x_size];
		for(int i=0;i<x_size;i++){           // x coordinates for odd lines
			x_odd[i]=x_even[i]+1.5;	
		}
		
		yPSize = (int) (ceil(y_max/(s))+2);  // positive y coordinates
		yP = new double[yPSize];
		
		for (int i=0;i<yPSize;i++){
			yP[i]= s*(i);
		}
		
		yNSize = (int) (ceil(abs(y_min/(s)))+2); // negetive y coordinates
		yN = new double[yNSize];
		
		for (int i=0;i<yNSize;i++){
			yN[i]= -s*(i+1);
		}
		
		y_size = yPSize+yNSize;        // y cordinates of atoms
		
		// upper atoms above x axis
		
		xUpperSize = yPSize*x_size;
		x_upper = new double[xUpperSize];
		y_upper = new double[xUpperSize];
		
		for (int i=0;i<yPSize;i++){
			
		    if (i%2==0){
			    for (int j=0; j<x_size;j++){
			       x_upper[j+x_size*(i)]=x_even[j];
			       y_upper[j+x_size*(i)]= s*(i); 
			    }
		    }
		    
		    if (i%2==1){
			    for(int j=0;j<x_size;j++){
			       x_upper[j+x_size*(i)]=x_odd[j];
			       y_upper[j+x_size*(i)]= s*(i);  
			    }
		    }
		}
		
		//lower atoms below x axis
		xLowerSize = yNSize*x_size;
		x_lower = new double[xLowerSize];
		y_lower = new double[xLowerSize];
		
		for (int i=0;i< yNSize;i++){
			
		    if (i%2==0){
			    for (int j=0; j<x_size;j++){
			    	x_lower[j+x_size*i]=x_odd[j];
			        y_lower[j+x_size*i]= -s*(i+1);
			    }
		    }
		    
		    if (i%2==1){
			    for(int j=0;j<x_size;j++){
			    	x_lower[j+x_size*i]=x_even[j];
			        y_lower[j+x_size*i]= -s*(i+1); 
			    }
		    }
		}
		AtomsCount= xUpperSize+xLowerSize;
		x_atom = new double[AtomsCount];
		y_atom = new double[AtomsCount];
		
		for(int i=0;i<xUpperSize;i++){
			x_atom[i]= x_upper[i];
			y_atom[i]= y_upper[i];
		}
		for(int i=xUpperSize;i<AtomsCount;i++){
			x_atom[i]= x_lower[i-xUpperSize];
			y_atom[i]= y_lower[i-xUpperSize];
		}
		
		
	}
    public double[][] getBondCoordinates(){
    	
    			
    	int NoOfAtoms=x_atom.length;
	    int[][] neigbers = new int[NoOfAtoms][4];
		
		for(int i=0;i<NoOfAtoms;i++){
			neigbers[i][0]=-1;
			neigbers[i][1]=-1;
			neigbers[i][2]=-1;
			neigbers[i][3]=i;
		}
		
		for(int k=1;k<NoOfAtoms;k++){    // k=2:no_of_atoms
	    
		    //to find the neigbers in the same line
		       // neigbers[k][3] = k;          //atom no                    
			    if(y_atom[k]==y_atom[k-1]){          // if in the same line as previous y_atom value is equal      cnt_2d(k,2)==cnt_2d(k-1,2)
				    if(x_atom[k]-x_atom[k-1]< 1.5){  //   cnt_2d(k,1)-cnt_2d(k-1,1)<1.5
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
		       
				if(0<y_atom[j]-y_atom[k] && y_atom[j]-y_atom[k] <1){        //          0<cnt_2d(j,2)-cnt_2d(k,2)&& cnt_2d(j,2)-cnt_2d(k,2)< 1
		           
					if(0< Math.abs(x_atom[j]-x_atom[k]) && Math.abs(x_atom[j]-x_atom[k])<1){  //  0< abs(cnt_2d(j,1)-cnt_2d(k,1)) && abs(cnt_2d(j,1)-cnt_2d(k,1))<1
		                
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
		int bondsc=0;
		boolean[][] bondmask=new boolean[NoOfAtoms][3];
		for(int i=0;i<NoOfAtoms;i++){
			
			bondmask[i][0]= false;
			bondmask[i][1]= false;
			bondmask[i][2]= false;
		}
		grapheneAtoms[] atoms= new grapheneAtoms[NoOfAtoms];
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
		
		int NoOfBonds = bondcount;
		bonds[] bonds = new bonds[bondcount];
		
		double cnt_2d[][]= new double[x_atom.length][2]; 
		for(int i=0;i<x_atom.length;i++){
			cnt_2d[i][0]= x_atom[i];
			cnt_2d[i][1]=y_atom[i];
		}
		
		
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
		
		
	//}
	
	//public double[][] getBondCoordinates(){
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
    
	public double[][] getcoordinates(){
		double[][] coordinates = new double[x_atom.length][3];
		for(int i=0;i<x_atom.length;i++){
			coordinates[i][0]= x_atom[i];
			coordinates[i][1]= y_atom[i];
			coordinates[i][2]=0;
		}
		return coordinates;
	}
	
	
	public static void main(String[] args) {
		//System.out.println(s);
		 double[][] a = {{1.234, 4.5, 6.78},{1.2, 3.45, 6.789}};
		 String  astr = new String();
		 
		 graphene plane1 = new graphene(-2,3,-2,3);
		astr = org.math.array.DoubleArray.toString(plane1.xEvenP);
		// System.out.println(astr);
		 astr = org.math.array.DoubleArray.toString(plane1.x_odd);
		// System.out.println(astr);
		 astr = org.math.array.DoubleArray.toString(plane1.x_even);
		// System.out.println(astr);
		 astr = org.math.array.DoubleArray.toString(plane1.x_atom);
		 //System.out.println(astr);
		 astr = org.math.array.DoubleArray.toString(plane1.y_atom);
		 //System.out.println(astr);
		//System.out.println(totring(plane1.yEvenP));
	}
	

}
