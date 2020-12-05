import java.io.*;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class webserver {
    static Directory directory;
    static List<Franchise> franchises;
    static List<Person> persons;

    public static void main(String[] args) throws Exception {
        directory = Interface.get_directory();
        franchises = directory.franchises;
        persons = directory.persons;


        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
        System.out.println("Server Started");
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response;

            // Create path from uri. Remove empty strings.
            String uri = t.getRequestURI().toString();
            ArrayList<String> path = new ArrayList<String>( Arrays.asList( uri.split("/", 0) ) );
            path.removeAll(Collections.singleton(""));


            // Landing Page Requested
            if (path.size() == 0) {
                response = handle_main();
            }


            else {
                // Create subpath
                ArrayList<String> subpath = new ArrayList(path);
                subpath.remove(0);


                response = switch (path.get(0)) {
                    case "list" -> handle_list(subpath); // Player List or Franchise List Requested
                    case "p" -> handle_p(subpath); // Player Card Requested
                    case "f" -> handle_f(subpath); // Franchise Card Requested
                    default -> "Unsupported Path."; // Catchall
                };
            }

            t.sendResponseHeaders(200, response.getBytes().length); // Send Response
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    // Handles Landing Page Response. Not really used anymore
    public static String handle_main() {
        String resp = " <a href=\"/list/p\">Players</a> <br> ";
        resp += " <a href=\"/list/f\">Franchises</a>\n";

        return resp;
    }

    // Handles the list responses
    public static String handle_list(ArrayList<String> path) {
        if( path.get(0).equals("p") ) { // Player List
            return handle_list_p();

        } else if ( path.get(0).equals("f") ) { // Franchise List
            return handle_list_f();
        }
        return "Not a defined list.";
    }

    // Handles the plater list response
    public static String handle_list_p() {
        // Read html file
        Path fileName = Path.of("html/list_p.html");
        String resp = "";
        try {
            resp = Files.readString(fileName);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        // Html for each item in list
        String list = "";
        for (Person p : persons) {
            list += " <a href=\"/p/" + p.get_id() + "\">" + p.get_name() + "</a> <br>";
        }

        // Add the list in the correct location
        resp = resp.replace("<!--list-->", list);

        return resp;
    }

    public static String handle_list_f(){
        // Read html file
        Path fileName = Path.of("html/list_f.html");
        String resp = "";
        try {
            resp = Files.readString(fileName);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        // Html for each item in list
        String list = "";
        for (Franchise f : franchises) {
            list += " <a href=\"/f/" + f.get_id() + "\">" + f.get_name() + "</a> <br>";
        }

        // Add the list in the correct location
        resp = resp.replace("<!--list-->", list);

        return resp;
    }

    // Handles the response for player card
    public static String handle_p(ArrayList<String> path){
        //Get player object and then player info
        Person p = directory.find_person(path.get(0));
        String name = p.name;
        String id = p.id;
        String age = p.age.toString();
        String birth = p.birthplace;
        String weight = p.weight.toString();
        String height = p.height.toString();
        String bats = p.bats;
        String throw_arm = p.throw_arm;
        String span = p.playSpan;

        // Read html file
        Path fileName = Path.of("html/p.html");
        String resp = "";
        try {
            resp = Files.readString(fileName);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        //Insert the player info
        resp = resp.replace("<!--name-->", name);
        resp = resp.replace("<!--id-->",id);
        resp = resp.replace("<!--age-->", age);
        resp = resp.replace("<!--birth-->", birth);
        resp = resp.replace("<!--weight-->", weight);
        resp = resp.replace("<!--height-->", height);
        resp = resp.replace("<!--bats-->", bats);
        resp = resp.replace("<!--arm-->", throw_arm);
        resp = resp.replace("<!--span-->", span);

        return resp;
    }

    public static String handle_f(ArrayList<String> path){
        // Get franchise object and franchise info
        Franchise f = directory.find_franchise(path.get(0));
        String name = f.get_name();
        String id = f.get_id();
        String active = f.is_active().toString();
        String teams = "";

        // Get teams
        List<String> teamList = f.get_teams();
        for (String t : teamList) {
            teams += t + " ";
        }

        // Get franchise records
        List<FranchiseRecord> record_list = directory.get_franchise_records(id);

        // Get data from each record and reate HTML for each table row
        String rows = "";
        for (FranchiseRecord r : record_list) {
            List<String> stats = new ArrayList<String>();

            stats.add(r.get_year());
            stats.add(r.rank.toString());
            stats.add(r.games.toString());
            stats.add(r.games_won.toString());
            stats.add(r.games_lost.toString());
            stats.add(r.runs.toString());
            stats.add(r.at_bats.toString());
            stats.add(r.hits.toString());
            stats.add(r.doubles.toString());
            stats.add(r.triples.toString());
            stats.add(r.home_runs.toString());
            stats.add(r.walks.toString());
            stats.add(r.strike_outs.toString());
            stats.add(r.stolen_bases.toString());
            stats.add(r.caught_stealing.toString());
            stats.add(r.hit_by_pitch.toString());
            stats.add(r.sacrifice_flies.toString());
            stats.add(r.earned_runs_allowed.toString());
            stats.add(r.earned_runs_average.toString());
            stats.add(r.complete_games.toString());
            stats.add(r.shutouts.toString());
            stats.add(r.saves.toString());
            stats.add(r.hits_allowed.toString());
            stats.add(r.home_runs_allowed.toString());
            stats.add(r.walks_allowed.toString());
            stats.add(r.pitcher_strike_outs.toString());
            stats.add(r.errors.toString());
            stats.add(r.double_plays.toString());
            stats.add(r.fielding_percentage.toString());

            String row = "";
            for (String s : stats) {
                row += "<td>" + s + "</td>";
            }

            rows += "<tr>" + row + "</tr>";
        }




        // Read HTML file
        Path fileName = Path.of("html/f.html");
        String resp = "";
        try {
            resp = Files.readString(fileName);
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        // Insert the franchise info and table rows
        resp = resp.replace("<!--name-->", name);
        resp = resp.replace("<!--id-->",id);
        resp = resp.replace("<!--active-->",active);
        resp = resp.replace("<!--teams-->",teams);
        resp = resp.replace("<!--rows-->",rows);

        return resp;
    }
}
