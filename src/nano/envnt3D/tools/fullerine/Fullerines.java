package nano.envnt3D.tools.fullerine;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import javax.swing.JOptionPane;
import nano.envnt3D.tools.swnt.swnt.bonds;




public class Fullerines {
	
	 public double[][] filedata;
     double[][] atomCoords,bondCoords;
     public int NoOfAtoms=200;
     bonds[] fbonds;
     int Type = 0;

	public Fullerines(int NoOfFullerineAtoms) {
		
		filedata =CreateFullerineData(NoOfFullerineAtoms);
		atomCoords = getAtomCoordinates();
		generateBonds();
		bondCoords = getBondCoordinates();
				
	}
	
	public Fullerines(int NoOfFullerineAtoms,int type){
		
		this.Type = type;
		filedata =CreateFullerineDataT(NoOfFullerineAtoms,type);
		atomCoords = getAtomCoordinates();
		generateBonds();
		bondCoords = getBondCoordinates();
	}
	
	public double[][] getAtomCoordinates(){
		double[][] aCoords = new double[NoOfAtoms][3];
		for(int i=0;i<NoOfAtoms;i++){
			aCoords[i][0]= filedata[i][1];
			aCoords[i][1]= filedata[i][2];
			aCoords[i][2]= filedata[i][3];
			
		}
		
		return aCoords;
	}
	public void generateBonds(){
		
		double[] a = {0,0,0};
		double[] b = {1,1,1};
		int atom1,atom2a,atom2b,atom2c;
		LinkedList<bonds> bondlist = new LinkedList<bonds>();
		bonds bond;
	    
		for(int i=0;i<filedata.length;i++){
			atom1 = (int)filedata[i][0];
			atom2a = (int)filedata[i][5];
			atom2b= (int)filedata[i][6];
			atom2c= (int)filedata[i][7];
			
			if(atom1<atom2a){
				bond= new bonds(atomCoords[atom1-1],atomCoords[atom2a-1],atom1,atom2a);
				bondlist.add(bond);
			}
			if(atom1<atom2b){
				bond= new bonds(atomCoords[atom1-1],atomCoords[atom2b-1],atom1,atom2b);
				bondlist.add(bond);
				}
			if(atom1<atom2c){
				bond= new bonds(atomCoords[atom1-1],atomCoords[atom2c-1],atom1,atom2c);
				bondlist.add(bond);
				}
			
		}
		
		fbonds = bondlist.toArray(new bonds[bondlist.size()]);
		
	}
	public double[][] getBondCoordinates(){
		double[][] bondcoords = new double[fbonds.length][6];
		for(int i=0;i<fbonds.length;i++){
			bondcoords[i][0]= fbonds[i].point1[0];
			bondcoords[i][1]= fbonds[i].point1[1];
			bondcoords[i][2]= fbonds[i].point1[2];
			bondcoords[i][3]= fbonds[i].point2[0];
			bondcoords[i][4]= fbonds[i].point2[1];
			bondcoords[i][5]= fbonds[i].point2[2];
		}
		
		return bondcoords;
	}

	public static String[] LoadStr(String file){
	 	   BufferedReader in;
	 	   BufferedReader in2;
	 	   String read = null;
	 	   String[] words=null;
	 	   
	 	   int Emptylines = 3;//the specific line i want to read
	 	   int LineIndex=0;
	 	   int NoOfLines=0;
	 	   
	 	   
	 	   try {
	 	   in = new BufferedReader(new FileReader(file));
	 	   
	 	   
	 	   while(Emptylines > 0){

	 		   read = in.readLine();//read the next line until the specfic line is found
	 		  	 	       
	 		   if(read ==null){
	 			   
	 			   Emptylines--;
	 			   
	 		   }
	 		   else{
	 		   NoOfLines++;
	 		   }
	 		   
	 		   }
	 	   in.close();
	 	   Emptylines =3;
	 	   words= new String[NoOfLines];
	 	   in2 = new BufferedReader(new FileReader(file));

	 	   while(Emptylines > 0){

	 	   read = in2.readLine();//read the next line until the specfic line is found
	 	  
	        
	 	   if(read ==null){
	 		   
	 		   Emptylines--;
	 		   
	 	   }
	 	   else{
	 		   
	 		   words[LineIndex]=read;
	 		   LineIndex ++;
	 		   
	 	   }
	 	   
	 	   
	 	   }

	 	   
	 	   in2.close();
	 	   }catch(IOException e){
	 	    JOptionPane.showMessageDialog(null, "Fullerine library not found. Copy the 'FullerineLib' folder in to project folder");
	 	   }


	 	   return words;
	     
	    }
	    
	    public double[][] CreateFullerineData(int CAtoms) {
	    	String[] searchQs = LoadStr(getFile(CAtoms));
	    	int size = searchQs.length;
	    	NoOfAtoms=size;
	    	Object[][] rows= new Object[size][50];
	    	Object[] rowi = new Object[30];
	    	Object[] Atomdetails = new Object[9];
			double[] Fatoms= new double[8];
			double[][] FatomsArray = new double[size][8];
	     
	        for(int i=0;i<size;i++){
	        	
			rowi = searchQs[i].split(" ");
			Object zero=rowi[0]; 
					
			int count=0;
			
			if(CAtoms<90 || CAtoms>100){
				for(int k=0;k<rowi.length;k++){
									
						if(rowi[k].toString().isEmpty() ){}
					
						else{
						Atomdetails[count]= rowi[k];
						count++;
						}
				}
			}
			else{
				for(int k=0;k<rowi.length-1;k++){
					
					if(rowi[k].toString().isEmpty() ){}
				
					else{
					Atomdetails[count]= rowi[k];
					count++;
					}
			}
				
			}
			
			
			for(int p=1;p<Atomdetails.length;p++){
				Fatoms[p-1]= Double.parseDouble(Atomdetails[p].toString());
				FatomsArray[i][p-1]=Fatoms[p-1];
			}

			for(int j=0;j<Atomdetails.length;j++){          
			     rows[size-1-i][j]=Atomdetails[j];                   
			}
			
	        }
	        
	    	return FatomsArray;
	    }
	    
	    public double[][] CreateFullerineDataT(int CAtoms,int Type) {
	    	String[] searchQs = LoadStr(getFile(CAtoms));
	    	int size = searchQs.length;
	    	NoOfAtoms=size-1;
	    	Object[][] rows= new Object[size-1][50];
	    	Object[] rowi = new Object[30];
	    	Object[] Atomdetails = new Object[9];
			double[] Fatoms= new double[8];
			double[][] FatomsArray = new double[size-1][8];
	    
			
	   
	    	
			
	        for(int i=1;i<size;i++){
	        	
			rowi = searchQs[i].split(" ");
			Object zero=rowi[0]; 
			
			
			
			int count=0;
			
			if(CAtoms<90 || CAtoms>100){
				for(int k=0;k<rowi.length;k++){
									
						if(rowi[k].toString().isEmpty() ){}
					
						else{
						Atomdetails[count]= rowi[k];
						count++;
						}
				}
			}
			else{
				for(int k=0;k<rowi.length-1;k++){
					
					if(rowi[k].toString().isEmpty() ){}
				
					else{
					Atomdetails[count]= rowi[k];
					count++;
					}
			}
				
			}
			
			
			for(int p=1;p<Atomdetails.length;p++){
				Fatoms[p-1]= Double.parseDouble(Atomdetails[p].toString());
				FatomsArray[i-1][p-1]=Fatoms[p-1];
				
			}
			
			
			
			for(int j=0;j<Atomdetails.length;j++){
		         
			rows[size-1-i][j]=Atomdetails[j];               
		  
			}
			
			
			
	        }
	        
	    	return FatomsArray;
	    }
	    
	    public String getFile(int NoOfCAtoms){
	    	
	    	String file;
	    	if(Type==0){
                //    URL myurl = this.getClass().getResource("resources/FullereneLib");
	    	 file = "resources/FullereneLib/C"+NoOfCAtoms+"/c"+NoOfCAtoms+".txt";
                 //System.out.print(file);
	    	}
	    	else{
	    		FileAccess f = new FileAccess();
	    		file = f.getFileName(NoOfCAtoms, Type);
	    	}
	    	
	    	return file;
	    }
	    
	        
	

}
