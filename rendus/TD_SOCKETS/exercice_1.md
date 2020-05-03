# SOCKETS JAVA : COMMUNICATION AVEC DES « STREAMS » OU DES « DATAGRAMS » - PARTIE A

## Exercice 1 - Socket Stream

### La classe ``EchoServer.java`` 

```java
public class EchoServer {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 1) {
            System.err.println("Usage: java EchoServer <port number>");
            System.exit(1);
        }
        
        int portNumber = Integer.parseInt(args[0]);
        
        try (
            ServerSocket serverSocket =
                new ServerSocket(Integer.parseInt(args[0]));
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        ) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
```

Dans cette classe, lors de son appel via lignes de commandes, on doit l'appeller avec ``EchoServer {numeroPort}`` afin de pouvoir lancer le serveur.
Le serveur renvoi au client ce qu'il reçoit en entrée.

### La classe ``EchoClient.java``

```java
public class EchoClient {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }

        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println("echo: " + in.readLine());
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}
```

Dans cette classe, lors de son appel via lignes de commandes, on doit l'appeller avec ``EchoClient {adresse} {numeroPort}`` afin de pouvoir lancer le client.
Le client va envoyer au serveur du texte (String) puis affhicher la réponse du serveur.

### Résultat de la commande ``lsof -i``

```bash
junkjumper@JunkJumperPonyOS:~$ lsof -i
COMMAND    PID       USER   FD   TYPE DEVICE SIZE/OFF NODE NAME
firefox-e 3580 junkjumper  107u  IPv4 224666      0t0  TCP JunkJumperPonyOS:36986->lb-140-82-114-26-iad.github.com:https (ESTABLISHED)
firefox-e 3580 junkjumper  114u  IPv4 224935      0t0  TCP JunkJumperPonyOS:57946->lb-140-82-113-25-iad.github.com:https (ESTABLISHED)
firefox-e 3580 junkjumper  154u  IPv4 224449      0t0  TCP JunkJumperPonyOS:36976->lb-140-82-114-26-iad.github.com:https (ESTABLISHED)
firefox-e 3580 junkjumper  241u  IPv4 231638      0t0  TCP JunkJumperPonyOS:41914->185.199.108.154:https (ESTABLISHED)
java      7411 junkjumper    6u  IPv6 232735      0t0  TCP *:50001 (LISTEN)
java      7411 junkjumper    7u  IPv6 231787      0t0  TCP localhost:50001->localhost:55230 (ESTABLISHED)
java      7428 junkjumper    6u  IPv6 230686      0t0  TCP localhost:55230->localhost:50001 (ESTABLISHED)
```

### Résultat de la commande ``ls -l /proc/7411/fd``

```bash
junkjumper@JunkJumperPonyOS:~$ ls -l /proc/7411/fd
total 0
lrwx------ 1 junkjumper junkjumper 64 janv. 28 12:00 0 -> /dev/pts/2
lrwx------ 1 junkjumper junkjumper 64 janv. 28 12:00 1 -> /dev/pts/2
lrwx------ 1 junkjumper junkjumper 64 janv. 28 12:00 2 -> /dev/pts/2
lr-x------ 1 junkjumper junkjumper 64 janv. 28 12:00 3 -> /usr/lib/jvm/java-11-openjdk-amd64/lib/modules
lr-x------ 1 junkjumper junkjumper 64 janv. 28 12:00 4 -> /usr/share/java/java-atk-wrapper.jar
lrwx------ 1 junkjumper junkjumper 64 janv. 28 12:00 5 -> 'socket:[232729]'
lrwx------ 1 junkjumper junkjumper 64 janv. 28 12:00 6 -> 'socket:[232735]'
lrwx------ 1 junkjumper junkjumper 64 janv. 28 12:00 7 -> 'socket:[231787]'
```

Les 3 première lignes correspondent à ``stdin`` (entrée standart), ``stdout`` (sortie standart) et ``stderr`` (sortie d'erreur).
On peut remarquer que nous avons des sockets (232729, 232735 et 231787).



















































