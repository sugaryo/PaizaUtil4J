package paizautil;

public class Do
{
	public static void answer()
	{

		Iterable<String> args = PaizaUtility.readArgs();

		for ( String arg : args )
		{
			PaizaUtility.io.writeLine( arg );
		}
	}
}
