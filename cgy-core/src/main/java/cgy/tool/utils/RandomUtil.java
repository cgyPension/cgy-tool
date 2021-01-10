package cgy.tool.utils;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机工具类
 */
public class RandomUtil {

	/**
	 * 用于随机选的数字
	 */
	public static final String BASE_NUMBER = "0123456789";
	/**
	 * 用于随机选的字符
	 */
	public static final String BASE_CHAR = "abcdefghijklmnopqrstuvwxyz";
	/**
	 * 用于随机选的字符和数字
	 */
	public static final String BASE_CHAR_NUMBER = BASE_CHAR + BASE_NUMBER;

	// ------------------------------------------------------------------- 伪随机

	/**
	 * 获取随机数生成器对象<br>
	 * ThreadLocalRandom是JDK 7之后提供并发产生随机数，能够解决多个线程发生的竞争争夺。
	 *
	 * <p>
	 * 注意：此方法返回的{@link ThreadLocalRandom}不可以在多线程环境下共享对象，否则有重复随机数问题。
	 * 见：https://www.jianshu.com/p/89dfe990295c
	 * </p>
	 *
	 * @return {@link ThreadLocalRandom}
	 * @since 3.1.2
	 */
	public static ThreadLocalRandom getRandom() {
		return ThreadLocalRandom.current();
	}

	/**
	 * 获得指定范围内的随机数 [0,limit)
	 *
	 * @param limit 限制随机数的范围，不包括这个数
	 * @return 随机数
	 */
	public static int randomInt(int limit) {
		return getRandom().nextInt(limit);
	}


	/**
	 * 随机字符
	 *
	 * @param baseString 随机字符选取的样本
	 * @return 随机字符
	 * @since 3.1.2
	 */
	public static char randomChar(String baseString) {
		return baseString.charAt(randomInt(baseString.length()));
	}

	/**
	 * 随机数字，数字为0~9单个数字
	 *
	 * @return 随机数字字符
	 * @since 3.1.2
	 */
	public static char randomNumber() {
		return randomChar(BASE_NUMBER);
	}

	/**
	 * 随机小写字母
	 *
	 * @return 随机小写字母
	 * @since 3.1.2
	 */
	public static char randomChar() {
		return randomChar(BASE_CHAR);
	}

	/**
	 * 随机字母或数字，小写
	 *
	 * @return 随机字符
	 * @since 3.1.2
	 */
	public static char randomCharNumber() {
		return randomChar(BASE_CHAR_NUMBER);
	}

	// ------------------------------------------------------------------- UUID



}
