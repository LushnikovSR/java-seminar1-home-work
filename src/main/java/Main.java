import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Random;

/*
Первый семинар.
1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

Пункты реализовать в методе main
*Пункты реализовать в разных методах

int i = new Random().nextInt(k); //это кидалка случайных чисел!)
 */
public class Main {
    public static void main(String[] args) {
        int number = getRandomNumber();
        if (number == 0) {
            System.out.println("Случайное число: " + number + ". Все результаты 0.");
        } else {
            System.out.println(number);
            number = getUpperBit(number);
            if (number == 1) {
                System.out.println("Старший значащий бит: 1.");
                int[] arr1 = getArrayPositiveMultiples(number);
//                System.out.println(Arrays.toString(arr1));
                System.out.println("Массив m2 не существует. Не существет чисел, некратных 1.");
            }
            else {
                System.out.println(number);
                int[] arr1 = getArrayPositiveMultiples(number);
//            System.out.println(Arrays.toString(arr1));
                int[] arr2 = getArrayNegativeMultiples(number);
//            System.out.println(Arrays.toString(arr2));
            }
        }
    }
    public static int getRandomNumber() {
        // Выбросывает случайное целое число в диапазоне от 0 до 2000 и сохранить в i
        Random rd = new Random();
        int i = rd.nextInt(0, 2000);
        return i;
    }
    public static int getUpperBit(int n) {
        // Считает и сохраняет в n номер старшего значащего бита принятого числа
        while (n > 9) {
            n /= 10;
        }
        return n;
    }
    public static int[] getArrayPositiveMultiples(int i) {
        // Находит все кратные n числа в диапазоне от i до Short.MAX_VALUE сохраняет в массив m1
        int[] m1 = new int[Short.MAX_VALUE / i];
        System.out.println(m1.length + " - размер массива m1");
        for (int j = i, el = 0; j <= Short.MAX_VALUE; j++) {
            if (j % i == 0) {
                m1[el] = j;
                el++;
            }
            }
        return m1;
    }
    public static int[] getArrayNegativeMultiples(int i) {
//        Находит все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохраняет в массив m2
        int[] m2 = new int[(Short.MIN_VALUE * (-1) + (Short.MIN_VALUE / i)) + i];
        System.out.println(m2.length + " - размер массива m2");
        for (int j = Short.MIN_VALUE, el = 0; j <= i; j++) {
            if (j == 0) j++;
            if (j % i != 0) {
                m2[el] = j;
                el++;
            }
        }
        return m2;
    }
    static String getType(Object o) {
        return o.getClass().getSimpleName();
    }
}