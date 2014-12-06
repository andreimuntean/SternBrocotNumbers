import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Returns the nth value from the Stern-Brocot sequence.
 *
 * @author Andrei Muntean
 */
public class SternBrocotNumbers
{
    // The list of known values from the Stern-Brocot sequence.
    private static ArrayList<Double> sequence;

    private static boolean isPositiveNumber(String input)
    {
        try
        {
            int number = Integer.parseInt(input);

            if (number >= 0)
            {
                return true;
            }
            else
            {
                throw new Exception();
            }
        }
        catch (Exception exception)
        {
            return false;
        }
    }

    // Calculates the nth number from the Stern-Brocot sequence,
    // stores it in a list and returns the value.
    private static double sternBrocot(int nthSternBrocotNumber)
    {
        while (sequence.size() <= nthSternBrocotNumber)
        {
            // The current size of the sequence.
            int size = sequence.size();

            sequence.add(sequence.get(size / 2 - 1) + sequence.get(size / 2));
            sequence.add(sequence.get(size / 2));
        }

        return sequence.get(nthSternBrocotNumber);
    }

    /**
     * The main method. Reads values from the standard input via the Scanner.
     */
    public static void main(String[] args)
    {
        // Initializes the sequence.
        sequence = new ArrayList<>(Arrays.asList(1.0, 1.0));

        // Initializes the scanner and waits for input.
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        while (isPositiveNumber(input))
        {
            int nthSternBrocotNumber = Integer.parseInt(input);

            // Shows the nth value from the Stern-Brocot sequence.
            System.out.println(sternBrocot(nthSternBrocotNumber));

            // Waits for input.
            input = scanner.next();
        }
    }
}