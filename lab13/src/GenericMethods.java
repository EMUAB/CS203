public class GenericMethods {
    public static <T extends Number> Pair<Double, Double> maxMin(T[] tArr) {
        double max = tArr[0].doubleValue();
        for (T i : tArr) {
           if (i.doubleValue() > max) {
                max = i.doubleValue();
            }
        }
        double min = tArr[0].doubleValue();
        for (T j : tArr) {
            if (j.doubleValue()< min) {
                min = j.doubleValue();
            }
        }
        return new Pair<>(max, min);
    }

    public static <S extends Number> Pair<Double, Double> avgSum(S[] sArr) {
        double sum = 0;
        double avg;
        for (S i : sArr) {
            sum += i.doubleValue();
        }
        avg = sum/(sArr.length);
        return new Pair<>(avg, sum);
    }
}
