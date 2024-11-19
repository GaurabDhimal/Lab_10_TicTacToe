import java.util.Scanner;

public class SafeInput
{


    /**
     * gets a string from the user using the console and
     * it must be at least one character in length
     *
     * @param pipe a Scanner used to get th input
     * @param prompt the Prompt that tells the user what to enter
     * @return a String of at least one character in length
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retVal = "";

        do
        {
            System.out.print(prompt + ": ");
            retVal = pipe.nextLine();

            if(retVal.isEmpty())
                System.out.println("You must enter at least one character!");

        }while(retVal.isEmpty());

        return retVal;
    }

    /**
     * gets an int value from the user at the console with no constraint
     * @param pipe a Scanner used to get the input
     * @param prompt the Prompt that tells the user what to enter
     * @return an int of any value
     */
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid int, not " + trash);
            }

        }while(!done);

        return retVal;
    }


    /**
     * gets an double value from the user at the console with no constraint
     * @param pipe a Scanner used to get the input
     * @param prompt the Prompt that tells the user what to enter
     * @return a double of any value
     */
    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + ": ");
            if(pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double, not " + trash);
            }

        }while(!done);

        return retVal;
    }


    /**
     * Get an integer from the user via the console within a specified range
     * @param pipe the scanner to use for input
     * @param prompt the prompt to tell the user what is required
     * @param low the inclusive low bound
     * @param high the inclusive high bound
     * @return an int within the specified bounds
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if(pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();

                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value within the range [" + low + " - " + high + "]: ");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid int, not " + trash);
            }

        }while(!done);

        return retVal;
    }


    /**
     * Get a double from the user via the console within a specified range
     * @param pipe the scanner to use for input
     * @param prompt the prompt to tell the user what is required
     * @param low the inclusive low bound
     * @param high the inclusive high bound
     * @return a double within the specified bounds
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: ");
            if(pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                pipe.nextLine();

                if(retVal >= low && retVal <= high)
                {
                    done = true;
                }
                else
                {
                    System.out.println("You must enter a value within the range [" + low + " - " + high + "]: ");
                }
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a valid double, not " + trash);
            }

        }while(!done);

        return retVal;
    }


    /**
     * Gets a Y or N from the user (Yes or No) and returns the equivalent, true or false
     * @param pipe Scanner to user for input
     * @param prompt Tells the user what to enter
     * @return true or false based on Y or N
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String YNResponse = "";
        boolean retVal = false;
        boolean done = false;

        do
        {
            System.out.print(prompt + ": ");
            YNResponse = pipe.nextLine();

            if(!YNResponse.matches("[YyNn]"))
            {
                System.out.println("You must enter [Y/N]: ");

            }
            else
            {
                done= true;
                switch (YNResponse)
                {
                    case "Y":
                    case "y":
                        retVal = true;
                        break;
                    case "N":
                    case "n":
                        retVal = false;
                        break;
                }
            }
        }while(!done);

        return retVal;
    }

    /**
     * Gets a SSN from the user, making sure it is withing the character limits
     * @param pipe Scanner for input
     * @param prompt Prompts the user
     * @param regEx Makes sure the user inputs matches the regular expression
     * @return true or false depending on y or n input
     */

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String retVal = "";
        boolean done = false;

        do
        {
            System.out.print(prompt + "" + regEx);
            retVal = pipe.nextLine();

            if(retVal.matches(regEx))
            {
                done = true;
            }
            else
            {
                System.out.println("You must enter a matching expression " + regEx + " not " + retVal);
            }

        }while(!done);

        return  retVal;
    }




    public static void prettyHeader(String msg)
    {
        int headerWidth = 60;
        int sideBorderWidth = 3;

        for (int i = 0; i < headerWidth; i++) // Print the top border
        {
            System.out.print("*");
        }
        System.out.println();

        int messageLength = msg.length(); // Calculate spaces needed to center the message
        int padding = (headerWidth - messageLength - (sideBorderWidth * 2)) / 2;

        // Print the middle row with centered message
        System.out.print("***"); // Left side border
        for (int i = 0; i < padding; i++)
        {
            System.out.print(" ");
        }
        System.out.print(msg);
        for (int i = 0; i < padding; i++)
        {
            System.out.print(" ");
        }
        System.out.println("***"); // Right side border

        for (int i = 0; i < headerWidth; i++) // Print the bottom border
        {
            System.out.print("*");
        }
        System.out.println();
    }

    public static void main(String[] args)
    {
        prettyHeader("Message Centered Here");
    }
}
