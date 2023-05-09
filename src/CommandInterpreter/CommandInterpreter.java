package CommandInterpreter;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Game.*;
import Game.Character;

public class CommandInterpreter {
    /*A futtatható commandokról map*/
    static Map<String, ICommand> commands = new HashMap<>();

    /*Jelenlegi inputstream*/
    static InputStreamReader is = new InputStreamReader( System.in);
    static BufferedReader reader = new BufferedReader(is);

    /*A különböző elemeket tároljuk itt*/

    static List<Character> characters = new ArrayList<>();
    static List<City> cities = new ArrayList<>();
    static List<Field> fields = new ArrayList<>();
    static List<Game> games = new ArrayList<>();
    static List<Mechanic> mechanics = new ArrayList<>();
    static List<Node> nodes = new ArrayList<>();
    static List<Nomad> nomads = new ArrayList<>();
    static List<Pipe> pipes = new ArrayList<>();
    static List<Playfield> playfields = new ArrayList<>();
    static List<Pump> pumps = new ArrayList<>();
    static List<Source> sources = new ArrayList<>();
    static List<Stepable> stepables = new ArrayList<>();

    static boolean run = true;

    static public void WriteToFile(String filename, String data) {
        try {
            File f = new File(filename);
            f.createNewFile();
            Files.write(Paths.get(filename), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException ie) {
            System.out.println("Invalid file");
        }
    }

    static public void Add(String[] cmd) {
        String output = "";
        if(cmd[1].equals("mechanic")) {
            Mechanic mechanic = new Mechanic();
            
            for(int i = 0; i < cmd.length; i++) {
                if(cmd[i].equals("-moves")) {
                    mechanic.setMoves(Integer.parseInt(cmd[i + 1]));
                } else if(cmd[i].equals("-field")) {
                    mechanic.setField(fields.get(Integer.parseInt(cmd[i + 1])));
                } else if(cmd[i].equals("-pump")) {
                    mechanic.setPumpInHand(pumps.get(Integer.parseInt(cmd[i + 1])));
                } else if(cmd[i].equals("-pipe")) {
                    mechanic.setPipeInHand(pipes.get(Integer.parseInt(cmd[i + 1])));
                }
            }
            
            output = String.format("Mechanic%d has been initialized.\nMechanic object's ID: %d\n", mechanics.size(), mechanics.size());
            mechanics.add(mechanic);
        } else if(cmd[1].equals("nomad")) {
            Nomad nomad = new Nomad();
            
            for(int i = 0; i < cmd.length; i++) {
                if(cmd[i].equals("-moves")) {
                    nomad.setMoves(Integer.parseInt(cmd[i + 1]));
                } else if(cmd[i].equals("-field")) {
                    nomad.setField(fields.get(Integer.parseInt(cmd[i + 1])));
                } 
            }
            
            output = String.format("Nomad%d has been initialized.\nNomad object's ID: %d\n", nomads.size(), nomads.size());
            nomads.add(nomad);
        } else if(cmd[1].equals("city")) {
            City city = new City();

            output = String.format("City%d has been initialized.\nCity object's ID: %d\n", cities.size(), cities.size());
            cities.add(city);
        } else if(cmd[1].equals("source")) {
            Source source = new Source();

            output = String.format("Source%d has been initialized.\nSource object's ID: %d\n", sources.size(), sources.size());
            sources.add(source);
        } else if(cmd[1].equals("pump")) {
            Pump pump = new Pump();

            for(int i = 0; i < cmd.length; i++) {
                if(cmd[i].equals("-input")) {
                    pump.setFrom(pipes.get(Integer.parseInt(cmd[i+1])));
                } else if(cmd[i].equals("-output")) {
                    pump.setWhere(pipes.get(Integer.parseInt(cmd[i + 1])));
                } else if(cmd[i].equals("-ends")) {
                    String[] pipenumbers = cmd[i + 1].split(",");

                    for(int j = 0; j < pipenumbers.length; j++){
                        Pipe p = pipes.get(Integer.parseInt(pipenumbers[j]));
                        if(p.getEndpoint(0) == null) {
                            p.setEndpoint(pump, 0);
                        } else {
                            p.setEndpoint(pump, 1);
                        }
                    }
                }
            }
            
            output = String.format("Pump%d has been initialized.\nPump object's ID: %d\n", pumps.size(), pumps.size());
            pumps.add(pump);
        } else if(cmd[1].equals("pipe")) {
            Pipe pipe = new Pipe();
            
            for(int i = 0; i < cmd.length; i++) {
                if(cmd[i].equals("-endpoint")) {
                    Node endpoint = new Pump();

                    if(cmd[i + 2].equals("source")) {
                        endpoint = sources.get(Integer.parseInt(cmd[i + 3]));
                    } else if(cmd[i + 2].equals("city")) {
                        endpoint = cities.get(Integer.parseInt(cmd[i + 3]));
                    } else if(cmd[i + 2].equals("pump")) {
                        endpoint = pumps.get(Integer.parseInt(cmd[i + 3]));
                    }

                    pipe.setEndpoint(endpoint, Integer.parseInt(cmd[i + 1]));
                } else if(cmd[i].equals("-has_hole")) {
                    pipe.Drill();
                } else if(cmd[i].equals("-has_water")) {
                    pipe.GiveWater(1);
                } else if(cmd[i].equals("-is_lubricated")) {
                    pipe.setSlippery(true);
                } else if(cmd[i].equals("-is_glued")) {
                    pipe.setSticky(true);
                }
            }

            output = String.format("Pipe%d has been initialized.\nPipe object's ID: %d\n", pipes.size(), pipes.size());
            pipes.add(pipe);
        }

        if(cmd[cmd.length - 2].equals(">")) {
            WriteToFile(cmd[cmd.length - 1], output);
        } else {
            System.out.print(output);
        }
    } 

    public static void main(String[] args) {

        commands.put("exit", (String[] cmd) -> run = false);
        commands.put("add", (String[] cmd) -> Add(cmd));

        while(run){
            try {
                String line = reader.readLine();
                String[] cmd = line.split(" ");

                commands.get(cmd[0]).execute(cmd);

            } catch(IOException ie) {
                System.out.println("Invalid input");
                break;
            }
        }
    }
}
