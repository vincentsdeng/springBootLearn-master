package com.example.demo.enums;

import com.alibaba.fastjson.JSON;
import com.example.demo.model.Rat;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.junit.Test;

import java.util.Map;
import java.util.jar.JarEntry;

public class CityStatusTest {



    /**
     * 6 1
     * 5 3
     * 4 5
     * 3 7
     * 2 9
     * 1 11
     * 0 13
     * 1 11
     * 2 9
     * 3 7
     * 4 5
     * 5 3
     * 6 1
     * @param
     */
    public static void main(String[] args) {
        //      printDiamond(12);
        print(3);
    }
    public static void print(int size) {
        int n = size;// 行数
      for (int i = 0; i < n; i++) {
           if (i <= (n - 1) / 2) {
                for (int j = i; j < (n - 1) / 2; j++) {
                    System.out.print("");
                }
                for (int k = 0; k < 2 * i + 1; k++) {
                    System.out.print("*");
                }
//            } else {
//                for (int j = 0; j < i - (n - 1) / 2; j++) {
//                    System.out.print(" ");
//                }
//                for (int k = 0; k < 2 * (n - i) - 1; k++) {
//                    System.out.print("*");
//                }
           }
            System.out.println();
        }

    }


    /**
     * 打印菱形实现方法
     */
    public static void printDiamond(int size) {

        size = (size / 2) * 2; // 菱形对角线两侧的宽度是相同的，所以对角线长度size必定是偶数,(size+1)即为行数和列数

        int center = (size / 2); // 以左上角为坐标点(0,0),菱形中心点坐标(center,center)

        for (int i = 0; i <= size; i++) { // 行
            for (int j = 0; j <= size; j++) { // 列
                if (Math.abs(i - center) + Math.abs(j - center) == center) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    @Test
    public   void  chen(){
        for (int i=1;i<12;i++){
             for (int j=1;j<=i;j++){
                 System.out.print(i + "*" + j + "=" + i*j + "   ");
            }
            System.out.println();
        }
    }
    @Test
    public void zoo(){
        Rat rat = new Rat();
        rat.setChickens("ji");
        rat.setRat("lao");
        rat.setElephant("sang");

 //      System.out.println(JSON.toJSONString(rat));
        Object J=JSON.toJSONString(rat);
        System.out.println(J);
        String R = JSON.toJSONString(new Rat(), true);
        System.out.println(R);

    }

}