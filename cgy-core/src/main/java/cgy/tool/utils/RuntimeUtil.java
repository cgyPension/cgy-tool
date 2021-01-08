package cgy.tool.utils;


import java.util.zip.ZipEntry;

/**
 * 系统运行时工具类，用于执行系统命令的工具
 *
 */
public class RuntimeUtil {

	/**
	 * 执行系统命令，使用系统默认编码
	 *
	 * @param cmds 命令列表，每个元素代表一条命令
	 * @return 执行结果
	 * @throws IORuntimeException IO异常
	 */
	/*public static String execForStr(String... cmds) throws IORuntimeException {
		return execForStr(CharsetUtil.systemCharset(), cmds);
	}*/


	// -------------------------------------------------------------------------------------------------- JVM

	/**
	 * 增加一个JVM关闭后的钩子，用于在JVM关闭时执行某些操作
	 *
	 * @param hook 钩子
	 * @since 4.0.5
	 */
	public static void addShutdownHook(Runnable hook) {
		Runtime.getRuntime().addShutdownHook((hook instanceof Thread) ? (Thread) hook : new Thread(hook));
	}


	/**
	*@Description: 打印Jvm所有详细信息，是后面方法的聚合方法
	*@Param: []
	*@return: print
	*/
	public static void getAllJvmMessages(){
		System.out.println("JVM可用的处理器数量（一般为CPU核心数）："+Runtime.getRuntime().availableProcessors());
		System.out.println("JVM中剩余的内存数，单位byte ："+Runtime.getRuntime().freeMemory());
		System.out.println("JVM已经从系统中获取到的总共的内存数，单位byte ："+Runtime.getRuntime().totalMemory());
		System.out.println("JVM中可以从系统中获取的最大的内存数，单位byte，以-Xmx参数为准 ："+Runtime.getRuntime().maxMemory());
		System.out.println("JVM最大可用内存，计算方法为(最大内存-总内存+剩余内存)："+(getMaxMemory() - getTotalMemory() + getFreeMemory()));
	}

	/**
	 * 获得JVM可用的处理器数量（一般为CPU核心数）
	 *
	 * @return 可用的处理器数量
	 * @since 5.3.0
	 */
	public static int getProcessorCount() {
		return Runtime.getRuntime().availableProcessors();
	}

	/**
	 * 获得JVM中剩余的内存数，单位byte
	 *
	 * @return JVM中剩余的内存数，单位byte
	 * @since 5.3.0
	 */
	public static long getFreeMemory() {
		return Runtime.getRuntime().freeMemory();
	}

	/**
	 * 获得JVM已经从系统中获取到的总共的内存数，单位byte
	 *
	 * @return JVM中剩余的内存数，单位byte
	 * @since 5.3.0
	 */
	public static long getTotalMemory() {
		return Runtime.getRuntime().totalMemory();
	}

	/**
	 * 获得JVM中可以从系统中获取的最大的内存数，单位byte，以-Xmx参数为准
	 *
	 * @return JVM中剩余的内存数，单位byte
	 * @since 5.3.0
	 */
	public static long getMaxMemory() {
		return Runtime.getRuntime().maxMemory();
	}

	/**
	 * 获得JVM最大可用内存，计算方法为：<br>
	 * 最大内存-总内存+剩余内存
	 *
	 * @return 最大可用内存
	 */
	public static long getUsableMemory() {
		return getMaxMemory() - getTotalMemory() + getFreeMemory();
	}
}
