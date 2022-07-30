public class NBody{
	public static double readRadius(String txtname){
		In in = new In(txtname);
		int planetNum = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String txtname){
		In in = new In(txtname);
		int planetNum = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[planetNum];
		for(int i = 0; i < planetNum; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,imgFileName);
		}
		return planets;
	}
}