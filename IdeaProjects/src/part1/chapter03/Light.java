package part1.chapter03;

/**
 * Created by Zed on 13.07.2016.
 */
class Light {

    public static void main(String[] args) {
        int lightspeed = 186000;
        long days = 1000;
        long seconds = days * 24 * 60 * 60;
        long distance = lightspeed * seconds;

        System.out.print("За " + days);
        System.out.print(" дней свет прйдет около ");
        System.out.println(distance + " миль");
    }
}


