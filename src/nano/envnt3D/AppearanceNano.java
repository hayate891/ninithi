package nano.envnt3D;

import java.awt.Color;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;

public  class AppearanceNano {
	private Material material;
	private  Appearance app;
	
	public  final Appearance matGRAY=setMatColor(255*1f,255*1f,255*1f);
	public final Appearance matRED=setMatColor(255*1f,0f,0f);
	public final Appearance matYELLOW=setMatColor(255*1f,255*1f,0f);
	public final Appearance matGREEN=setMatColor(0f,255*1f,0f);
	public  final Appearance matBLUE=setMatColor(0f,0f,255*1f);

	
	
	public AppearanceNano() {
		// TODO Auto-generated constructor stub
		
	}
	
	
	public  Appearance setMatColor(float r, float g, float b) {
		// TODO Auto-generated method stub
		material=new Material();
		app= new Appearance();
		 material.setAmbientColor(r/255,g/255,b/255);
		 app.setMaterial(material);
		 return app;
	}
	public  Appearance setMatColor(Color color) {
		// TODO Auto-generated method stub
		material=new Material();
		app= new Appearance();
		 material.setAmbientColor((float)color.getRed()/255,(float)color.getGreen()/255,(float)color.getBlue()/255);
		 app.setMaterial(material);
		 return app;
	}
	public Appearance setMatColor(float[] color) {
		// TODO Auto-generated method stub
		material=new Material();
		app= new Appearance();
		 material.setAmbientColor(color[0]/255,color[1]/255,color[2]/255);
		 app.setMaterial(material);
		 return app;
	}
	
	public AmbientLight setAmbientLight(){	
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1000.0);
		Color3f lightColor = new Color3f(.3f,.3f,0.3f);
	    AmbientLight ambientLight= new AmbientLight(lightColor);
	    ambientLight.setInfluencingBounds(bounds);
	    return ambientLight;
	}
	
	public AmbientLight setAmbientLight(Color3f lightColor){
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1000.0);
		AmbientLight ambientLight= new AmbientLight(lightColor);
	    ambientLight.setInfluencingBounds(bounds);
	    return ambientLight;
	}
	
	public AmbientLight setAmbientLight(Color3f lightColor,BoundingSphere bounds){			
		AmbientLight ambientLight= new AmbientLight(lightColor);
	    ambientLight.setInfluencingBounds(bounds);
	    return ambientLight;
	}
	
    public DirectionalLight setDirectionalLight(){
    	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1000.0);
    	Color3f lightColor = new Color3f(.3f,.3f,0.3f);
    	DirectionalLight directionalLight = new DirectionalLight();
        directionalLight.setColor(lightColor);
        directionalLight.setInfluencingBounds(bounds);
        return directionalLight;
    	
    }
    
    public DirectionalLight setDirectionalLight(Color3f lightColor){
    	BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 1000.0);
    	DirectionalLight directionalLight = new DirectionalLight();
        directionalLight.setColor(lightColor);
        directionalLight.setInfluencingBounds(bounds);
        return directionalLight;
    	
    }
    public DirectionalLight setDirectionalLight(Color3f lightColor,BoundingSphere bounds){
    	DirectionalLight directionalLight = new DirectionalLight();
        directionalLight.setColor(lightColor);
        directionalLight.setInfluencingBounds(bounds);
        return directionalLight;
    	
    }
    

}
