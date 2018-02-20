package zadanie2;

public class Commander {
	
	public static void main(String args[]) {
		if (args.length<2 || args.length>3) {
			printUsage();
			return;
		}
	}
	
	private static void printUsage() {
		System.out.print("Usage:");
		System.out.println(" java Commander.class <filepath> <operation name> <additional parameter>");
		System.out.println("     where <operation name> is one of the following:");
		System.out.println("     list_files - simple list of files");
		System.out.println("     list_files_detailed - list of files with details");
		System.out.println("     list_files_filter - list of files with extension filter as additional parameter");
		System.out.println("     list_tree - tree of files");
		
	}
	
	
}
