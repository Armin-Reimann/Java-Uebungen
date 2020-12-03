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
        System.out.println(findSingle1xFor(eingabe));
    }

    private static long findSingle1xFor(long[] arr) {
        long result = arr[0];
        for(int i = 1 ; i < arr.length ; i++ ) {
            result = result ^ arr[i];
        }
        return result;
    }
}
