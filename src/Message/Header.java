package Message;

import static Common.Constants.CRLF;

public class Header {
    private String chunkNo;
    private String ip;
    private String port;
    private final String version;
    private final String messageType;
    private String senderId;
    private String fileId;
    private String replicationDeg;

    /**
     * Message header for PUTCHUNK messages
     * <MessageType> <Version> <SenderId> <FileId> <ChunkNo> <ReplicationDeg> <CRLF>
     *
     * @param MessageType    : indicates message type
     * @param Version        : indicates the version of the peer that sends the message
     * @param SenderId       : indicates the sender id
     * @param FileId         : indicates the file id
     * @param ChunkNo        : indicate the chunk number
     * @param ReplicationDeg : indicates the desired replication degree
     */
    public Header(String MessageType, String Version, String SenderId, String FileId, String ChunkNo, String ReplicationDeg) {
        this.messageType = MessageType.trim();
        this.version = Version.trim();
        this.senderId = SenderId.trim();
        this.fileId = FileId.trim();
        this.chunkNo = ChunkNo.trim();
        this.replicationDeg = ReplicationDeg.trim();
    }

    /**
     * Message header for CHUNK, GETCHUNK and STORED messages
     * <MessageType> <Version> <SenderId> <FileId> <ChunkNo> <CRLF>
     *
     * @param MessageType : indicates message type
     * @param Version     : indicates the version of the peer that sends the message
     * @param SenderId    : indicates the sender id
     * @param FileId      : indicates the file id
     * @param ChunkNo     : indicate the chunk number
     */
    public Header(String MessageType, String Version, String SenderId, String FileId, String ChunkNo) {
        this.messageType = MessageType.trim();
        this.version = Version.trim();
        this.senderId = SenderId.trim();
        this.fileId = FileId.trim();
        this.chunkNo = ChunkNo.trim();
    }

    /**
     * Message header for DELETE messages
     * <MessageType> <Version> <SenderId> <FileId> <ChunkNo> <CRLF>
     *
     * @param MessageType : indicates message type
     * @param Version     : indicates the version of the peer that sends the message
     * @param SenderId    : indicates the sender id
     * @param FileId      : indicates the file id
     */
    public Header(String MessageType, String Version, String SenderId, String FileId) {
        this.messageType = MessageType.trim();
        this.version = Version.trim();
        this.senderId = SenderId.trim();
        this.fileId = FileId.trim();
    }

    public Header(String MessageType, String Version, String SenderId, String FileId, String ChunkNo, String ip, String port) {
        this.messageType = MessageType.trim();
        this.version = Version.trim();
        this.senderId = SenderId.trim();
        this.fileId = FileId.trim();
        this.chunkNo = ChunkNo.trim();
        this.ip = ip.trim();
        this.port = port.trim();
    }



    /**
     * Message header for DELETEACK messages
     * <MessageType> <Version> <CRLF>
     *
     * @param MessageType : indicates message type
     * @param Version     : indicates the version of the peer that sends the message
     */
    public Header(String MessageType, String Version) {
        this.messageType = MessageType.trim();
        this.version = Version.trim();
    }


    @Override
    public String toString() {
        String header = this.version + " " + this.messageType;

        if(this.senderId != null) {
            header += " " + this.senderId;
        }
        if(this.fileId != null) {
            header += " " + this.fileId;
        }
        if(this. chunkNo != null) {
            header += " " + this. chunkNo;
        }
        if(this.replicationDeg != null) {
            header += " " + this.replicationDeg;
        }

        header += " " + CRLF + CRLF;

        return header;
    }

    public String getVersion() {
        return version;
    }

    public String getMessageType() {
        return messageType;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getFileId() {
        return fileId;
    }

    public String getChuckNo() {
        return  chunkNo;
    }

    public String getReplicationDeg() {
        return replicationDeg;
    }


    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

}
