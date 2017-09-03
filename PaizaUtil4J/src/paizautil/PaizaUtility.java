package paizautil;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 注意事項：Javaはstaticクラスを定義出来ないので、innerに持ってく時にstaticを追記する必要がある。
 * @author sugaryo
 */
public class PaizaUtility
{
	public interface ITestIO
	{
		String readLine();

		void writeLine(String line);
	}

	public static class ConsoleProxy implements ITestIO
	{
		private final Scanner in = new Scanner( System.in );

		@Override
		public String readLine()
		{
			return in.next();
		}

		@Override
		public void writeLine(String line)
		{
			System.out.println( line );
		}
	}

	static ITestIO io;

	// static ctor
	static {
		io = new ConsoleProxy();
	}

	public static Iterable<String> readArgs()
	{
		String s = io.readLine();
		int n = Integer.valueOf( s );

		return readArgs( n );
	}
	public static Iterable<String> readArgs(final int n)
	{
		List<String> args = new ArrayList<String>();

		for ( int i = 0; i < n; i++ )
		{
			String arg = io.readLine();

			args.add( arg );
		}

		return args;
	}

	public interface IFunction<TResult, TParameter>
	{
		TResult invoke( TParameter parameter );
	}
	public static Iterable<String> readArgs( IFunction<Integer, String> parseHeaderRecord ) {
		String header = io.readLine();
		int n = parseHeaderRecord.invoke( header ).intValue();

		return readArgs( n );
	}


	// static class.
	private PaizaUtility() { }
}