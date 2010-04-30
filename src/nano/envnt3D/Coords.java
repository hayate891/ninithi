package nano.envnt3D;

public class Coords {

    // Return max and min pints on X,Y and Z axis
    public double[] extremeAxisPoints(double[][] point) {

        double x = 0, nx = 0, y = 0, ny = 0, z = 0, nz = 0;
        double[] returnPoint = {0, 0, 0, 0, 0, 0};

        if (point.length > 0) {
            x = point[0][0];
            y = point[0][1];
            z = point[0][2];
            nx = point[0][0];
            ny = point[0][1];
            nz = point[0][2];

            for (int i = 0; i < point.length; i++) {
                if (point[i].length == 3) {
                    x = Math.max(point[i][0], x);
                    y = Math.max(point[i][1], y);
                    z = Math.max(point[i][2], z);
                    nx = Math.min(point[i][0], nx);
                    ny = Math.min(point[i][1], ny);
                    nz = Math.min(point[i][2], nz);

                }
                if (point[i].length == 6) {
                    x = Math.max(point[i][0], x);
                    y = Math.max(point[i][1], y);
                    z = Math.max(point[i][2], z);
                    nx = Math.min(point[i][0], nx);
                    ny = Math.min(point[i][1], ny);
                    nz = Math.min(point[i][2], nz);
                    x = Math.max(point[i][3], x);
                    y = Math.max(point[i][4], y);
                    z = Math.max(point[i][5], z);
                    nx = Math.min(point[i][3], nx);
                    ny = Math.min(point[i][4], ny);
                    nz = Math.min(point[i][5], nz);

                }

            }

            returnPoint = new double[6];
            returnPoint[0] = x;
            returnPoint[1] = y;
            returnPoint[2] = z;
            returnPoint[3] = nx;
            returnPoint[4] = ny;
            returnPoint[5] = nz;

        }


        return returnPoint;

    }

    public double[] findCenter(double[][] point) {
        double[] points = extremeAxisPoints(point);
        double[] center = {(points[0] + points[3]) / 2, (points[1] + points[4]) / 2, (points[2] + points[5]) / 2};
        return center;
    }

    public double[] findCenter(double[] points) {
        double[] center = {(points[0] + points[3]) / 2, (points[1] + points[4]) / 2, (points[2] + points[5]) / 2};

        return center;
    }

    public double[][] adjustCoordsToCenter(double[][] coords) {
        double[] center = findCenter(coords);
        return (adjustCoordsToCenter(center, coords));

    }

    public double[][] adjustCoordsToCenter(double[] center, double[][] coords) {

        for (int i = 0; i < coords.length; i++) {
            if (coords[i].length == 3) {
                coords[i][0] -= center[0];
                coords[i][1] -= center[1];
                coords[i][2] -= center[2];
            }
            if (coords[i].length == 6) {
                coords[i][0] -= center[0];
                coords[i][1] -= center[1];
                coords[i][2] -= center[2];
                coords[i][3] -= center[0];
                coords[i][4] -= center[1];
                coords[i][5] -= center[2];
            }

        }
        return coords;
    }

    public double[][] NormalizeCoords(double[][] coords) {

        double max = 0;
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < coords[i].length; j++) {
                if (Math.abs(coords[i][j]) > max) {
                    max = Math.abs(coords[i][j]);
                }
            }
        }
        if (max != 0) {
            for (int i = 0; i < coords.length; i++) {
                for (int j = 0; j < coords[i].length; j++) {
                    coords[i][j] = coords[i][j] / max * 10;
                }
            }
        }

        return coords;

    }

    public void printCoordsArray(double[][] coords) {
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < coords[i].length; j++) {
                System.out.print(coords[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    public void printCoordsArray(double[] coords) {

        for (int j = 0; j < coords.length; j++) {
            System.out.print(coords[j] + " ");
        }
        System.out.print("\n");

    }
    
}
