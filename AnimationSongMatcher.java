import java.util.ArrayList;
import java.util.List;

public class AnimationSongMatcher {

    public static void main(String[] args) {
        String[] songs = {"Hello:150", "Hi:100"};
        String[] animations = {"Anime1:30", "Anime2:50"};

        String[] result = findMatchingPairs(songs, animations);

        System.out.println("Output array of animationName:songName:");
        for (String pair : result) {
            System.out.println(pair);
        }
    }

    public static String[] findMatchingPairs(String[] songs, String[] animations) {
        List<String> pairs = new ArrayList<>();

        for (String animation : animations) {
            String[] animParts = animation.split(":");
            String animationName = animParts[0];
            int animationLength = Integer.parseInt(animParts[1]);

            for (String song : songs) {
                String[] songParts = song.split(":");
                String songName = songParts[0];
                int songLength = Integer.parseInt(songParts[1]);

                if (songLength % animationLength == 0) {
                    pairs.add(animationName + ":" + songName);
                    break; // Once a match is found, no need to check further songs
                }
            }
        }

        // Convert list to array
        String[] result = new String[pairs.size()];
        result = pairs.toArray(result);
        return result;
    }
}