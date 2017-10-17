public class StringArray {

    public static void sortStringArray(String[] array){
        for (int i = 0; i < array.length; i++){
            for (int j = i + 1; j < array.length; j++){
                if(array[j].compareTo(array[i]) < 0){
                    String temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void showStringArray(String[] array){
        for(String i : array) System.out.print(i+" ");
    }
}
