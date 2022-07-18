package challenge;

// Converting String into int, long, float, or double:
// Write a program that converts the given String object (representing a number) into int, long, float, or double
public class Main {

    private static final String TO_INT = "453";
    private static final String TO_LONG = "45234223233";
    private static final String TO_FLOAT = "45.823F";
    private static final String TO_DOUBLE = "13.83423D";

    private static final String TO_INT_NEGATIVE = "-453";
    private static final String TO_LONG_NEGATIVE = "-45234223233";
    private static final String TO_FLOAT_NEGATIVE = "-45.823F";
    private static final String TO_DOUBLE_NEGATIVE = "-13.83423D";

    public static void main(String[] args) {
        Integer to_int1 = Integer.valueOf(TO_INT);
        int to_int2 = Integer.parseInt(TO_INT);
        int to_int3 = Integer.parseInt(TO_INT_NEGATIVE);
        System.out.println(to_int1);
        System.out.println(to_int2);
        System.out.println(to_int3);

        Long to_long1 = Long.valueOf(TO_LONG);
        long to_long2 = Long.parseLong(TO_LONG);
        long to_long3 = Long.parseLong(TO_LONG_NEGATIVE);
        System.out.println(to_long1);
        System.out.println(to_long2);
        System.out.println(to_long3);

        float to_float1 = Float.parseFloat(TO_FLOAT);
        Float to_float2 = Float.valueOf(TO_FLOAT);
        float to_float3 = Float.parseFloat(TO_FLOAT_NEGATIVE);
        System.out.println(to_float1);
        System.out.println(to_float2);
        System.out.println(to_float3);

        Double to_double1 = Double.valueOf(TO_DOUBLE);
        double to_double2 = Double.parseDouble(TO_DOUBLE);
        double to_double3 = Double.parseDouble(TO_DOUBLE_NEGATIVE);
        System.out.println(to_double1);
        System.out.println(to_double2);
        System.out.println(to_double3);

    }
}
