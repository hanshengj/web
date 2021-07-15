package type;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-06-28
 * Time: 9:13
 */
//根据角判断
public class AngularRelation {
    public static String Angular(double a, double b, double c) {

        if (a > 100 || b > 100 || c > 100 ){
            return  "超出边界值";
        }

        if(a <= 0 || b <= 0 || c <= 0){
            return  "边不能为负数或者等于0";
        }

        if((a+b>c && a+c>b && b+c>a)){

            double [] array = sort(a,b,c);
            double x, y;
            x = array[0] * array[0] + array[1] * array[1];//两个小边ji
            y = array[2] * array[2];//大边之积
            if (x > y) {
                return "这个三角形是锐角三角形";
            } else if (x < y) {
                return "这个三角形是钝角三角形";
            } else {
                return "这个三角形是直角三角形";
            }
        }else{
            return "不能组成三角形";
        }



    }
    public static double [] sort (double num1, double num2, double num3){
        double  t = 0.0;
        if(num1 > num2){
            t = num1;
            num1 = num2;
            num2 = t;
        }
        if(num1 > num3){
            t = num1;
            num1 = num3;
            num3 = t;
        }
        if(num2 > num3){
            t = num2;
            num2 = num3;
            num3 = t;
        }

        double [] ret = new double[3];
        ret[0] = num1;
        ret[1] = num2;
        ret[2] = num3;
//        System.out.println(num1);
//        System.out.println(num2);
//        System.out.println(num3);
        return ret;


    }


}