public class BirthdayProblem {
    public static void main(String[] args) {
        // Percentage to match
        double percentage = 0.69;

        // Printing the number of people requqired and calling the matching birthday method
        System.out.println("Number of people needed: " + matchBirthDay(percentage));
    }

    /*
     * This method will take the percentage to match and return the number of people
     * needed in a group in which 2 people will have matching birthday percentage > than given percentage
     */
    public static int matchBirthDay(double percentage) {
        // Calculating the number of people
        int people = (int)Math.ceil(Math.sqrt(
            365 * 2 * Math.log(1 / (1 - percentage))
        ));

        // Return the number of people
        return people;
    }
}