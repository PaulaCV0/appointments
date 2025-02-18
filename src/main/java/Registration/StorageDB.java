package Registration;

public class StorageDB {
    final String url = "jdbc:sqlite:TeenPregnant.sqlite";

    final String DataBase = "Teen Pregnancy";

    final String createTable = "CREATE table if not exists Appointments (\n" +
            "ID INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
            "Name Text NOT NULL, \n" +
            "Surname TEXT NOT NULL," +
            "Pregnant BOOLEAN NOT NULL CHECK (Pregnant IN (0,1)), \n" +
            "Days TEXT NOT NULL,\n" +
            "ConsultancyType TEXT NOT NULL\n" +
            ");";

    private Database db;

    public StorageDB() {
        System.out.println("Connecting to " + url);
        this.db = new Database(url);
        db.createTables(createTable);
    }

    public void save (User user) {
        System.out.println("Saving to " + url);
        try {
            boolean[] days = user.getDays();
            StringBuilder daysString = new StringBuilder();
            String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
            for (int i = 0; i < days.length; i++) {
                if (days[i]) {
                    daysString.append(daysOfWeek[i]).append(",");
                }
            }

            String sql = "INSERT INTO Appointments (Name, Surname, Pregnant, Days, ConsultancyType) " +
                    "VALUES ('" + user.getName() + "', '"
                    + user.getSurname() + "', "
                    + user.isPregnant() + ", '"
                    + daysString.toString() + "', '"
                    + user.getAppointmentType() + "');";
            db.insert(sql);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}