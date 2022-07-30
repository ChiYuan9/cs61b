public class TestPlanet{
	public static double staticG = 6.67e-11;
	public static void main(String arg[]){
	Planet planetA = new Planet(0,0,1,1,1e10,"jupiter.gif");
	Planet planetB = new Planet(10,10,2,2,1e10,"jupiter.gif");
	double TrueForce = planetA.mass*planetB.mass*staticG/(((planetA.xxPos-planetB.xxPos)*(planetA.xxPos-planetB.xxPos))+((planetA.yyPos-planetB.yyPos)*(planetA.yyPos-planetB.yyPos)));
	double TestForce = planetA.calcForceExertedBy(planetB);
	if(Math.abs(TrueForce - TestForce) < 0.01*Math.max(TrueForce,TestForce)){
		System.out.println("pass: " + TrueForce + " = " + TestForce);
	}
	else{
		System.out.println("Wrong: "+ TrueForce + " != " + TestForce);
	}
	}
}