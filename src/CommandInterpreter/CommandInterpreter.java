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
                    if(cmd[i + 1].equals("pump")) {
                        mechanic.setField(pumps.get(Integer.parseInt(cmd[i + 2])));
                        pumps.get(Integer.parseInt(cmd[i + 2])).Accept(mechanic);
                    } else if(cmd[i + 1].equals("pipe")) {
                        mechanic.setField(pipes.get(Integer.parseInt(cmd[i + 2])));
                        pipes.get(Integer.parseInt(cmd[i + 2])).Accept(mechanic);
                    } else if(cmd[i + 1].equals("city")) {
                        mechanic.setField(cities.get(Integer.parseInt(cmd[i + 2])));
                        cities.get(Integer.parseInt(cmd[i + 2])).Accept(mechanic);
                    } else if(cmd[i + 1].equals("source")) {
                        mechanic.setField(sources.get(Integer.parseInt(cmd[i + 2])));
                        sources.get(Integer.parseInt(cmd[i + 2])).Accept(mechanic);
                    }         
                } else if(cmd[i].equals("-pump")) {
                    mechanic.setPumpInHand(pumps.get(Integer.parseInt(cmd[i + 1])));
                } else if(cmd[i].equals("-pipe")) {
                    mechanic.setPipeInHand(pipes.get(Integer.parseInt(cmd[i + 1])));
                }
            }
            
            output = String.format("Mechanic has been initialized.\nMechanic object's ID: %d\n", mechanics.size());
            mechanics.add(mechanic);
        } else if(cmd[1].equals("nomad")) {
            Nomad nomad = new Nomad();
            
            for(int i = 0; i < cmd.length; i++) {
                if(cmd[i].equals("-moves")) {
                    nomad.setMoves(Integer.parseInt(cmd[i + 1]));
                } else if(cmd[i].equals("-field")) {
                    if(cmd[i + 1].equals("pump")) {
                        nomad.setField(pumps.get(Integer.parseInt(cmd[i + 2])));
                        pumps.get(Integer.parseInt(cmd[i + 2])).Accept(nomad);
                    } else if(cmd[i + 1].equals("pipe")) {
                        nomad.setField(pipes.get(Integer.parseInt(cmd[i + 2])));
                        pipes.get(Integer.parseInt(cmd[i + 2])).Accept(nomad);
                    } else if(cmd[i + 1].equals("city")) {
                        nomad.setField(cities.get(Integer.parseInt(cmd[i + 2])));
                        cities.get(Integer.parseInt(cmd[i + 2])).Accept(nomad);
                    } else if(cmd[i + 1].equals("source")) {
                        nomad.setField(sources.get(Integer.parseInt(cmd[i + 2])));
                        sources.get(Integer.parseInt(cmd[i + 2])).Accept(nomad);
                    }         
                } 
            }
            
            output = String.format("Nomad has been initialized.\nNomad object's ID: %d\n", nomads.size());
            nomads.add(nomad);
        } else if(cmd[1].equals("city")) {
            City city = new City();

            output = String.format("City has been initialized.\nCity object's ID: %d\n",  cities.size());
            cities.add(city);
        } else if(cmd[1].equals("source")) {
            Source source = new Source();

            output = String.format("Source has been initialized.\nSource object's ID: %d\n",sources.size());
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
            
            output = String.format("Pump has been initialized.\nPump object's ID: %d\n", pumps.size());
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

            output = String.format("Pipe has been initialized.\nPipe object's ID: %d\n", pipes.size());
            pipes.add(pipe);
        }

        if(cmd[cmd.length - 2].equals(">")) {
            WriteToFile(cmd[cmd.length - 1], output);
        } else {
            System.out.print(output);
        }
    } 

    static public void delete(String[] cmd) {
        String output = "";

        if(cmd[1].equals("character")) {
            output = "Deleted object's type and ID: Character " + cmd[2] + "\n";
            characters.remove(Integer.parseInt(cmd[2]));
            characters.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("city")) {
            output = "Deleted object's type and ID: City " + cmd[2] + "\n";
            cities.remove(Integer.parseInt(cmd[2]));
            cities.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("field")) {
            output = "Deleted object's type and ID: Field " + cmd[2] + "\n";
            fields.remove(Integer.parseInt(cmd[2]));
            fields.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("game")) {
            output = "Deleted object's type and ID: Game " + cmd[2] + "\n";
            games.remove(Integer.parseInt(cmd[2]));
            games.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("mechanic")) {
            output = "Deleted object's type and ID: Mechanic " + cmd[2] + "\n";
            mechanics.remove(Integer.parseInt(cmd[2]));
            mechanics.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("node")) {
            output = "Deleted object's type and ID: Node " + cmd[2] + "\n";
            nodes.remove(Integer.parseInt(cmd[2]));
            nodes.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("nomad")) {
            output = "Deleted object's type and ID: Nomad " + cmd[2] + "\n";
            nomads.remove(Integer.parseInt(cmd[2]));
            nomads.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("pipe")) {
            output = "Deleted object's type and ID: Pipe " + cmd[2] + "\n";
            pipes.remove(Integer.parseInt(cmd[2]));
            pipes.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("playfield")) {
            output = "Deleted object's type and ID: Playfield " + cmd[2] + "\n";
            playfields.remove(Integer.parseInt(cmd[2]));
            playfields.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("pump")) {
            output = "Deleted object's type and ID: Pump " + cmd[2] + "\n";
            pumps.remove(Integer.parseInt(cmd[2]));
            pumps.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("source")) {
            output = "Deleted object's type and ID: Source " + cmd[2] + "\n";
            sources.remove(Integer.parseInt(cmd[2]));
            sources.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("stepable")) {
            output = "Deleted object's type and ID: Stepable " + cmd[2] + "\n";
            stepables.remove(Integer.parseInt(cmd[2]));
            stepables.add(Integer.parseInt(cmd[2]), null);
        } else if(cmd[1].equals("-all")) {
            for(int j = 0; j < characters.size(); j++) {
                output += "Deleted object's type and ID: Character " + j + "\n";
            }
            characters.clear();

            for(int j = 0; j < cities.size(); j++) {
                output += "Deleted object's type and ID: City " + j + "\n";
            }
            cities.clear();

            for(int j = 0; j < fields.size(); j++) {
                output += "Deleted object's type and ID: Field " + j + "\n";
            }
            fields.clear();

            for(int j = 0; j < games.size(); j++) {
                output += "Deleted object's type and ID: Game " + j + "\n";
            }
            games.clear();

            for(int j = 0; j < mechanics.size(); j++) {
                output += "Deleted object's type and ID: Mechanic " + j + "\n";
            }
            mechanics.clear();

            for(int j = 0; j < nodes.size(); j++) {
                output += "Deleted object's type and ID: Node " + j + "\n";
            }
            nodes.clear();

            for(int j = 0; j < nomads.size(); j++) {
                output += "Deleted object's type and ID: Nomad " + j + "\n";
            }
            nomads.clear();

            for(int j = 0; j < pipes.size(); j++) {
                output += "Deleted object's type and ID: Pipe " + j + "\n";
            }
            pipes.clear();

            for(int j = 0; j < playfields.size(); j++) {
                output += "Deleted object's type and ID: PlayField " + j + "\n";
            }
            playfields.clear();

            for(int j = 0; j < pumps.size(); j++) {
                output += "Deleted object's type and ID: Pump " + j + "\n";
            }
            pumps.clear();

            for(int j = 0; j < sources.size(); j++) {
                output += "Deleted object's type and ID: Source " + j + "\n";
            }
            sources.clear();

            for(int j = 0; j < stepables.size(); j++) {
                output += "Deleted object's type and ID: Stepable " + j + "\n";
            }
            stepables.clear();
        }

        if(cmd[cmd.length - 2].equals(">")) {
            WriteToFile(cmd[cmd.length - 1], output);
        } else {
            System.out.print(output);
        }
    }

    public static void list(String[] cmd) {
        String output = "";

        if(cmd[1].equals("mechanic")) {
            output+= "Mechanics' ID:\n";
            for(int i = 0; i < mechanics.size(); i++) {
                if(mechanics.get(i) != null) {
                    output += i + "\n";
                }
            }
        } else if(cmd[1].equals("nomad")) {
            output+= "Nomads' ID:\n";
            for(int i = 0; i < nomads.size(); i++) {
                if(nomads.get(i) != null) {
                    output += i + "\n";
                }
            }
        } else if(cmd[1].equals("city")) {
            output+= "Citys' ID:\n";
            for(int i = 0; i < cities.size(); i++) {
                if(cities.get(i) != null) {
                    output += i + "\n";
                }
            }
        } else if(cmd[1].equals("source")) {
            output+= "Sources' ID:\n";
            for(int i = 0; i < sources.size(); i++) {
                if(sources.get(i) != null) {
                    output += i + "\n";
                }
            }
        } else if(cmd[1].equals("pump")) {
            output+= "Pumps' ID:\n";
            for(int i = 0; i < pumps.size(); i++) {
                if(pumps.get(i) != null) {
                    output += i + "\n";
                }
            }
        } else if(cmd[1].equals("pipe")) {
            output+= "Pipes' ID:\n";
            for(int i = 0; i < pipes.size(); i++) {
                if(pipes.get(i) != null) {
                    output += i + "\n";
                }
            }
        } else if(cmd[1].equals("-all")) {
            output+= "Mechanics' ID:\n";
            for(int i = 0; i < mechanics.size(); i++) {
                if(mechanics.get(i) != null) {
                    output += i + "\n";
                }
            }

            output+= "Nomads' ID:\n";
            for(int i = 0; i < nomads.size(); i++) {
                if(nomads.get(i) != null) {
                    output += i + "\n";
                }
            }

            output+= "Citys' ID:\n";
            for(int i = 0; i < cities.size(); i++) {
                if(cities.get(i) != null) {
                    output += i + "\n";
                }
            }

            output+= "Sources' ID:\n";
            for(int i = 0; i < sources.size(); i++) {
                if(sources.get(i) != null) {
                    output += i + "\n";
                }
            }

            output+= "Pumps' ID:\n";
            for(int i = 0; i < pumps.size(); i++) {
                if(pumps.get(i) != null) {
                    output += i + "\n";
                }
            }

            output+= "Pipes' ID:\n";
            for(int i = 0; i < pipes.size(); i++) {
                if(pipes.get(i) != null) {
                    output += i + "\n";
                }
            }
        }

        if(cmd[cmd.length - 2].equals(">")) {
            WriteToFile(cmd[cmd.length - 1], output);
        } else {
            System.out.print(output);
        }
    }

    public static void set(String[] cmd) {
        String output = "";
        
        if(cmd[1].equals("mechanic")) {
            Mechanic mechanic = mechanics.get(Integer.parseInt(cmd[2]));
            
            for(int i = 0; i < cmd.length; i++) {
                if(cmd[i].equals("-moves")) {
                    mechanic.setMoves(Integer.parseInt(cmd[i + 1]));
                } else if(cmd[i].equals("-field")) {
                    if(cmd[i + 1].equals("pump")) {
                        mechanic.setField(pumps.get(Integer.parseInt(cmd[i + 2])));
                        pumps.get(Integer.parseInt(cmd[i + 2])).Accept(mechanic);
                    } else if(cmd[i + 1].equals("pipe")) {
                        mechanic.setField(pipes.get(Integer.parseInt(cmd[i + 2])));
                        pipes.get(Integer.parseInt(cmd[i + 2])).Accept(mechanic);
                    } else if(cmd[i + 1].equals("city")) {
                        mechanic.setField(cities.get(Integer.parseInt(cmd[i + 2])));
                        cities.get(Integer.parseInt(cmd[i + 2])).Accept(mechanic);
                    } else if(cmd[i + 1].equals("source")) {
                        mechanic.setField(sources.get(Integer.parseInt(cmd[i + 2])));
                        sources.get(Integer.parseInt(cmd[i + 2])).Accept(mechanic);
                    }                     
                } else if(cmd[i].equals("-pump")) {
                    mechanic.setPumpInHand(pumps.get(Integer.parseInt(cmd[i + 1])));
                } else if(cmd[i].equals("-pipe")) {
                    mechanic.setPipeInHand(pipes.get(Integer.parseInt(cmd[i + 1])));
                }
            }
            
            output = String.format("Mechanic %d has been modified.\n", mechanics.size());
            mechanics.add(mechanic);
        } else if(cmd[1].equals("nomad")) {
            Nomad nomad = nomads.get(Integer.parseInt(cmd[2]));;
            
            for(int i = 0; i < cmd.length; i++) {
                if(cmd[i].equals("-moves")) {
                    nomad.setMoves(Integer.parseInt(cmd[i + 1]));
                } else if(cmd[i].equals("-field")) {
                    if(cmd[i + 1].equals("pump")) {
                        nomad.setField(pumps.get(Integer.parseInt(cmd[i + 2])));
                        pumps.get(Integer.parseInt(cmd[i + 2])).Accept(nomad);
                    } else if(cmd[i + 1].equals("pipe")) {
                        nomad.setField(pipes.get(Integer.parseInt(cmd[i + 2])));
                        pipes.get(Integer.parseInt(cmd[i + 2])).Accept(nomad);
                    } else if(cmd[i + 1].equals("city")) {
                        nomad.setField(cities.get(Integer.parseInt(cmd[i + 2])));
                        cities.get(Integer.parseInt(cmd[i + 2])).Accept(nomad);
                    } else if(cmd[i + 1].equals("source")) {
                        nomad.setField(sources.get(Integer.parseInt(cmd[i + 2])));
                        sources.get(Integer.parseInt(cmd[i + 2])).Accept(nomad);
                    }         
                } 
            }
            
            output = String.format("Nomad %d has been modified.", nomads.size());
            nomads.add(nomad);
        } else if(cmd[1].equals("pump")) {
            Pump pump = pumps.get(Integer.parseInt(cmd[2]));

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
            
            output = String.format("Pump%d has been modified.\n", pumps.size());
            pumps.add(pump);
        } else if(cmd[1].equals("pipe")) {
            Pipe pipe = pipes.get(Integer.parseInt(cmd[2]));;
            
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

            output = String.format("Pipe%d has been modified.\n", pipes.size());
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
        commands.put("delete", (String [] cmd) -> delete(cmd));
        commands.put("list", (String [] cmd) -> list(cmd));
        commands.put("set", (String[] cmd) -> set(cmd));

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
