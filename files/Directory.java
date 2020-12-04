import java.util.Random;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Directory{
	private RecordFactory recordFactory;

	private List<Person> persons = new ArrayList<Person>();
	private List<Franchise> franchises = new ArrayList<Franchise>();
	private List<Record> records = new ArrayList<Record>();


	private List<String> get_managers(){
		String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;
		List<String> managers = new ArrayList<String>();
        try(BufferedReader br = new BufferedReader(new FileReader("../data/Managers.csv"))) {

            while ((line = br.readLine()) != null) {
        		if(i != 0){
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);
	                if(managers.contains(info[0]) == false){
	                	managers.add(info[0]);
	                }
                }
                i = 1;
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        return managers;
	}

	private String[] fill_blanks(String[] info){
		for(int i = 0; i < info.length; i++){
			if(info[i].equals("")){
				info[i] = "0";
			}
		}
		return info;
	}

				// String[] info = line.split(cvsSplitBy);
    // 			read(info);
	private void read(String[] info){
		for(int i = 0; i < info.length; i++){
			String value = info[i];
			String k = String.valueOf(i);
			String holder = ": ";
			String n = value.concat(holder);
			n = n.concat(k);
			System.out.println(n);
		}
	}

	//find franchise object by franchise id
 	public Franchise find_franchise(String id){
 		Franchise franchise = null;
 		for(int i = 0; i < franchises.size(); i++){
 			franchise = franchises.get(i);
 			if(franchise.get_id().equals(id)){
 				break;
 			}
 		}
 		return franchise;
 	}

 	//takes in team id and returns franchise object associated with the team
 	public Franchise find_team(String id){
 		Franchise franchise = null;
 		for(int i = 0; i < franchises.size(); i++){
 			franchise = franchises.get(i);
 			if(franchise.contains_team(id)){
 				break;
 			}
 		}
 		return franchise;
 	}

 	public void read_person(){
        String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;
        Integer count = 0;
        
        List<String> managers = get_managers();

        try(BufferedReader br = new BufferedReader(new FileReader("../data/People.csv"))) {

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
					if(managers.contains(id)){
						persons.add(new Manager(id, name, age, birthplace, weight, height, bats, throw_arm, playSpan));
						count += 1;
					}
					else{
						persons.add(new Player(id, name, age, birthplace, weight, height, bats, throw_arm, playSpan));
					}
	                
                }
                i = 1;

            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        Integer size = persons.size();
        System.out.println("Number of persons added: ");
        System.out.println(size);

        System.out.println("Number of managers added: ");
        System.out.println(count);
 	}

 	public void read_franchise(){
 		String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("../data/TeamsFranchises.csv"))) {

            while ((line = br.readLine()) != null) {

        		if(i != 0){
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);

	                String id = info[0];
					String name = info[1];
					Boolean active;

					if(info[2] == "Y"){
						active = true;
					}
					else{
						active = false;
					}
					
	                franchises.add(new Franchise(id, name, active));
                }
                i = 1;

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        Integer size = franchises.size();
        System.out.println("Number of franchises added: ");
        System.out.println(size);
 	}

 	public Person find_person(String id){
 		Person person = null;
 		for(int i = 0; i < persons.size(); i++){
 			person = persons.get(i);
 			if(person.get_id().equals(id)){
 				break;
 			}
 		}
 		return person;
 	}

 	//creates franchise records and tracks teams that fall under a franchise
 	public void read_teams(){
 		String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;

        try(BufferedReader br = new BufferedReader(new FileReader("../data/teams.csv"))) {

            while ((line = br.readLine()) != null) {
 
        		if(i != 0){
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);
	                info = fill_blanks(info);
	                String year = info[0];
	                String league = info[1];
	                String team_id = info[2];
	                String franchise_id = info[3];
	                
	                // get franchise object that will be reference in record
	                Franchise franchise = find_franchise(franchise_id);
	                franchise.add_team(team_id);


	                // instantiate franchise record
	                FranchiseRecord record = new FranchiseRecord(franchise, league, year);


	                Integer rank = Integer.parseInt(info[5]);
					Integer games = Integer.parseInt(info[6]);
					Integer games_won = Integer.parseInt(info[8]);
					Integer games_lost = Integer.parseInt(info[9]);
					Integer runs = Integer.parseInt(info[14]);
					Integer at_bats = Integer.parseInt(info[15]);
					Integer hits = Integer.parseInt(info[16]);
					Integer doubles = Integer.parseInt(info[17]);
					Integer triples = Integer.parseInt(info[18]);
					Integer home_runs = Integer.parseInt(info[19]);
					Integer walks = Integer.parseInt(info[20]);
					Integer strike_outs = Integer.parseInt(info[21]);
					Integer stolen_bases = Integer.parseInt(info[22]);
					Integer caught_stealing = Integer.parseInt(info[23]);
					Integer hit_by_pitch = Integer.parseInt(info[24]);
					Integer sacrifice_flies = Integer.parseInt(info[25]);
					Integer earned_runs_allowed = Integer.parseInt(info[27]);
					Float earned_runs_average = Float.parseFloat(info[28]);
					Integer complete_games = Integer.parseInt(info[29]);
					Integer shutouts = Integer.parseInt(info[30]);
					Integer saves = Integer.parseInt(info[31]);
					Integer hits_allowed = Integer.parseInt(info[33]);
					Integer home_runs_allowed = Integer.parseInt(info[34]);
					Integer walks_allowed = Integer.parseInt(info[35]);
					Integer pitcher_strike_outs = Integer.parseInt(info[36]);
					Integer errors = Integer.parseInt(info[37]);
					Integer double_plays = Integer.parseInt(info[38]);
					Float fielding_percentage = Float.parseFloat(info[39]);

					record.set_stats(rank, games, games_won, games_lost, runs, at_bats, hits, doubles, triples, home_runs, walks, strike_outs, stolen_bases, caught_stealing, hit_by_pitch, sacrifice_flies, earned_runs_allowed, earned_runs_average, complete_games, shutouts, saves, hits_allowed, home_runs_allowed, walks_allowed, pitcher_strike_outs, errors, double_plays, fielding_percentage);
					records.add(record);
                }
                i = 1;
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
        System.out.println(records.size());
 	}






 	public void read_records(){
 		System.out.println("do stuff");
 	}


}
