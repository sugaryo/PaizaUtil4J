package paizautil;

// static class 問題を回避する為に、余計なエンクロージングクラスを作ってその中にDoとPaizaUtilityを突っ込んだ。
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import paizautil.EnclosingDummy.Do;
import paizautil.EnclosingDummy.PaizaUtility;
import paizautil.EnclosingDummy.PaizaUtility.ITestIO;


public class Program
{
	private static class DebugIO implements ITestIO
	{
		// java には C# みたいな逐次的文字列リテラル記法が無いからダルい、どーすりゃいいんだこれ。
		private final String[] source;

		// readLineで読み込みを進めるためのシーケンスカウンタ。
		private int index = 0;

		public DebugIO()
		{
			super();
			this.source = readDataSource();
		}
		private static String[] readDataSource()
		{
			// 取り敢えず相対パスでテキストファイルから読み込む事にする。
			Path path = Paths.get( "dat/datasource.txt" );

			try
			{
				return Files.lines( path ).toArray( String[]::new );
			}
			catch ( IOException ex )
			{
				// 絶対有り得ないケースだから何でも良いんだけど取り敢えず空にしとく。
				ex.printStackTrace();
				return new String[]{};
			}
		}

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
