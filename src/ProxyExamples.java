interface Image {
    void show();
}

class RealImage implements Image {
    private final String fileName;

    RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("--> [SLOW] Reading " + fileName + " from hard drive...");
    }

    @Override
    public void show() {
        System.out.println("Displaying " + fileName + " on screen!");
    }
}

class ProxyImage implements Image {
    private final String fileName;
    private final String userRole;
    private RealImage realImage;

    ProxyImage(String fileName, String userRole) {
        this.fileName = fileName;
        this.userRole = userRole;
    }

    @Override
    public void show() {
        if (!"ADMIN".equals(userRole)) {
            System.out.println("[ACCESS DENIED] You lack permission to view: " + fileName);
            return;
        }

        if (realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.show();
    }
}

interface Video {
    void play();
}

class RealVideo implements Video {
    private final String fileName;

    RealVideo(String fileName) {
        this.fileName = fileName;
        downloadVideo();
    }

    private void downloadVideo() {
        System.out.println("--> [DOWNLOADING] Connecting to server & buffering 4K video: " + fileName);
    }

    @Override
    public void play() {
        System.out.println("Playing video: " + fileName);
    }
}

class ProxyVideo implements Video {
    private final String fileName;
    private RealVideo realVideo;
    private int viewCount = 0;

    ProxyVideo(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void play() {
        viewCount++;
        System.out.println("--> [AUDIT] Video has been played " + viewCount + " time(s).");

        if (realVideo == null) {
            realVideo = new RealVideo(fileName);
        }
        realVideo.play();
    }
}

interface Internet {
    void connectTo(String site);
}

class RealInternet implements Internet {
    @Override
    public void connectTo(String site) {
        System.out.println("Connected to site: " + site);
    }
}

class SchoolProxyInternet implements Internet {
    private RealInternet realInternet;

    @Override
    public void connectTo(String site) {
        if ("gaming.com".equals(site) || "socialmedia.com".equals(site)) {
            System.out.println("[BLOCKED BY FIREWALL] Cannot access: " + site);
            return;
        }

        if (realInternet == null) {
            realInternet = new RealInternet();
        }
        realInternet.connectTo(site);
    }
}