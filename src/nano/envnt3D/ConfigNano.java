package nano.envnt3D;

import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.View;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3d;

import com.sun.j3d.utils.universe.SimpleUniverse;

public class ConfigNano {
	
	TransformGroup tg;
	SimpleUniverse simpleU;

    public ConfigNano() {
        simpleU=Interface3D.getSimpleUniverse();
    }



    @SuppressWarnings("empty-statement")
	public void setView(Point3d eye,Point3d center,Vector3d up) {
		// TODO Auto-generated method stub
	
    	tg = simpleU.getViewingPlatform().getMultiTransformGroup().getTransformGroup(0);
    	View view = simpleU.getViewer().getView();
    	
    	view.setFieldOfView(Math.PI/3.0);
    	Transform3D tx = new Transform3D();
    	tx.lookAt(eye, center, up);
    	tx.invert();
    	tg.setTransform(tx);
    	
		
	}
	public void setView(double[] range) {
		// TODO Auto-generated method stub
		
    	tg = simpleU.getViewingPlatform().getMultiTransformGroup().getTransformGroup(0);
    	Transform3D tx = new Transform3D();
    	tx.frustum(range[1],range[0], range[3], range[2], range[4], range[5]);
    	//tx.invert();
    	//tg.setTransform(tx);
    	View view = simpleU.getViewer().getView();
    	view.setFieldOfView(Math.PI/2.0);
		
	}
	

}
