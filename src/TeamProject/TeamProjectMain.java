package TeamProject;

class TeamProjectMain {
    public static void main(String[] args) {
        Application application = new Application();
        application.LoadFile();
        TeamProject.GUI gui = new GUI(2);
    }
}