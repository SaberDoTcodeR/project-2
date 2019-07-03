package DuelystClient;

import DuelystClient.View.View;
import DuelystServer.Server;
import com.google.gson.Gson;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.util.Properties;

public class Connection implements Runnable {
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;
    private Socket socket;
    private boolean running;
    private volatile boolean closedManual;

    public Connection(Socket socket) {
        this.socket = socket;
        try {

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        new Thread(this).start();
    }

    @Override
    public void run() {
        running = true;
       /* while (running && !closedManual) {

            if (string.contains("loggingIn")) {
                AccountPacket accountPacket = gson.fromJson(string, AccountPacket.class);
                Account account = accountPacket.getAccount();

                boolean x = accountPacket.isSuccess();
                if (x) {
                    Account.setCurrentAccount(account);
                    ClientGame.makeMainMenu(account);
                } else if (accountPacket.isLoggingIn()) {
                    ClientGame.wrongLogIn();
                } else {
                    ClientGame.wrongSingUp();
                }


            } else if (string.contains("game")) {
                GamePacket gamePacket = gson.fromJson(string, GamePacket.class);
                boolean x = gamePacket.isCreatingGame();
                if (x) {
                    if (gamePacket.isSuccess()) {
                        Account.getCurrentAccount().setGame(gamePacket.getGame());
                        ClientGame.makeGame(gamePacket.getGame());
                    } else {
                        ClientGame.wrongOpponent();
                    }
                } else {
                    Account.getCurrentAccount().setGame(gamePacket.getGame());
                    ClientGame.makeGame(gamePacket.getGame());
                    if (gamePacket.getGame().getFinished() != 0)
                        ClientGame.whoWinError(gamePacket.getGame());
                }
            } else if (string.contains("MSG")) {
                ClientGame.printOppMessage(string.substring(3));
            } else if (string.equals("quit battle")) {
                Account.getCurrentAccount().setGame(null);
                ClientGame.makeMainMenu(Account.getCurrentAccount());
            }
        } catch(EOFException | SocketException e){
            while (!closedManual) {
                try {
                    ClientGame.socket = new Socket("localhost", 5555);
                    ClientGame.connection = new Connection(ClientGame.socket);
                    System.out.println("connection client ..");
                    ClientGame.loginSceneManage(true);
                    break;
                } catch (ConnectException e1) {
                    // ClientGame.connectionError();
                } catch (IOException e1) {
                    e.printStackTrace();
                }
            }
            break;
        } catch(IOException e){
            e.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }*/

    }

    public void sendPacket(Object object) {
        try {
            outputStream.writeObject(object);
            outputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object readPacket() {
        try {
            return inputStream.readObject();
        } catch (EOFException | SocketException e) {
            while (!closedManual) {
                Properties properties = null;
                try {
                    properties = Client.getProperties();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                int port = Client.getPort(properties.getProperty("port"));
                int defaultPort = 8000;
                Socket socket = null;
                String host = "localhost";
                try {
                    socket = new Socket(host, port);
                    View.makeLoginScene();
                    Client.primaryStage.show();
                    Client.connectionToServer = new Connection(socket);
                } catch (IOException e1) {
                    try {
                        socket = new Socket(host, defaultPort);
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                    View.makeLoginScene();
                    Client.primaryStage.show();
                    Client.connectionToServer = new Connection(socket);
                }
                break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void close() {

        try {
            inputStream.close();
            outputStream.close();
        } catch (EOFException | SocketException e) {
            return;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}