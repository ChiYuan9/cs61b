public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

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

}