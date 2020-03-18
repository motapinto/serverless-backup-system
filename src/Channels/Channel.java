package Channels;

import Common.Logs;
import Message.Dispatcher;
import Peer.Peer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

// Channel channel1 = new Channel(...); channel1.start() - delete after
public class Channel extends Thread {
    protected Peer peer;
    protected int port;
    protected InetAddress address;
    protected MulticastSocket multicastSocket;

    /**
     * Class responsible for the comunication with the multicast
     *
     * @param peer : peer listening to the multicast
     * @param address : multicast address
     * @param port : multicast port
     * @throws IOException
     */
    Channel(Peer peer, String address, int port) throws IOException {
        this.peer = peer;
        this.address = InetAddress.getByName(address);
        this.port = port;
        this.multicastSocket = new MulticastSocket(this.port);
        this.multicastSocket.setTimeToLive(1);
        this.multicastSocket.joinGroup(this.address);
    }

    /**
     * Receives packets from the multicast socket
     *
     * @return DatagramPacket : received packet
     * @throws IOException
     */
    public DatagramPacket receive() throws IOException {
        byte[] buf = new byte[???];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        this.multicastSocket.receive(packet);
        return packet;
    }

    /**
     * Runs the Channel thread that handles received packets
     */
    @Override
    public void run() {
        while (true) {
            try {
                Dispatcher handler = new Dispatcher(this.peer, this.receive());
                handler.start();
            } catch (IOException e) {
                Logs.logError("Error handling peer" + e);
            }
        }
    }

    /**
     * Gets peer connected to the channel
     *
     * @return Peer peer : peer connected to the chanel
     */
    public Peer getPeer() {
        return this.peer;
    }

    /**
     * Closes the multicast socket
     */
    public void closeSocket() {
        this.multicastSocket.close();
    }
}