public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	public static double staticG = 6.67e-11;

	public Planet(double xP,double yP,double xV,double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		this.xxPos = p.xxPos;
		this.yyPos = p.yyPos;
		this.xxVel = p.xxVel;
		this.yyVel = p.yyVel;
		this.mass = p.mass;
		this.imgFileName = p.imgFileName;
	}
	public double calcDistance(Planet PlanetA){
		double dx,dy;
		if(this.xxPos > PlanetA.xxPos){
			dx = this.xxPos - PlanetA.xxPos;
		}
		else{
			dx = PlanetA.xxPos - this.xxPos;
		}
		if(this.yyPos > PlanetA.yyPos){
			dy = this.yyPos - PlanetA.yyPos;
		}
		else{
			dy = PlanetA.yyPos - this.yyPos;
		}
		return Math.sqrt(dx*dx+dy*dy);
	}
	public double calcForceExertedBy(Planet planetA){
		double distance = this.calcDistance(planetA);
		double force = staticG * this.mass * planetA.mass / (distance * distance);
		return force;
	}
	public double calcForceExertedByX(Planet planetA){
		double dx = planetA.xxPos - this.xxPos;
		double distance = this.calcDistance(planetA);
		double force = this.calcForceExertedBy(planetA);
		double fx = force*dx/distance;
		return fx;
	}
	public double calcForceExertedByY(Planet planetA){
		double dy = planetA.yyPos - this.yyPos;
		double distance = this.calcDistance(planetA);
		double force = this.calcForceExertedBy(planetA);
		double fy = force*dy/distance;
		return fy;
	}
	public double calcNetForceExertedByX(Planet[] planets){
		double netforcex = 0;
		for(Planet planet : planets){
			if(this.equals(planet)){
				continue;
			}
			netforcex += this.calcForceExertedByX(planet);
		}
		return netforcex;
	}
	public double calcNetForceExertedByY(Planet[] planets){
		double netforcey = 0;
		for(Planet planet : planets){
			if(this.equals(planet)){
				continue;
			}
			netforcey += this.calcForceExertedByY(planet);
		}
		return netforcey;
	}
	public void update(double dt, double fX, double fY){
		double ax = fX / this.mass;
		double ay = fY / this.mass;
		this.xxVel = this.xxVel + dt * ax;
		this.yyVel = this.yyVel + dt * ay;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}
}