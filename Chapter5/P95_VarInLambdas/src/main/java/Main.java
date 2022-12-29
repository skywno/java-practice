public class Main {

    public static void main(String[] args) {
        // cannot infer type: lambda expression requires an explicit target type
//        var square = (var x) -> x * x;
        Square square = (var x) -> x * x;

        System.out.println(square.calculate(5));


    }
}
