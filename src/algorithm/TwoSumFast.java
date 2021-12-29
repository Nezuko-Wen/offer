package algorithm;

import netscape.javascript.JSObject;
import utils.In;
import utils.StdOut;

import java.util.Arrays;

public class TwoSumFast {
    public static int count(int[] a) {
        int count = 0;
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            int key = -a[i];
            if (BinarySearch.search(key, a) > i) {
                count ++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String item ="{\n" +
                "    \"bizs\": [\n" +
                "        \"dqyIos\"\n" +
                "    ],\n" +
                "    \"needVideoTask\": false,\n" +
                "    \"dayLimit\": NumberInt(1000),\n" +
                "    \"dayCanDo\": NumberInt(6),\n" +
                "    \"timeBegin\": NumberInt(9),\n" +
                "    \"timeEnd\": NumberInt(23),\n" +
                "    \"available\": true,\n" +
                "    \"updateTime\": ISODate(\"2021-03-18T11:05:30.809+08:00\"),\n" +
                "    \"createTime\": ISODate(\"2021-03-18T11:05:30.809+08:00\"),\n" +
                "    \"recallStrategy\": {\n" +
                "        \"timing\": true,\n" +
                "        \"interval\": NumberInt(10),\n" +
                "        \"scores\": [\n" +
                "            NumberInt(288),\n" +
                "            NumberInt(88),\n" +
                "            NumberInt(88),\n" +
                "            NumberInt(88),\n" +
                "            NumberInt(88),\n" +
                "            NumberInt(88)\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_class\": \"com.middle.dao.domain.RecallLaunch\"";
        String[] strings = In.readStrings("test.txt");
        StringBuffer ret = new StringBuffer();
        for (String string : strings) {

            ret.append(item);
        }
    }
}
