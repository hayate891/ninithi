package nano.envnt3D.tools.swnt.swnt;
import java.lang.Math.*;


public class mathOps {
	
	static double[] arrayOutMul,arrayOutAdd,arrayOutSub;
	
	public static double[] scaleMul(double[] arrayIn, int scalar){
		
		arrayOutMul = new double[arrayIn.length];
		for(int i=0;i < arrayIn.length;i++){
			arrayOutMul[i]=  scalar*arrayIn[i];
		}
		return arrayOutMul;
				
	}
	public static double[] scaleMul(double[] arrayIn, double scalar){
		
		arrayOutMul = new double[arrayIn.length];
		for(int i=0;i < arrayIn.length;i++){
			arrayOutMul[i]=  scalar*arrayIn[i];
		}
		return arrayOutMul;
				
	}
	public static double[] scaleDev(double[] arrayIn, double scalar){
		
		double[] arrayOutDev = new double[arrayIn.length];
		for(int i=0;i < arrayIn.length;i++){
			arrayOutDev[i]=  arrayIn[i]/scalar;
		}
		return arrayOutDev;
				
	}
	
	public static double[] add(double[] array1, double[] array2){
		
		arrayOutAdd =new double[array1.length];
		for(int i=0;i < array1.length;i++){
			arrayOutAdd[i]= array1[i]+array2[i];
		}
		
		return arrayOutAdd;
		
	}
	public static double[] scaleAdd(double[] arrayIn, double scalar){
		
		double[] arrayOut = new double[arrayIn.length];
		for(int i=0;i < arrayIn.length;i++){
			arrayOut[i]=  arrayIn[i]+scalar;
		}
		return arrayOut;
				
	}
	
    public static double[] subs(double[] array1, double[] array2){
		
		arrayOutSub =new double[array1.length];
		for(int i=0;i < array1.length;i++){
			arrayOutSub[i]= array1[i]-array2[i];
		}
		
		return arrayOutSub;
		
	}
	
	public static double norm(double[] inputarray){
		double normval = 0;
		for(int i=0;i<inputarray.length;i++){
			normval = normval + (inputarray[i]*inputarray[i]);
		}
		return Math.sqrt(normval);
	}
	
    public static double[] isInside(double[] x,double[] y,double[] v1,double[] v2){
		
    	double[] alpa1= new double[x.length] ;
    	double[] beeta1= new double[x.length] ;
    	double[] mask1= new double[x.length] ;
    	
    	for (int i=0;i<x.length;i++){
        
	        alpa1[i] = (v2[1]*x[i]-v2[0]*y[i])/(v1[0]*v2[1]-v1[1]*v2[0]);       
	        beeta1[i] = (v1[1]*x[i]-v1[0]*y[i])/(-v1[0]*v2[1]+v1[1]*v2[0]);
	        
	        if (-0.01 <= alpa1[i] &&  alpa1[i]<=1.01 && -0.01<= beeta1[i] &&  beeta1[i] <=1.01){
	            mask1[i]=1;	            
	        }
	        else{
	        	mask1[i]=0;
	        }	     
    	}
    	
    	return mask1;
    	
    }
    
    public static int noOfPointsInside(double[] mask){
    	int no_of_points =0;
    	for(int i=0;i<mask.length;i++){
    		if(mask[i]==1){
    			no_of_points++;
    		}    		
    	}
    	return 	no_of_points;
    	
    }
	
	
	
	public static double[][] IntArray2Double(int[][] input){
		
		double[][] output = new double[input.length][input.length];
		return output;
	}
	
	public static double dotProduct(double[] v1, double[] v2 ){
		double product =0;
		for(int i=0;i<v1.length;i++){
			product = product + v1[i]*v2[i];
		}
		return product;
	}
	public static double[] combineArrays(double[] array1,double[] array2){
		double[] result = new double[array1.length+array2.length];
		for(int i=0;i<array1.length;i++){
			result[i]= array1[i];
		}
		for(int i=0;i<array2.length;i++){
			result[i+array1.length]=array2[i];
		}
		return result;
	}
        public static double[][] combineArrayBelow(double[][] array1,double[][] array2){
		double[][] result = new double[array1.length+array2.length][array1[0].length];
                for(int i=0;i<array1.length;i++){
                    result[i]= array1[i];
                }
                for(int i=0;i<array2.length;i++){
                    result[i+array1.length]= array2[i];
                }

		return result;
	}

	public static int gcd(int a, int b) {
		 
		   if (b==0) 
		     return a;
		   else
		     return gcd(b, a % b);
	} 
	
	public static boolean isWithin(double[] a, double b){
		
		boolean c = false;
		int i=0;
		while(i<a.length){
			if(a[i]==b){
				c = true;
				break;
			}
			i++;
		}
		return c;
	}
	
	
	public static void main(String[] args){
		double[] a= {1,-1,2,4,5};
		double[] b= {2,3};
		
		if(!isWithin(a, 2.0000001)){
		System.out.println("Thanks");
		}
		//System.out.println(scaleDev(a,5)[1]);
		double[][] news = {{1,2,3},{2,3,5}};
		//System.out.println(news.clone().toString());
		
	}

	
	
}
