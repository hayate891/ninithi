package nano.envnt3D.commonElements;

import javax.media.j3d.Appearance;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Vector3f;

import nano.envnt3D.AppearanceNano;

import com.sun.j3d.utils.geometry.Sphere;

public class Atom{
	private AppearanceNano apperancenano=new AppearanceNano();
	private Transform3D location=new Transform3D();
	private TransformGroup atomsGroup=new TransformGroup();
	
	
	
	public TransformGroup drawAtoms(double[][] coords2) {
		// TODO Auto-generated method stub
		return (drawAtoms(coords2, apperancenano.matYELLOW, 0.1f));
    			
	}

	
	public TransformGroup drawAtoms(double[][] coords2,Appearance appAtom) {		
		return (drawAtoms(coords2, appAtom, 0.1f));
		
	}
	
	public TransformGroup drawAtoms(double[][] coords2,float radious) {
		return (drawAtoms(coords2, apperancenano.matRED, radious));
		
	}
	
	
	public TransformGroup drawAtoms(double[][] coords2,Appearance appAtom,float radious) {
		for(int i=0;i<coords2.length;i++ ){    		
	    	
	    	location.setTranslation(new Vector3f((float)coords2[i][0], (float)coords2[i][1], (float)coords2[i][2]));      	
	    	TransformGroup atomGroup=new TransformGroup(location); 
	    	Sphere atom=new Sphere(radious,appAtom);
	    	atomGroup.addChild(atom);
	    	atomsGroup.addChild(atomGroup);
	    	
	    	
    	}//End of for loop
		
		return atomsGroup;
	}
	
}
