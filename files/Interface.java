import java.util.Random;
import java.util.*;

public class Interface{

	private static Directory directory = build_directory();

	public static Directory get_directory() {
		return directory;
	}

	private static Directory build_directory(){
		Directory directory = new Directory();
		directory.read_person();
		directory.read_franchise();
		directory.read_teams();
		directory.read_batting();

		return directory;
		directory.read_records();
	}
}
