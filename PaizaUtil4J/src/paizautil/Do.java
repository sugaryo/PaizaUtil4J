package paizautil;

/**
 * 注意事項：Javaはstaticクラスを定義出来ないので、innerに持ってく時にstaticを追記する必要がある。
 * @author sugaryo
 */
public class Do
{
	public static void answer()
	{
//		// IFunction デリゲートで書くとこんなコードになる。
//		Iterable<String> args = PaizaUtility.readArgs(
//				s -> Integer.parseInt( s )
//		);
		Iterable<String> args = PaizaUtility.readArgs();

		for ( String arg : args )
		{
			PaizaUtility.io.writeLine( arg );
		}
	}
}
