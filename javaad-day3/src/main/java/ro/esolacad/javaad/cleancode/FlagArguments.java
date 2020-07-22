package ro.esolacad.javaad.cleancode;

import ro.esolacad.javaad.csvlab.Citizen;

/**
 * @author calin nicoara
 *
 * 23-07-2020 modified process citizen
 */
public class FlagArguments {

    public static void processCitizen(Citizen citizen, boolean flag) {
        //TODO change with two methods

        if(flag) {
            citizen.setName("New name");
        } else {
            citizen.setName("False Name");
        }

        citizen.setForeigner(false);
    }

    public static void test(String... strings) {
        System.out.println(strings[0]);
        System.out.println(strings[1]);
        System.out.println(strings[2]);
    }
}
