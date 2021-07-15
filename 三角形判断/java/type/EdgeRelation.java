package type;

/**
 * Crtated with IntelliJ IDEA.
 * Destcription:
 * User: hp
 * Date: 2021-06-28
 * Time: 9:11
 */
//根据角判断
    public class EdgeRelation {
        public static  String Edge(float a, float b, float c) {
            if (a > 100 || b > 100 || c > 100 ){
                return  "超出边界值";
            }
            if(a <= 0 || b <= 0 || c <= 0){
                return  "边不能为负数或者等于0";
            }
            if((a+b>c && a+c>b && b+c>a)){

                double [] array = sort(a,b,c);
                if (a == b || a == c || b == c) {
                    if (a == b && a == c && b == c) {
                        return "该三角形为等边三角形";
                    } else {
                        if (array[0] * array[0] + array[1] * array[1] == array[2] * array[2]) {
                            return "该三角形为等腰直角三角形";
                        } else {
                            return "该三角形为等腰三角形";
                        }
                    }
                } else {
//                    if (array[0] * array[0] + array[1] * array[1] == array[2] * array[2]) {
//                        return "该三角形为直角三角形";
//                    } else {
                        return "该三角形为一般三角形";
//                    }
                }
            }else{
                return "不能组成三角形";
            }

        }


    public static double [] sort (double num1, double num2, double num3){
        double  t = 0;
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
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
        return ret;


    }

}

