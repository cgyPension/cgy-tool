package cgy.tool.utils;


import java.util.zip.ZipEntry;

/**
 * 系统运行时工具类，用于执行系统命令的工具
 *
 */
public class RuntimeUtil {

	// -------------------------------------------------------------------------------------------------- JVM


	/**
	*@Description: 打印Jvm所有详细信息
	*@Param: []
	*@return: print
	*/
	public static void printAllJvmMessages(){
		System.out.println("JVM可用的处理器数量（一般为CPU核心数）："+Runtime.getRuntime().availableProcessors());
		System.out.println("JVM中剩余的内存数，单位byte ："+Runtime.getRuntime().freeMemory());
		System.out.println("JVM已经从系统中获取到的总共的内存数，单位byte ："+Runtime.getRuntime().totalMemory());
		System.out.println("JVM中可以从系统中获取的最大的内存数，单位byte，以-Xmx参数为准 ："+Runtime.getRuntime().maxMemory());
		System.out.println("JVM最大可用内存，计算方法为(最大内存-总内存+剩余内存)："+(Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory() + Runtime.getRuntime().freeMemory()));
	}

	/**
	 * 增加一个JVM关闭后的钩子，用于在JVM关闭时执行某些操作
	 *
	 * @param hook 钩子
	 * @since 4.0.5
	 */
	public static void addShutdownHook(Runnable hook) {
		Runtime.getRuntime().addShutdownHook((hook instanceof Thread) ? (Thread) hook : new Thread(hook));
	}

}
