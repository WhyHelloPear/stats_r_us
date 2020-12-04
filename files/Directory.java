import java.util.Random;
import java.util.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Directory{

	public List<Person> persons = new ArrayList<Person>();
	public List<Franchise> franchises = new ArrayList<Franchise>();
	public List<Record> records = new ArrayList<Record>();

	private String[] fill_blanks(String[] info){

		for(int i = 0; i < info.length; i++){
			if(info[i].equals("")){
				info[i] = "0";
			}
		}

		return info;
	}

	private String fix_line(String line){
		char holder = line.charAt(line.length()-1);
		String last = String.valueOf(holder);  
		if(last.equals(",")){
			line = line.concat("0");
		}
		return line;
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

 	public void read_person(){
        String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;
        Integer count = 0;
        
        List<String> managers = get_managers();

        try(BufferedReader br = new BufferedReader(new FileReader("../data/People.csv"))) {

            while ((line = br.readLine()) != null) {
            	line = fix_line(line);
        		if(i != 0){
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);

	                String id = info[0];
					String name = info[13] + " " + info[14];

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
            	line = fix_line(line);
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

 	//creates franchise records and tracks teams that fall under a franchise
 	public void read_teams(){
 		String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;

        try(BufferedReader br = new BufferedReader(new FileReader("../data/teams.csv"))) {

            while ((line = br.readLine()) != null) {
            	line = fix_line(line);
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
 	}

 	//creates batting records and tracks teams that fall under a franchise
 	public void read_batting(){
		String line = "";
		String cvsSplitBy = ",";
		Integer i = 0;

		try(BufferedReader br = new BufferedReader(new FileReader("../data/Batting.csv"))) {
			while ((line = br.readLine()) != null) {
				line = fix_line(line);
				if(i != 0){
					// use comma as separator
					String[] info = line.split(cvsSplitBy);


					info = fill_blanks(info);
					

					String player_id = info[0];
					String year = info[1];
					String team_id = info[3];
					String league = info[4];



					Person player = find_person(player_id);
					// get franchise object that will be reference in record
					Franchise franchise = find_team(team_id);

					// instantiate batting record
					BattingRecord record = new BattingRecord(franchise, league, year);

					// attach player object to the record
					record.set_player(player);

					Integer games = Integer.parseInt(info[5]);
					Integer at_bats = Integer.parseInt(info[6]);
					Integer runs = Integer.parseInt(info[7]);
					Integer hits = Integer.parseInt(info[8]);
					Integer doubles = Integer.parseInt(info[9]);
					Integer triples = Integer.parseInt(info[10]);
					Integer home_runs = Integer.parseInt(info[11]);
					Integer rbi = Integer.parseInt(info[12]);
					Integer stolen_bases = Integer.parseInt(info[13]);
					Integer caught_stealing = Integer.parseInt(info[14]);
					Integer walks = Integer.parseInt(info[15]);
					Integer strike_outs = Integer.parseInt(info[16]);
					Integer intentional_walks = Integer.parseInt(info[17]);
					Integer hit_by_pitch = Integer.parseInt(info[18]);
					Integer sacrifice_hits = Integer.parseInt(info[19]);
					Integer sacrifice_flies = Integer.parseInt(info[20]);
					Integer grounded_into_double_play = Integer.parseInt(info[21]);

					record.set_stats(games, at_bats, runs, hits, doubles, triples, home_runs, rbi, stolen_bases, caught_stealing, walks, strike_outs, intentional_walks, hit_by_pitch, sacrifice_hits, sacrifice_flies, grounded_into_double_play);
					records.add(record);

				}
				i += 1;
			}

		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

	//creates fielding records and tracks teams that fall under a franchise
 	public void read_fielding(){
 		String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;

        try(BufferedReader br = new BufferedReader(new FileReader("../data/fielding.csv"))) {

            while ((line = br.readLine()) != null) {
            	line = fix_line(line);
        		if(i != 0){
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);
	                info = fill_blanks(info);

	                String player_id = info[0];
					String year = info[1];
					String team_id = info[3];
					String league = info[4];

					Person player = find_person(player_id);
					// get franchise object that will be reference in record
					Franchise franchise = find_team(team_id);


	                // instantiate franchise record
	                FieldingRecord record = new FieldingRecord(franchise, league, year);

	                // attach player object to the record
					record.set_player(player);

	                String position = info[5];
					Integer games = Integer.parseInt(info[6]);
					Integer games_started = Integer.parseInt(info[7]);
					Integer putouts = Integer.parseInt(info[9]);
					Integer assists = Integer.parseInt(info[10]);
					Integer errors = Integer.parseInt(info[11]);
					Integer double_plays = Integer.parseInt(info[12]);
					Integer passed_balls = Integer.parseInt(info[13]);
					Integer wild_pitches = Integer.parseInt(info[14]);
					Integer stolen_bases = Integer.parseInt(info[15]);
					Integer caught_stealing = Integer.parseInt(info[16]);

					record.set_stats(position, games, games_started, putouts, assists, errors, double_plays, passed_balls, wild_pitches, stolen_bases, caught_stealing);
					records.add(record);
                }
                i = 1;
            }

        }
        catch(IOException e) {
            e.printStackTrace();
        }
 	}

 	//creates pitching records and tracks teams that fall under a franchise
 	public void read_pitching(){
 		String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;

        try(BufferedReader br = new BufferedReader(new FileReader("../data/pitching.csv"))) {

            while ((line = br.readLine()) != null) {
            	line = fix_line(line);
        		if(i != 0){
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);
	                info = fill_blanks(info);

	                String player_id = info[0];
					String year = info[1];
					String team_id = info[3];
					String league = info[4];

					Person player = find_person(player_id);
					// get franchise object that will be reference in record
					Franchise franchise = find_team(team_id);


	                // instantiate pitching record
	                PitchingRecord record = new PitchingRecord(franchise, league, year);

	                // attach player object to the record
					record.set_player(player);

	                Integer wins = Integer.parseInt(info[5]);
	                Integer losses = Integer.parseInt(info[6]);
	                Integer games = Integer.parseInt(info[7]);
					Integer games_started = Integer.parseInt(info[8]);
					Integer games_finished = Integer.parseInt(info[25]);
					Integer complete_games = Integer.parseInt(info[10]);
					Integer shutouts = Integer.parseInt(info[10]);
					Integer saves = Integer.parseInt(info[11]);
					Integer outs_pitched = Integer.parseInt(info[12]);
					Integer hits = Integer.parseInt(info[13]);
					Integer earned_runs = Integer.parseInt(info[14]);
					Integer home_runs = Integer.parseInt(info[15]);
					Integer walks = Integer.parseInt(info[16]);
					Integer strike_outs = Integer.parseInt(info[17]);
					Float opp_batting_avg = Float.parseFloat(info[18]);
					Float era = Float.parseFloat(info[19]);
					Integer intentional_walks = Integer.parseInt(info[20]);
					Integer wild_pitches = Integer.parseInt(info[21]);
					Integer bat_hit_by_pitch = Integer.parseInt(info[22]);
					Integer balks = Integer.parseInt(info[23]);
					Integer batters_faced = Integer.parseInt(info[24]);
					Integer runs_allowed = Integer.parseInt(info[26]);

					record.set_stats(wins, losses, games, games_started, games_finished, complete_games, shutouts, saves, outs_pitched, hits, earned_runs, home_runs, walks, strike_outs, opp_batting_avg, era, intentional_walks, wild_pitches, bat_hit_by_pitch, balks, batters_faced, runs_allowed);
					records.add(record);
                }
                i = 1;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
 	}

 	public void read_managers(){
 		String line = "";
        String cvsSplitBy = ",";
        Integer i = 0;

        try(BufferedReader br = new BufferedReader(new FileReader("../data/pitching.csv"))) {

            while ((line = br.readLine()) != null) {
            	line = fix_line(line);
        		if(i != 0){
	                // use comma as separator
	                String[] info = line.split(cvsSplitBy);
	                info = fill_blanks(info);

	                String manager_id = info[0];
					String year = info[1];
					String team_id = info[2];
					String league = info[3];

					Person manager = find_person(manager_id);
					// get franchise object that will be reference in record
					Franchise franchise = find_team(team_id);

	                // instantiate pitching record
	                ManagerRecord record = new ManagerRecord(franchise, league, year);

	                Integer games_played = Integer.parseInt(info[5]);
					Integer games_won = Integer.parseInt(info[6]);
					Integer games_lost = Integer.parseInt(info[7]);
					Integer rank = Integer.parseInt(info[8]);

					record.set_stats(manager, games_played, games_won, games_lost, rank);
					records.add(record);
                }
                i = 1;
            }
        }
        catch(IOException e) {
            e.printStackTrace();
        }
 	}

 	public void read_records(){
 		read_teams();
 		read_batting();
 		read_fielding();
 		read_pitching();
 		read_managers();
 		System.out.println(records.size());
 	}
}
