package Lesson5;

import java.util.concurrent.Semaphore;

// тоннель
public class Tunnel extends Stage {
    private final Semaphore semaphore;

    public Tunnel() {
        this.semaphore = new Semaphore(2); // 2 разрешения для доступа к ресурсу одновременно
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                // получить разрешение на доступ к общему ресурсу
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                semaphore.acquire();
                // если разерешение получено, получить доступ к общему ресурсу
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                // освободить общий ресурс
                System.out.println(c.getName() + " закончил этап: " + description);
                semaphore.release(); // освободить семафор
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
