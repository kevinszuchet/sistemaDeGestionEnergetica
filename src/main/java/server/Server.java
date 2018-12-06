package server;

import spark.Spark;
import spark.debug.DebugScreen;
import server.login.DatosDePrueba;

public class Server {
	public static void main(String[] args) {
		
		System.out.print("Hello");
		Spark.port(getHerokuAssignedPort());
		DebugScreen.enableDebugScreen();
		new Router().configure();
	}
	
	private static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
