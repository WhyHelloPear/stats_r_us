import java.util.Random;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Directory{
	private RecordFactory recordFactory;

	private List<Person> players = new ArrayList<Person>();
	private List<Person> managers = new ArrayList<Person>();

 	public void read_person(){
        String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("../data/People.csv"))) {

            while ((line = br.readLine()) != null) {

        		if(i != 0){
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);

	                String id = info[0];
					String name = info[13] + info[14];

					String birthdate = info[2]+"/"+info[3]+"/"+info[1];
					Integer age = 0; //need a function to find differences between dates
					
					String birthplace = info[6]+", "+info[5]+", "+info[4];

					Integer weight;
					Integer height;
					String bats;
					String throw_arm;
					String playSpan;
					if(info.length > 16){
						if(info[16].length() > 0 && info[17].length() > 0){
							weight = Integer.parseInt(info[16]);
							height = Integer.parseInt(info[17]);
						}
						else{
							weight = 0;
							height = 0;
						}

						bats = info[18];
						throw_arm = info[19];
						playSpan = "holder";
					}
					else{
						weight = 0;
						height = 0;
						bats = "hold";
						throw_arm = "hold";
						playSpan = "hold";
					}
	                players.add(new Player(id, name, age, birthplace, weight, height, bats, throw_arm, playSpan));
                }
                i = 1;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer size = players.size();
        System.out.println("Number of persons added: ");
        System.out.print(size);
 	}
}
