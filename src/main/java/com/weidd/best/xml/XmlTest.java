package com.weidd.best.xml;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-02 14:26
 **/
public class XmlTest {

    public static void main(String[] args) {
        String format = format("<response><head><tradeTime>2017-01-12</tradeTime></head><body><List><map><name>大鹏</name><age>20</age><sex>男</sex></map><map><name>大鹏2</name><age>202</age><sex>男2</sex></map></List></body></response>");
        System.out.println(format);
    }

    /**
     * 格式化xml
     *
     * @return
     */
    public static String format(String str) {
        StringBuffer buffer = new StringBuffer(str);
        int numSpace = 0;//空格的个数
        /**
         * 定位开始结束标签
         */
        int start = buffer.indexOf("<", 0);
        int end = buffer.indexOf(">", start);
        //定位下下个标签
        int nextStart =  buffer.indexOf("<", end);//-1之后
        boolean isNext = true;

        while (start != -1 && end != -1) {
            /**
             * 是否换行，已经换多少格
             */
            //如果当前为开始标签，下一个也为开始标签
            if ((buffer.indexOf("/", start) != start + 1 && buffer.indexOf("/", nextStart) != nextStart + 1)) {
                numSpace++;
                isNext = true;
            }
            //如果当前为开始标签，且下一个标签为结束标签
            else if ((buffer.indexOf("/", start) != start + 1 && buffer.indexOf("/", nextStart) == nextStart + 1)) {
                isNext = false;
            }
            //如果当前为结束标签，且下一个标签为开始标签
            else if ((buffer.indexOf("/", start) == start + 1 && buffer.indexOf("/", nextStart) != nextStart + 1)) {
                isNext = true;
            }
            //如果当前为结束标签，且下一个标签还是结束标签
            else if ((buffer.indexOf("/", start) == start + 1 && buffer.indexOf("/", nextStart) == nextStart + 1)) {
                numSpace--;
                isNext = true;
            }

            //这个位置判断是否是加空格
            if (isNext) buffer.insert(end + 1, "\n" + $t(numSpace));
            //标签向下移动
            start = buffer.indexOf("<", end);
            end = buffer.indexOf(">", start);
            nextStart =  buffer.indexOf("<", end);
        }


        // 注释：返回我们格式化后的结果
        return buffer.toString();
    }

    //返回N个\t
    private static String $t(int num) {
        String t = "";
        for (int i = 1; i < num; i++) {
            t += "\t";
        }
        return t;
    }


}

