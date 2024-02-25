public class Driver{

  public static int averageBurn(int width, int height, int repeat, double density){
    int avg = 0;
    for (int i = 0; i < repeat; i +=1){
      BurnTrees b = new BurnTrees(width, height, density);
      avg += b.run();
    }
    return avg/repeat;
  }

  public static void main(String[]args){
    int WIDTH = 300;
    int HEIGHT = 300;
    int REPEAT = 50;
    if(args.length > 2){
      WIDTH = Integer.parseInt(args[0]);
      HEIGHT = Integer.parseInt(args[1]);
      REPEAT = Integer.parseInt(args[2]);
    }
    double DENSITY = 0.0;

    //repeat this test with different densities, REPEAT times.

    double increment = 0.1;
    double tempA = DENSITY + increment;
    int burnOne = averageBurn(WIDTH, HEIGHT, REPEAT, DENSITY);
    int burnTwo = averageBurn(WIDTH, HEIGHT, REPEAT, DENSITY + increment);

    double denSolve = 0;
    int largestBurn = 0;

    System.out.println("| Width: "+WIDTH + " Height: "+HEIGHT + " Repeat: " + REPEAT);
    System.out.print("| burnTime: "+burnTwo + " Density: ");
    System.out.printf("%5.2f%n", tempA);
    while (burnOne < burnTwo){
      DENSITY = DENSITY + increment;
      tempA = DENSITY + increment;
      burnOne = averageBurn(WIDTH, HEIGHT, REPEAT, DENSITY);
      burnTwo = averageBurn(WIDTH, HEIGHT, REPEAT, tempA);

        System.out.print("| burnTime: "+burnTwo + " Density: ");
        System.out.printf("%5.2f%n", tempA);
}
  largestBurn = burnOne;
  denSolve = DENSITY;

    DENSITY = DENSITY + increment;
    increment = 0.01;
    double temp = DENSITY - increment;

    burnOne = averageBurn(WIDTH, HEIGHT, REPEAT, temp);
    System.out.print("| burnTime: "+burnOne + " Density: ");
    System.out.printf("%5.2f%n", temp);


    while (burnOne > burnTwo){
      DENSITY = DENSITY - increment;
      temp = DENSITY - increment;
      burnOne = averageBurn(WIDTH, HEIGHT, REPEAT, temp);
      burnTwo = averageBurn(WIDTH, HEIGHT, REPEAT, DENSITY);

        System.out.print("| burnTime: "+burnOne + " Density: ");
        System.out.printf("%5.2f%n", temp);

        if (burnOne > largestBurn){
          largestBurn = burnOne;
          denSolve = temp;
        }

    }
    System.out.print("DENSITY: ");
    System.out.printf("%5.2f%n", denSolve);

    //print all of the burnTime results (average the repeated tests into one result please)
    //Print in a table that includes the other important information for the experiment.
    //print out the DENSITY with the largest burnTime

  }
}
