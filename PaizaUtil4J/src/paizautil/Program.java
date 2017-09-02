package paizautil;


import paizautil.PaizaUtility.ITestIO;

public class Program
{
	private static class DebugIO implements ITestIO
	{
		// java には C# みたいな逐次的文字列リテラル記法が無いからダルい、どーすりゃいいんだこれ。
		private final String[] source = {
				"2",
				"hello",
				"world",
		};

		private int index = 0;

		@Override
		public String readLine()
		{
			return index < source.length ? source[index++] : null;
		}

		@Override
		public void writeLine(String line)
		{
			System.out.println( line );
		}
	}


	public static void main( String[] args )
	{
		PaizaUtility.io = new DebugIO();

		Do.answer();
	}
}
