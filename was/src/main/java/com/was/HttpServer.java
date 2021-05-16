package com.was;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.was.cfg.HttpConfig;

/**
 * Created by cybaek on 15. 5. 22..
 */
public class HttpServer {
    private static final Logger logger = Logger.getLogger(HttpServer.class.getCanonicalName());
    private static final int NUM_THREADS = 50;
    private static final String INDEX_FILE = "index.html";
    private static Map<String, Object> httpConfig;
    private final File rootDirectory;
    private final int port;
    
    public HttpServer() throws IOException {
    	httpConfig = new HttpConfig().getConfigMap();
    	Map<String, Object> host_mode = (Map<String, Object>) httpConfig.get("root_directory");
    	File root = new File((String) host_mode.get("default"));
    	this.rootDirectory = root;
    	this.port = (int) httpConfig.get("port");
    }
    
//
//    public HttpServer(File rootDirectory, int port) throws IOException {
//        if (!rootDirectory.isDirectory()) {
//            throw new IOException(rootDirectory
//                    + " does not exist as a directory");
//        }
//        this.rootDirectory = rootDirectory;
//        this.port = port;
//    }

    public void start() throws IOException {
        ExecutorService pool = Executors.newFixedThreadPool(NUM_THREADS);
        try (ServerSocket server = new ServerSocket(port)) {
            logger.info("Accepting connections on port " + server.getLocalPort());
            logger.info("Document Root: " + rootDirectory);
            while (true) {
                try {
                    Socket request = server.accept();
                    Runnable r = new RequestProcessor(rootDirectory, INDEX_FILE, request);
                    pool.submit(r);
                } catch (IOException ex) {
                    logger.log(Level.WARNING, "Error accepting connection", ex);
                }
            }
        }
    }

    public static void main(String[] args) {
//        // get the Document root
//        File docroot;
//        try {
//            docroot = new File("src/main/java");
//        } catch (ArrayIndexOutOfBoundsException ex) {
//            System.out.println("Usage: java JHTTP docroot port");
//            return;
//        }
//        // set the port to listen on
//        int port;
//        try {
//            port = Integer.parseInt(args[1]);
//            if (port < 0 || port > 65535) port = 80;
//        } catch (RuntimeException ex) {
//            port = 80;
//        }
//        
        try {
            HttpServer webserver = new HttpServer();
            webserver.start();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "Server could not start", ex);
        }
    }
}