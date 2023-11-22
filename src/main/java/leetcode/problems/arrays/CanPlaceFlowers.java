package leetcode.problems.arrays;

public class CanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (flowerbed.length == 1) {
            if (flowerbed[0] == 0 && n == 1) {
                return true;
            }
        }
        int counter = 0;
        if (flowerbed.length >= 2) {
            if (flowerbed[0] == 0 && flowerbed[1] == 0){
                flowerbed[0] = 1;
                counter++;
            }
        }

        for (int i = 2; i < flowerbed.length; i++) {
            if (flowerbed[i-2] == 0 && flowerbed[i-1] == 0 && flowerbed[i] == 0) {
                flowerbed[i-1] = 1;
                counter++;
                i++;
            }
        }

        if (flowerbed.length >= 2) {
            if (flowerbed[flowerbed.length-2] == 0 && flowerbed[flowerbed.length-1] == 0){
                flowerbed[flowerbed.length-1] = 1;
                counter++;
            }
        }

        if (counter >= n) {
            return true;
        }
        return false;
    }
}
