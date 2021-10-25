public class NBody {


    public static double readRadius(String filename){
        In in=new In(filename);
        int num_planet=in.readInt();
        double radiuss=in.readDouble();
        return radiuss;

    }
    public static Planet[] readPlanets(String planetsTxtPath) {
        In in = new In(planetsTxtPath);
        int num_planets= in.readInt();
        Planet[] p= new Planet[num_planets];
        double readiuss= in.readDouble();
        int i;
        for(i=0;i<num_planets;i++){
            double xp=in.readDouble();
            double yp=in.readDouble();
            double xv=in.readDouble();
            double yv=in.readDouble();
            double m=in.readDouble();
            String gif=in.readString();
            p[i]= new Planet(xp,yp,xv,yv,m,gif);
        }
        return p;
    }

    public static void main(String[] args) {
        double T=Double.parseDouble(args[0]);
        double dt=Double.parseDouble(args[1]);
        String filename=args[2];
        double radius=readRadius(filename);
        Planet[] planets=readPlanets(filename);
        StdDraw.setScale((-1)*radius, radius);
        StdDraw.picture(0,0,"images/starfield.jpg",2*radius,2*radius);
        int num_p = planets.length;
        int i;
        for(i=0;i<num_p;i++)
            planets[i].draw();
        StdDraw.enableDoubleBuffering();
        double tnow=0;
        double[] forcex=new double[num_p];
        double[] forcey=new double[num_p];
        while (tnow<T){
            for(i=0;i<num_p;i++){
                forcex[i]=planets[i].calcNetForceExertedByX(planets);
                forcey[i]=planets[i].calcNetForceExertedByY(planets);
            }
            for (i=0;i<num_p;i++){
                planets[i].update(dt,forcex[i],forcey[i]);
            }
            StdDraw.picture(0,0,"images/starfield.jpg",2*radius,2*radius);
            for(i=0;i<num_p;i++)
                planets[i].draw();
            StdDraw.show();
            StdDraw.pause(1);
            tnow +=dt;
        }
        StdOut.printf("%d\n", planets.length);
        StdOut.printf("%.2e\n", radius);
        for ( i = 0; i < planets.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                    planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
        }
    }
}
