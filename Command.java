package textgame;

import java.util.*;

/**
 * Encodes the commands issued by the user. The <code>Listener</code> creates
 * <code>Command</code>s that are passed to the <code>Modifier</code> to
 * change the game state. A command should have the form <code>verb
 * arguments</code>. For example "Go north" or "Give bike to Colin".
 *
 * @author Lewis Brown
 *
 * @see Listener
 * @see Modifier
 */
public class Command {
    private final Verb verb;
    private final String[] args;

    public Command(String commandString) {
        String[] elements = commandString.split(" ");
        args = Arrays.copyOfRange(elements,1,elements.length);
        verb = recogniseVerb(elements);
    }

    /**
     * Executes the command. Uses the <code>Verb</code>'s execute method to
     * execute the command and thus modify the game state.
     */
    public UserResponse execute(Player player) {
        return this.verb.execute(args,player);
    }

    // Verb spellings
    private static String[] go = {"go"};
    private static String[] combine = {"combine", "use"};
    private static String[] talk = {"speak", "talk"};
    private static String[] none = {""};
    private static String[] quit = {"q","quit","exit"};
    private static String[] take = {"take"};
    private static String[] look = {"look"};

    /**
     * Verb enum type defines the verbs that can be used and their spellings.
     * It has a single constructor which takes a String to recognise which verb
     * has that spelling.
     */
    private enum Verb {
        GO(go) {
            UserResponse execute(String[] args, Player player) {
                String roomName = null;
                if (args[0].equals("to")) {
                    roomName = concatenate(Arrays.copyOfRange(args, 1, args.length));
                }
                else {
                    roomName = concatenate(args);
                }
                return player.goTo(roomName);
            }
        },
        COMBINE(combine) {
            UserResponse execute(String[] args, Player player) {
                switch (args.length) {
                    case 2:
                        player.use(args[0], args[1]);
                        break;
                    case 3:
                        if (args[1].equals("and") || args[1].equals("or")) {
                            player.use(args[0], args[2]); 
                        }
                        break;
                }
                return UserResponse.error("Wrong amount of arguments");
            }
        },
        TALK(talk) {
            UserResponse execute(String[] args, Player player) {
                String npcName = concatenate(args);
                return player.talkTo(npcName);
            }
        },
        TAKE(take) {
            UserResponse execute(String[] args, Player player) {
                String itemName = concatenate(args);
                return player.pickUp(itemName);
            }
        },
        LOOK(look) {
            UserResponse execute(String[] args, Player player) {
                String objectName = null;
                if (args[0].equals("at")) {
                    objectName = concatenate(Arrays.copyOfRange(args,1,args.length));
                }
                else {
                    objectName = concatenate(args);
                }
                return player.lookAt(objectName);
            }
        },
        NONE(none) {
            UserResponse execute(String[] args, Player player) {
                return UserResponse.error("No command");
            }
        },
        QUIT(quit) {
            UserResponse execute(String[] args, Player player) {
                return UserResponse.quit("Goodbye!");
            }
        };

        private final String[] spellings;

        Verb(String[] spellings) {
            this.spellings = spellings;
        }

        private static String concatenate(String[] args) {
            String string = "";
            for (String s: args) {
                string += s + " ";
            }
            // Get rid of trailing space
            string = string.substring(0, string.length() - 1); 
            return string;
        }

        private List<String> getSpellings() {
            return Arrays.asList(spellings);
        }
        static Verb getVerb(String verb) {
            for (Verb v: Verb.values()) {
                for (String s: v.getSpellings()) {
                    if (s.equals(verb)) {
                        return v;
                    }
                }
            }
            return NONE;
        }
        abstract UserResponse execute(String[] args, Player player);
    }

    /**
     * Extracts a verb from the string. A verb may span more than one words.
     * Possible verbs will be stored in a file as will the articles and objects
     * they are allowed to operate on.
     */
    private Verb recogniseVerb(String[] elements) {
        String verbCandidate;
        try {
            verbCandidate = elements[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            verbCandidate = "";
        }
        return Verb.getVerb(verbCandidate);
    }

    public Verb getVerb() {
        return verb;
    }
}
