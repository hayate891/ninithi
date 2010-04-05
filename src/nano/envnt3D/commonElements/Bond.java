package nano.envnt3D.commonElements;

import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Vector3f;

import nano.envnt3D.AppearanceNano;

import com.sun.j3d.utils.geometry.Cylinder;

public class Bond {
	
    private Vector3f tempVec = new Vector3f();
    private Vector3f crossVec = new Vector3f();
    private static final Vector3f YAXIS = new Vector3f(0, 1, 0);
    private Transform3D tempTrans = new Transform3D();
    private Transform3D tempTrans2 = new Transform3D();
    private AxisAngle4f tempAA = new AxisAngle4f();
    private TransformGroup bondGroup=new TransformGroup();
    private TransformGroup bondsGroup=new TransformGroup();
    private AppearanceNano apperancenano=new AppearanceNano();
	
    public TransformGroup drawBonds(double[][] coordsBond){
    	return (drawBonds(coordsBond, apperancenano.matGREEN,0.01f));
    
    }
    
    public TransformGroup drawBonds(double[][] coordsBond,Appearance appBond){
    	return (drawBonds(coordsBond, appBond,0.01f));
    }
    
    public TransformGroup drawBonds(double[][] coordsBond,float radious){
    	return (drawBonds(coordsBond, apperancenano.matGREEN,radious));
    }
    
    public TransformGroup drawBonds(double[][] coordsBond,Appearance appBond,float radious){
		float x,y,z;
		double dx,dy,dz,length;
		
    	for(int i=0;i<coordsBond.length;i++ ){ 		
    		
    		x=(float)(coordsBond[i][0]+coordsBond[i][3]);
    		y=(float)(coordsBond[i][1]+coordsBond[i][4]);
    		z=(float)(coordsBond[i][2]+coordsBond[i][5]);
    		dx=(coordsBond[i][3]-coordsBond[i][0]);
    		dy=(coordsBond[i][4]-coordsBond[i][1]);
    		dz=(coordsBond[i][5]-coordsBond[i][2]);
    		
    		length=Math.sqrt(dx*dx+dy*dy+dz*dz);
    		
    		tempVec.set((float)dx, (float)dy,(float) dz);
    		
    		 // Find axis of rotation
            tempVec.normalize();
            crossVec.cross(YAXIS, tempVec);
            
         // Find amount of rotation and put into matrix
            tempAA.set(crossVec, (float)Math.acos(YAXIS.dot(tempVec)));
            tempTrans.set(tempAA);
            
            
         // Transform to midpoint between two nodes
            tempTrans2.setIdentity();
            tempTrans2.setTranslation(new Vector3f(x/2, y/2, z/2));
            
            tempTrans2.mul(tempTrans);
            
           
            
            bondGroup=new TransformGroup(tempTrans2);           

	          
	    	Cylinder bond=new Cylinder(radious, (float)length,appBond);

	    	bondGroup.addChild(bond);
	    	bondsGroup.addChild(bondGroup);
	    	
	    	
    	}//End of for loop
		return bondsGroup;
	}

	

}
