package paizautil;

// static class 問題を回避する為に、余計なエンクロージングクラスを作ってその中にDoとPaizaUtilityを突っ込んだ。
import paizautil.EnclosingDummy.Do;
import paizautil.EnclosingDummy.PaizaUtility;
import paizautil.EnclosingDummy.PaizaUtility.ITestIO;


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


	public static void main(String[] args)
	{
		PaizaUtility.io = new DebugIO();

		Do.answer();
	}
}
