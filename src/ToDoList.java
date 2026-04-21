import java.util.ArrayList;
import java.util.Scanner;

public class ToDoList {

    static ArrayList<String> tasks = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void showTasks() {
        if (tasks.isEmpty()) {
            System.out.println("Yapilacak görev yok.");
        } else {
            System.out.println("\nYapilacaklar Listesi:");
            for (int i = 0; i < tasks.size(); i++) {
                System.out.println((i + 1) + ". " + tasks.get(i));
            }
        }
    }

    public static void addTask() {
        System.out.print("Eklemek istediğiniz görevi yazin: ");
        String task = scanner.nextLine();
        tasks.add(task);
        System.out.println("Görev eklendi!");
    }

    public static void deleteTask() {
        showTasks();

        if (tasks.isEmpty()) {
            return;
        }

        System.out.print("Silmek istediğiniz görev numarasini girin: ");

        try {
            int number = scanner.nextInt();
            scanner.nextLine();

            tasks.remove(number - 1);
            System.out.println("Görev silindi!");
        } catch (Exception e) {
            System.out.println("Hatali giriş yaptiniz!");
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n--- TO-DO LIST UYGULAMASI ---");
            System.out.println("1- Görevleri Göster");
            System.out.println("2- Görev Ekle");
            System.out.println("3- Görev Sil");
            System.out.println("4- Çikiş");
            System.out.print("Seçiminiz: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> showTasks();
                case "2" -> addTask();
                case "3" -> deleteTask();
                case "4" -> {
                    System.out.println("Programdan çikiliyor...");
                    return;
                }
                default -> System.out.println("Geçersiz seçim!");
            }
        }
    }
}
