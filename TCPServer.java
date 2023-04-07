import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
class TCPServer{
    public static void main(String[] args) throws Exception{

        String clientSentence;
        String capitalizedSentence;
        String UserReply;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        ServerSocket welcomeSocket= new ServerSocket(6789);
        while(true){
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            clientSentence = inFromClient.readLine();
            try{
                while(!(clientSentence.equals(""))){
                    System.out.println("From Client: "+ clientSentence);
                    UserReply = inFromUser.readLine();
                    capitalizedSentence = "Reply from server: "+ UserReply + "\n";
                    outToClient.writeBytes(capitalizedSentence);
                    clientSentence = inFromClient.readLine();
                }
            }
            catch(Exception e){
                System.out.println("Chat ended");
                welcomeSocket.close();
            }
        }
    }
}