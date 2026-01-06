import java.util.*;

public class Chat_Servers_Outgoing_Traffic_5A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // current chat members
        Set<String> chat = new HashSet<>();
        long totalTraffic = 0;

        while (sc.hasNextLine()) {
            String line = sc.nextLine();

            // Add command
            if (line.startsWith("+")) {
                String name = line.substring(1);
                chat.add(name);
            }
            // Remove command
            else if (line.startsWith("-")) {
                String name = line.substring(1);
                chat.remove(name);
            }
            // Send command
            else {
                int idx = line.indexOf(':');
                String message = line.substring(idx + 1);

                int l = message.length();     // message length
                int k = chat.size();          // current participants

                totalTraffic += (long) l * k;
            }
        }

        System.out.println(totalTraffic);
        sc.close();
    }
}

