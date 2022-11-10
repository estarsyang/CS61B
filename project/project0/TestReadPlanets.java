/**
 *  Tests Nbody.readPlanets. Reads in ./data/planets.txt and checks output of
 *  readPlanets().
 */
public class TestReadPlanets {


    private static Planet[] checkReadPlanets(){
        System.out.println("Checking readRadius...");
        String planetsTxtPath = "./data/planets.txt";
        /**
         *  apply Nbody.readRadius
         */
        Planet[] actualOutput = NBody.readPlanets(planetsTxtPath);
        return actualOutput;
    }
    private static void displayPlanets(Planet[] planets) {
        for (Planet planet : planets) {
            System.out.println("the planet's data is "  + planet.xxPos 
            + ", " + planet.yyPos + ", " + planet.xxVel
            + ", " + planet.yyVel + ", " + planet.mass
            + ", " + planet.imgFileName);
        }
    }

    public static void main(String[] args) {
        Planet[] planets = checkReadPlanets();
        displayPlanets(planets);
    }
    
}
