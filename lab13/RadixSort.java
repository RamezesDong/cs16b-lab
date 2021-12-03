import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Class for doing Radix sort
 *
 * @author Akhil Batra, Alexander Hwang
 *
 */
public class RadixSort {
    /**
     * Does LSD radix sort on the passed in array with the following restrictions:
     * The array can only have ASCII Strings (sequence of 1 byte characters)
     * The sorting is stable and non-destructive
     * The Strings can be variable length (all Strings are not constrained to 1 length)
     *
     * @param asciis String[] that needs to be sorted
     *
     * @return String[] the sorted array
     */
    public static String[] sort(String[] asciis) {
        String[] sorted = new String[asciis.length];
        System.arraycopy(sorted, 0, asciis, 0, asciis.length);
        for (int d = asciis[0].length() - 1; d >= 0; d--) {
            sortHelperLSD(sorted, d);
        }
        return sorted;
    }

    /**
     * LSD helper method that performs a destructive counting sort the array of
     * Strings based off characters at a specific index.
     * @param asciis Input array of Strings
 * @param index The position to sort the Strings on.
     */
    private static void sortHelperLSD(String[] asciis, int index) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (String s : asciis) {
            hashMap.put(s.charAt(index), hashMap.get(s.charAt(index)) + 1);
        }
        String[] sorted = new String[asciis.length];
        int[] starts = new int[256];
        int pos = 0;
        for (int i = 0; i < starts.length; i += 1) {
            starts[i] = pos;
            pos += hashMap.get((char)i);
        }

        for (int i = 0; i < asciis.length; i += 1) {
            String item = asciis[i];
            int place = starts[(int)item.charAt(index)];
            sorted[place] = item;
            starts[(int)item.charAt(index)] += 1;
        }
        System.arraycopy(asciis, 0, sorted, 0, asciis.length);
    }

    /**
     * MSD radix sort helper function that recursively calls itself to achieve the sorted array.
     * Destructive method that changes the passed in array, asciis.
     *
     * @param asciis String[] to be sorted
     * @param start int for where to start sorting in this method (includes String at start)
     * @param end int for where to end sorting in this method (does not include String at end)
     * @param index the index of the character the method is currently sorting on
     *
     **/
    private static void sortHelperMSD(String[] asciis, int start, int end, int index) {
        // Optional MSD helper method for optional MSD radix sort
        return;
    }
}
