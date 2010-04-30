package nano.envnt3D;

import com.sun.j3d.exp.swing.JCanvas3D;
import java.awt.GraphicsConfiguration;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.universe.*;
import java.awt.Color;
import java.util.LinkedList;
import javax.media.j3d.*;
import javax.vecmath.*;
import nano.envnt3D.tools.NanoGUI;

public class Interface3D {

    private double[] axisPoints;
    private static Background background;
    private static BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0), 3000.0);
    double[] center, points;
    private static SimpleUniverse simpleU;
    static int x=0,y=0;
    TransformGroup tg;
    //private TransformGroup[] atomGroup;
    //private Sphere[] atom;
    Vector3d vect3d = new Vector3d();
    int guiwidth, guiheight;
    static ConfigNano confignano = new ConfigNano();
    static AppearanceNano apperancenano = new AppearanceNano();
    static Canvas3D canvas3D, offScreenCanvas3D;
    double[][] coords_bond;
    double[][] coords_atom;
    Transform3D rotate = new Transform3D();
    Transform3D rotate2 = new Transform3D();
    Transform3D translate = new Transform3D();
    static BranchGroup BG;
    static BranchGroup scene;
    static OrbitBehavior orbit;
    private static LinkedList<BranchGroup> ll = new LinkedList();

    private static BranchGroup createSceneGraph(Canvas3D canvas) {
        // Create the root of the branch graph

        BG = new BranchGroup();
        BG.addChild(apperancenano.setAmbientLight());
        BG.addChild(apperancenano.setDirectionalLight());

        background = new Background();
        background.setColor(0, 0, 0);
        background.setCapability(Background.ALLOW_COLOR_WRITE);
        background.setApplicationBounds(bounds);
        BG.addChild(background);


        BG.compile();

        return BG;
    } // end of CreateSceneGraph method

    // Create a simple scene and attach it to the virtual universe
    public Interface3D() {
    } // end of HelloJava3Db (constructor)

    public static Canvas3D getPanel() {

        return canvas3D;
    }

    public static void setSizeofCanvas(){
        int[] i=NanoGUI.getPanelMsize();
        canvas3D.setSize(i[0], i[1]);
    }

    public static void setSizeofCanvas(int w,int h){
        canvas3D.setSize(w, h);
    }

    public static void setDefaultSizeofCanvas(int w,int h){
        x=w;
        y=h;
        
    }
    public static Canvas3D createPanel() {

        //setLayout(new BorderLayout());
        
        GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();
        canvas3D = new Canvas3D(config);
        canvas3D.setDoubleBufferEnable(true);
        canvas3D.setFocusable(true);

        scene = createSceneGraph(canvas3D);

        // SimpleUniverse is a Convenience Utility class
        simpleU = new SimpleUniverse(canvas3D);
        //simpleU.getViewer().getView().setProjectionPolicy(View.SCALE_EXPLICIT);
        orbit = new OrbitBehavior(canvas3D, OrbitBehavior.REVERSE_ALL | OrbitBehavior.STOP_ZOOM);
        orbit.setSchedulingBounds(bounds);
        // This will move the ViewPlatform back a bit so the
        // objects in the scene can be viewed.

        Transform3D vt = new Transform3D();
        Vector3f transV = new Vector3f(0f, 0f, 15.0f);
        vt.setTranslation(transV);

        // simpleU.getViewingPlatform().setNominalViewingTransform();
        simpleU.getViewingPlatform().getViewPlatformTransform().setTransform(vt);
        simpleU.getViewingPlatform().setViewPlatformBehavior(orbit);
        //simpleU.getViewer().clearViewerMap();


        simpleU.addBranchGraph(scene);






        //confignano.setUniverse(simpleU);
        //confignano.setView(new Point3d(center[0], center[1], 11.7),new Point3d(center[0], center[1], center[2]),new Vector3d(0, 1, 0));
        //confignano.setView(coords.findPoints(coords_atom));
        canvas3D.setSize(x,y);
        
        return canvas3D;
        

    }

    public static SimpleUniverse getSimpleUniverse() {
        return simpleU;
    }

    public static void addBG(BranchGroup branchgroup) {
        ll.add(branchgroup);

    }

    public static void createBG(TransformGroup[] TG) {
        BranchGroup branchgroup = new BranchGroup();
        branchgroup.setCapability(BranchGroup.ALLOW_DETACH);

        if (TG.length != 0) {
            for (int i = 0; i < TG.length; i++) {
                branchgroup.addChild(TG[i]);
            }

        }

        ll.add(branchgroup);

    }

    public static void removeLastBG() {
        if (ll.size() != 0) {
            simpleU.getLocale().removeBranchGraph(ll.get(ll.size() - 1));
            ll.removeLast();

        }

    }

    public static void displayLastBG() {
        if (ll.size() - 1 == 0) {
            simpleU.addBranchGraph(ll.getLast());
        } else {
            simpleU.getLocale().removeBranchGraph(ll.get(ll.size() - 2));
            simpleU.addBranchGraph(ll.get(ll.size() - 1));
        }

        if(NanoGUI.getIsCanvas()==false)
        NanoGUI.setJPanelM(canvas3D);

    }

    public static ConfigNano getConfigNano() {
        return confignano;
    }

    public static void setBackGround(Color C) {
        background.setColor((float) C.getRed() / 255, (float) C.getGreen() / 255, (float) C.getBlue() / 255);
    }

    public static Canvas3D getcanvas3D() {
        return canvas3D;
    }

    public static Canvas3D getOffScreenCanvas3D() {
        return offScreenCanvas3D;
    }

    public static LinkedList getLinkedList() {
        return ll;
    }
    public double[] getAxixPoints(){
        return axisPoints;
    }

    public void setAxisPoints(double[] points){
        axisPoints=points;
    }
} 

