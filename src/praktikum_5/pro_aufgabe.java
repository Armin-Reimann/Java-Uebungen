package praktikum_5;

public class pro_aufgabe {
    public static void main(String[] args){

        long [] eingabe = {
                8432789273489L,
                2138934798732L,
                8432789273489L,
                8432789273489L,
                2138934798732L,
                7832480324983L,
                8432789273489L,
                1243427807722L,
                3789024723489L,
                7832480324983L,
                3789024723489L,
                7432873047312L,
                7432873047312L,
                7832480324983L,
                7832480324983L};
        long result = findSingle1xFor(eingabe);
        System.out.println(result);

    }
    //Methode mit 2x For-Schleife
    private static long findSingle2xFor(long[] arr) {
        boolean check = true;

        for(int i = 0; i < arr.length ; i++ ) {
            //System.out.println(eingabe[i]);
            for(int j = 0 ; j < arr.length ; j++ ) {
                if(arr[i] == arr[j] && i != j)
                    check = false;
            }
            if(check)
                System.out.println(arr[i]);
            check = true;
        }
        return 0;
    }


    //Methode mit 1x For-Schleife
    private static long findSingle1xFor(long[] arr) {

        // "^" = XOR
        long result = arr[0];
        //System.out.println("=: " + result);
        for(int i = 1 ; i < arr.length ; i++ ) {
            result = result ^ arr[i];
            //System.out.println(i + ": " + result + "   ----" + arr[i]);
        }
        System.out.println(result);
        return result;
    }
}
