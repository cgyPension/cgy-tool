package cgy.tool.utils;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author GyuanYuan Cai
 * 2021/1/10
 * Description: 正则相关工具类
 */

public class ReUtil {
    /**
     * 正则表达式匹配中文汉字
     */
    public final static String RE_CHINESE = "[\u4E00-\u9FFF]";
    /**
     * 正则表达式匹配中文字符串
     */
    public final static String RE_CHINESES = RE_CHINESE + "+";


}