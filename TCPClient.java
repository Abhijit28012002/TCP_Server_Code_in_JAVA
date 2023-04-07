import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

class TCPClient {
    public static void main(String[] args) throws Exception{
        String Sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket= new Socket("192.168.56.1",6789);
        DataOutputStream outToServer= new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer= new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("Enter your message: ");
        Sentence= inFromUser.readLine();
        while(!(Sentence.equals(""))){
            outToServer.writeBytes(Sentence+"\n");
            modifiedSentence =inFromServer.readLine();
            System.out.println("Enter Your message: ");
            Sentence=inFromUser.readLine();
        }
        clientSocket.close();

    }
    
}
