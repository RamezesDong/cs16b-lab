import java.security.PublicKey;

public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private static double Gravity_num=6.67e-11;
    public Planet(double xP,double yP, double xV, double yV, double m,String img){
        this.xxPos=xP;
        this.yyPos=yP;
        this.xxVel=xV;
        this.yyVel=yV;
        this.mass=m;
        this.imgFileName=img;
    }
    public Planet(Planet p){
        this.imgFileName=p.imgFileName;
        this.mass=p.mass;
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
    }
    public double calcDistance(Planet p){
        double dis;
        dis =Math.sqrt((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)+(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos));
        return dis;
    }
    public double calcForceExertedBy(Planet p){
        double dis=this.calcDistance(p);
        double force;
        force=(Gravity_num*this.mass*p.mass)/(dis*dis);
        return force;
    }
    public double calcForceExertedByX(Planet p){
        double forcex;
        double xdis=p.xxPos-this.xxPos;
        forcex=(this.calcForceExertedBy(p)*xdis)/this.calcDistance(p);
        return forcex;
    }
    public double calcForceExertedByY(Planet p){
        double forcey;
        double ydis=p.yyPos-this.yyPos;
        forcey=(this.calcForceExertedBy(p)*ydis)/this.calcDistance(p);
        return forcey;
    }
    public double calcNetForceExertedByX(Planet[] p){
        double xnetforce=0;
        int n=p.length;
        int i;
        for (i=0;i<n;i++)
        {
            if(!this.equals(p[i])){
                xnetforce += this.calcForceExertedByX(p[i]);
            }
        }
        return xnetforce;
    }
    public double calcNetForceExertedByY(Planet[] p){
        double ynetforce=0;
        int n=p.length;
        int i;
        for (i=0;i<n;i++)
        {
            if(!this.equals(p[i])){
                ynetforce += this.calcForceExertedByY(p[i]);
            }
        }
        return ynetforce;
    }
    public void update(double dt, double fx, double fy){
        double ax=fx/this.mass;
        double ay=fy/this.mass;
//        this.xxPos = this.xxPos + this.xxVel*dt+(0.5)*ax*dt*dt;
//        this.yyPos = this.yyPos + this.yyVel*dt+(0.5)*ay*dt*dt;
        this.xxVel =this.xxVel+dt*ax;
        this.yyVel =this.yyVel+dt*ay;
        this.xxPos=this.xxPos+this.xxVel*dt;
        this.yyPos=this.yyPos+this.yyVel*dt;
    }
    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }
}
