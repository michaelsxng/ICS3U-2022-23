package assignment;

import java.util.Scanner;

public class BayviewGlenPools {
    
    public static void main(String[] args) {

        /*Asking the user information */
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter the length of the pool: ");
        int length = in.nextInt(); 

        System.out.print("Please enter the width of the pool: ");
        int width = in.nextInt();

        System.out.print("Please enter the depth of the shallow end of the pool: ");
        int shallowHeight = in.nextInt();
        
        System.out.print("Please enter the depth of the deep end of the pool: ");
        int deepHeight = in.nextInt();

        System.out.print("Please enter the length of the transition between the shallow end and the deep end of the pool: ");
        int transitionSlope = in.nextInt();

        System.out.print("Please enter the length of the shallow end of the pool: ");
        int shallowLength = in.nextInt();

        System.out.print("Please enter the price per meter squared of the liner that they can get for the pool: ");
        int linerCost = in.nextInt();


        //volume of pool
        double transitionHeight = (double) deepHeight-shallowHeight;
        double transitionLength = Math.sqrt(Math.pow(transitionSlope,2) - Math.pow(transitionHeight, 2));
        double deepLength = (double)length - transitionLength - shallowLength;

        double volume = (deepLength*deepHeight*width) + (shallowLength*shallowHeight*width) + (transitionLength*shallowHeight*width)
        + (0.5*transitionHeight*transitionLength*width);
        /*
         * calculates the volume of the pool by getting the volume of the deep end, 
         * the shallow end, the square area above the transition, and the transition.
         */

        double ninetyFull = volume*0.9;
        double ninetyFullRounded = Math.round(ninetyFull*100)/100.0;
        //rounds the volume to two decimal points

        System.out.println("The amount of water you need to keep the pool at 90% is: " + ninetyFullRounded + "m^3");

        //Surface area  
        double SurfaceArea = ((deepHeight*width) + (2*(deepLength*deepHeight)) + (deepLength*width)) 
        + ((shallowHeight*width) + (2*(shallowLength*shallowHeight)) + (shallowLength*width)) + 
        ((transitionSlope*width) + (2*(transitionHeight*transitionLength)/2) + (2*(transitionLength*shallowHeight))); 

        /*
         * calculates the surface area by getting the surface area of the deep end, transition, and shallow end.
         */


        double SurfaceAreaRounded = Math.round(SurfaceArea*100)/100.0;
        //rounds the surface area to two decimal points

        System.out.println("the amount of lining needed is: " + SurfaceAreaRounded + "m^2");

        //Cost of liner
        double cost = SurfaceAreaRounded*linerCost;
        //calculates the price of liner by getting the surface area rounded multiplied by the price of liner per m^2
        
        System.out.println("the price of lining is: " + cost + "$");

        in.close();
    };
}