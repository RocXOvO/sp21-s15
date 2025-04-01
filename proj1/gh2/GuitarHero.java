package gh2;

import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

public class GuitarHero {
    public static void main(String[] args) {
        String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
        GuitarString[] strings = new GuitarString[37];

        for (int i = 0; i < strings.length; i++) {
            double frequency = 440.0 * Math.pow(2, (i - 24)/12.0);
            strings[i] = new GuitarString(frequency);
        }

        while (true){
            if (StdDraw.hasNextKeyTyped()) {
                char UserKey = StdDraw.nextKeyTyped();
                int index = keyboard.indexOf(UserKey);
                if (index != -1) {
                    strings[index].pluck();
                }
            }

            double sample = 0;
            for (GuitarString string : strings) {
                sample += string.sample();
            }
            StdAudio.play(sample);

            for (GuitarString string : strings) {
                string.tic();
            }
        }
    }
}
